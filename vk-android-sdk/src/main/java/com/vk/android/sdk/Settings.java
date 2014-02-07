/**
 * Settings.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 07.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import com.vk.android.sdk.models.VKAccessToken;

@SuppressWarnings("unused")
class Settings {

    private static Settings sInstance;

    static Settings get() {
        if(sInstance == null) {
            sInstance = new Settings();
        }
        return sInstance;
    }

    /**
     * Current version of API.
     */
    final static String API_VERSION = "5.8";

    private VKAccessToken mAccount;
    private boolean mHttpsEnabled = false;
    private boolean mHttpsRequired = false;
    private int mAttempts = 1;


    private boolean mInterruptionEnabled = true;

    private Settings () {

    }

    void requireHttps() {
        mHttpsRequired = true;
        if(mAccount != null) {
            mAccount.requireHttps();
        }
    }

    boolean isHttps() {
        return mHttpsEnabled || mHttpsRequired;
    }

    boolean ismHttpsRequired() {
        return mHttpsRequired;
    }

    void authorize(VKAccessToken account) {
        mAccount = account;
    }

    boolean isAuthorized() {
        return getAccount() != null;
    }

    public VKAccessToken getAccount() {
        return mAccount;
    }

    public int getAttempts() {
        return mAttempts;
    }

    boolean interruptUIIfNecessary() {
        return mInterruptionEnabled;
    }

    void setInterruptionEnabled(boolean mInterruptionEnabled) {
        this.mInterruptionEnabled = mInterruptionEnabled;
    }

    void setHttpsEnabled(boolean mHttpsEnabled) {
        this.mHttpsEnabled = mHttpsEnabled;
    }

    void setAttempts(int mAttempts) {
        this.mAttempts = mAttempts;
    }

    public boolean isHttpsEnabled() {
        return mHttpsEnabled;
    }
}
