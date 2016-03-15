//
//  Copyright (c) 2016 VK.com
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
import com.vk.sdk.api.model.VKApiCategoryArray;
import com.vk.sdk.api.model.VKApiItemAlbumArray;
import com.vk.sdk.api.model.VKApiItemArray;
import com.vk.sdk.api.model.VKApiItemFullArray;
import com.vk.sdk.api.model.VKCommentArray;

/**
 * Section market
 * Created by 4xes on 13.01.16.
 */
public class VKApiMarket extends VKApiBase{

    /*
    * https://vk.com/dev/market.get
    */
    public VKRequest get(VKParameters params) {
        if (params.containsKey(VKApiConst.EXTENDED) && ((Integer) params.get(VKApiConst.EXTENDED)) == 1) {
            return prepareRequest("get", params, VKApiItemFullArray.class);
        } else {
            return prepareRequest("get", params, VKApiItemArray.class);
        }
    }

    /*
    * https://vk.com/dev/market.getById
    */
    public VKRequest getById(VKParameters params) {
        if (params.containsKey(VKApiConst.EXTENDED) && ((Integer) params.get(VKApiConst.EXTENDED)) == 1) {
            return prepareRequest("getById", params, VKApiItemFullArray.class);
        } else {
            return prepareRequest("getById", params, VKApiItemArray.class);
        }
    }

    /*
    * https://vk.com/dev/market.search
    */
    public VKRequest search(VKParameters params) {
        if (params.containsKey(VKApiConst.EXTENDED) && ((Integer) params.get(VKApiConst.EXTENDED)) == 1) {
            return prepareRequest("search", params, VKApiItemFullArray.class);
        } else {
            return prepareRequest("search", params, VKApiItemArray.class);
        }
    }

    /*
    * https://vk.com/dev/market.getAlbums
    */
    public VKRequest getAlbums(VKParameters params) {
        return prepareRequest("getAlbums", params, VKApiItemAlbumArray.class);
    }

    /*
    * https://vk.com/dev/market.getAlbumById
    */
    public VKRequest getAlbumById(VKParameters params) {
        return prepareRequest("getAlbums", params, VKApiItemAlbumArray.class);
    }

    /*
    * https://vk.com/dev/market.createComment
    */
    public VKRequest createComment(VKParameters params) {
        return prepareRequest("createComment", params);
    }

    /*
    * https://vk.com/dev/market.getComments
    */
    public VKRequest getComments(VKParameters params) {
        return prepareRequest("getComments", params, VKCommentArray.class);
    }

    /*
    * https://vk.com/dev/market.deleteComment
    */
    public VKRequest deleteComment(VKParameters params) {
        return prepareRequest("deleteComment", params);
    }

    /*
    * https://vk.com/dev/market.restoreComment
    */
    public VKRequest restoreComment(VKParameters params) {
        return prepareRequest("restoreComment", params);
    }

    /*
    * https://vk.com/dev/market.reportComment
    */
    public VKRequest reportComment(VKParameters params) {
        return prepareRequest("reportComment", params);
    }

    /*
    * https://vk.com/dev/market.getCategories
    */
    public VKRequest getCategories(VKParameters params) {
        return prepareRequest("getCategories", params, VKApiCategoryArray.class);
    }

    /*
    * https://vk.com/dev/market.report
    */
    public VKRequest report(VKParameters params) {
        return prepareRequest("report", params);
    }

    /*
    * https://vk.com/dev/market.add
    */
    public VKRequest add(VKParameters params) {
        return prepareRequest("add", params);
    }

    /*
    * https://vk.com/dev/market.edit
    */
    public VKRequest edit(VKParameters params) {
        return prepareRequest("edit", params);
    }

    /*
    * https://vk.com/dev/market.delete
    */
    public VKRequest delete(VKParameters params) {
        return prepareRequest("delete", params);
    }

    /*
    * https://vk.com/dev/market.restore
    */
    public VKRequest restore(VKParameters params) {
        return prepareRequest("restore", params);
    }

    /*
    * https://vk.com/dev/market.reorderItems
    */
    public VKRequest reorderItems(VKParameters params) {
        return prepareRequest("reorderItems", params);
    }

    /*
    * https://vk.com/dev/market.reorderAlbums
    */
    public VKRequest reorderAlbums(VKParameters params) {
        return prepareRequest("reorderAlbums", params);
    }

    /*
    * https://vk.com/dev/market.addAlbum
    */
    public VKRequest addAlbum(VKParameters params) {
        return prepareRequest("addAlbum", params);
    }

    /*
    * https://vk.com/dev/market.editAlbum
    */
    public VKRequest editAlbum(VKParameters params) {
        return prepareRequest("editAlbum", params);
    }

    /*
    * https://vk.com/dev/market.deleteAlbum
    */
    public VKRequest deleteAlbum(VKParameters params) {
        return prepareRequest("deleteAlbum", params);
    }

    /*
    * https://vk.com/dev/market.removeFromAlbum
    */
    public VKRequest removeFromAlbum(VKParameters params) {
        return prepareRequest("removeFromAlbum", params);
    }

    /*
    * https://vk.com/dev/market.addToAlbum
    */
    public VKRequest addToAlbum(VKParameters params) {
        return prepareRequest("addToAlbum", params);
    }

    @Override
    protected String getMethodsGroup() {
        return "market";
    }
}
