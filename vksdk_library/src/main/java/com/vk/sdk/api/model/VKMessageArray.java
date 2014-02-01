package com.vk.sdk.api.model;

/**
 * Array of VKMessage
 * Created by alex_xpert on 29.01.14.
 */
public class VKMessageArray extends VKApiArray<VKMessage> {
    @Override
    protected VKMessage createObject() {
        return new VKMessage();
    }
}
