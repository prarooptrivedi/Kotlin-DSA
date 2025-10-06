package com.praroop.dsa

import android.content.Context
import android.util.Log
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import androidx.core.content.ContextCompat

/**
 * Helper class to manage and display the BiometricPrompt for authentication.
 */
class BiometricPromptManager(
    private val activity: FragmentActivity,
    private val onAuthSuccess: () -> Unit,
    private val onAuthFailure: () -> Unit
) {
    private val TAG = "BiometricAuth"

    private val executor = ContextCompat.getMainExecutor(activity)
    private val biometricPrompt: BiometricPrompt

    init {
        biometricPrompt = BiometricPrompt(activity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Log.d(TAG, "Auth Error: $errorCode - $errString")
                    onAuthFailure()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Log.d(TAG, "Authentication Succeeded!")
                    onAuthSuccess()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Log.d(TAG, "Authentication Failed.")
                    // Authentication failed but prompt remains open for retry unless error is thrown.
                }
            })
    }

    /**
     * Checks if biometric authentication is available and starts the prompt if it is.
     */
    fun startBiometricAuth() {
        val biometricManager = BiometricManager.from(activity)

        val authenticators = BIOMETRIC_STRONG or DEVICE_CREDENTIAL

        when (biometricManager.canAuthenticate(authenticators)) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                Log.d(TAG, "App can authenticate using biometrics.")
                val promptInfo = BiometricPrompt.PromptInfo.Builder()
                    .setTitle("App Login")
                    .setSubtitle("Authenticate to access the app")
                    // Allows strong biometrics (fingerprint/face) or device PIN/Pattern/Password
                    .setAllowedAuthenticators(authenticators)
                    .build()

                biometricPrompt.authenticate(promptInfo)
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                Log.e(TAG, "No biometric features available on this device.")
                onAuthFailure() // Fallback to a login screen or just show the main content unauthenticated
            }
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                Log.e(TAG, "Biometric features are currently unavailable.")
                onAuthFailure()
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                Log.e(TAG, "No biometrics enrolled. Prompting for device credential fallback.")
                // You can still show the prompt, which will automatically fallback to device credential
                val promptInfo = BiometricPrompt.PromptInfo.Builder()
                    .setTitle("App Login")
                    .setSubtitle("Use PIN, pattern, or password")
                    .setAllowedAuthenticators(authenticators)
                    .build()
                biometricPrompt.authenticate(promptInfo)
            }
            else -> {
                Log.e(TAG, "Other biometric status/error.")
                onAuthFailure()
            }
        }
    }
}

/**
 * Helper extension to safely cast a Context to FragmentActivity or null.
 */
fun Context.findFragmentActivity(): FragmentActivity? {
    var context = this
    while (context is android.content.ContextWrapper) {
        if (context is FragmentActivity) return context
        context = context.baseContext
    }
    return null
}