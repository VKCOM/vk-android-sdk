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
    const val CODE_IGNORED_ACCESS_TOKEN = -2
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
    const val CODE_CONTENT_BLOCKED = 19
    const val CODE_OPERATION_DENIED_FOR_NON_STANDALONE_APP = 20
    const val CODE_OPERATION_AVAILABLE_ONLY_FOR_STANDALONE_AND_OPEN_API_APPS = 21
    const val CODE_INVALID_PHOTO_UPLOAD = 22
    const val CODE_METHOD_NOT_SUPPORTED = 23
    const val CODE_USER_CONFIRM_REQUIRED = 24
    const val CODE_TOKEN_CONFIRMATION_REQUIRED = 25
    const val CODE_RATE_LIMIT_REACHED = 29
    const val CODE_PRIVATE_PROFILE = 30
    const val CODE_CLIENT_VERSION_DEPRECATED = 34
    const val CODE_CLIENT_UPDATE_NEEDED = 35
    const val CODE_REQUIRED_ARG_NOT_FOUND = 100
    const val CODE_INVALID_APP_IDENTIFIER = 101

    const val CODE_ERROR_LIMITS = 103
    const val SUBCODE_TOO_MANY_COMMUNITIES = 1

    const val CODE_TOO_MANY_CHAT_USERS = CODE_ERROR_LIMITS
    const val CODE_NOT_FOUND = 104
    const val CODE_INVALID_USER_IDENTIFIER = 113
    const val CODE_INVALID_PHOTO_FORMAT = 129
    const val CODE_INVALID_TIMESTAMP = 150
    const val CODE_ACCESS_DENIED_TO_ALBUM = 200
    const val CODE_ACCESS_DENIED_TO_AUDIO = 201
    const val CODE_ACCESS_DENIED_TO_GROUP = 203
    const val CODE_ERROR_WALL_ACCESS_REPLIES = 212
    const val CODE_ACCESS_POLLS_WITHOUT_VOTE = 253
    const val CODE_PHOTO_ALBUM_LIMIT_EXCEED = 300
    const val CODE_OPERATION_NOT_PERMITTED = 500

    const val CODE_VK_PAY_NOT_ENOUGH_MONEY = 504
    const val CODE_VK_PAY_INVALID_AMOUNT = 506
    const val CODE_VK_PAY_INVALID_PIN = 509

    const val CODE_ADVERTISE_CABINET_NO_PERMISSIONS_FOR_OPERATION = 600
    const val CODE_ADVERTISE_CABINET_ERROR = 603
    const val CODE_INVITE_LINK_AVAILABLE_FOR_CLOSED_GROUPS = 713
    const val CODE_INVITE_LINK_EXPIRED = 714
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
    const val CODE_ADD_CHAT_MEMBER_ACCESS_TO_GROUP_DENIED = 947
    const val CODE_CALL_HAS_BEEN_FINISHED = 951
    const val CODE_CALL_INVALID_SECRET = 952

    const val CODE_TOO_MANY_CONTACTS_TO_SYNC = 937

    const val CODE_INVALID_NAME = 953
    const val CODE_INVALID_AUDIO_TRANSCRIPTION = 959

    const val CODE_CALL_REQUIRES_AUTH = 960
    const val CODE_CALL_LINK_OUTDATED = 961
    const val CODE_CHAT_ALREADY_IN_ARCHIVE = 964
    const val CODE_CHAT_NOT_IN_ARCHIVE = 965

    const val CODE_PHONE_PARAM_PHONE = 1000
    const val CODE_PHONE_ALREADY_USED = 1004
    const val CODE_PHONE_AUTH_DELAY = 1112
    const val CODE_INVALID_SID = 1113
    const val CODE_SIGN_UP_CODE_INCORRECT = 1110
    const val CODE_SIGN_UP_PASSWORD_UNALLOWABLE = 1111
    const val CODE_ANONYM_TOKEN_EXPIRED = 1114
    const val CODE_SUPER_APP_TOKEN_INVALID = 1115
    const val CODE_ANONYM_TOKEN_INVALID = 1116
    const val CODE_STICKERS_DISABLED = 1191

    const val CODE_ERROR_APPS_MENU_TOO_MANY_APPS = 1259
    const val CODE_ACCOUNT_INVALID_SCREEN_NAME = 1260

    const val CODE_ERROR_MARKET_COMMENTS_CLOSED = 1401
    const val CODE_ERROR_MARKET_ITEM_NOT_FOUND = 1403

    const val CODE_TEXT_LIVE_EMPTY_MESSAGE = 2600
    const val CODE_TEXT_LIVE_MORE_ONE_ATTACH = 2601
    const val CODE_TEXT_LIVE_WRONG_AUTHOR = 2602
    const val CODE_TEXT_LIVE_FINISHED = 2603
    const val CODE_TEXT_LIVE_UNAVAILABLE = 2604
    const val CODE_TEXT_LIVE_SERVER_ERROR = 2605
    const val CODE_TEXT_LIVE_LARGE_MESSAGE = 2606

    const val CODE_ERROR_NEED_TOKEN_EXTENSION = 3609
    const val CODE_ERROR_USER_DEACTIVATED = 3610
    const val CODE_ERROR_ALREADY_HAS_EXTERNAL_BINDING = 3612

    const val CODE_COMMUNITY_NOT_FOUND = 4519
    const val CODE_INVALID_PHOTO_ID = 4520
    const val CODE_PHOTO_ACCESS_ERROR = 4525
    const val CODE_PRODUCT_DUPLICATE_ERROR = 4527

    const val CODE_ERROR_UPLOAD_PHOTO_DECODE_FAILED = 4600
    const val CODE_ERROR_UPLOAD_PHOTO_WRONG_IMAGE_SIZE = 4601
    const val CODE_ERROR_UPLOAD_PHOTO_PREPROCESS_FAILED = 4602

    const val CODE_ERROR_UNAVAILABLE_REGISTRATION = 5400
    const val CODE_ERROR_CANNOT_TRANSFER_MONEY_YOURSELF = 5800

    const val EXTRA_CAPTCHA_SID = "captcha_sid"
    const val EXTRA_CAPTCHA_KEY = "captcha_key"
    const val EXTRA_CAPTCHA_IMG = "captcha_img"
    const val EXTRA_CONFIRM = "confirm"
    const val EXTRA_VALIDATION_URL = "validation_url"
    const val EXTRA_USER_BAN_INFO = "user_ban_info"
    const val EXTRA_CONFIRMATION_TEXT = "confirmation_text"
    const val EXTRA_EXTENSION_HASH = "extend_hash"
    const val EXTRA_ACCESS_TOKEN = "access_token"
    const val EXTRA_AUTH_ERROR = "error"
    const val EXTRA_VW_LOGIN_ERROR = "vw_login_error"

    const val PARAM_DEVICE_ID = "device_id"
    const val PARAM_LANG = "lang"
    const val PARAM_REDIRECT_URI = "redirect_uri"
    const val PARAM_CONFIRM_TEXT = "confirmation_text"
    const val PARAM_ERROR = "error"
    const val PARAM_ERROR_CODE = "error_code"
    const val PARAM_EXECUTE_ERRORS = "execute_errors"
    const val PARAM_BAN_INFO = "ban_info"
}