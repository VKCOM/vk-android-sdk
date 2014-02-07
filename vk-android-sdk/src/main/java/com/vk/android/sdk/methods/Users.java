/**
 * Users.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 13.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.methods;

import com.vk.android.sdk.VKRequest;
import com.vk.android.sdk.models.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Methods of "users" section.
 * @see <a href="http://vk.com/dev/users">http://vk.com/dev/users</a>
 */
@SuppressWarnings("unused")
public class Users {

    private Users() {}

    /**
     * @see <a href="http://vk.com/dev/users.get">http://vk.com/dev/users.get</a>
     */
    public static class get extends VKRequest<VKList<VKUser>> {

        public get(int... user_ids) {
            super("users.get");
            params("user_ids", user_ids);
            param("fields", VKUser.FIELDS_DEFAULT);
        }

        public get fields(String... fields) {
            return (get) params("fields", fields);
        }

        public get nameCase(String name_case) {
            return (get) param("name_case", name_case);
        }

        @Override
        protected VKList<VKUser> parse(String source) throws JSONException {
            return new VKList<VKUser>(ParseUtils.rootJSONArray(source), VKUser.class);
        }
    }

    /**
     * @see <a href="http://vk.com/dev/users.search">http://vk.com/dev/users.search</a>
     */
    public static class search extends VKRequest<VKList<VKUser>> {

        public search(String query) {
            super("users.search");
            param("q", query);
            param("fields", VKUser.FIELDS_DEFAULT);
        }

        public search limit(int offset, int count) {
            return (search) param("offset", offset).param("count", count);
        }

        public search fields(String... fields) {
            return (search) params("fields", fields);
        }

        @Override
        protected VKList<VKUser> parse(String source) throws JSONException {
            return new VKList<VKUser>(ParseUtils.rootJSONObject(source), VKUser.class);
        }
    }

    /**
     * @see <a href="http://vk.com/dev/users.isAppUser">http://vk.com/dev/users.isAppUser</a>
     */
    public static class isAppUser extends VKRequest<Boolean> {

        public isAppUser(int user_id) {
            super("users.isAppUser");
            param("user_id", user_id);
        }

        @Override
        protected Boolean parse(String source) throws JSONException {
            return ParseUtils.parseBoolean(source);
        }
    }

    /**
     * @see <a href="http://vk.com/dev/users.getSubscriptions">http://vk.com/dev/users.getSubscriptions</a>
     */
    public static class getSubscriptions extends VKRequest<VKList<VKOwner>> {

        public getSubscriptions(int user_id) {
            super("users.getSubscriptions");
            param("user_id", user_id);
            param("extended", true);
        }

        public getSubscriptions limit(int offset, int count) {
            return (getSubscriptions) param("offset", offset).param("count", count);
        }

        @Override
        protected VKList<VKOwner> parse(String source) throws JSONException {
            return new VKList<VKOwner>(ParseUtils.rootJSONObject(source), new VKList.Parser<VKOwner>() {
                @Override
                public VKOwner parseObject(JSONObject source) throws Exception {
                    if("profile".equals(source.optString("type"))) {
                        return new VKUser().parse(source);
                    }
                    return new VKCommunity().parse(source);
                }
            });
        }
    }

    /**
     * @see <a href="http://vk.com/dev/users.getFollowers">http://vk.com/dev/users.getFollowers</a>
     */
    public static class getFollowers extends VKRequest<VKList<VKUser>> {

        public getFollowers(int user_id) {
            super("users.getFollowers");
            param("user_id", user_id);
            param("fields", VKUser.FIELDS_DEFAULT);
        }

        public getFollowers fields(String... fields) {
            return (getFollowers) params("fields", fields);
        }

        public getFollowers limit(int offset, int count) {
            return (getFollowers) param("offset", offset).param("count", count);
        }

        @Override
        protected VKList<VKUser> parse(String source) throws JSONException {
            return new VKList<VKUser>(ParseUtils.rootJSONObject(source), VKUser.class);
        }
    }

    /**
     * @see <a href="http://vk.com/dev/users.get">http://vk.com/dev/users.get</a>
     */
    public static get get(int... user_ids) {
        return new get(user_ids);
    }

    /**
     * @see <a href="http://vk.com/dev/users.search">http://vk.com/dev/users.search</a>
     */
    public static search search(String query) {
        return new search(query);
    }

    /**
     * @see <a href="http://vk.com/dev/users.isAppUser">http://vk.com/dev/users.isAppUser</a>
     */
    public static isAppUser isAppUser(int user_id) {
        return new isAppUser(user_id);
    }

    /**
     * @see <a href="http://vk.com/dev/users.isAppUser">http://vk.com/dev/users.isAppUser</a>
     */
    public static isAppUser isAppUser(VKUser user) {
        return new isAppUser(user.id);
    }

    /**
     * @see <a href="http://vk.com/dev/users.getSubscriptions">http://vk.com/dev/users.getSubscriptions</a>
     */
    public static getSubscriptions getSubscriptions(int user_id) {
        return new getSubscriptions(user_id);
    }

    /**
     * @see <a href="http://vk.com/dev/users.getSubscriptions">http://vk.com/dev/users.getSubscriptions</a>
     */
    public static getSubscriptions getSubscriptions(VKUser user) {
        return new getSubscriptions(user.id);
    }

    /**
     * @see <a href="http://vk.com/dev/users.getFollowers">http://vk.com/dev/users.getFollowers</a>
     */
    public static getFollowers getFollowers(int user_id) {
        return new getFollowers(user_id);
    }

    /**
     * @see <a href="http://vk.com/dev/users.getFollowers">http://vk.com/dev/users.getFollowers</a>
     */
    public static getFollowers getFollowers(VKUser user) {
        return new getFollowers(user.id);
    }

}
