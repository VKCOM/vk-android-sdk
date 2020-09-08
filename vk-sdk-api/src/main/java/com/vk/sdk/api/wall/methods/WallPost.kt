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
package com.vk.sdk.api.wall.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.wall.dto.WallPostResponseDto
import com.vk.sdk.api.wall.responses.WallPostResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Adds a new post on a user wall or community wall. Can also be used to publish suggested or
 * scheduled posts.
 * @param ownerId User ID or community ID. Use a negative value to designate a community ID. 
 * @param friendsOnly '1' � post will be available to friends only, '0' � post will be available to
 * all users (default) 
 * @param fromGroup For a community: '1' � post will be published by the community, '0' � post will
 * be published by the user (default) 
 * @param message (Required if 'attachments' is not set.) Text of the post. 
 * @param attachments (Required if 'message' is not set.) List of objects attached to the post, in
 * the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media attachment:
 * 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, 'page' � wiki-page, 'note' �
 * note, 'poll' � poll, 'album' � photo album, '<owner_id>' � ID of the media application owner.
 * '<media_id>' � Media application ID. Example: "photo100172_166443618,photo66748_265827614", May
 * contain a link to an external page to include in the post. Example:
 * "photo66748_265827614,http://habrahabr.ru", "NOTE: If more than one link is being attached, an error
 * will be thrown." 
 * @param services List of services or websites the update will be exported to, if the user has so
 * requested. Sample values: 'twitter', 'facebook'. 
 * @param signed Only for posts in communities with 'from_group' set to '1': '1' � post will be
 * signed with the name of the posting user, '0' � post will not be signed (default) 
 * @param publishDate Publication date (in Unix time). If used, posting will be delayed until the
 * set time. minimum 0
 * @param lat Geographical latitude of a check-in, in degrees (from -90 to 90). 
 * @param long Geographical longitude of a check-in, in degrees (from -180 to 180). 
 * @param placeId ID of the location where the user was tagged. minimum 0
 * @param postId Post ID. Used for publishing of scheduled and suggested posts. minimum 0
 * @param guid  
 * @param markAsAds  default false
 * @param closeComments  
 * @param muteNotifications  
 * @param copyright  
 */
class WallPost(
    private val ownerId: Int? = null,
    private val friendsOnly: Boolean? = null,
    private val fromGroup: Boolean? = null,
    private val message: String? = null,
    private val attachments: List<String>? = null,
    private val services: String? = null,
    private val signed: Boolean? = null,
    private val publishDate: Int? = null,
    private val lat: Float? = null,
    private val long: Float? = null,
    private val placeId: Int? = null,
    private val postId: Int? = null,
    private val guid: String? = null,
    private val markAsAds: Boolean? = null,
    private val closeComments: Boolean? = null,
    private val muteNotifications: Boolean? = null,
    private val copyright: String? = null
) : VKRequest<WallPostResponseDto>("wall.post") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        friendsOnly?.let { value ->
            addParam("friends_only", if (value) 1 else 0)
        }
        fromGroup?.let { value ->
            addParam("from_group", if (value) 1 else 0)
        }
        message?.let { value ->
            addParam("message", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
        services?.let { value ->
            addParam("services", value)
        }
        signed?.let { value ->
            addParam("signed", if (value) 1 else 0)
        }
        publishDate?.let { value ->
            addParam("publish_date", value)
        }
        lat?.let { value ->
            addParam("lat", value.toString())
        }
        long?.let { value ->
            addParam("long", value.toString())
        }
        placeId?.let { value ->
            addParam("place_id", value)
        }
        postId?.let { value ->
            addParam("post_id", value)
        }
        guid?.let { value ->
            addParam("guid", value)
        }
        markAsAds?.let { value ->
            addParam("mark_as_ads", if (value) 1 else 0)
        }
        closeComments?.let { value ->
            addParam("close_comments", if (value) 1 else 0)
        }
        muteNotifications?.let { value ->
            addParam("mute_notifications", if (value) 1 else 0)
        }
        copyright?.let { value ->
            addParam("copyright", value)
        }
    }

    override fun parse(r: JSONObject): WallPostResponseDto = GsonHolder.gson.fromJson(r.toString(),
            WallPostResponse::class.java).response
}
