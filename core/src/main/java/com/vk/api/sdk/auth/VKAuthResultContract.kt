package com.vk.api.sdk.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.vk.api.sdk.VK
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
        val params = VKAuthParams(VK.getAppId(context), scope = input)
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
}