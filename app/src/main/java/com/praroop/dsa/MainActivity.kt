package com.praroop.dsa

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.praroop.dsa.ui.theme.DummyTheme

// CHANGE: Extend FragmentActivity instead of ComponentActivity
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DummyTheme {
                // Pass the FragmentActivity instance to the composable
                AuthAppScreen(activity = this)
            }
        }
    }
}

@Composable
fun AuthAppScreen(activity: FragmentActivity, viewModel: MainViewModel = viewModel()) {
    val isAuthenticated by viewModel.isAuthenticated.collectAsState()

    // The BiometricPromptManager must be initialized with the FragmentActivity
    // and the callbacks for success/failure.
    val biometricPromptManager = remember(activity) {
        BiometricPromptManager(
            activity = activity,
            onAuthSuccess = { viewModel.setAuthenticated(true) },
            onAuthFailure = {
                // Handle non-recoverable error or complete failure here.
                // For simplicity, we just allow access on final failure.
                viewModel.setAuthenticated(true)
            }
        )
    }

    // Trigger biometric authentication when the screen is first composed.
    LaunchedEffect(Unit) {
        if (!isAuthenticated) {
            biometricPromptManager.startBiometricAuth()
        }
    }

    if (isAuthenticated) {
        MainContent()
    } else {
        LoadingScreen() // Show a loading/waiting state while prompt is active
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Greeting(name = "Authenticated User", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
        Text("Waiting for Biometric Authentication...", modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DummyTheme {
        // Preview content without full biometric logic
        Greeting("Android")
    }
}