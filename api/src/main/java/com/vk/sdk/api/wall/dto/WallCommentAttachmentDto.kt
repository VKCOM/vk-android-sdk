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
package com.vk.sdk.api.wall.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.audio.dto.AudioAudioDto
import com.vk.sdk.api.base.dto.BaseLinkDto
import com.vk.sdk.api.base.dto.BaseStickerDto
import com.vk.sdk.api.docs.dto.DocsDocDto
import com.vk.sdk.api.market.dto.MarketMarketAlbumDto
import com.vk.sdk.api.market.dto.MarketMarketItemDto
import com.vk.sdk.api.pages.dto.PagesWikipageFullDto
import com.vk.sdk.api.photos.dto.PhotosPhotoDto
import com.vk.sdk.api.video.dto.VideoVideoDto

/**
 * @param type
 * @param audio
 * @param doc
 * @param link
 * @param market
 * @param marketMarketAlbum
 * @param note
 * @param page
 * @param photo
 * @param sticker
 * @param video
 * @param graffiti
 */
data class WallCommentAttachmentDto(
    @SerializedName("type")
    val type: WallCommentAttachmentTypeDto,
    @SerializedName("audio")
    val audio: AudioAudioDto? = null,
    @SerializedName("doc")
    val doc: DocsDocDto? = null,
    @SerializedName("link")
    val link: BaseLinkDto? = null,
    @SerializedName("market")
    val market: MarketMarketItemDto? = null,
    @SerializedName("market_market_album")
    val marketMarketAlbum: MarketMarketAlbumDto? = null,
    @SerializedName("note")
    val note: WallAttachedNoteDto? = null,
    @SerializedName("page")
    val page: PagesWikipageFullDto? = null,
    @SerializedName("photo")
    val photo: PhotosPhotoDto? = null,
    @SerializedName("sticker")
    val sticker: BaseStickerDto? = null,
    @SerializedName("video")
    val video: VideoVideoDto? = null,
    @SerializedName("graffiti")
    val graffiti: WallGraffitiDto? = null
)
