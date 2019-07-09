package com.vk.api.sdk

/**
 * Describes Http request for authorization through oauth.
 * Since the format of the response to such a request differs from the format of answers of ordinary requests in the VK API,
 * you must use a separate overload of the [VKApiManager.execute] method, which accepts
 * instance of this class
 * @see [com.vk.api.sdk.chain.OAuthHttpUrlChainCall]
 */
class OauthHttpUrlPostCall(val url: String, val timeoutMs: Long = 0L, val retryCountOnBackendError: Int = 0)