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

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vk.sdk.R;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKImageOperation;
import com.vk.sdk.api.model.VKApiLink;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadWallPhotoRequest;
import com.vk.sdk.dialogs.VKShareDialogBuilder.VKShareDialogListener;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;

import java.util.ArrayList;

class VKShareDialogDelegate {

	public interface DialogFragmentI {
		Activity getActivity();

		Resources getResources();

		void dismissAllowingStateLoss();

		Dialog getDialog();
	}

	static private final String SHARE_TEXT_KEY = "ShareText";
	static private final String SHARE_LINK_KEY = "ShareLink";
	static private final String SHARE_IMAGES_KEY = "ShareImages";
	static private final String SHARE_UPLOADED_IMAGES_KEY = "ShareUploadedImages";

	static private final int SHARE_PHOTO_HEIGHT = 100;
	static private final int SHARE_PHOTO_CORNER_RADIUS = 3;
	static private final int SHARE_PHOTO_MARGIN_LEFT = 10;

	private EditText mShareTextField;
	private Button mSendButton;
	private ProgressBar mSendProgress;
	private LinearLayout mPhotoLayout;
	private HorizontalScrollView mPhotoScroll;

	private UploadingLink mAttachmentLink;
	private VKUploadImage[] mAttachmentImages;
	private VKPhotoArray mExistingPhotos;
	private CharSequence mAttachmentText;

	private VKShareDialogListener mListener;
	private final DialogFragmentI dialogFragmentI;

	public VKShareDialogDelegate(DialogFragmentI dialogFragmentI) {
		this.dialogFragmentI = dialogFragmentI;
	}

	public void setAttachmentImages(VKUploadImage[] images) {
		mAttachmentImages = images;
	}

	public void setText(CharSequence textToPost) {
		mAttachmentText = textToPost;
	}

	public void setAttachmentLink(String linkTitle, String linkUrl) {
		mAttachmentLink = new UploadingLink(linkTitle, linkUrl);
	}

	public void setUploadedPhotos(VKPhotoArray photos) {
		mExistingPhotos = photos;
	}

	public void setShareDialogListener(VKShareDialogListener listener) {
		mListener = listener;
	}

	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Context context = dialogFragmentI.getActivity();
		View mInternalView = View.inflate(context, R.layout.vk_share_dialog, null);

		assert mInternalView != null;

		mSendButton = (Button) mInternalView.findViewById(R.id.sendButton);
		mSendProgress = (ProgressBar) mInternalView.findViewById(R.id.sendProgress);
		mPhotoLayout = (LinearLayout) mInternalView.findViewById(R.id.imagesContainer);
		mShareTextField = (EditText) mInternalView.findViewById(R.id.shareText);
		mPhotoScroll = (HorizontalScrollView) mInternalView.findViewById(R.id.imagesScrollView);

		LinearLayout mAttachmentLinkLayout = (LinearLayout) mInternalView.findViewById(R.id.attachmentLinkLayout);

		mSendButton.setOnClickListener(sendButtonPress);

		//Attachment text
		if (savedInstanceState != null) {
			mShareTextField.setText(savedInstanceState.getString(SHARE_TEXT_KEY));
			mAttachmentLink = savedInstanceState.getParcelable(SHARE_LINK_KEY);
			mAttachmentImages = (VKUploadImage[]) savedInstanceState.getParcelableArray(SHARE_IMAGES_KEY);
			mExistingPhotos = savedInstanceState.getParcelable(SHARE_UPLOADED_IMAGES_KEY);
		} else if (mAttachmentText != null) {
			mShareTextField.setText(mAttachmentText);
		}

		//Attachment photos
		mPhotoLayout.removeAllViews();
		if (mAttachmentImages != null) {
			for (VKUploadImage mAttachmentImage : mAttachmentImages) {
				addBitmapToPreview(mAttachmentImage.mImageData);
			}
			mPhotoLayout.setVisibility(View.VISIBLE);
		}

		if (mExistingPhotos != null) {
			processExistingPhotos();
		}
		if (mExistingPhotos == null && mAttachmentImages == null) {
			mPhotoLayout.setVisibility(View.GONE);
		}

