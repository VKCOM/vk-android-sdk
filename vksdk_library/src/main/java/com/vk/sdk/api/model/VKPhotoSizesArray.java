package com.vk.sdk.api.model;

public class VKPhotoSizesArray extends VKApiArray<VKPhotoSize> {
    @Override
    protected VKPhotoSize createObject() {
        return new VKPhotoSize();
    }
}
