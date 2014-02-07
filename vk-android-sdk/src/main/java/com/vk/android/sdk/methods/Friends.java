/**
 * Friends.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 18.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.methods;

import com.vk.android.sdk.VKRequest;
import com.vk.android.sdk.models.VKList;
import com.vk.android.sdk.models.ParseUtils;
import com.vk.android.sdk.models.VKUser;
import org.json.JSONException;

/**
 * Methods of "friends" section.
 * @see <a href="http://vk.com/dev/friends">http://vk.com/dev/friends</a>
 */
public class Friends {

    public final static String ORDER_NAME = "name";
    public final static String ORDER_HINTS = "hints";
    public final static String ORDER_RANDOM = "random";

    private Friends() {}

    /**
     * @see <a href="http://vk.com/dev/friends.get">http://vk.com/dev/friends.get</a>
     */
    public static class get extends VKRequest<VKList<VKUser>> {

        /**
         * Will return friends according with given user id
         */
        public get(int user_id) {
            super("friends.get");
            param("user_id", user_id);
            param("order", ORDER_HINTS);
            param("fields", VKUser.FIELDS_DEFAULT);
        }

        /**
         * Will return friends of current user
         */
        public get() {
            super("friends.get");
            param("order", ORDER_HINTS);
            param("fields", VKUser.FIELDS_DEFAULT);
        }

        public get order(String order) {
            return (get) param("order", order);
        }

        public get fields(String... fields) {
            return (get) params("fields", fields);
        }

        public get limit(int offset, int count) {
            return (get) param("offset", offset).param("count", count);
        }

        public get nameCase(String name_case) {
            return (get) param("name_case", name_case);
        }

        @Override
        protected VKList<VKUser> parse(String source) throws JSONException {
            return new VKList<VKUser>(ParseUtils.rootJSONObject(source), VKUser.class);
        }
    }

    /**
     * Will return friends of current user
     */
    public static get get() {
        return new get();
    }

    /**
     * Will return friends according with given user id
     */
    public static get get(int user_id) {
        return new get(user_id);
    }

    /**
     * Will return friends according with given user
     */
    public static get get(VKUser user) {
        return new get(user.id);
    }

}
