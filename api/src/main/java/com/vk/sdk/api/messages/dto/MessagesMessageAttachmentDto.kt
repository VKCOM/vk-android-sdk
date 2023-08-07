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
import com.vk.sdk.api.audio.dto.AudioAudioDto
import com.vk.sdk.api.base.dto.BaseStickerDto
import com.vk.sdk.api.calls.dto.CallsCallDto
import com.vk.sdk.api.docs.dto.DocsDocDto
import com.vk.sdk.api.gifts.dto.GiftsLayoutDto
import com.vk.sdk.api.market.dto.MarketMarketAlbumDto
import com.vk.sdk.api.market.dto.MarketMarketItemDto
import com.vk.sdk.api.photos.dto.PhotosPhotoDto
import com.vk.sdk.api.polls.dto.PollsPollDto
import com.vk.sdk.api.stories.dto.StoriesStoryDto
import com.vk.sdk.api.wall.dto.WallWallCommentDto

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
 * @param wallReply
 * @param poll
 */
data class MessagesMessageAttachmentDto(
    @SerializedName("type")
    val type: MessagesMessageAttachmentTypeDto,
    @SerializedName("audio")
    val audio: AudioAudioDto? = null,
    @SerializedName("audio_message")
    val audioMessage: MessagesAudioMessageDto? = null,
    @SerializedName("call")
    val call: CallsCallDto? = null,
    @SerializedName("doc")
    val doc: DocsDocDto? = null,
    @SerializedName("gift")
    val gift: GiftsLayoutDto? = null,
    @SerializedName("graffiti")
    val graffiti: MessagesGraffitiDto? = null,
    @SerializedName("market")
    val market: MarketMarketItemDto? = null,
    @SerializedName("market_market_album")
    val marketMarketAlbum: MarketMarketAlbumDto? = null,
    @SerializedName("photo")
    val photo: PhotosPhotoDto? = null,
    @SerializedName("sticker")
    val sticker: BaseStickerDto? = null,
    @SerializedName("story")
    val story: StoriesStoryDto? = null,
    @SerializedName("wall_reply")
    val wallReply: WallWallCommentDto? = null,
    @SerializedName("poll")
    val poll: PollsPollDto? = null
)
