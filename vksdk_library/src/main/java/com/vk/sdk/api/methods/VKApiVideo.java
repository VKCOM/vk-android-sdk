package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiModel;
import com.vk.sdk.api.model.VkVideoArray;

/**
 * Builds request for API.video part
 */
public class VKApiVideo extends VKApiBase {
    /*
     * https://vk.com/dev/video.get
     */
    public VKRequest get() {
        return get(null);
    }

    /*
     * https://vk.com/dev/video.get
     */
    public VKRequest get(VKParameters params) {
        return prepareRequest("get", params, VkVideoArray.class);
    }

    /*
     * https://vk.com/dev/video.edit
     */
    public VKRequest edit(VKParameters params) {
        return prepareRequest("edit", params);
    }

    /*
     * https://vk.com/dev/video.add
     */
    public VKRequest add(VKParameters params) {
        return prepareRequest("add", params);
    }

    /*
     * https://vk.com/dev/video.save
     */
    public VKRequest save(VKParameters params) {
        return prepareRequest("save", params);
    }

    /*
     * https://vk.com/dev/video.delete
     */
    public VKRequest delete(VKParameters params) {
        return prepareRequest("delete", params);
    }

    /*
     * https://vk.com/dev/video.restore
     */
    public VKRequest restore(VKParameters params) {
        return prepareRequest("restore", params);
    }

    /*
     * https://vk.com/dev/video.search
     */
    public VKRequest search(VKParameters params) {
        return prepareRequest("search", params, VkVideoArray.class);
    }

    /*
     * https://vk.com/dev/video.getUserVideos
     */
    public VKRequest getUserVideos(VKParameters params) {
        return prepareRequest("getUserVideos", params, VkVideoArray.class);
    }

    /*
     * https://vk.com/dev/video.getAlbums
     */
    public VKRequest getAlbums() {
        return getAlbums(null);
    }

    /*
     * https://vk.com/dev/video.getAlbums
     */
    public VKRequest getAlbums(VKParameters params) {
        return prepareRequest("getAlbums", params);
    }

    /*
     * https://vk.com/dev/video.getAlbumById
     */
    public VKRequest getAlbumById(VKParameters params) {
        return prepareRequest("getAlbumById", params);
    }

    /*
     * https://vk.com/dev/video.addAlbum
     */
    public VKRequest addAlbum(VKParameters params) {
        return prepareRequest("addAlbum", params);
    }

    /*
     * https://vk.com/dev/video.editAlbum
     */
    public VKRequest editAlbum(VKParameters params) {
        return prepareRequest("editAlbum", params);
    }

    /*
     * https://vk.com/dev/video.deleteAlbum
     */
    public VKRequest deleteAlbum(VKParameters params) {
        return prepareRequest("deleteAlbum", params);
    }

    /*
     * https://vk.com/dev/video.reorderAlbums
     */
    public VKRequest reorderAlbums(VKParameters params) {
        return prepareRequest("getAlbumById", params);
    }

    /*
     * https://vk.com/dev/video.reorderVideos
     */
    public VKRequest reorderVideos(VKParameters params) {
        return prepareRequest("getAlbumById", params);
    }

    /*
     * https://vk.com/dev/video.addToAlbum
     */
    public VKRequest addToAlbum(VKParameters params) {
        return prepareRequest("addToAlbum", params);
    }

    /*
     * https://vk.com/dev/video.removeFromAlbum
     */
    public VKRequest removeFromAlbum(VKParameters params) {
        return prepareRequest("removeFromAlbum", params);
    }

    /*
     * https://vk.com/dev/video.getAlbumsByVideo
     */
    public VKRequest getAlbumsByVideo(VKParameters params) {
        return prepareRequest("getAlbumsByVideo", params);
    }

    /*
     * https://vk.com/dev/video.getComments
     */
    public VKRequest getComments(VKParameters params) {
        return prepareRequest("getComments", params);
    }

    /*
     * https://vk.com/dev/video.createComment
     */
    public VKRequest createComment(VKParameters params) {
        return prepareRequest("createComment", params);
    }

    /*
     * https://vk.com/dev/video.deleteComment
     */
    public VKRequest deleteComment(VKParameters params) {
        return prepareRequest("deleteComment", params);
    }

    /*
     * https://vk.com/dev/video.restoreComment
     */
    public VKRequest restoreComment(VKParameters params) {
        return prepareRequest("restoreComment", params);
    }

    /*
     * https://vk.com/dev/video.editComment
     */
    public VKRequest editComment(VKParameters params) {
        return prepareRequest("editComment", params);
    }

    /*
     * https://vk.com/dev/video.getTags
     */
    public VKRequest getTags(VKParameters params) {
        return prepareRequest("getTags", params);
    }

    /*
     * https://vk.com/dev/video.putTag
     */
    public VKRequest putTag(VKParameters params) {
        return prepareRequest("putTag", params);
    }

    /*
     * https://vk.com/dev/video.removeTag
     */
    public VKRequest removeTag(VKParameters params) {
        return prepareRequest("removeTag", params);
    }

    /*
     * https://vk.com/dev/video.getNewTags
     */
    public VKRequest getNewTags(VKParameters params) {
        return prepareRequest("getNewTags", params);
    }

    /*
     * https://vk.com/dev/video.report
     */
    public VKRequest report(VKParameters params) {
        return prepareRequest("report", params);
    }

    /*
     * https://vk.com/dev/video.reportComment
     */
    public VKRequest reportComment(VKParameters params) {
        return prepareRequest("reportComment", params);
    }

    @Override
    protected String getMethodsGroup() {
        return "video";
    }
}
