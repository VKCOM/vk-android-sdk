/**
 * identifiable.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 06.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

/**
 * Describes objects that contains an "id" field.
 */
@SuppressWarnings("unused")
public interface Identifiable {

    /**
     * Returns unique identifier of this object(usually it's value of JSON field "id").
     */
    int getId();

}