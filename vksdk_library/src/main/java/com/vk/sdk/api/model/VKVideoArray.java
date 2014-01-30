package com.vk.sdk.api.model;

/**
 * Array of VKVideo
 * Created by alex_xpert on 29.01.14.
 */
public class VKVideoArray extends VKApiArray<VKVideo> {
    @Override
    protected VKVideo createObject() {
        return new VKVideo();
    }
}
