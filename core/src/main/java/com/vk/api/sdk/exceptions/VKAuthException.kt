package com.vk.api.sdk.exceptions

/**
 * @param webViewError error code according to one of [android.webkit.WebView].ERROR_#; 0 if no WebView errors occurred
 * @param authError error name returned on authentication.
 * @see <a href="https://vk.com/dev/authcode_flow_group">VK Authorization Code Flow</a>
 **/
class VKAuthException(
    val webViewError: Int = 0,
    val authError: String? = null
) : Exception("Auth canceled") {
    val isCanceled: Boolean
        get() = webViewError == 0 && authError.isNullOrEmpty()
}