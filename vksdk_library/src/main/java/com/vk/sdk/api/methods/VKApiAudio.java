package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VkAudioArray;

/**
 * Builds requests for API.audio part
 */
public class VKApiAudio extends VKApiBase {
    /*
     * https://vk.com/dev/audio.get
     */
    public VKRequest get() {
        return get(null);
    }

    /*
     * https://vk.com/dev/audio.get
     */
    public VKRequest get(VKParameters params) {
        return prepareRequest("get", params, VkAudioArray.class);
    }

    /*
     * https://vk.com/dev/audio.getById
     */
    public VKRequest getById(VKParameters params) {
        return prepareRequest("getById", params);
    }

    /*
     * https://vk.com/dev/audio.getLyrics
     */
    public VKRequest getLyrics(VKParameters params) {
        return prepareRequest("getLyrics", params);
    }

    /*
     * https://vk.com/dev/audio.search
     */
    public VKRequest search(VKParameters params) {
        return prepareRequest("search", params, VkAudioArray.class);
    }

    /*
     * https://vk.com/dev/audio.getUploadServer
     */
    public VKRequest getUploadServer() {
        return getUploadServer(null);
    }

    /*
     * https://vk.com/dev/audio.getUploadServer
     */
    public VKRequest getUploadServer(VKParameters params) {
        return prepareRequest("getUploadServer", params);
    }

    /*
     * https://vk.com/dev/audio.save
     */
    public VKRequest save(VKParameters params) {
        return prepareRequest("save", params);
    }

    /*
     * https://vk.com/dev/audio.add
     */
    public VKRequest add(VKParameters params) {
        return prepareRequest("add", params);
    }

    /*
     * https://vk.com/dev/audio.delete
     */
    public VKRequest delete(VKParameters params) {
        return prepareRequest("delete", params);
    }

    /*
     * https://vk.com/dev/audio.edit
     */
    public VKRequest edit(VKParameters params) {
        return prepareRequest("edit", params);
    }

    /*
     * https://vk.com/dev/audio.reorder
     */
    public VKRequest reorder(VKParameters params) {
        return prepareRequest("reorder", params);
    }

    /*
     * https://vk.com/dev/audio.restore
     */
    public VKRequest restore(VKParameters params) {
        return prepareRequest("restore", params);
    }

    /*
     * https://vk.com/dev/audio.getAlbums
     */
    public VKRequest getAlbums() {
        return getAlbums(null);
    }

    /*
     * https://vk.com/dev/audio.getAlbums
     */
    public VKRequest getAlbums(VKParameters params) {
        return prepareRequest("getAlbums", params);
    }

    /*
     * https://vk.com/dev/audio.addAlbum
     */
    public VKRequest addAlbum(VKParameters params) {
        return prepareRequest("addAlbum", params);
    }

    /*
     * https://vk.com/dev/audio.editAlbum
     */
    public VKRequest editAlbum(VKParameters params) {
        return prepareRequest("editAlbum", params);
    }

    /*
     * https://vk.com/dev/audio.deleteAlbum
     */
    public VKRequest deleteAlbum(VKParameters params) {
        return prepareRequest("deleteAlbum", params);
    }

    /*
     * https://vk.com/dev/audio.moveToAlbum
     */
    public VKRequest moveToAlbum(VKParameters params) {
        return prepareRequest("moveToAlbum", params);
    }

    /*
     * https://vk.com/dev/audio.setBroadcast
     */
    public VKRequest setBroadcast(VKParameters params) {
        return prepareRequest("setBroadcast", params);
    }

    /*
     * https://vk.com/dev/audio.getBroadcastList
     */
    public VKRequest getBroadcastList() {
        return getBroadcastList(null);
    }

    /*
     * https://vk.com/dev/audio.getBroadcastList
     */
    public VKRequest getBroadcastList(VKParameters params) {
        return prepareRequest("getBroadcastList", params);
    }

    /*
     * https://vk.com/dev/audio.getRecommendations
     */
    public VKRequest getRecommendations() {
        return getRecommendations(null);
    }

    /*
     * https://vk.com/dev/audio.getRecommendations
     */
    public VKRequest getRecommendations(VKParameters params) {
        return prepareRequest("getRecommendations", params, VkAudioArray.class);
    }

    /*
     * https://vk.com/dev/audio.getPopular
     */
    public VKRequest getPopular() {
        return getPopular(null);
    }

    /*
     * https://vk.com/dev/audio.getPopular
     */
    public VKRequest getPopular(VKParameters params) {
        return prepareRequest("getPopular", params, VkAudioArray.class);
    }

    /*
     * https://vk.com/dev/audio.getCount
     */
    public VKRequest getCount(VKParameters params) {
        return prepareRequest("getCount", params);
    }

    @Override
    protected String getMethodsGroup() {
        return "audio";
    }
}