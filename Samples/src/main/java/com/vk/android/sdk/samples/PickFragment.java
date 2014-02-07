/**
 * PickFragment.java
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

public class PickFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick, container, false);
        view.findViewById(R.id.test_requests).setOnClickListener(this);
        view.findViewById(R.id.test_methods).setOnClickListener(this);
        view.findViewById(R.id.test_errors).setOnClickListener(this);
        view.findViewById(R.id.test_vk_auth).setOnClickListener(this);
        view.findViewById(R.id.test_oauth).setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_requests: {
                getFragmentManager().beginTransaction().replace(R.id.root_fragment, new RequestsFragment()).addToBackStack(null).commit();
            } break;
            case R.id.test_methods: {
                getFragmentManager().beginTransaction().replace(R.id.root_fragment, new APIFragment()).addToBackStack(null).commit();
            } break;
            case R.id.test_errors: {
                getFragmentManager().beginTransaction().replace(R.id.root_fragment, new ErrorsFragment()).addToBackStack(null).commit();
            } break;
            case R.id.test_vk_auth: {
                ((MainActivity) getActivity()).requestAuth();
            } break;
            case R.id.test_oauth: {
                ((MainActivity) getActivity()).requestOAuth();
            } break;
        }
    }
}
