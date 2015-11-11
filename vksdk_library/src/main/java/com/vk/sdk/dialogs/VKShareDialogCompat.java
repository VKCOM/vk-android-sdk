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

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;


public class VKShareDialogCompat extends DialogFragment implements VKShareDialogHelper.VKShareDialogApis {

    private VKShareDialogHelper mHelper;

    public VKShareDialogCompat() {
        mHelper = new VKShareDialogHelper(this);
    }

    @Override
    public void show(android.app.FragmentManager fragmentManager, String vk_share_dialog) {
        throw new IllegalArgumentException("Please, use getFragmentManager() and not getSupportFragmentManager()");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return mHelper.onCreateDialog(savedInstanceState);
    }

    @Override
    @SuppressLint("NewApi")
    public void onStart() {
        super.onStart();
        mHelper.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mHelper.onSaveInstanceState(outState);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        mHelper.onCancel();

    }

    @Override
    public Context onRequestActivity() {
        return getActivity();
    }

    @Override
    public void onRequestDismiss() {
        dismissAllowingStateLoss();
    }

    @Override
    public VKShareDialogHelper getHelper() {
        return mHelper;
    }

}