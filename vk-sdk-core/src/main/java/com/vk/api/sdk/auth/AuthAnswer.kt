package com.vk.api.sdk.auth

import org.json.JSONObject

class AuthAnswer constructor(
        // Success
        val accessToken: String = "",
        val secret: String = "",
        val userId: Int = 0,
        val expiresIn: Int = 0,
        val httpsRequired: Boolean = true,
        val trustedHash: String = "",
        // Help data
        var isSecretNeeded: Boolean = true,
        // Validation
        val redirectUrl: String = "",
        val validationType: ValidationType = ValidationType.URL,
        val validationSid: String = "",
        val phoneMask: String = "",
        // Facebook auth
        val errorType: String = "",
        val email: String? = "",
        // Error
        val error: String = "",
        val errorDescription: String = "",
        // Banned
        val banInfo: BanInfo? = null,
        // Restore info
        val restoreRequestId: Long = 0,
        val restoreHash: String = ""
) {
    constructor(jo: JSONObject) : this(
            error = jo.optString("error"),
            errorDescription = jo.optString("error_description"),
            errorType = jo.optString("error_type"),
            email = jo.optString("email"),
            redirectUrl = jo.optString("redirect_uri"),
            validationType = jo.optString("validation_type").let { ValidationType.parse(it) },
            validationSid = jo.optString("validation_sid"),
            phoneMask = jo.optString("phone_mask"),
            accessToken = jo.optString("access_token"),
            secret = jo.optString("secret"),
            userId = jo.optInt("user_id"),
            expiresIn = jo.optInt("expires_in"),
            httpsRequired = jo.optString("https_required", "1") == "1",
            trustedHash = jo.optString("trusted_hash"),
            banInfo = jo.optJSONObject("ban_info")?.let { BanInfo.parse(it) },
            restoreRequestId = jo.optLong("restore_request_id"),
            restoreHash = jo.optString("restore_hash")
    )

    companion object {
        const val ERROR_NEED_VALIDATE = "need_validation"
        const val ERROR_NEED_AUTH_CHECK = "need_authcheck"
        const val ERROR_INVALID_CLIENT = "invalid_client"
        const val ERROR_INVALID_TOKEN = "invalid_token"
        const val ERROR_INVALID_REQUEST = "invalid_request"

        const val ERROR_TYPE_WRONG_CODE_FORMAT = "otp_format_is_incorrect"
        const val ERROR_TYPE_WRONG_CODE = "wrong_otp"
        const val ERROR_TYPE_TOO_MUCH_TRIES = "too_much_tries"
        const val ERROR_TYPE_FACEBOOK_EMAIL_REGISTERED = "facebook_email_already_registered"
        const val ERROR_TYPE_FACEBOOK_EMAIL_USED = "facebook_email_used"
        const val ERROR_TYPE_CANCEL_BY_OWNER_NEEDED = "cancel_by_owner_needed"
    }
}
