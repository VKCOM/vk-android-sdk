package com.vk.sdk.api.model;

/**
 * Array of VKDoc
 * Created by alex_xpert on 29.01.14.
 */
public class VKDocArray extends VKApiArray<VKDoc> {
    @Override
    protected VKDoc createObject() {
        return new VKDoc();
    }
}
