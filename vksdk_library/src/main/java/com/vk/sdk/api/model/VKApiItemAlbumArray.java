package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Array of VKItem
 * Created by 4xes on 13.01.16.
 */
public class VKApiItemAlbumArray extends VKList<VKApiItemAlbum> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiItemAlbum.class);
        return this;
    }
}
