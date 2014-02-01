package com.vk.sdk.api.model;

/**
 * Array of VKChat
 * Created by alex_xpert on 29.01.14.
 */
public class VKChatArray extends VKApiArray<VKChat> {
    @Override
    protected VKChat createObject() {
        return new VKChat();
    }
}
