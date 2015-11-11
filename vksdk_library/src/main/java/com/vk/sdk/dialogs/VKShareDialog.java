//
//  Copyright (c) 2015 VK.com
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

package com.vk.sdk.dialogs;

import android.os.Build;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.photo.VKUploadImage;

/**
 * Share dialog for making post directly to VK.
 * Now it supports: attaching 1 named link, attaching photos with upload,
 * attaching photos already uploaded to VK.
 * Example usage:
 * <pre>
 * {@code VKPhotoArray photos = new VKPhotoArray();
 * photos.add(new VKApiPhoto("photo-47200925_314622346"));
 * new VKShareDialogCompat()
 * .setText("I created this post with VK Android SDK\nSee additional information below\n#vksdk")
 * .setUploadedPhotos(photos)
 * .setAttachmentImages(new VKUploadImage[]{
 * new VKUploadImage(myBitmap, VKImageParameters.pngImage())
 * })
 * .setAttachmentLink("VK Android SDK information", "https://vk.com/dev/android_sdk")
 * .setShareDialogListener(new VKShareDialogCompat.VKShareDialogListener() {
 * public void onVkShareComplete(int postId) {
 *
 * }
 * public void onVkShareCancel() {
 *
 * }
 * })
 * .show(getFragmentManager(), "VK_SHARE_DIALOG");
 * }
 * </pre>
 */
public class VKShareDialog {

    private VKShareDialogHelper.VKShareDialogApis mDialog;

    public VKShareDialog() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            mDialog = new VKShareDialogICS();
        } else {
            mDialog = new VKShareDialogCompat();
        }
    }

    public VKShareDialog setText(String text) {
        mDialog.getHelper().setText(text);
        return this;
    }

    public VKShareDialog setUploadedPhotos(VKPhotoArray photos) {
        mDialog.getHelper().setUploadedPhotos(photos);
        return this;
    }

    public VKShareDialog setAttachmentImages(VKUploadImage[] vkUploadImages) {
        mDialog.getHelper().setAttachmentImages(vkUploadImages);
        return this;
    }

    public VKShareDialog setAttachmentLink(String s, String s1) {
        mDialog.getHelper().setAttachmentLink(s, s1);
        return this;
    }

    /**
     * Sets this dialog listener
     *
     * @param listener {@link VKShareDialog.VKShareDialogListener} object
     * @return Returns this dialog for chaining
     */
    public VKShareDialog setShareDialogListener(VKShareDialogListener listener) {
        mDialog.getHelper().setShareDialogListener(listener);
        return this;
    }

    public void show(android.app.FragmentManager fragmentManager, String vk_share_dialog) {
        mDialog.show(fragmentManager, vk_share_dialog);
    }

    public void show(android.support.v4.app.FragmentManager fragmentManager, String vk_share_dialog) {
        mDialog.show(fragmentManager, vk_share_dialog);
    }

    public interface VKShareDialogListener {
        void onVkShareComplete(int postId);

        void onVkShareCancel();

        void onVkShareError(VKError error);
    }

}
