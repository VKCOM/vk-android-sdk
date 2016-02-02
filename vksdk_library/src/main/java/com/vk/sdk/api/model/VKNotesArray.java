package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Array of API notes objects
 */
public class VKNotesArray extends VKList<VKApiNote> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiNote.class);
        return this;
    }
}
