//
//  Copyright (c) 2014 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.docs.VKUploadDocRequest;
import com.vk.sdk.api.docs.VKUploadWallDocRequest;
import com.vk.sdk.api.model.VKDocsArray;
import com.vk.sdk.util.VKUtil;

import java.io.File;

/**
 * Builds requests for API.docs part
 */
public class VKApiDocs extends VKApiBase {

    /**
     * https://vk.com/dev/docs.getUploadServer
     * Returns upload server for document
     * @return Request for get server address
     */
    public VKRequest getUploadServer() {
        return prepareRequest("getUploadServer", null);    }

    /**
     * https://vk.com/dev/docs.getUploadServer
     * Returns upload server for document
     * @param groupId community ID (if the document will be uploaded to the community).
     * @return Request for get server address
     */
    public VKRequest getUploadServer(long groupId) {
        return prepareRequest("getUploadServer", VKUtil.paramsFrom(VKApiConst.GROUP_ID, groupId));
    }

    /**
     * https://vk.com/dev/docs.getWallUploadServer
     * Returns wall upload server for document
     * @return Request for get server address
     */
    public VKRequest getUploadWallServer() {
        return prepareRequest("getWallUploadServer", null);    }

    /**
     * https://vk.com/dev/docs.getWallUploadServer
     * Returns wall upload server for document
     * @param groupId community ID (if the document will be uploaded to the community).
     * @return Request for get server address
     */
    public VKRequest getUploadWallServer(long groupId) {
        return prepareRequest("getWallUploadServer", VKUtil.paramsFrom(VKApiConst.GROUP_ID, groupId));
    }

    /**
     * https://vk.com/dev/docs.save
     * Saves a document after uploading it to a server.
     * Returns an array of uploaded document objects.
     * @param params use parameters from description with VKApiConst class
     * @return Request for upload file on server
     */
    public VKRequest save(VKParameters params) {
        return prepareRequest("save", params, VKDocsArray.class);
    }

    /**
     * Upload a document to VK servers
     * @param doc Doc object to upload
     * @return Prepared vk request for doc upload
     */
    public VKRequest uploadDocRequest(File doc) {
        return new VKUploadDocRequest(doc);
    }

    /**
     * Upload a document to VK servers
     * @param doc Doc object to upload
     * @param groupId Group id or 0
     * @return Prepared vk request for doc upload
     */
    public VKRequest uploadDocRequest(File doc, long groupId) {
        return new VKUploadDocRequest(doc, groupId);
    }

    /**
     * Upload a document to VK servers
     * @param doc Doc object to upload
     * @return Prepared vk request for doc upload
     */
    public VKRequest uploadWallDocRequest(File doc) {
        return new VKUploadWallDocRequest(doc);
    }

    /**
     * Upload a document to VK servers
     * @param doc Doc object to upload
     * @param groupId Group id or 0
     * @return Prepared vk request for doc upload
     */
    public VKRequest uploadWallDocRequest(File doc, long groupId) {
        return new VKUploadWallDocRequest(doc, groupId);
    }

    @Override
    protected String getMethodsGroup() {
        return "docs";
    }
}