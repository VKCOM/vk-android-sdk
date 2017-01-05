package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Aleksei Moisseev on 31.05.15.
 */
public class VKDialogsArray extends VKList<VKDialog> {

    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKDialog.class);
        return this;
    }
}
