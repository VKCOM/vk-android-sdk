/**
 * StoredFunction.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 16.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import com.vk.android.sdk.models.VKModel;

/**
 * Represents a stored function of the app. <br/>
 * <b>Note</b>: this method requires authorization
 */
public abstract class StoredFunction<T extends VKModel> extends VKRequest<T> {

    /**
     * Creates a new stored function according with given name.
     * @param name name of the function to call
     */
    public StoredFunction(String name) {
        super("execute." + name);
    }
}
