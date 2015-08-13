package com.vk.sdk.api.docs;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.util.VKJsonHelper;
import com.vk.sdk.util.VKUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class VKUploadDocRequest extends VKUploadDocBase {
    /**
     * Creates a VKUploadDocRequest instance.
     * @param doc file for upload to server
     */
    public VKUploadDocRequest(File doc) {
        super();
        this.mDoc = doc;
        this.mGroupId = 0;
    }

    /**
     * Creates a VKUploadDocRequest instance.
     * @param doc file for upload to server
     * @param groupId community ID (if the document will be uploaded to the community).
     */
    public VKUploadDocRequest(File doc, long groupId) {
        super();
        this.mDoc = doc;
        this.mGroupId = groupId;
    }

    @Override
    protected VKRequest getServerRequest() {
        if (mGroupId != 0)
            return VKApi.docs().getUploadServer(mGroupId);
        return VKApi.docs().getUploadServer();
    }

    @Override
    protected VKRequest getSaveRequest(JSONObject response) {
        VKRequest saveRequest;
        try {
            saveRequest = VKApi.docs().save(new VKParameters(VKJsonHelper.toMap(response)));
        } catch (JSONException e) {
            return null;
        }
        if (mGroupId != 0)
            saveRequest.addExtraParameters(VKUtil.paramsFrom(VKApiConst.GROUP_ID, mGroupId));
        return saveRequest;
    }
}
