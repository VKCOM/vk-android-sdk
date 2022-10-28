package com.vk.api.sdk.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKHost
import com.vk.api.sdk.exceptions.VKAuthException
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import com.vk.api.sdk.utils.VKUtils

internal class VKAuthResultContract(
    private val authManager: VKAuthManager
): ActivityResultContract<Collection<VKScope>, VKAuthenticationResult>() {
    override fun createIntent(
        context: Context,
        input: Collection<VKScope>
    ): Intent {
        tryWarn(input)
        val params = VKAuthParams(appId = VK.getAppId(context), scope = input)
        return if (VKUtils.isIntentAvailable(context, VKAuthManager.VK_APP_AUTH_ACTION, null, VKAuthManager.VK_APP_PACKAGE_ID)) {
            authManager.createVKClientAuthIntent(params)
        } else {
            VKWebViewAuthActivity.createAuthIntent(context, params)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): VKAuthenticationResult {
        val result = if (resultCode != Activity.RESULT_OK) {
            VKAuthenticationResult.Failed(
                VKAuthException(authError = "Authentication cancelled with activity code = $resultCode")
            )
        } else {
            authManager.processResult(intent)
        }
        if (result is VKAuthenticationResult.Success) {
            authManager.storeLoginResult(result)
            VK.trackVisitor()
        }
        return result
    }

    private fun tryWarn(scopes: Collection<VKScope>) {
        if (scopes.contains(VKScope.OFFLINE)) {
            Log.w(LOG_TAG, " Don't use OFFLINE scope, if you registered app as embedded. Read more https://dev.${VKHost.host}/reference/access-rights")
        }
    }

    private companion object {
        const val LOG_TAG = "VKAuthResultContract"
    }
}