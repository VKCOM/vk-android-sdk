/**
 * VKAttachments.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 01.02.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * A list of attachments in {@link com.vk.android.sdk.models.VKComment}, {@link com.vk.android.sdk.models.VKPost}, {@link com.vk.android.sdk.models.VKMessage}
 */
public class VKAttachments extends VKList<VKAttachments.VKAttachment> implements android.os.Parcelable {

    /**
     * Attachment is a photo.
     * @see {@link VKPhoto}
     */
    public static final String TYPE_PHOTO = "photo";

    /**
     * Attachment is a video.
     * @see {@link VKVideo}
     */
    public static final String TYPE_VIDEO = "video";

    /**
     * Attachment is an audio.
     * @see {@link VKAudio}
     */
    public static final String TYPE_AUDIO = "audio";

    /**
     * Attachment is a document.
     * @see {@link VKDocument}
     */
    public static final String TYPE_DOC = "doc";

    /**
     * Attachment is a wall post.
     * @see {@link VKPost}
     */
    public static final String TYPE_POST = "wall";

    /**
     * Attachment is a posted photo.
     * @see {@link VKPostedPhoto}
     */
    public static final String TYPE_POSTED_PHOTO = "posted_photo";

    /**
     * Attachment is a link
     * @see {@link VKLink}
     */
    public static final String TYPE_LINK = "link";

    /**
     * Attachment is a note
     * @see {@link VKNote}
     */
    public static final String TYPE_NOTE = "note";

    /**
     * Attachment is an application content
     * @see {@link VKApplicationContent}
     */
    public static final String TYPE_APP = "app";

    /**
     * Attachment is a poll
     * @see {@link VKPoll}
     */
    public static final String TYPE_POLL = "poll";

    /**
     * Attachment is a WikiPage
     * @see {@link VKWikiPage}
     */
    public static final String TYPE_WIKI_PAGE = "page";

    /**
     * Attachment is a PhotoAlbum
     * @see {@link VKPhotoAlbum}
     */
    public static final String TYPE_ALBUM = "album";


    public VKAttachments() {
        super();
    }

    public VKAttachments(List<? extends VKAttachment> data) {
        super(data);
    }

    public VKAttachments(JSONObject from) {
        super();
        fill(from);
    }

    public VKAttachments(JSONArray from) {
        super();
        fill(from);
    }

    public void fill(JSONObject from) {
        super.fill(from, parser);
    }

    public void fill(JSONArray from) {
        super.fill(from, parser);
    }

    /**
     * Parser that's used for parsing photo sizes.
     */
    private final Parser<VKAttachment> parser = new Parser<VKAttachment>() {
        @Override
        public VKAttachment parseObject(JSONObject attachment) throws Exception {
            String type = attachment.optString("type");
            if(TYPE_PHOTO.equals(type)) {
                return new VKPhoto().parse(attachment.getJSONObject(TYPE_PHOTO));
            } else if(TYPE_VIDEO.equals(type)) {
                return new VKVideo().parse(attachment.getJSONObject(TYPE_VIDEO));
            } else if(TYPE_AUDIO.equals(type)) {
                return new VKAudio().parse(attachment.getJSONObject(TYPE_AUDIO));
            } else if(TYPE_DOC.equals(type)) {
                return new VKDocument().parse(attachment.getJSONObject(TYPE_DOC));
            } else if(TYPE_POST.equals(type)) {
                return new VKPost().parse(attachment.getJSONObject(TYPE_POST));
            } else if(TYPE_POSTED_PHOTO.equals(type)) {
                return new VKPostedPhoto().parse(attachment.getJSONObject(TYPE_POSTED_PHOTO));
            } else if(TYPE_LINK.equals(type)) {
                return new VKLink().parse(attachment.getJSONObject(TYPE_LINK));
            } else if(TYPE_NOTE.equals(type)) {
                return new VKNote().parse(attachment.getJSONObject(TYPE_NOTE));
            } else if(TYPE_APP.equals(type)) {
                return new VKApplicationContent().parse(attachment.getJSONObject(TYPE_APP));
            } else if(TYPE_POLL.equals(type)) {
                return new VKPoll().parse(attachment.getJSONObject(TYPE_POLL));
            } else if(TYPE_WIKI_PAGE.equals(type)) {
                return new VKWikiPage().parse(attachment.getJSONObject(TYPE_WIKI_PAGE));
            } else if(TYPE_ALBUM.equals(type)) {
                return new VKPhotoAlbum().parse(attachment.getJSONObject(TYPE_ALBUM));
            }
            return null;
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(size());
        for(VKAttachment attachment: this) {
            dest.writeString(attachment.getType());
            dest.writeParcelable(attachment, 0);
        }
    }

    public VKAttachments(Parcel parcel) {
        int size = parcel.readInt();
        for(int i = 0; i < size; i++) {
            String type = parcel.readString();
            if(TYPE_PHOTO.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKPhoto.class.getClassLoader()));
            } else if(TYPE_VIDEO.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKVideo.class.getClassLoader()));
            } else if(TYPE_AUDIO.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKAudio.class.getClassLoader()));
            } else if(TYPE_DOC.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKDocument.class.getClassLoader()));
            } else if(TYPE_POST.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKPost.class.getClassLoader()));
            } else if(TYPE_POSTED_PHOTO.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKPostedPhoto.class.getClassLoader()));
            } else if(TYPE_LINK.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKLink.class.getClassLoader()));
            } else if(TYPE_NOTE.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKNote.class.getClassLoader()));
            } else if(TYPE_APP.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKApplicationContent.class.getClassLoader()));
            } else if(TYPE_POLL.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKPoll.class.getClassLoader()));
            } else if(TYPE_WIKI_PAGE.equals(type)) {
                add((VKAttachment) parcel.readParcelable(VKWikiPage.class.getClassLoader()));
            } else if(TYPE_ALBUM.equals(type)) {
                add((VKAttachment)  parcel.readParcelable(VKPhotoAlbum.class.getClassLoader()));
            }
        }
    }

    public static Creator<VKAttachments> CREATOR = new Creator<VKAttachments>() {
        public VKAttachments createFromParcel(Parcel source) {
            return new VKAttachments(source);
        }

        public VKAttachments[] newArray(int size) {
            return new VKAttachments[size];
        }
    };

    /**
     * An abstract class for all attachments
     */
    @SuppressWarnings("unused")
    public abstract static class VKAttachment extends VKModel implements Identifiable {

        /**
         * Convert attachment to special string to attach it to the post, message or comment.
         */
        public abstract CharSequence toAttachmentString();

        /**
         * @return type of this attachment
         */
        public abstract String getType();
    }
}
