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
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.vk.sdk.R;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKServiceActivity;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import java.util.Locale;
import java.util.Map;

public class VKOpenAuthDialog implements DialogInterface.OnDismissListener {

	public static final String VK_EXTRA_CLIENT_ID = "client_id";
	public static final String VK_EXTRA_SCOPE = "scope";
	public static final String VK_EXTRA_API_VERSION = "version";
	public static final String VK_EXTRA_REVOKE = "revoke";

	public static final String VK_RESULT_INTENT_NAME = "com.vk.auth-token";
	public static final String VK_EXTRA_TOKEN_DATA = "extra-token-data";
	public static final String VK_EXTRA_VALIDATION_REQUEST = "extra-validation-request";

	private static final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
	private static final String ERROR = "error";
	private static final String CANCEL = "cancel";

	@Nullable
	protected VKError mVkError;
	protected WebView mWebView;
	protected View mProgress;
	protected View mView;
	protected Bundle mBundle;
	protected Intent mData;
	protected int mResCode = Activity.RESULT_OK;
	protected int mReqCode;
	protected Dialog mDialog;

	public void show(@NonNull Activity activity, Bundle bundle, int reqCode, @Nullable VKError vkError) {
		mVkError = vkError;
		mBundle = bundle;
		mReqCode = reqCode;
		mView = View.inflate(activity, R.layout.vk_open_auth_dialog, null);

		mProgress = mView.findViewById(R.id.progress);
		mWebView = (WebView) mView.findViewById(R.id.copyUrl);

		final Dialog dialog = new Dialog(activity, R.style.VKAlertDialog);
		dialog.setContentView(mView);
		dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialogInterface) {
				dialog.dismiss();
			}
		});
		dialog.setOnDismissListener(this);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			dialog.getWindow().setStatusBarColor(Color.TRANSPARENT);
		}

		mDialog = dialog;
		mDialog.show();

		loadPage();
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void loadPage() {
		try {
			String urlToLoad;
			urlToLoad = mVkError == null ? null : mVkError.redirectUri;
			if (urlToLoad == null) {
				int appId = mBundle.getInt(VK_EXTRA_CLIENT_ID, 0);
				String scope = mBundle.getString(VK_EXTRA_SCOPE),
						apiV = mBundle.getString(VK_EXTRA_API_VERSION);
				boolean revoke = mBundle.getBoolean(VK_EXTRA_REVOKE, false);
				urlToLoad = String.format(Locale.US,
						"https://oauth.vk.com/authorize?client_id=%s" +
								"&scope=%s" +
								"&redirect_uri=%s" +
								"&display=mobile" +
								"&v=%s" +
								"&response_type=token&revoke=%d",
						appId, scope, REDIRECT_URL, apiV, revoke ? 1 : 0);
			}
			mWebView.setWebViewClient(new OAuthWebViewClient(this));
			WebSettings webSettings = mWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			mWebView.loadUrl(urlToLoad);
			mWebView.setBackgroundColor(Color.TRANSPARENT);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				mWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
			}
			mWebView.setVerticalScrollBarEnabled(false);
			mWebView.setVisibility(View.INVISIBLE);
			mWebView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
			mProgress.setVisibility(View.VISIBLE);
		} catch (Exception e) {
			setResult(Activity.RESULT_CANCELED);
			finish();
		}
	}

	private static class OAuthWebViewClient extends WebViewClient {
		boolean canShowPage = true;
		@NonNull
		final VKOpenAuthDialog vkOpenAuthDialog;

		public OAuthWebViewClient(@NonNull VKOpenAuthDialog vkOpenAuthDialog) {
			this.vkOpenAuthDialog = vkOpenAuthDialog;
		}

		boolean processUrl(String url) {
			if (url.startsWith(REDIRECT_URL)) {
				Intent data = new Intent(VK_RESULT_INTENT_NAME);
				String extraData = url.substring(url.indexOf('#') + 1);
				data.putExtra(VK_EXTRA_TOKEN_DATA, extraData);
				Map<String, String> resultParams = VKUtil.explodeQueryString(extraData);

				if (vkOpenAuthDialog.mVkError != null) {
					data.putExtra(VK_EXTRA_VALIDATION_REQUEST, vkOpenAuthDialog.mVkError.request.registerObject());
				}
				if (resultParams != null && (resultParams.containsKey(ERROR) || resultParams.containsKey(CANCEL))) {
					vkOpenAuthDialog.setResult(Activity.RESULT_CANCELED, data);
				} else {
					vkOpenAuthDialog.setResult(Activity.RESULT_OK, data);
				}
				vkOpenAuthDialog.finish();
				return true;
			}
			return false;
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (processUrl(url))
				return true;
			canShowPage = true;
			return false;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			processUrl(url);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			if (canShowPage) {
				if (vkOpenAuthDialog.mProgress != null) {
					vkOpenAuthDialog.mProgress.setVisibility(View.GONE);
				}
				view.setVisibility(View.VISIBLE);
			}
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			super.onReceivedError(view, errorCode, description, failingUrl);
			canShowPage = false;
			AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext())
					.setMessage(description)
					.setPositiveButton(R.string.vk_retry, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							vkOpenAuthDialog.loadPage();
						}
					})
					.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							vkOpenAuthDialog.finish();
						}
					});
			try {
				builder.show();
			} catch (Exception e) {
				if (VKSdk.DEBUG)
					e.printStackTrace();
			}
		}
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		Activity activity = mView == null ? null : (Activity) mView.getContext();
		if (activity instanceof VKServiceActivity) {
			((VKServiceActivity) activity).onActivityResultPublic(mReqCode, mResCode, mData);
		}
	}

	private void setResult(int code) {
		mResCode = code;
	}

	private void setResult(int code, Intent data) {
		mResCode = code;
		mData = data;
	}

	private void finish() {
		if (mDialog != null) {
			mDialog.dismiss();
		}
	}
}