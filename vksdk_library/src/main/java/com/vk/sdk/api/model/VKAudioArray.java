package com.vk.sdk.api.model;

/**
 * Array of VKAudio
 * Created by alex_xpert on 28.01.14.
 */
public class VKAudioArray extends VKApiArray<VKAudio> {
    @Override
    protected VKAudio createObject() {
        return new VKAudio();
    }
}
