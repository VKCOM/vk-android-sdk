package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Array of VKItemFull
 * Created by 4xes on 14.01.16.
 */
public class VKApiItemFullArray extends VKList<VKApiItemFull> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiItemFull.class);
        return this;
    }
}
