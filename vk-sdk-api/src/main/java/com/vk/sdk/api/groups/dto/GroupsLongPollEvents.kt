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
 * @param audioNew no description
 * @param boardPostDelete no description
 * @param boardPostEdit no description
 * @param boardPostNew no description
 * @param boardPostRestore no description
 * @param groupChangePhoto no description
 * @param groupChangeSettings no description
 * @param groupJoin no description
 * @param groupLeave no description
 * @param groupOfficersEdit no description
 * @param marketCommentDelete no description
 * @param marketCommentEdit no description
 * @param marketCommentNew no description
 * @param marketCommentRestore no description
 * @param messageAllow no description
 * @param messageDeny no description
 * @param messageNew no description
 * @param messageRead no description
 * @param messageReply no description
 * @param messageTypingState no description
 * @param messageEdit no description
 * @param photoCommentDelete no description
 * @param photoCommentEdit no description
 * @param photoCommentNew no description
 * @param photoCommentRestore no description
 * @param photoNew no description
 * @param pollVoteNew no description
 * @param userBlock no description
 * @param userUnblock no description
 * @param videoCommentDelete no description
 * @param videoCommentEdit no description
 * @param videoCommentNew no description
 * @param videoCommentRestore no description
 * @param videoNew no description
 * @param wallPostNew no description
 * @param wallReplyDelete no description
 * @param wallReplyEdit no description
 * @param wallReplyNew no description
 * @param wallReplyRestore no description
 * @param wallRepost no description
 * @param leadFormsNew no description
 */
data class GroupsLongPollEvents(
    @SerializedName(value="audio_new")
    val audioNew: BaseBoolInt,
    @SerializedName(value="board_post_delete")
    val boardPostDelete: BaseBoolInt,
    @SerializedName(value="board_post_edit")
    val boardPostEdit: BaseBoolInt,
    @SerializedName(value="board_post_new")
    val boardPostNew: BaseBoolInt,
    @SerializedName(value="board_post_restore")
    val boardPostRestore: BaseBoolInt,
    @SerializedName(value="group_change_photo")
    val groupChangePhoto: BaseBoolInt,
    @SerializedName(value="group_change_settings")
    val groupChangeSettings: BaseBoolInt,
    @SerializedName(value="group_join")
    val groupJoin: BaseBoolInt,
    @SerializedName(value="group_leave")
    val groupLeave: BaseBoolInt,
    @SerializedName(value="group_officers_edit")
    val groupOfficersEdit: BaseBoolInt,
    @SerializedName(value="market_comment_delete")
    val marketCommentDelete: BaseBoolInt,
    @SerializedName(value="market_comment_edit")
    val marketCommentEdit: BaseBoolInt,
    @SerializedName(value="market_comment_new")
    val marketCommentNew: BaseBoolInt,
    @SerializedName(value="market_comment_restore")
    val marketCommentRestore: BaseBoolInt,
    @SerializedName(value="message_allow")
    val messageAllow: BaseBoolInt,
    @SerializedName(value="message_deny")
    val messageDeny: BaseBoolInt,
    @SerializedName(value="message_new")
    val messageNew: BaseBoolInt,
    @SerializedName(value="message_read")
    val messageRead: BaseBoolInt,
    @SerializedName(value="message_reply")
    val messageReply: BaseBoolInt,
    @SerializedName(value="message_typing_state")
    val messageTypingState: BaseBoolInt,
    @SerializedName(value="message_edit")
    val messageEdit: BaseBoolInt,
    @SerializedName(value="photo_comment_delete")
    val photoCommentDelete: BaseBoolInt,
    @SerializedName(value="photo_comment_edit")
    val photoCommentEdit: BaseBoolInt,
    @SerializedName(value="photo_comment_new")
    val photoCommentNew: BaseBoolInt,
    @SerializedName(value="photo_comment_restore")
    val photoCommentRestore: BaseBoolInt,
    @SerializedName(value="photo_new")
    val photoNew: BaseBoolInt,
    @SerializedName(value="poll_vote_new")
    val pollVoteNew: BaseBoolInt,
    @SerializedName(value="user_block")
    val userBlock: BaseBoolInt,
    @SerializedName(value="user_unblock")
    val userUnblock: BaseBoolInt,
    @SerializedName(value="video_comment_delete")
    val videoCommentDelete: BaseBoolInt,
    @SerializedName(value="video_comment_edit")
    val videoCommentEdit: BaseBoolInt,
    @SerializedName(value="video_comment_new")
    val videoCommentNew: BaseBoolInt,
    @SerializedName(value="video_comment_restore")
    val videoCommentRestore: BaseBoolInt,
    @SerializedName(value="video_new")
    val videoNew: BaseBoolInt,
    @SerializedName(value="wall_post_new")
    val wallPostNew: BaseBoolInt,
    @SerializedName(value="wall_reply_delete")
    val wallReplyDelete: BaseBoolInt,
    @SerializedName(value="wall_reply_edit")
    val wallReplyEdit: BaseBoolInt,
    @SerializedName(value="wall_reply_new")
    val wallReplyNew: BaseBoolInt,
    @SerializedName(value="wall_reply_restore")
    val wallReplyRestore: BaseBoolInt,
    @SerializedName(value="wall_repost")
    val wallRepost: BaseBoolInt,
    @SerializedName(value="lead_forms_new")
    val leadFormsNew: BaseBoolInt? = null
)
