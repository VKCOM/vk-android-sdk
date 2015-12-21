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

package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class VKShareDialogNative extends DialogFragment implements VKShareDialogDelegate.DialogFragmentI {

	private VKShareDialogDelegate mDelegate = new VKShareDialogDelegate(this);

	public VKShareDialogNative() {
	}

	@SuppressLint("ValidFragment")
	VKShareDialogNative(VKShareDialogBuilder builder) {
		mDelegate.setAttachmentImages(builder.attachmentImages);
		mDelegate.setText(builder.attachmentText);
		if (builder.linkTitle != null && builder.linkUrl != null) {
			mDelegate.setAttachmentLink(builder.linkTitle, builder.linkUrl);
		}
		mDelegate.setUploadedPhotos(builder.existingPhotos);
		mDelegate.setShareDialogListener(builder.listener);
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return mDelegate.onCreateDialog(savedInstanceState);
	}

	@Override
	@SuppressLint("NewApi")
	public void onStart() {
		super.onStart();
		mDelegate.onStart();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mDelegate.onSaveInstanceState(outState);
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		mDelegate.onCancel(dialog);
	}
}