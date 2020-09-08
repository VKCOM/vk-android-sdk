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
package com.vk.sdk.api.groups.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Allow to set notifications settings for group.
 * @param groupId Community ID. minimum 0
 * @param serverId Server ID. minimum 0
 * @param apiVersion  
 * @param messageNew A new incoming message has been received ('0' � disabled, '1' � enabled). 
 * @param messageReply A new outcoming message has been received ('0' � disabled, '1' � enabled). 
 * @param messageAllow Allowed messages notifications ('0' � disabled, '1' � enabled). 
 * @param messageEdit  
 * @param messageDeny Denied messages notifications ('0' � disabled, '1' � enabled). 
 * @param messageTypingState  
 * @param photoNew New photos notifications ('0' � disabled, '1' � enabled). 
 * @param audioNew New audios notifications ('0' � disabled, '1' � enabled). 
 * @param videoNew New videos notifications ('0' � disabled, '1' � enabled). 
 * @param wallReplyNew New wall replies notifications ('0' � disabled, '1' � enabled). 
 * @param wallReplyEdit Wall replies edited notifications ('0' � disabled, '1' � enabled). 
 * @param wallReplyDelete A wall comment has been deleted ('0' � disabled, '1' � enabled). 
 * @param wallReplyRestore A wall comment has been restored ('0' � disabled, '1' � enabled). 
 * @param wallPostNew New wall posts notifications ('0' � disabled, '1' � enabled). 
 * @param wallRepost New wall posts notifications ('0' � disabled, '1' � enabled). 
 * @param boardPostNew New board posts notifications ('0' � disabled, '1' � enabled). 
 * @param boardPostEdit Board posts edited notifications ('0' � disabled, '1' � enabled). 
 * @param boardPostRestore Board posts restored notifications ('0' � disabled, '1' � enabled). 
 * @param boardPostDelete Board posts deleted notifications ('0' � disabled, '1' � enabled). 
 * @param photoCommentNew New comment to photo notifications ('0' � disabled, '1' � enabled). 
 * @param photoCommentEdit A photo comment has been edited ('0' � disabled, '1' � enabled). 
 * @param photoCommentDelete A photo comment has been deleted ('0' � disabled, '1' � enabled). 
 * @param photoCommentRestore A photo comment has been restored ('0' � disabled, '1' � enabled). 
 * @param videoCommentNew New comment to video notifications ('0' � disabled, '1' � enabled). 
 * @param videoCommentEdit A video comment has been edited ('0' � disabled, '1' � enabled). 
 * @param videoCommentDelete A video comment has been deleted ('0' � disabled, '1' � enabled). 
 * @param videoCommentRestore A video comment has been restored ('0' � disabled, '1' � enabled). 
 * @param marketCommentNew New comment to market item notifications ('0' � disabled, '1' � enabled).
 * 
 * @param marketCommentEdit A market comment has been edited ('0' � disabled, '1' � enabled). 
 * @param marketCommentDelete A market comment has been deleted ('0' � disabled, '1' � enabled). 
 * @param marketCommentRestore A market comment has been restored ('0' � disabled, '1' � enabled). 
 * @param pollVoteNew A vote in a public poll has been added ('0' � disabled, '1' � enabled). 
 * @param groupJoin Joined community notifications ('0' � disabled, '1' � enabled). 
 * @param groupLeave Left community notifications ('0' � disabled, '1' � enabled). 
 * @param groupChangeSettings  
 * @param groupChangePhoto  
 * @param groupOfficersEdit  
 * @param userBlock User added to community blacklist 
 * @param userUnblock User removed from community blacklist 
 * @param leadFormsNew New form in lead forms 
 * @param likeAdd  
 * @param likeRemove  
 * @param messageEvent  
 */
