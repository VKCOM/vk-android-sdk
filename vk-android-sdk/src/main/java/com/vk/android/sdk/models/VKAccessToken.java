/**
 * VKAccount.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 08.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.StringTokenizer;

/**
 * Represents VK logged user.
 */
@SuppressWarnings("unused")
public final class VKAccessToken extends VKModel implements android.os.Parcelable {

    final static String TOKEN = "access_token";
    final static String SECRET = "secret";
    final static String USER_ID = "user_id";
    final static String APP_ID = "app_id";
    final static String EXPIRES_IN = "expires_in";
    final static String CREATED = "created";
    final static String SCOPES = "scopes";
    final static String HTTPS_REQUIRED = "https_required";

    private String mToken;
    private String mSecret;
    private int mUserId;
    private int mAppId = 0;
    private int mExpires;
    private long mCreated = (System.currentTimeMillis() / 1000);
    private String mScopes;
    private boolean mHttpsRequired;

    protected VKAccessToken(Parcel in) {
        this.mToken = in.readString();
        this.mSecret = in.readString();
        this.mUserId = in.readInt();
        this.mAppId = in.readInt();
        this.mExpires = in.readInt();
        this.mCreated = in.readLong();
        this.mScopes = in.readString();
        this.mHttpsRequired = in.readByte() != 0;
    }

    private VKAccessToken() {

    }

    /**
     * @return string token for use in request parameters
     */
    public String getAccessToken() {
        return mToken;
    }

    /**
     * @return user secret to sign requests (if nohttps used, null otherwise)
     */
    public String getSecret() {
        return mSecret;
    }

    /**
     * @return current user id for this token.
     */
    public int getUserId() {
        return mUserId;
    }

    /**
     * @return time when token expires in Unix time
     */
    public int getExpires() {
        return mExpires;
    }

    /**
     * @return application ID with which the token was created
     */
    public int getAppId() {
        return mAppId;
    }

    /**
     * @return scopes with which the token was created, a comma-separated
     */
    public String getScopes() {
        return mScopes;
    }

    /**
     * @return time of token creation in Unix time.
     */
    public long getCreated() {
        return mCreated;
    }

    /**
     * @return true if user sets "Always use HTTPS" setting in his profile, false otherwise
     */
    public boolean isHttpsRequired() {
        return mHttpsRequired;
    }

    /**
     * Sets that all API method should be via HTTPs.
     */
    public void requireHttps() {
        mHttpsRequired = true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mToken);
        dest.writeString(this.mSecret);
        dest.writeInt(this.mUserId);
        dest.writeInt(this.mAppId);
        dest.writeInt(mExpires);
        dest.writeLong(mCreated);
        dest.writeString(this.mScopes);
        dest.writeByte(mHttpsRequired ? (byte) 1 : (byte) 0);
    }

    public static Creator<VKAccessToken> CREATOR = new Creator<VKAccessToken>() {
        public VKAccessToken createFromParcel(Parcel source) {
            return new VKAccessToken(source);
        }

        public VKAccessToken[] newArray(int size) {
            return new VKAccessToken[size];
        }
    };

    /**
     * Creates account from OAuth response.
     * @param oAuthResponse URL ref segment at redirect_uri page.
     * @param app_id application ID with which the token was created
     * @param scopes scopes with which the token was created, a comma-separated
     */
    public static VKAccessToken create(String oAuthResponse, int app_id, String scopes) {
        VKAccessToken account = new VKAccessToken();
        StringTokenizer tokenizer = new StringTokenizer(oAuthResponse, "=&");
        while (tokenizer.hasMoreTokens()) {
            String key = tokenizer.nextToken();
            if(TOKEN.equals(key)) {
                account.mToken = tokenizer.nextToken();
            } else if(SECRET.equals(key)) {
                account.mSecret = tokenizer.nextToken();
            } else if(USER_ID.equals(key)) {
                account.mUserId = Integer.valueOf(tokenizer.nextToken());
            } else if (HTTPS_REQUIRED.equals(key)) {
                account.mHttpsRequired = Integer.parseInt(tokenizer.nextToken()) == 1;
            } else if(EXPIRES_IN.equals(key)) {
                account.mExpires = Integer.valueOf(tokenizer.nextToken());
            }
        }
        account.mScopes = scopes;
        account.mAppId = app_id;
        return account.mToken != null ? account : null;
    }

    /**
     * Creates account VK Android app response.
     * @param vkontakteResponse returned in {@link android.app.Activity#onActivityResult(int, int, android.content.Intent)}
     *                          VK Android app response.
     * @param app_id application ID with which the token was created
     * @param scopes scopes with which the token was created, a comma-separated
     */
    public static VKAccessToken create(Bundle vkontakteResponse, int app_id, String scopes) {
        VKAccessToken account = new VKAccessToken();
        account.mToken = vkontakteResponse.getString("access_token");
        account.mSecret = vkontakteResponse.getString("secret");
        account.mUserId = vkontakteResponse.getInt("user_id");
        account.mExpires = vkontakteResponse.getInt("expires_in");
        account.mScopes = scopes;
        account.mAppId = app_id;
        return account.mToken != null ? account : null;
    }

    /**
     * Saves whole account to SharedPreferences.
     * @param key key for SharedPreferences to store.
     * @param account account for SharedPreferences to store.
     * @param to SharedPreferences to store.
     */
    public static void save(String key, VKAccessToken account, SharedPreferences to) {
        try {
            JSONObject result = new JSONObject();
            result.put(TOKEN, account.mToken);
            result.put(SECRET, account.mSecret);
            result.put(USER_ID, account.mUserId);
            result.put(APP_ID, account.mAppId);
            result.put(EXPIRES_IN, account.mExpires);
            result.put(CREATED, account.mCreated);
            result.put(SCOPES, account.mScopes);
            result.put(HTTPS_REQUIRED, account.mHttpsRequired);
            to.edit().putString(key, result.toString()).commit();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("VK", "Unable to save access_token");
        }
    }

    /**
     * Reads whole account from SharedPreferences.
     * @param key key for SharedPreferences to read.
     * @param from SharedPreferences to read.
     * @return account if it exists, null otherwise
     */
    public static VKAccessToken restore(String key, SharedPreferences from) {
        String result = from.getString(key, null);
        if(result != null) {
            try {
                JSONObject source = new JSONObject(result);
                VKAccessToken account = new VKAccessToken().parse(source);
                return TextUtils.isEmpty(account.mToken) ? null : account;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Parses VKAccount from saved JSONObject
     */
    @Override
    public VKAccessToken parse(JSONObject source) throws JSONException {
        this.mToken = source.optString(TOKEN);
        this.mSecret = source.optString(SECRET);
        this.mUserId = source.optInt(USER_ID);
        this.mAppId = source.optInt(APP_ID);
        this.mExpires = source.optInt(EXPIRES_IN);
        this.mCreated = source.optLong(CREATED);
        this.mScopes = source.optString(SCOPES);
        this.mHttpsRequired = source.optBoolean(HTTPS_REQUIRED);
        return this;
    }
}
