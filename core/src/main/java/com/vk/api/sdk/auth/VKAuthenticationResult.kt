package com.vk.api.sdk.auth

import com.vk.api.sdk.exceptions.VKAuthException

/**
 * Represents result of authentication to VK.
 */
sealed class VKAuthenticationResult {
    /**
     * Represents failed authentication state.
     * @param exception reason of authentication failure
     */
    class Failed(val exception: VKAuthException): VKAuthenticationResult()

    /**
     * Represents succeed authentication state.
     * @param token contains main user info like user id, access token and etc
     */
    class Success(val token: VKAccessToken): VKAuthenticationResult()
}