class GroupsSetCallbackSettings(
    private val groupId: Int,
    private val serverId: Int? = null,
    private val apiVersion: String? = null,
    private val messageNew: Boolean? = null,
    private val messageReply: Boolean? = null,
    private val messageAllow: Boolean? = null,
    private val messageEdit: Boolean? = null,
    private val messageDeny: Boolean? = null,
    private val messageTypingState: Boolean? = null,
    private val photoNew: Boolean? = null,
    private val audioNew: Boolean? = null,
    private val videoNew: Boolean? = null,
    private val wallReplyNew: Boolean? = null,
    private val wallReplyEdit: Boolean? = null,
    private val wallReplyDelete: Boolean? = null,
    private val wallReplyRestore: Boolean? = null,
    private val wallPostNew: Boolean? = null,
    private val wallRepost: Boolean? = null,
    private val boardPostNew: Boolean? = null,
    private val boardPostEdit: Boolean? = null,
    private val boardPostRestore: Boolean? = null,
    private val boardPostDelete: Boolean? = null,
    private val photoCommentNew: Boolean? = null,
    private val photoCommentEdit: Boolean? = null,
    private val photoCommentDelete: Boolean? = null,
    private val photoCommentRestore: Boolean? = null,
    private val videoCommentNew: Boolean? = null,
    private val videoCommentEdit: Boolean? = null,
    private val videoCommentDelete: Boolean? = null,
    private val videoCommentRestore: Boolean? = null,
    private val marketCommentNew: Boolean? = null,
    private val marketCommentEdit: Boolean? = null,
    private val marketCommentDelete: Boolean? = null,
    private val marketCommentRestore: Boolean? = null,
    private val pollVoteNew: Boolean? = null,
    private val groupJoin: Boolean? = null,
    private val groupLeave: Boolean? = null,
    private val groupChangeSettings: Boolean? = null,
    private val groupChangePhoto: Boolean? = null,
    private val groupOfficersEdit: Boolean? = null,
    private val userBlock: Boolean? = null,
    private val userUnblock: Boolean? = null,
    private val leadFormsNew: Boolean? = null,
    private val likeAdd: Boolean? = null,
    private val likeRemove: Boolean? = null,
    private val messageEvent: Boolean? = null
) : VKRequest<BaseOkResponseDto>("groups.setCallbackSettings") {
    init {
        addParam("group_id", groupId)
        serverId?.let { value ->
            addParam("server_id", value)
        }
        apiVersion?.let { value ->
            addParam("api_version", value)
        }
        messageNew?.let { value ->
            addParam("message_new", if (value) 1 else 0)
        }
        messageReply?.let { value ->
            addParam("message_reply", if (value) 1 else 0)
        }
        messageAllow?.let { value ->
            addParam("message_allow", if (value) 1 else 0)
        }
        messageEdit?.let { value ->
            addParam("message_edit", if (value) 1 else 0)
        }
        messageDeny?.let { value ->
            addParam("message_deny", if (value) 1 else 0)
        }
        messageTypingState?.let { value ->
            addParam("message_typing_state", if (value) 1 else 0)
        }
        photoNew?.let { value ->
            addParam("photo_new", if (value) 1 else 0)
        }
        audioNew?.let { value ->
            addParam("audio_new", if (value) 1 else 0)
        }
        videoNew?.let { value ->
            addParam("video_new", if (value) 1 else 0)
        }
        wallReplyNew?.let { value ->
            addParam("wall_reply_new", if (value) 1 else 0)
        }
        wallReplyEdit?.let { value ->
            addParam("wall_reply_edit", if (value) 1 else 0)
        }
        wallReplyDelete?.let { value ->
            addParam("wall_reply_delete", if (value) 1 else 0)
        }
        wallReplyRestore?.let { value ->
            addParam("wall_reply_restore", if (value) 1 else 0)
        }
        wallPostNew?.let { value ->
            addParam("wall_post_new", if (value) 1 else 0)
        }
        wallRepost?.let { value ->
            addParam("wall_repost", if (value) 1 else 0)
        }
        boardPostNew?.let { value ->
            addParam("board_post_new", if (value) 1 else 0)
        }
        boardPostEdit?.let { value ->
            addParam("board_post_edit", if (value) 1 else 0)
        }
        boardPostRestore?.let { value ->
            addParam("board_post_restore", if (value) 1 else 0)
        }
        boardPostDelete?.let { value ->
            addParam("board_post_delete", if (value) 1 else 0)
        }
        photoCommentNew?.let { value ->
            addParam("photo_comment_new", if (value) 1 else 0)
        }
        photoCommentEdit?.let { value ->
            addParam("photo_comment_edit", if (value) 1 else 0)
        }
        photoCommentDelete?.let { value ->
            addParam("photo_comment_delete", if (value) 1 else 0)
        }
        photoCommentRestore?.let { value ->
            addParam("photo_comment_restore", if (value) 1 else 0)
        }
        videoCommentNew?.let { value ->
            addParam("video_comment_new", if (value) 1 else 0)
        }
        videoCommentEdit?.let { value ->
            addParam("video_comment_edit", if (value) 1 else 0)
        }
        videoCommentDelete?.let { value ->
            addParam("video_comment_delete", if (value) 1 else 0)
        }
        videoCommentRestore?.let { value ->
            addParam("video_comment_restore", if (value) 1 else 0)
        }
        marketCommentNew?.let { value ->
            addParam("market_comment_new", if (value) 1 else 0)
        }
        marketCommentEdit?.let { value ->
            addParam("market_comment_edit", if (value) 1 else 0)
        }
        marketCommentDelete?.let { value ->
            addParam("market_comment_delete", if (value) 1 else 0)
        }
        marketCommentRestore?.let { value ->
            addParam("market_comment_restore", if (value) 1 else 0)
        }
        pollVoteNew?.let { value ->
            addParam("poll_vote_new", if (value) 1 else 0)
        }
        groupJoin?.let { value ->
            addParam("group_join", if (value) 1 else 0)
        }
        groupLeave?.let { value ->
            addParam("group_leave", if (value) 1 else 0)
        }
        groupChangeSettings?.let { value ->
            addParam("group_change_settings", if (value) 1 else 0)
        }
        groupChangePhoto?.let { value ->
            addParam("group_change_photo", if (value) 1 else 0)
        }
        groupOfficersEdit?.let { value ->
            addParam("group_officers_edit", if (value) 1 else 0)
        }
        userBlock?.let { value ->
            addParam("user_block", if (value) 1 else 0)
        }
        userUnblock?.let { value ->
            addParam("user_unblock", if (value) 1 else 0)
        }
        leadFormsNew?.let { value ->
            addParam("lead_forms_new", if (value) 1 else 0)
        }
        likeAdd?.let { value ->
            addParam("like_add", if (value) 1 else 0)
        }
        likeRemove?.let { value ->
            addParam("like_remove", if (value) 1 else 0)
        }
        messageEvent?.let { value ->
            addParam("message_event", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
