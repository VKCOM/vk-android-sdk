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

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.os.Build;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.model.VKApiPhoto;
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
 * new VKShareDialogBuilder()
 * .setText("I created this post with VK Android SDK\nSee additional information below\n#vksdk")
 * .setUploadedPhotos(photos)
 * .setAttachmentImages(new VKUploadImage[]{
 * new VKUploadImage(myBitmap, VKImageParameters.pngImage())
 * })
 * .setAttachmentLink("VK Android SDK information", "https://vk.com/dev/android_sdk")
 * .setShareDialogListener(new VKShareDialog.VKShareDialogListener() {
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
public class VKShareDialogBuilder {

	String linkTitle;
	String linkUrl;
	VKUploadImage[] attachmentImages;
	VKPhotoArray existingPhotos;
	CharSequence attachmentText;
	VKShareDialogListener listener;

	/**
	 * Sets images that will be uploaded with post
	 *
	 * @param images array of VKUploadImage objects with image data and upload parameters
	 * @return Returns this dialog for chaining
	 */
	public VKShareDialogBuilder setAttachmentImages(VKUploadImage[] images) {
		this.attachmentImages = images;
		return this;
	}

	/**
	 * Sets this dialog post text. User can change that text
	 *
	 * @param textToPost Text for post
	 * @return Returns this dialog for chaining
	 */
	public VKShareDialogBuilder setText(CharSequence textToPost) {
		this.attachmentText = textToPost;
		return this;
	}

	/**
	 * Sets dialog link with link name
	 *
	 * @param linkTitle A small description for your link
	 * @param linkUrl   Url that link follows
	 * @return Returns this dialog for chaining
	 */
	public VKShareDialogBuilder setAttachmentLink(String linkTitle, String linkUrl) {
		this.linkTitle = linkTitle;
		this.linkUrl = linkUrl;
		return this;
	}

	/**
	 * Sets array of already uploaded photos from VK, that will be attached to post
	 *
	 * @param photos Prepared array of {@link VKApiPhoto} objects
	 * @return Returns this dialog for chaining
	 */
	public VKShareDialogBuilder setUploadedPhotos(VKPhotoArray photos) {
		this.existingPhotos = photos;
		return this;
	}

	/**
	 * Sets this dialog listener
	 *
	 * @param listener {@link VKShareDialogListener} object
	 * @return Returns this dialog for chaining
	 */
	public VKShareDialogBuilder setShareDialogListener(VKShareDialogListener listener) {
		this.listener = listener;
		return this;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void show(FragmentManager manager, String tag) {
		new VKShareDialogNative(this).show(manager, tag);
	}

	public void show(android.support.v4.app.FragmentManager manager, String tag) {
		new VKShareDialog(this).show(manager, tag);
	}

	public interface VKShareDialogListener {
		void onVkShareComplete(int postId);

		void onVkShareCancel();

		void onVkShareError(VKError error);
	}
}