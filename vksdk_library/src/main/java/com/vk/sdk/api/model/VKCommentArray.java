package com.vk.sdk.api.model;

/**
 * Array of VKComment
 * Created by alex_xpert on 29.01.14.
 */
public class VKCommentArray extends VKApiArray<VKComment> {
    @Override
    protected VKComment createObject() {
        return new VKComment();
    }
}
