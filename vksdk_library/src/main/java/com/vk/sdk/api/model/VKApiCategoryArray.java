package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Array of VKCategory
 * Created by 4xes on 15.01.16.
 */
public class VKApiCategoryArray extends VKList<VKApiCategory> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiCategory.class);
        return this;
    }
}
