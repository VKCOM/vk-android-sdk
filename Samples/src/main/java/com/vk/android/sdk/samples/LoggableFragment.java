/**
 * LoggableFragment.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 20.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.samples;

import android.app.Fragment;

public class LoggableFragment extends Fragment {

    public void log(CharSequence what) {
        ((MainActivity) getActivity()).log(what);
    }

}
