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
package com.vk.sdk.api.audio.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseImage
import com.vk.sdk.api.groups.dto.GroupsGroupFull
import com.vk.sdk.api.users.dto.UsersUser
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param name - Artist name
 * @param domain - Artist domain
 * @param id - Artist ID
 * @param isAlbumCover - Mark shows that artist has no official cover, last album thumb is used
 * instead
 * @param photo - Artist photos
 * @param photos - Artist photos by type
 * @param isFollowed - Is user follow this artist
 * @param canFollow - Can be this artist followed by user
 * @param canPlay
 * @param genres - Artist genres
 * @param bio - Artist bio
 * @param pages - Artist pages
 * @param profiles
 * @param groups
 */
data class AudioArtist(
    @SerializedName("name")
    val name: String,
    @SerializedName("domain")
    val domain: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_album_cover")
    val isAlbumCover: Boolean? = null,
    @SerializedName("photo")
    val photo: List<BaseImage>? = null,
    @SerializedName("photos")
    val photos: List<AudioPhotosByType>? = null,
    @SerializedName("is_followed")
    val isFollowed: Boolean? = null,
    @SerializedName("can_follow")
    val canFollow: Boolean? = null,
    @SerializedName("can_play")
    val canPlay: Boolean? = null,
    @SerializedName("genres")
    val genres: List<AudioGenre>? = null,
    @SerializedName("bio")
    val bio: String? = null,
    @SerializedName("pages")
    val pages: List<Int>? = null,
    @SerializedName("profiles")
    val profiles: List<UsersUser>? = null,
    @SerializedName("groups")
    val groups: List<GroupsGroupFull>? = null
)
