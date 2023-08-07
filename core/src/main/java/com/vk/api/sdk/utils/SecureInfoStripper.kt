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
package com.vk.api.sdk.utils

import kotlin.text.Regex.Companion.escapeReplacement

class SecureInfoStripper {

    private val stripRules = mutableListOf<StripRule>()

    fun withRule(regex: Regex, replacement: String): SecureInfoStripper {
        stripRules += StripRule.StringReplacement(regex, escapeReplacement(replacement))
        return this
    }

    fun withRule(regex: Regex, replacement: (MatchResult) -> CharSequence): SecureInfoStripper {
        stripRules += StripRule.MatchGroupReplacement(regex, replacement)
        return this
    }

    fun strip(msg: String?): String {
        return stripRules.fold(msg) { strip, rule ->
            strip?.replace(rule.regex, rule.replacement)
        } ?: ""
    }

    private sealed class StripRule(open val regex: Regex, open val replacement: (MatchResult) -> CharSequence) {
        data class StringReplacement(
            override val regex: Regex,
            val replacementString: String
        ) : StripRule(regex, { replacementString })

        class MatchGroupReplacement(
            override val regex: Regex,
            override val replacement: (MatchResult) -> CharSequence
        ) : StripRule(regex, replacement)
    }

    companion object {
        private val DEFAULT_KEYS = listOf(
            "sign", "key", "access_token", "webview_access_token", "webview_refresh_token", "exchange_token", "exchange_tokens", "common_token"
        )
        const val SENSITIVE_VALUE_PATTERN = "[a-zA-Z0-9._%-]+"

        val SIGN_STRIPPER_DEFAULT = generateBaseStripper(DEFAULT_KEYS)

        fun generateBaseStripper(keys: Collection<String>): SecureInfoStripper {
            return SecureInfoStripper()
                .withRule("(${keys.joinToString("|")})=$SENSITIVE_VALUE_PATTERN".toRegex(RegexOption.IGNORE_CASE), { match -> "${match.groupValues[1]}=<HIDE>" })
                .withRule("(${keys.joinToString("|")}):$SENSITIVE_VALUE_PATTERN".toRegex(RegexOption.IGNORE_CASE), { match -> "${match.groupValues[1]}:<HIDE>" })
                .withRule("\"(${keys.joinToString("|")})\":\"$SENSITIVE_VALUE_PATTERN\"".toRegex(RegexOption.IGNORE_CASE), { match -> "\"${match.groupValues[1]}\":\"<HIDE>\"" })
                .withRule("\\{\"key\":\"(${keys.joinToString("|")})\",\"value\":\"${SENSITIVE_VALUE_PATTERN}\"".toRegex(RegexOption.IGNORE_CASE), { match -> "\"${match.groupValues[1]}:<HIDE>\"}" })
        }
    }
}
