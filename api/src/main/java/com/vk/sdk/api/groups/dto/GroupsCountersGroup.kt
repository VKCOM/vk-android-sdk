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
import kotlin.Int

/**
 * @param addresses - Addresses number
 * @param albums - Photo albums number
 * @param audios - Audios number
 * @param audioPlaylists - Audio playlists number
 * @param docs - Docs number
 * @param market - Market items number
 * @param photos - Photos number
 * @param topics - Topics number
 * @param videos - Videos number
 * @param marketServices - Market services number
 * @param podcasts - Podcasts number
 * @param articles - Articles number
 * @param narratives - Narratives number
 * @param clips - Clips number
 * @param clipsFollowers - Clips followers number
 */
data class GroupsCountersGroup(
    @SerializedName("addresses")
    val addresses: Int? = null,
    @SerializedName("albums")
    val albums: Int? = null,
    @SerializedName("audios")
    val audios: Int? = null,
    @SerializedName("audio_playlists")
    val audioPlaylists: Int? = null,
    @SerializedName("docs")
    val docs: Int? = null,
    @SerializedName("market")
    val market: Int? = null,
    @SerializedName("photos")
    val photos: Int? = null,
    @SerializedName("topics")
    val topics: Int? = null,
    @SerializedName("videos")
    val videos: Int? = null,
    @SerializedName("market_services")
    val marketServices: Int? = null,
    @SerializedName("podcasts")
    val podcasts: Int? = null,
    @SerializedName("articles")
    val articles: Int? = null,
    @SerializedName("narratives")
    val narratives: Int? = null,
    @SerializedName("clips")
    val clips: Int? = null,
    @SerializedName("clips_followers")
    val clipsFollowers: Int? = null
)
