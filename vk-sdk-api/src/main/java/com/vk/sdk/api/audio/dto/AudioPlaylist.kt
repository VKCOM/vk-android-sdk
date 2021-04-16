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
import com.vk.sdk.api.media.dto.MediaPopup
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Playlist ID
 * @param ownerId - Playlist owner ID
 * @param type - Playlist type
 * @param title - Playlist title
 * @param description - Playlist description
 * @param count - Playlist tracks count
 * @param followers - Playlist followers count
 * @param plays - Playlist plays count
 * @param createTime - Playlist create time
 * @param updateTime - Playlist upload time
 * @param playlistId - Original or followed playlist ID
 * @param genres - Playlist genres
 * @param isFollowing - Is user follow this playlist
 * @param noDiscover - If playlist should be hidden from search results and recommendations
 * @param audios - Playlist audios
 * @param year - Playlist year
 * @param original - Original playlist
 * @param followed - Followed playlist
 * @param photo - Playlist photo
 * @param permissions - Playlist permissions
 * @param subtitleBadge - Should show badge near playlist subtitle
 * @param playButton - Should show playlist play button on cover
 * @param thumbs - Playlist photos
 * @param accessKey - Playlist access key
 * @param umaAlbumId - UMA playlist ID
 * @param subtitle - Playlist subtitle
 * @param originalYear - Playlist original year
 * @param isExplicit - Is playlist exist
 * @param artists - Playlist artists
 * @param mainArtists - Playlist main artists
 * @param mainArtist - Playlist main artist name
 * @param featuredArtists - Playlist featured artists
 * @param albumType - Playlist type
 * @param meta - Playlist meta info
 * @param restriction - Playlist restriction popup
 */
data class AudioPlaylist(
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: Int,
    @SerializedName("type")
    val type: AudioPlaylist.Type,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("plays")
    val plays: Int,
    @SerializedName("create_time")
    val createTime: Int,
    @SerializedName("update_time")
    val updateTime: Int,
    @SerializedName("playlist_id")
    val playlistId: Int? = null,
    @SerializedName("genres")
    val genres: List<AudioGenre>? = null,
    @SerializedName("is_following")
    val isFollowing: Boolean? = null,
    @SerializedName("no_discover")
    val noDiscover: Boolean? = null,
    @SerializedName("audios")
    val audios: List<AudioAudio>? = null,
    @SerializedName("year")
    val year: Int? = null,
    @SerializedName("original")
    val original: AudioPlaylistOriginalFollowed? = null,
    @SerializedName("followed")
    val followed: AudioPlaylistOriginalFollowed? = null,
    @SerializedName("photo")
    val photo: AudioPhoto? = null,
    @SerializedName("permissions")
    val permissions: AudioPlaylistPermissions? = null,
    @SerializedName("subtitle_badge")
    val subtitleBadge: Boolean? = null,
    @SerializedName("play_button")
    val playButton: Boolean? = null,
    @SerializedName("thumbs")
    val thumbs: List<AudioPhoto>? = null,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("uma_album_id")
    val umaAlbumId: Int? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("original_year")
    val originalYear: Int? = null,
    @SerializedName("is_explicit")
    val isExplicit: Boolean? = null,
    @SerializedName("artists")
    val artists: List<AudioArtist>? = null,
    @SerializedName("main_artists")
    val mainArtists: List<AudioArtist>? = null,
    @SerializedName("main_artist")
    val mainArtist: String? = null,
    @SerializedName("featured_artists")
    val featuredArtists: List<AudioArtist>? = null,
    @SerializedName("album_type")
    val albumType: AudioPlaylist.AlbumType? = null,
    @SerializedName("meta")
    val meta: AudioPlaylistMeta? = null,
    @SerializedName("restriction")
    val restriction: MediaPopup? = null
) {
    enum class Type(
        val value: Int
    ) {
        @SerializedName("0")
        NO_ALBUM(0),

        @SerializedName("1")
        ALBUM(1),

        @SerializedName("2")
        EP(2),

        @SerializedName("3")
        COLLECTION(3),

        @SerializedName("4")
        SINGLE(4),

        @SerializedName("5")
        CHAT(5);
    }

    enum class AlbumType(
        val value: String
    ) {
        @SerializedName("playlist")
        PLAYLIST("playlist"),

        @SerializedName("main_only")
        MAIN_ONLY("main_only"),

        @SerializedName("main_feat")
        MAIN_FEAT("main_feat"),

        @SerializedName("collection")
        COLLECTION("collection");
    }
}
