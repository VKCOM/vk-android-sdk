/**
 * Copyright (c) 2020 - present, LLC “V Kontakte”
 *
 * 1. Permission is hereby granted to any person obtaining a copy of this Software to
 * use the Software without charge.
 *
 * 2. Restrictions
 * You may not modify, merge, publish, distribute, sublicense, and/or sell copies,
 * create derivative works based upon the Software or any part thereof.
 *
 * 3. Termination
 * This License is effective until terminated. LLC “V Kontakte” may terminate this
 * License at any time without any negative consequences to our rights.
 * You may terminate this License at any time by deleting the Software and all copies
 * thereof. Upon termination of this license for any reason, you shall continue to be
 * bound by the provisions of Section 2 above.
 * Termination will be without prejudice to any rights LLC “V Kontakte” may have as
 * a result of this agreement.
 *
 * 4. Disclaimer of warranty and liability
 * THE SOFTWARE IS MADE AVAILABLE ON THE “AS IS” BASIS. LLC “V KONTAKTE” DISCLAIMS
 * ALL WARRANTIES THAT THE SOFTWARE MAY BE SUITABLE OR UNSUITABLE FOR ANY SPECIFIC
 * PURPOSES OF USE. LLC “V KONTAKTE” CAN NOT GUARANTEE AND DOES NOT PROMISE ANY
 * SPECIFIC RESULTS OF USE OF THE SOFTWARE.
 * UNDER NO CIRCUMSTANCES LLC “V KONTAKTE” BEAR LIABILITY TO THE LICENSEE OR ANY
 * THIRD PARTIES FOR ANY DAMAGE IN CONNECTION WITH USE OF THE SOFTWARE.
*/
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