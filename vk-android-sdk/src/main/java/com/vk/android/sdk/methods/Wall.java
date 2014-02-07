/**
 * Wall.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 18.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.methods;

import com.vk.android.sdk.VKRequest;
import com.vk.android.sdk.models.ParseUtils;
import org.json.JSONException;

/**
 * Methods of "wall" section.
 * @see <a href="http://vk.com/dev/wall">http://vk.com/dev/wall</a>
 */
public class Wall {

    private Wall() {}

    /**
     * @see <a href="http://vk.com/dev/wall.post">http://vk.com/dev/wall.post</a>
     */
    public static class post extends VKRequest<Integer> {

        public post(int owner_id) {
            super("wall.post");
            param("owner_id", owner_id);
        }

        public post() {
            super("wall.post");
        }

        public post friendsOnly(boolean friendsOnly) {
            return (post) param("friends_only", friendsOnly);
        }

        public post fromGroup(boolean fromGroup, boolean signed) {
            return (post) param("from_group", fromGroup).param("signed", signed);
        }

        public post withText(CharSequence text) {
            return (post) param("message", text);
        }

        public post withAttachments(CharSequence... attachments) {
            return (post) params("attachments", attachments);
        }

        public post services(String... services) {
            return (post) params("services", services);
        }

        public post publishDate(long publishDate) {
            return (post) param("publish_date", publishDate);
        }

        public post location(double latitude, double longitude) {
            return (post) param("lat", latitude).param("long", longitude);
        }

        public post withPlace(int place_id) {
            return (post) param("place_id", place_id);
        }

        public post pubicPost(int post_id) {
            return (post) param("post_id", post_id);
        }

        @Override
        protected Integer parse(String source) throws JSONException {
            return ParseUtils.rootJSONObject(source).getInt("post_id");
        }
    }

    /**
     * @see <a href="http://vk.com/dev/wall.post">http://vk.com/dev/wall.post</a>
     */
    public static post post(int owner_id) {
        return new post(owner_id);
    }

    /**
     * @see <a href="http://vk.com/dev/wall.post">http://vk.com/dev/wall.post</a>
     */
    public static post post() {
        return new post();
    }
}
