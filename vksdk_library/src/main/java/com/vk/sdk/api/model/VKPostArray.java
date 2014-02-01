package com.vk.sdk.api.model;

/**
 * Array of Post
 * Created by alex_xpert on 29.01.14.
 */
public class VKPostArray extends VKApiArray<VKPost> {
    @Override
    protected VKPost createObject() {
        return new VKPost();
    }
}
