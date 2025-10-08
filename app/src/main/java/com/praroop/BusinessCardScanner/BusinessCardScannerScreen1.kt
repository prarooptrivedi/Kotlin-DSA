package com.praroop.BusinessCardScanner

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import java.util.concurrent.Executors

// Utility function to check permission status
private fun checkCameraPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
}

@Composable
fun BusinessCardScannerScreen1() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val executor = remember { Executors.newSingleThreadExecutor() }

    var recognizedText by remember { mutableStateOf("") }
    var extractedData by remember { mutableStateOf(mapOf<String, String>()) }
    var captureRequest by remember { mutableStateOf(false) }

    // Check initial permission status
    var hasCameraPermission by remember { mutableStateOf(checkCameraPermission(context)) }

    // Permission launcher
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasCameraPermission = granted
        if (granted) {
            Toast.makeText(context, "Camera permission granted!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Camera permission denied!", Toast.LENGTH_SHORT).show()
        }
    }

    // Trigger permission request only if it's not already granted
    LaunchedEffect(Unit) {
        // NO DELAY NEEDED HERE. The delay was likely contributing to the request code issue.
        if (!hasCameraPermission) {
            try {
                launcher.launch(Manifest.permission.CAMERA)
            } catch (e: Exception) {
                // Log and handle the exception, in case of any remaining issues
                Log.e("PermissionRequest", "Failed to launch permission request", e)
                Toast.makeText(context, "Error launching permission request: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    // --- UI START ---
    if (hasCameraPermission) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AndroidView(
                factory = { ctx ->
                    val previewView = PreviewView(ctx)

                    val cameraProvider = cameraProviderFuture.get()
                    val preview = Preview.Builder().build().also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }

                    val analyzer = ImageAnalysis.Builder()
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build()
                        .also {
                            it.setAnalyzer(executor) { imageProxy ->
                                if (captureRequest) {
                                    processImage1(imageProxy) { text ->
                                        recognizedText = text
                                        extractedData = extractData1(text)
                                        captureRequest = false
                                    }
                                } else {
                                    imageProxy.close()
                                }
                            }
                        }

                    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                    try {
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner, cameraSelector, preview, analyzer
                        )
                    } catch (exc: Exception) {
                        Log.e("CameraX", "Binding failed", exc)
                    }

                    previewView
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Spacer(Modifier.height(16.dp))

            Button(onClick = { captureRequest = true }) {
                Text("Capture & Scan")
            }

            Spacer(Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Detected Text:", style = MaterialTheme.typography.titleMedium)
                Text(
                    recognizedText.take(500) + if (recognizedText.length > 500) "..." else "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFE0E0E0))
                        .padding(8.dp)
                )

                Spacer(Modifier.height(8.dp))

                Text("Extracted Info:", style = MaterialTheme.typography.titleMedium)
                Text("Name: ${extractedData["name"] ?: ""}")
                Text("Email: ${extractedData["email"] ?: ""}")
                Text("Phone: ${extractedData["phone"] ?: ""}")
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Camera permission required")
        }
    }
}

fun extractData1(text: String): Map<String, String> {
    val result = mutableMapOf<String, String>()

    // Regex improved for better phone number matching (e.g., handles international formats)
    val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    val phoneRegex = Regex("(\\+?\\d{1,4}[ .-]?)?(\\(\\d{1,4}\\)[ .-]?)?\\d{2,4}[ .-]\\d{2,4}[ .-]\\d{2,4}")

    // A simple name extraction regex, often less reliable than NLP, but kept for consistency
    val nameRegex = Regex("([A-Z][a-z]+(?:\\s[A-Z][a-z]+)*)")

    result["email"] = emailRegex.find(text)?.value ?: "Not found"
    result["phone"] = phoneRegex.find(text)?.value ?: "Not found"
    result["name"] = nameRegex.find(text)?.value ?: "Not found"

    return result
}

private fun processImage1(imageProxy: ImageProxy, onResult: (String) -> Unit) {
    val mediaImage = imageProxy.image ?: return

    // ML Kit requires a specific format for the Image
    val inputImage = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    recognizer.process(inputImage)
        .addOnSuccessListener { visionText ->
            onResult(visionText.text)
        }
        .addOnFailureListener { e ->
            Log.e("MLKit", "Text recognition failed", e)
        }
        .addOnCompleteListener {
            // IMPORTANT: Close the image proxy when done processing to release the buffer.
            imageProxy.close()
        }
}