package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lynnfield on 23.11.2015.
 */
public class VkVideoArray extends VKList<VKApiVideo> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiVideo.class);
        return this;
    }
}
