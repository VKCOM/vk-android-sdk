package com.vk.api.sdk.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle

abstract class VKBaseAuthActivity : Activity() {
    /**
     * Flag indicating that auth process was started before onResume (cleared in onPause)
     * It isn't saved in onSaveInstanceState because of this flag is just session flag.
     */
    private var authWasStarted = false

    /**
     * Flag indicating that this or previously destroyed activity is waiting for auth.
     * It's saved in onSaveInstanceState because of system could kill our app after opening
     * the browser and we have to know what state was the last in out app.
     */
    private var isWaitingForAuthResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(0, 0)
        super.onCreate(savedInstanceState)

        isWaitingForAuthResult = savedInstanceState?.getBoolean(KEY_WAITING_FOR_AUTH_RESULT, false) ?: false

        processIntent(intent, false)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        processIntent(intent, true)
    }

    override fun onResume() {
        super.onResume()
        if (isWaitingForAuthResult && !authWasStarted) {
            // We're waiting for auth result but user returns to activity. Okay. Just finish it.
            setResult(RESULT_CANCELED)
            finish()
        }
    }

    private fun processIntent(intent: Intent?, allowRedirectHandle: Boolean) {
        val data = intent?.data
        if (!isWaitingForAuthResult && isIntentWithAuthRequest(intent) && data != null) {
            if (handleStartAuth(data)) {
                isWaitingForAuthResult = true
                authWasStarted = true
            } else {
                finish()
            }
        } else if (allowRedirectHandle) {
            val result = handleRedirectUri(data)
            setResult(RESULT_OK, result)
            finish()
            isWaitingForAuthResult = false
        }
    }

    override fun onPause() {
        super.onPause()
        authWasStarted = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_WAITING_FOR_AUTH_RESULT, isWaitingForAuthResult)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, 0)
    }

    /**
     * Check this activity was started for auth but not with redirect
     *
     * @param intent intent to check
     *
     * @return true if this intent for auth request, false otherwise
     */
    protected abstract fun isIntentWithAuthRequest(intent: Intent?): Boolean

    /**
     * Called on auth using external service (or via browser) was started
     *
     * @param oauthUri oauth uri this activity was started with (taken from [Intent.getData])
     */
    protected abstract fun handleStartAuth(oauthUri: Uri): Boolean

    /**
     * Called on redirect from browser/another app on oauth finished.
     *
     * @param redirectUri uri redirect occurred with
     *
     * @return intent for [Activity.setResult]
     */
    protected abstract fun handleRedirectUri(redirectUri: Uri?): Intent


    companion object {
        private const val KEY_WAITING_FOR_AUTH_RESULT = "VK_waitingForAuthResult"
    }
}