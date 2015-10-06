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

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vk.sdk.R;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKImageOperation;

/**
 * Dialog fo displaying captcha
 */
public class VKCaptchaDialog {
    private final VKError mCaptchaError;
    private EditText mCaptchaAnswer;
    private ImageView mCaptchaImage;
    private ProgressBar mProgressBar;
    private float mDensity;

    public VKCaptchaDialog(VKError captchaError) {

        mCaptchaError = captchaError;
    }

    /**
     * Prepare, create and show dialog for displaying captcha
     *
     * @param context Context activity for dialog
     */
    public void show(@NonNull Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        View innerView = View.inflate(context, R.layout.vk_captcha_dialog, null);
        assert innerView != null;
        mCaptchaAnswer = (EditText) innerView.findViewById(R.id.captchaAnswer);
        mCaptchaImage = (ImageView) innerView.findViewById(R.id.imageView);
        mProgressBar = (ProgressBar) innerView.findViewById(R.id.progressBar);

        mDensity = context.getResources().getDisplayMetrics().density;
        final AlertDialog dialog = new AlertDialog.Builder(context).setView(innerView).create();
        mCaptchaAnswer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });
        mCaptchaAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    sendAnswer();
                    dialog.dismiss();
                    return true;
                }
                return false;
            }
        });

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(android.R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        sendAnswer();
                        dialog.dismiss();
                    }
                });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                dialog.dismiss();
                mCaptchaError.request.cancel();
            }
        });
        if (onDismissListener != null) {
            dialog.setOnDismissListener(onDismissListener);
        }
        loadImage();
        dialog.show();
    }

    private void sendAnswer() {
        mCaptchaError.answerCaptcha(mCaptchaAnswer.getText() != null ? mCaptchaAnswer.getText().toString() : "");
    }

    private void loadImage() {
        VKImageOperation imageOperation = new VKImageOperation(mCaptchaError.captchaImg);
        imageOperation.imageDensity = mDensity;
        imageOperation.setImageOperationListener(new VKImageOperation.VKImageOperationListener() {
            @Override
            public void onComplete(VKImageOperation operation, Bitmap image) {
                mCaptchaImage.setImageBitmap(image);
                mCaptchaImage.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(VKImageOperation operation, VKError error) {
                loadImage();
            }
        });
        VKHttpClient.enqueueOperation(imageOperation);
    }
}