		//Attachment link
		if (mAttachmentLink != null) {
			TextView linkTitle = (TextView) mAttachmentLinkLayout.findViewById(R.id.linkTitle),
					linkHost = (TextView) mAttachmentLinkLayout.findViewById(R.id.linkHost);

			linkTitle.setText(mAttachmentLink.linkTitle);
			linkHost.setText(VKUtil.getHost(mAttachmentLink.linkUrl));
			mAttachmentLinkLayout.setVisibility(View.VISIBLE);
		} else {
			mAttachmentLinkLayout.setVisibility(View.GONE);
		}
		Dialog result = new Dialog(context);
		result.requestWindowFeature(Window.FEATURE_NO_TITLE);
		result.setContentView(mInternalView);
		result.setCancelable(true);
		return result;
	}

	public void onStart() {
		int width = WindowManager.LayoutParams.WRAP_CONTENT;

		if (Build.VERSION.SDK_INT >= 13) {
			WindowManager wm = (WindowManager) dialogFragmentI.getActivity().getSystemService(Context.WINDOW_SERVICE);
			Display display = wm.getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			width = size.x - dialogFragmentI.getResources().getDimensionPixelSize(R.dimen.vk_share_dialog_view_padding) * 2;
		}

		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(dialogFragmentI.getDialog().getWindow().getAttributes());
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.width = width;
		dialogFragmentI.getDialog().getWindow().setAttributes(lp);
	}

	public void onSaveInstanceState(Bundle outState) {
		outState.putString(SHARE_TEXT_KEY, mShareTextField.getText().toString());
		if (mAttachmentLink != null)
			outState.putParcelable(SHARE_LINK_KEY, mAttachmentLink);
		if (mAttachmentImages != null)
			outState.putParcelableArray(SHARE_IMAGES_KEY, mAttachmentImages);
		if (mExistingPhotos != null)
			outState.putParcelable(SHARE_UPLOADED_IMAGES_KEY, mExistingPhotos);
	}

	private void setIsLoading(boolean loading) {
		if (loading) {
			mSendButton.setVisibility(View.GONE);
			mSendProgress.setVisibility(View.VISIBLE);
			mShareTextField.setEnabled(false);
			mPhotoLayout.setEnabled(false);
		} else {
			mSendButton.setVisibility(View.VISIBLE);
			mSendProgress.setVisibility(View.GONE);
			mShareTextField.setEnabled(true);
			mPhotoLayout.setEnabled(true);
		}
	}

	private void processExistingPhotos() {
		ArrayList<String> photosToLoad = new ArrayList<>(mExistingPhotos.size());
		for (VKApiPhoto photo : mExistingPhotos) {
			photosToLoad.add("" + photo.owner_id + '_' + photo.id);
		}
		VKRequest photosById = new VKRequest("photos.getById",
				VKParameters.from(VKApiConst.PHOTO_SIZES, 1, VKApiConst.PHOTOS, VKStringJoiner.join(photosToLoad, ",")), VKPhotoArray.class);
		photosById.executeWithListener(new VKRequest.VKRequestListener() {
			@Override
			public void onComplete(VKResponse response) {
				VKPhotoArray photos = (VKPhotoArray) response.parsedModel;
				for (VKApiPhoto photo : photos) {
					if (photo.src.getByType('q') != null) {
						loadAndAddPhoto(photo.src.getByType('q'));
					} else if (photo.src.getByType('p') != null) {
						loadAndAddPhoto(photo.src.getByType('p'));
					} else if (photo.src.getByType('m') != null) {
						loadAndAddPhoto(photo.src.getByType('m'));
					}
					//else ignore that strange photo
				}
			}

			@Override
			public void onError(VKError error) {
				if (VKSdk.DEBUG) {
					Log.w(VKSdk.SDK_TAG, "Cannot load photos for share: " + error.toString());
				}
				if (mListener != null) {
					mListener.onVkShareError(error);
				}
			}
		});
	}

	private void loadAndAddPhoto(final String photoUrl) {
		loadAndAddPhoto(photoUrl, 0);
	}

	private void loadAndAddPhoto(final String photoUrl, final int attempt) {
		if (attempt > 10) return;
		VKImageOperation op = new VKImageOperation(photoUrl);
		op.setImageOperationListener(new VKImageOperation.VKImageOperationListener() {
			@Override
			public void onComplete(VKImageOperation operation, Bitmap image) {
				if (image == null) {
					new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
						@Override
						public void run() {
							loadAndAddPhoto(photoUrl, attempt + 1);
						}
					}, 1000);
					return;
				}
				addBitmapToPreview(image);
			}

			@Override
			public void onError(VKImageOperation operation, VKError error) {
				// todo method body
			}
		});
		VKHttpClient.enqueueOperation(op);
	}

	private void addBitmapToPreview(Bitmap sourceBitmap) {
		if (dialogFragmentI.getActivity() == null) return;
		Bitmap b = VKUIHelper.getRoundedCornerBitmap(sourceBitmap, SHARE_PHOTO_HEIGHT, SHARE_PHOTO_CORNER_RADIUS);
		if (b == null) return;
		ImageView iv = new ImageView(dialogFragmentI.getActivity());
		iv.setImageBitmap(b);
		iv.setAdjustViewBounds(true);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		params.setMargins(mPhotoLayout.getChildCount() > 0 ? SHARE_PHOTO_MARGIN_LEFT : 0, 0, 0, 0);

		mPhotoLayout.addView(iv, params);
		mPhotoLayout.invalidate();
		mPhotoScroll.invalidate();
	}

	private void makePostWithAttachments(VKAttachments attachments) {

		if (attachments == null) {
			attachments = new VKAttachments();
		}
		if (mExistingPhotos != null) {
			attachments.addAll(mExistingPhotos);
		}
		if (mAttachmentLink != null) {
			attachments.add(new VKApiLink(mAttachmentLink.linkUrl));
		}
		String message = mShareTextField.getText().toString();

		final Long userId = Long.parseLong(VKSdk.getAccessToken().userId);
		VKRequest wallPost = VKApi.wall().post(VKParameters.from(VKApiConst.OWNER_ID, userId, VKApiConst.MESSAGE, message, VKApiConst.ATTACHMENTS, attachments.toAttachmentsString()));
		wallPost.executeWithListener(new VKRequest.VKRequestListener() {
			@Override
			public void onError(VKError error) {
				setIsLoading(false);
				if (mListener != null) {
					mListener.onVkShareError(error);
				}
			}

			@Override
			public void onComplete(VKResponse response) {
				setIsLoading(false);
				VKWallPostResult res = (VKWallPostResult) response.parsedModel;
				if (mListener != null) {
					mListener.onVkShareComplete(res.post_id);
				}
				dialogFragmentI.dismissAllowingStateLoss();
			}
		});
	}

	View.OnClickListener sendButtonPress = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			setIsLoading(true);
			if (mAttachmentImages != null && VKSdk.getAccessToken() != null) {
				final Long userId = Long.parseLong(VKSdk.getAccessToken().userId);
				VKUploadWallPhotoRequest photoRequest = new VKUploadWallPhotoRequest(mAttachmentImages, userId, 0);
				photoRequest.executeWithListener(new VKRequest.VKRequestListener() {
					@Override
					public void onComplete(VKResponse response) {
						VKPhotoArray photos = (VKPhotoArray) response.parsedModel;
						VKAttachments attachments = new VKAttachments(photos);
						makePostWithAttachments(attachments);
					}

					@Override
					public void onError(VKError error) {
						setIsLoading(false);
						if (mListener != null) {
							mListener.onVkShareError(error);
						}
					}
				});
			} else {
				makePostWithAttachments(null);
			}
		}
	};

	public void onCancel(DialogInterface dialog) {
		if (mListener != null) {
			mListener.onVkShareCancel();
		}
	}

	static private class UploadingLink implements Parcelable {
		public String linkTitle, linkUrl;

		public UploadingLink(String title, String url) {
			linkTitle = title;
			linkUrl = url;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.linkTitle);
			dest.writeString(this.linkUrl);
		}

		private UploadingLink(Parcel in) {
			this.linkTitle = in.readString();
			this.linkUrl = in.readString();
		}

		public static final Parcelable.Creator<UploadingLink> CREATOR = new Parcelable.Creator<UploadingLink>() {
			public UploadingLink createFromParcel(Parcel source) {
				return new UploadingLink(source);
			}

			public UploadingLink[] newArray(int size) {
				return new UploadingLink[size];
			}
		};
	}
}