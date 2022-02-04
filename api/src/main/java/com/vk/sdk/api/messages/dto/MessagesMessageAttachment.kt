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
import com.vk.sdk.api.base.dto.BaseSticker
import com.vk.sdk.api.calls.dto.CallsCall
import com.vk.sdk.api.docs.dto.DocsDoc
import com.vk.sdk.api.gifts.dto.GiftsLayout
import com.vk.sdk.api.market.dto.MarketMarketAlbum
import com.vk.sdk.api.market.dto.MarketMarketItem
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.polls.dto.PollsPoll
import com.vk.sdk.api.stories.dto.StoriesStory
import com.vk.sdk.api.video.dto.VideoVideoFull
import com.vk.sdk.api.wall.dto.WallWallComment

/**
 * @param type
 * @param audio
 * @param audioMessage
 * @param call
 * @param doc
 * @param gift
 * @param graffiti
 * @param market
 * @param marketMarketAlbum
 * @param photo
 * @param sticker
 * @param story
 * @param video
 * @param wallReply
 * @param poll
 */
data class MessagesMessageAttachment(
    @SerializedName("type")
    val type: MessagesMessageAttachmentType,
    @SerializedName("audio")
    val audio: AudioAudio? = null,
    @SerializedName("audio_message")
    val audioMessage: MessagesAudioMessage? = null,
    @SerializedName("call")
    val call: CallsCall? = null,
    @SerializedName("doc")
    val doc: DocsDoc? = null,
    @SerializedName("gift")
    val gift: GiftsLayout? = null,
    @SerializedName("graffiti")
    val graffiti: MessagesGraffiti? = null,
    @SerializedName("market")
    val market: MarketMarketItem? = null,
    @SerializedName("market_market_album")
    val marketMarketAlbum: MarketMarketAlbum? = null,
    @SerializedName("photo")
    val photo: PhotosPhoto? = null,
    @SerializedName("sticker")
    val sticker: BaseSticker? = null,
    @SerializedName("story")
    val story: StoriesStory? = null,
    @SerializedName("video")
    val video: VideoVideoFull? = null,
    @SerializedName("wall_reply")
    val wallReply: WallWallComment? = null,
    @SerializedName("poll")
    val poll: PollsPoll? = null
)
