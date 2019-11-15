/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 vk.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package com.vk.api.sdk.exceptions

object VKApiCodes {
    const val CODE_COMPOSITE_EXECUTE_ERROR = Int.MIN_VALUE
    const val CODE_IO_ERROR = -1
    const val CODE_UNKNOWN_ERROR = 1
    const val CODE_APP_DISABLED = 2
    const val CODE_UNKNOWN_METHOD = 3
    const val CODE_INVALID_SIGNATURE = 4
    const val CODE_AUTHORIZATION_FAILED = 5
    const val CODE_TOO_MANY_REQUESTS_PER_SECOND = 6
    const val CODE_NO_PERMISSIONS = 7
    const val CODE_INVALID_REQUEST = 8
    const val CODE_TOO_MANY_SIMILAR_REQUESTS = 9
    const val CODE_INTERNAL_SERVER_ERROR = 10
    const val CODE_INTERNAL_EXECUTE_ERROR = 13
    const val CODE_APP_MUST_BE_TURNED_OFF_WHILE_TESTING = 11
    const val CODE_CAPTCHA_REQUIRED = 14
    const val CODE_ACCESS_DENIED = 15
    const val CODE_HTTPS_REQUIRED = 16
    const val CODE_USER_VALIDATION_REQUIRED = 17
    const val CODE_USER_WAS_DELETED_OR_BANNED = 18
    const val CODE_OPERATION_DENIED_FOR_NON_STANDALONE_APP = 20
    const val CODE_OPERATION_AVAILABLE_ONLY_FOR_STANDALONE_AND_OPEN_API_APPS = 21
    const val CODE_INVALID_PHOTO_UPLOAD = 22
    const val CODE_METHOD_NOT_SUPPORTED = 23
    const val CODE_USER_CONFIRM_REQUIRED = 24
    const val CODE_TOKEN_CONFIRMATION_REQUIRED = 25
    const val CODE_PRIVATE_PROFILE = 30
    const val CODE_REQUIRED_ARG_NOT_FOUND = 100
    const val CODE_INVALID_APP_IDENTIFIER = 101
    const val CODE_ERROR_LIMITS = 103
    const val CODE_TOO_MANY_CHAT_USERS = CODE_ERROR_LIMITS
    const val CODE_NOT_FOUND = 104
    const val CODE_INVALID_USER_IDENTIFIER = 113
    const val CODE_INVALID_TIMESTAMP = 150
    const val CODE_ACCESS_DENIED_TO_ALBUM = 200
    const val CODE_ACCESS_DENIED_TO_AUDIO = 201
    const val CODE_ACCESS_DENIED_TO_GROUP = 203
    const val CODE_ERROR_WALL_ACCESS_REPLIES = 212
    const val CODE_ACCESS_POLLS_WITHOUT_VOTE = 253
    const val CODE_PHOTO_ALBUM_LIMIT_EXCEED = 300
    const val CODE_OPERATION_NOT_PERMITTED = 500
    const val CODE_ADVERTISE_CABINET_NO_PERMISSIONS_FOR_OPERATION = 600
    const val CODE_ADVERTISE_CABINET_ERROR = 603
    const val CODE_VIDEO_ALREADY_ADDED = 800
    const val CODE_ERROR_VIDEO_COMMENTS_CLOSED = 801

    const val CODE_MSG_SEND_RECIPIENT_BLACKLISTED = 900
    const val CODE_MSG_SEND_RECIPIENT_FORBID_GROUPS_MSGS = 901
    const val CODE_MSG_SEND_VIOLATION_OF_PRIVACY_SETTINGS = 902
    const val CODE_MSG_SEND_TO_MANY_FWDS = 913
    const val CODE_MSG_SEND_MSG_TOO_LONG = 914
    const val CODE_MSG_SEND_NO_ACCESS_TO_CHAT = 917
    const val CODE_MSG_SEND_FAIL_TO_RESEND_FWDS = 921

    const val CODE_CLEAR_CACHE_REQUESTED = 907
    const val CODE_CLEAR_CACHE_REQUESTED2 = 908
    const val CODE_CHAT_ACCESS_DENIED = 917
    const val CODE_CHAT_INVITE_MAKE_LINK_DENIED = 919
    const val CODE_MSG_DELETE_FOR_ALL_FAILED = 924
    const val CODE_CHAT_NOT_ADMIN = 925
    const val CODE_CHAT_MR_ALREADY_SEND = 939

    const val CODE_TOO_MANY_CONTACTS_TO_SYNC = 937

    const val CODE_PHONE_PARAM_PHONE = 1000
    const val CODE_PHONE_ALREADY_USED = 1004
    const val CODE_PHONE_AUTH_DELAY = 1112
    const val CODE_INVALID_SID = 1113
    const val CODE_SIGN_UP_CODE_INCORRECT = 1110
    const val CODE_SIGN_UP_PASSWORD_UNALLOWABLE = 1111

    const val CODE_ACCOUNT_INVALID_SCREEN_NAME = 1260

    const val CODE_ERROR_MARKET_COMMENTS_CLOSED = 1401

    const val EXTRA_CAPTCHA_SID = "captcha_sid"
    const val EXTRA_CAPTCHA_KEY = "captcha_key"
    const val EXTRA_CAPTCHA_IMG = "captcha_img"
    const val EXTRA_CONFIRM = "confirm"
    const val EXTRA_VALIDATION_URL = "validation_url"
    const val EXTRA_USER_BAN_INFO = "user_ban_info"
    const val EXTRA_CONFIRMATION_TEXT = "confirmation_text"

    const val PARAM_DEVICE_ID = "device_id"
    const val PARAM_LANG = "lang"
    const val PARAM_REDIRECT_URI = "redirect_uri"
    const val PARAM_CONFIRM_TEXT = "confirmation_text"
    const val PARAM_ERROR = "error"
    const val PARAM_ERROR_CODE = "error_code"
    const val PARAM_EXECUTE_ERRORS = "execute_errors"
    const val PARAM_BAN_INFO = "ban_info"
}