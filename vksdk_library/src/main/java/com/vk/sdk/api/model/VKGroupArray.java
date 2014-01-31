package com.vk.sdk.api.model;

/**
 * Array of VKGroup
 * Created by alex_xpert on 28.01.14.
 */
public class VKGroupArray extends VKApiArray<VKGroup> {
    @Override
    protected VKGroup createObject() {
        return new VKGroup();
    }
}
