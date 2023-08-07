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
import com.vk.sdk.api.base.dto.BaseBoolIntDto

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
 * @param messageReactionEvent
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
data class GroupsLongPollEventsDto(
    @SerializedName("audio_new")
    val audioNew: BaseBoolIntDto,
    @SerializedName("board_post_delete")
    val boardPostDelete: BaseBoolIntDto,
    @SerializedName("board_post_edit")
    val boardPostEdit: BaseBoolIntDto,
    @SerializedName("board_post_new")
    val boardPostNew: BaseBoolIntDto,
    @SerializedName("board_post_restore")
    val boardPostRestore: BaseBoolIntDto,
    @SerializedName("group_change_photo")
    val groupChangePhoto: BaseBoolIntDto,
    @SerializedName("group_change_settings")
    val groupChangeSettings: BaseBoolIntDto,
    @SerializedName("group_join")
    val groupJoin: BaseBoolIntDto,
    @SerializedName("group_leave")
    val groupLeave: BaseBoolIntDto,
    @SerializedName("group_officers_edit")
    val groupOfficersEdit: BaseBoolIntDto,
    @SerializedName("market_comment_delete")
    val marketCommentDelete: BaseBoolIntDto,
    @SerializedName("market_comment_edit")
    val marketCommentEdit: BaseBoolIntDto,
    @SerializedName("market_comment_new")
    val marketCommentNew: BaseBoolIntDto,
    @SerializedName("market_comment_restore")
    val marketCommentRestore: BaseBoolIntDto,
    @SerializedName("message_allow")
    val messageAllow: BaseBoolIntDto,
    @SerializedName("message_deny")
    val messageDeny: BaseBoolIntDto,
    @SerializedName("message_new")
    val messageNew: BaseBoolIntDto,
    @SerializedName("message_read")
    val messageRead: BaseBoolIntDto,
    @SerializedName("message_reply")
    val messageReply: BaseBoolIntDto,
    @SerializedName("message_typing_state")
    val messageTypingState: BaseBoolIntDto,
    @SerializedName("message_edit")
    val messageEdit: BaseBoolIntDto,
    @SerializedName("photo_comment_delete")
    val photoCommentDelete: BaseBoolIntDto,
    @SerializedName("photo_comment_edit")
    val photoCommentEdit: BaseBoolIntDto,
    @SerializedName("photo_comment_new")
    val photoCommentNew: BaseBoolIntDto,
    @SerializedName("photo_comment_restore")
    val photoCommentRestore: BaseBoolIntDto,
    @SerializedName("photo_new")
    val photoNew: BaseBoolIntDto,
    @SerializedName("poll_vote_new")
    val pollVoteNew: BaseBoolIntDto,
    @SerializedName("user_block")
    val userBlock: BaseBoolIntDto,
    @SerializedName("user_unblock")
    val userUnblock: BaseBoolIntDto,
    @SerializedName("video_comment_delete")
    val videoCommentDelete: BaseBoolIntDto,
    @SerializedName("video_comment_edit")
    val videoCommentEdit: BaseBoolIntDto,
    @SerializedName("video_comment_new")
    val videoCommentNew: BaseBoolIntDto,
    @SerializedName("video_comment_restore")
    val videoCommentRestore: BaseBoolIntDto,
    @SerializedName("video_new")
    val videoNew: BaseBoolIntDto,
    @SerializedName("message_reaction_event")
    val messageReactionEvent: BaseBoolIntDto,
    @SerializedName("wall_post_new")
    val wallPostNew: BaseBoolIntDto,
    @SerializedName("wall_reply_delete")
    val wallReplyDelete: BaseBoolIntDto,
    @SerializedName("wall_reply_edit")
    val wallReplyEdit: BaseBoolIntDto,
    @SerializedName("wall_reply_new")
    val wallReplyNew: BaseBoolIntDto,
    @SerializedName("wall_reply_restore")
    val wallReplyRestore: BaseBoolIntDto,
    @SerializedName("wall_repost")
    val wallRepost: BaseBoolIntDto,
    @SerializedName("donut_subscription_create")
    val donutSubscriptionCreate: BaseBoolIntDto,
    @SerializedName("donut_subscription_prolonged")
    val donutSubscriptionProlonged: BaseBoolIntDto,
    @SerializedName("donut_subscription_cancelled")
    val donutSubscriptionCancelled: BaseBoolIntDto,
    @SerializedName("donut_subscription_expired")
    val donutSubscriptionExpired: BaseBoolIntDto,
    @SerializedName("donut_subscription_price_changed")
    val donutSubscriptionPriceChanged: BaseBoolIntDto,
    @SerializedName("donut_money_withdraw")
    val donutMoneyWithdraw: BaseBoolIntDto,
    @SerializedName("donut_money_withdraw_error")
    val donutMoneyWithdrawError: BaseBoolIntDto,
    @SerializedName("lead_forms_new")
    val leadFormsNew: BaseBoolIntDto? = null,
    @SerializedName("market_order_new")
    val marketOrderNew: BaseBoolIntDto? = null,
    @SerializedName("market_order_edit")
    val marketOrderEdit: BaseBoolIntDto? = null
)
