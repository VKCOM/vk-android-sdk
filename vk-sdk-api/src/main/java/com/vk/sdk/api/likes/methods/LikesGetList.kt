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
package com.vk.sdk.api.likes.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.likes.dto.LikesGetListFilter
import com.vk.sdk.api.likes.dto.LikesGetListFriendsOnly
import com.vk.sdk.api.likes.dto.LikesGetListResponseDto
import com.vk.sdk.api.likes.responses.LikesGetListResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns a list of IDs of users who added the specified object to their 'Likes' list.
 * @param type , Object type: 'post' � post on user or community wall, 'comment' � comment on a wall
 * post, 'photo' � photo, 'audio' � audio, 'video' � video, 'note' � note, 'photo_comment' � comment on
 * the photo, 'video_comment' � comment on the video, 'topic_comment' � comment in the discussion,
 * 'sitepage' � page of the site where the [vk.com/dev/Like|Like widget] is installed 
 * @param ownerId ID of the user, community, or application that owns the object. If the 'type'
 * parameter is set as 'sitepage', the application ID is passed as 'owner_id'. Use negative value for a
 * community id. If the 'type' parameter is not set, the 'owner_id' is assumed to be either the current
 * user or the same application ID as if the 'type' parameter was set to 'sitepage'. 
 * @param itemId Object ID. If 'type' is set as 'sitepage', 'item_id' can include the 'page_id'
 * parameter value used during initialization of the [vk.com/dev/Like|Like widget]. 
 * @param pageUrl URL of the page where the [vk.com/dev/Like|Like widget] is installed. Used instead
 * of the 'item_id' parameter. 
 * @param filter Filters to apply: 'likes' � returns information about all users who liked the
 * object (default), 'copies' � returns information only about users who told their friends about the
 * object 
 * @param friendsOnly Specifies which users are returned: '1' � to return only the current user's
 * friends, '0' � to return all users (default) default 0
 * @param extended Specifies whether extended information will be returned. '1' � to return extended
 * information about users and communities from the 'Likes' list, '0' � to return no additional
 * information (default) 
 * @param offset Offset needed to select a specific subset of users. minimum 0
 * @param count Number of user IDs to return (maximum '1000'). Default is '100' if 'friends_only' is
 * set to '0', otherwise, the default is '10' if 'friends_only' is set to '1'. minimum 0
 * @param skipOwn  
 */
class LikesGetList(
    private val type: String,
    private val ownerId: Int? = null,
    private val itemId: Int? = null,
    private val pageUrl: String? = null,
    private val filter: LikesGetListFilter? = null,
    private val friendsOnly: LikesGetListFriendsOnly? = null,
    private val extended: Boolean? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val skipOwn: Boolean? = null
) : VKRequest<LikesGetListResponseDto>("likes.getList") {
    init {
        addParam("type", type)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        itemId?.let { value ->
            addParam("item_id", value)
        }
        pageUrl?.let { value ->
            addParam("page_url", value)
        }
        filter?.let { value ->
            addParam("filter", value.value)
        }
        friendsOnly?.let { value ->
            addParam("friends_only", value.value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        skipOwn?.let { value ->
            addParam("skip_own", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): LikesGetListResponseDto =
            GsonHolder.gson.fromJson(r.toString(), LikesGetListResponse::class.java).response
}
