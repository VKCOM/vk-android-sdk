package com.vk.sdk.api.model;

/**
 * Array of VKNote
 * Created by alex_xpert on 29.01.14.
 */
public class VKNoteArray extends VKApiArray<VKNote> {
    @Override
    protected VKNote createObject() {
        return new VKNote();
    }
}
