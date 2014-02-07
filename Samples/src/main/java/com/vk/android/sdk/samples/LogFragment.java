/**
 * LogFragment.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 20.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.samples;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LogFragment extends Fragment {

    private StringBuilder text;
    private TextView logText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.log_fragment, container, false);
        logText = (TextView) view.findViewById(R.id.log_text);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logText = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logText.setText(text);
    }

    public void log(CharSequence text) {
        if(this.text == null) {
            this.text = new StringBuilder(text);
        } else {
            this.text.append(text);
        }
        this.text.append('\n');
        if(logText != null) {
            logText.setText(this.text);
        }
    }

    public void clear() {
        this.text = null;
        this.logText.setText(text);
    }
}
