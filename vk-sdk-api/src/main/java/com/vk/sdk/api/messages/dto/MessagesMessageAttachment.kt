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
package com.vk.sdk.api.messages.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.audio.dto.AudioAudio
import com.vk.sdk.api.base.dto.BaseLink
import com.vk.sdk.api.base.dto.BaseSticker
import com.vk.sdk.api.docs.dto.DocsDoc
import com.vk.sdk.api.gifts.dto.GiftsLayout
import com.vk.sdk.api.market.dto.MarketMarketAlbum
import com.vk.sdk.api.market.dto.MarketMarketItem
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.stories.dto.StoriesStory
import com.vk.sdk.api.video.dto.VideoVideo
import com.vk.sdk.api.wall.dto.WallWallComment
import com.vk.sdk.api.wall.dto.WallWallpostFull

/**
 * @param type no description
 * @param audio no description
 * @param audioMessage no description
 * @param doc no description
 * @param gift no description
 * @param graffiti no description
 * @param link no description
 * @param market no description
 * @param marketMarketAlbum no description
 * @param photo no description
 * @param sticker no description
 * @param story no description
 * @param video no description
 * @param wall no description
 * @param wallReply no description
 */
data class MessagesMessageAttachment(
    @SerializedName(value="type")
    val type: MessagesMessageAttachmentType,
    @SerializedName(value="audio")
    val audio: AudioAudio? = null,
    @SerializedName(value="audio_message")
    val audioMessage: MessagesAudioMessage? = null,
    @SerializedName(value="doc")
    val doc: DocsDoc? = null,
    @SerializedName(value="gift")
    val gift: GiftsLayout? = null,
    @SerializedName(value="graffiti")
    val graffiti: MessagesGraffiti? = null,
    @SerializedName(value="link")
    val link: BaseLink? = null,
    @SerializedName(value="market")
    val market: MarketMarketItem? = null,
    @SerializedName(value="market_market_album")
    val marketMarketAlbum: MarketMarketAlbum? = null,
    @SerializedName(value="photo")
    val photo: PhotosPhoto? = null,
    @SerializedName(value="sticker")
    val sticker: BaseSticker? = null,
    @SerializedName(value="story")
    val story: StoriesStory? = null,
    @SerializedName(value="video")
    val video: VideoVideo? = null,
    @SerializedName(value="wall")
    val wall: WallWallpostFull? = null,
    @SerializedName(value="wall_reply")
    val wallReply: WallWallComment? = null
)
