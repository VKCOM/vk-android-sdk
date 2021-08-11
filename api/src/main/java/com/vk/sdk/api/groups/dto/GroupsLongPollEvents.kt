/**
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
*/
// *********************************************************************
// THIS FILE IS AUTO GENERATED!
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING.
// *********************************************************************
package com.vk.sdk.api.groups.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt

/**
 * @param audioNew
 * @param boardPostDelete
 * @param boardPostEdit
 * @param boardPostNew
 * @param boardPostRestore
 * @param groupChangePhoto
 * @param groupChangeSettings
 * @param groupJoin
 * @param groupLeave
 * @param groupOfficersEdit
 * @param marketCommentDelete
 * @param marketCommentEdit
 * @param marketCommentNew
 * @param marketCommentRestore
 * @param messageAllow
 * @param messageDeny
 * @param messageNew
 * @param messageRead
 * @param messageReply
 * @param messageTypingState
 * @param messageEdit
 * @param photoCommentDelete
 * @param photoCommentEdit
 * @param photoCommentNew
 * @param photoCommentRestore
 * @param photoNew
 * @param pollVoteNew
 * @param userBlock
 * @param userUnblock
 * @param videoCommentDelete
 * @param videoCommentEdit
 * @param videoCommentNew
 * @param videoCommentRestore
 * @param videoNew
 * @param wallPostNew
 * @param wallReplyDelete
 * @param wallReplyEdit
 * @param wallReplyNew
 * @param wallReplyRestore
 * @param wallRepost
 * @param donutSubscriptionCreate
 * @param donutSubscriptionProlonged
 * @param donutSubscriptionCancelled
 * @param donutSubscriptionExpired
 * @param donutSubscriptionPriceChanged
 * @param donutMoneyWithdraw
 * @param donutMoneyWithdrawError
 * @param leadFormsNew
 * @param marketOrderNew
 * @param marketOrderEdit
 */
data class GroupsLongPollEvents(
    @SerializedName("audio_new")
    val audioNew: BaseBoolInt,
    @SerializedName("board_post_delete")
    val boardPostDelete: BaseBoolInt,
    @SerializedName("board_post_edit")
    val boardPostEdit: BaseBoolInt,
    @SerializedName("board_post_new")
    val boardPostNew: BaseBoolInt,
    @SerializedName("board_post_restore")
    val boardPostRestore: BaseBoolInt,
    @SerializedName("group_change_photo")
    val groupChangePhoto: BaseBoolInt,
    @SerializedName("group_change_settings")
    val groupChangeSettings: BaseBoolInt,
    @SerializedName("group_join")
    val groupJoin: BaseBoolInt,
    @SerializedName("group_leave")
    val groupLeave: BaseBoolInt,
    @SerializedName("group_officers_edit")
    val groupOfficersEdit: BaseBoolInt,
    @SerializedName("market_comment_delete")
    val marketCommentDelete: BaseBoolInt,
    @SerializedName("market_comment_edit")
    val marketCommentEdit: BaseBoolInt,
    @SerializedName("market_comment_new")
    val marketCommentNew: BaseBoolInt,
    @SerializedName("market_comment_restore")
    val marketCommentRestore: BaseBoolInt,
    @SerializedName("message_allow")
    val messageAllow: BaseBoolInt,
    @SerializedName("message_deny")
    val messageDeny: BaseBoolInt,
    @SerializedName("message_new")
    val messageNew: BaseBoolInt,
    @SerializedName("message_read")
    val messageRead: BaseBoolInt,
    @SerializedName("message_reply")
    val messageReply: BaseBoolInt,
    @SerializedName("message_typing_state")
    val messageTypingState: BaseBoolInt,
    @SerializedName("message_edit")
    val messageEdit: BaseBoolInt,
    @SerializedName("photo_comment_delete")
    val photoCommentDelete: BaseBoolInt,
    @SerializedName("photo_comment_edit")
    val photoCommentEdit: BaseBoolInt,
    @SerializedName("photo_comment_new")
    val photoCommentNew: BaseBoolInt,
    @SerializedName("photo_comment_restore")
    val photoCommentRestore: BaseBoolInt,
    @SerializedName("photo_new")
    val photoNew: BaseBoolInt,
    @SerializedName("poll_vote_new")
    val pollVoteNew: BaseBoolInt,
    @SerializedName("user_block")
    val userBlock: BaseBoolInt,
    @SerializedName("user_unblock")
    val userUnblock: BaseBoolInt,
    @SerializedName("video_comment_delete")
    val videoCommentDelete: BaseBoolInt,
    @SerializedName("video_comment_edit")
    val videoCommentEdit: BaseBoolInt,
    @SerializedName("video_comment_new")
    val videoCommentNew: BaseBoolInt,
    @SerializedName("video_comment_restore")
    val videoCommentRestore: BaseBoolInt,
    @SerializedName("video_new")
    val videoNew: BaseBoolInt,
    @SerializedName("wall_post_new")
    val wallPostNew: BaseBoolInt,
    @SerializedName("wall_reply_delete")
    val wallReplyDelete: BaseBoolInt,
    @SerializedName("wall_reply_edit")
    val wallReplyEdit: BaseBoolInt,
    @SerializedName("wall_reply_new")
    val wallReplyNew: BaseBoolInt,
    @SerializedName("wall_reply_restore")
    val wallReplyRestore: BaseBoolInt,
    @SerializedName("wall_repost")
    val wallRepost: BaseBoolInt,
    @SerializedName("donut_subscription_create")
    val donutSubscriptionCreate: BaseBoolInt,
    @SerializedName("donut_subscription_prolonged")
    val donutSubscriptionProlonged: BaseBoolInt,
    @SerializedName("donut_subscription_cancelled")
    val donutSubscriptionCancelled: BaseBoolInt,
    @SerializedName("donut_subscription_expired")
    val donutSubscriptionExpired: BaseBoolInt,
    @SerializedName("donut_subscription_price_changed")
    val donutSubscriptionPriceChanged: BaseBoolInt,
    @SerializedName("donut_money_withdraw")
    val donutMoneyWithdraw: BaseBoolInt,
    @SerializedName("donut_money_withdraw_error")
    val donutMoneyWithdrawError: BaseBoolInt,
    @SerializedName("lead_forms_new")
    val leadFormsNew: BaseBoolInt? = null,
    @SerializedName("market_order_new")
    val marketOrderNew: BaseBoolInt? = null,
    @SerializedName("market_order_edit")
    val marketOrderEdit: BaseBoolInt? = null
)
