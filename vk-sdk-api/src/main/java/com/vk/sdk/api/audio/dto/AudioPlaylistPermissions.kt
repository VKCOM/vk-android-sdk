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
import kotlin.Boolean

/**
 * @param play - Permission to play playlist
 * @param share - Permission to share playlist
 * @param edit - Permission to edit playlist
 * @param follow - Permission to follow/unfollow playlist
 * @param delete - Permission to delete playlist
 * @param boomDownload - Permission to download playlist
 * @param saveAsCopy - Permission to save generated playlist as copy of its content
 */
data class AudioPlaylistPermissions(
    @SerializedName("play")
    val play: Boolean? = null,
    @SerializedName("share")
    val share: Boolean? = null,
    @SerializedName("edit")
    val edit: Boolean? = null,
    @SerializedName("follow")
    val follow: Boolean? = null,
    @SerializedName("delete")
    val delete: Boolean? = null,
    @SerializedName("boom_download")
    val boomDownload: Boolean? = null,
    @SerializedName("save_as_copy")
    val saveAsCopy: Boolean? = null
)
