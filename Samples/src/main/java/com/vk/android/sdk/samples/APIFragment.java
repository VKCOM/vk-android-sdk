/**
 * PickFragment.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 20.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.samples;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vk.android.sdk.VK;
import com.vk.android.sdk.exceptions.*;
import com.vk.android.sdk.methods.Friends;
import com.vk.android.sdk.methods.Upload;
import com.vk.android.sdk.methods.Wall;
import com.vk.android.sdk.models.VKList;
import com.vk.android.sdk.models.VKPhoto;
import com.vk.android.sdk.models.VKUser;
import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.CancellationException;

public class APIFragment extends LoggableFragment implements View.OnClickListener {

    private static final int REQUEST_PICK_IMAGE = 33;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_api, container, false);
        view.findViewById(R.id.test_friends).setOnClickListener(this);
        view.findViewById(R.id.test_codeblock).setOnClickListener(this);
        view.findViewById(R.id.test_post).setOnClickListener(this);
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
            case R.id.test_friends: {
                getFriends();
            } break;
            case R.id.test_codeblock: {
                testCodeblock();
            } break;
            case R.id.test_post: {
                // First let's pick a photo to wall
                pickPhoto();
            } break;
        }
    }

    private void testCodeblock() {
        if(!VK.with(getActivity()).isAuthorized()) {
            log("Codeblock: you need to authorize first.");
            return;
        }

        // Let's try to do something simple - return our first friend
        VK.with(getActivity()).exec(new VK.Codeblock<VKUser>() {

            @Override
            public VKUser run()  throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {
                VKList<VKUser> friends =  new Friends.get().order(Friends.ORDER_HINTS).execute();
                if(!friends.isEmpty()) {
                    return friends.get(0);
                } else {
                    return null;
                }
            }
        }, new VK.SimpleCallback<VKUser>() {
            @Override
            public void onAdded(VK vk) {
                log("Codeblock: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("Codeblock: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKUser data) {
                if(data != null) {
                    log("Codeblock: onSuccess, result: " + data);
                } else {
                    log("Codeblock: Ooops! It's seems like you have no friends");
                }
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("Codeblock: onError, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("Codeblock: onPostExecute");
            }
        });
    }

    private void getFriends() {
        if(!VK.with(getActivity()).isAuthorized()) {
            log("FriendsRequest: you need to authorize first.");
            return;
        }
        VK.with(getActivity()).exec(Friends.get().limit(0, 5).order(Friends.ORDER_HINTS), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                log("FriendsRequest: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("FriendsRequest: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                log("FriendsRequest: onSuccess, result: " + TextUtils.join(", ", data));
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("FriendsRequest: onError, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("FriendsRequest: onPostExecute");
            }
        });
    }

    private void pickPhoto() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent, REQUEST_PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_PICK_IMAGE && data != null) {
            // Now, let's get a file URI from database URI;
            Uri uri = data.getData();
            String scheme = uri.getScheme();
            if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
                String[] projection = { MediaStore.Images.Media.DATA };
                Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                String result = new StringBuilder().append(ContentResolver.SCHEME_FILE).append("://").append(cursor.getString(column_index)).toString();
                cursor.close();
                uri = Uri.parse(result);
            }

            // And finally start an upload
            testWallPost(uri);
        }
    }

    private void testWallPost(Uri photo) {
        if(!VK.with(getActivity()).isAuthorized()) {
            log("testWallPost: you need to authorize first.");
            return;
        }
        final VK vk = VK.with(getActivity());
        final Upload.photoToWall uploader = Upload.photoToWall(photo, vk.getAccount().getUserId());

        vk.exec(uploader, new VK.SimpleCallback<VKPhoto>() {
            @Override
            public void onAdded(VK vk) {
                log("testWallPost: photoUploading: onAdded");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("testWallPost: photoUploading: onPreExecute");
            }

            @Override
            public void onUploadProgress(VK vk, int file, int progress) {
                log("progress: " + progress);
            }

            @Override
            public void onSuccess(VK vk, VKPhoto data) {
                log("testWallPost: photoUploading: onSuccess");
                log("testWallPost: starting a wall publishing");

                vk.exec(Wall.post().
                        withText("Test!").withAttachments(data.toAttachmentString()).friendsOnly(true).publishDate(System.currentTimeMillis() / 1000 + 12 * 60 * 60 ), new VK.SimpleCallback<Integer>() {

                    @Override
                    public void onSuccess(VK vk, Integer data) {
                        log("testWallPost: Post is ready");
                    }
                });
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("testWallPost: photoUploading: onError, error=" + e.getMessage());
            }

            @Override
            public void onPostExecute(VK vk) {
                log("testWallPost: photoUploading: onPostExecute");
            }
        });
    }
}
