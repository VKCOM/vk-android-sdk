package com.vk.vktestapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKBatchRequest;
import com.vk.sdk.api.VKBatchRequest.VKBatchRequestListener;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKRequest.VKRequestListener;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.methods.VKApiCaptcha;
import com.vk.sdk.api.model.VKPhoto;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKImageParameters;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.util.VKStringJoiner;

import java.io.IOException;

public class TestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        VKUIHelper.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VKUIHelper.onDestroy(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKUIHelper.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_test, container, false);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            getView().findViewById(R.id.users_get).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS,
//                            "id,first_name,last_name,sex,bdate,city,country,photo_50,photo_100," +
//                            "photo_200_orig,photo_200,photo_400_orig,photo_max,photo_max_orig,online," +
//                            "online_mobile,lists,domain,has_mobile,contacts,connections,site,education," +
//                            "universities,schools,can_post,can_see_all_posts,can_see_audio,can_write_private_message," +
//                            "status,last_seen,common_count,relation,relatives,counters"));
                    VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS, "1,2"));
                    request.secure = false;
                    request.useSystemLanguage = false;
                    startApiCall(request);
                }
            });
            getView().findViewById(R.id.friends_get).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    VKRequest request = new VKRequest("friends.get", VKParameters.from(VKApiConst.FIELDS, "id,first_name,last_name,sex,bdate,city"));
                    startApiCall(request);
                }
            });
            getView().findViewById(R.id.captcha_force).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VKRequest request = new VKApiCaptcha().force();
                    startApiCall(request);
                }
            });
            getView().findViewById(R.id.wall_post).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VKRequest request = VKApi.wall().post(VKParameters.from(VKApiConst.OWNER_ID, "21153043", VKApiConst.MESSAGE, "Test"));
                    request.attempts = 10;
                    startApiCall(request);
                }
            });
            getView().findViewById(R.id.upload_photo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Bitmap photo = getPhoto();
                    VKRequest request = VKApi.uploadAlbumPhotoRequest(new VKUploadImage(photo, VKImageParameters.pngImage()), 186361428, 21153043);
                    request.executeWithListener(new VKRequestListener() {
                        @Override
                        public void onComplete(VKResponse response) {
                            photo.recycle();
                            VKPhotoArray photoArray = (VKPhotoArray) response.parsedModel;
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://vk.com/photo-60479154_%s", photoArray.get(0).id)));
                            startActivity(i);
                        }

                        @Override
                        public void onError(VKError error) {
                            showError(error);
                        }
                    });
                }
            });
            getView().findViewById(R.id.upload_photo_to_wall).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Bitmap photo = getPhoto();
                    VKRequest request = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), 21153043, 0);
                    request.executeWithListener(new VKRequestListener() {
                        @Override
                        public void onComplete(VKResponse response) {
                            photo.recycle();
                            VKPhoto photoModel = ((VKPhotoArray) response.parsedModel).get(0);
                            makePost(String.format("photo%s_%s", photoModel.owner_id, photoModel.id));
                        }

                        @Override
                        public void onError(VKError error) {
                            showError(error);
                        }
                    });
                }
            });
            getView().findViewById(R.id.upload_several_photos_to_wall).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Bitmap photo = getPhoto();
                    VKRequest request1 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), 21153043, 0);
                    VKRequest request2 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.5f)), 21153043, 0);
                    VKRequest request3 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.1f)), 21153043, 0);
                    VKRequest request4 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.pngImage()), 21153043, 0);

                    VKBatchRequest batch = new VKBatchRequest(request1, request2, request3, request4);
                    batch.executeWithListener(new VKBatchRequestListener() {
                        @Override
                        public void onComplete(VKResponse[] responses) {
                            super.onComplete(responses);
                            String[] photos = new String[responses.length];
                            for (int i = 0; i < responses.length; i++) {
                                VKPhoto photoModel = ((VKPhotoArray) responses[i].parsedModel).get(0);
                                photos[i] = String.format("photo%s_%s", photoModel.owner_id, photoModel.id);
                            }
                            makePost(VKStringJoiner.join(photos, ","));
                        }

                        @Override
                        public void onError(VKError error) {
                            showError(error);
                        }
                    });
                }
            });
        }

        private void startApiCall(VKRequest request) {
            Intent i = new Intent(getActivity(), ApiCallActivity.class);
            i.putExtra("request", request);
            startActivity(i);
        }

        private void showError(VKError error) {
            new AlertDialog.Builder(getActivity())
                    .setMessage(error.errorMessage)
                    .setPositiveButton("OK", null)
                    .show();
            if (error.httpError != null)
                Log.w("Test", "Error in request or upload", error.httpError);
        }

        private Bitmap getPhoto() {
            Bitmap b = null;
            try {
                b = BitmapFactory.decodeStream(getActivity().getAssets().open("android.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return b;
        }

        private void makePost(String attachments) {
            VKRequest post = VKApi.wall().post(VKParameters.from(VKApiConst.OWNER_ID, "21153043", VKApiConst.ATTACHMENTS, attachments));
            post.setModelClass(VKWallPostResult.class);
            post.executeWithListener(new VKRequestListener() {
                @Override
                public void onComplete(VKResponse response) {
                    super.onComplete(response);

                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://vk.com/wall-60479154_%s", ((VKWallPostResult) response.parsedModel).post_id)));
                    startActivity(i);
                }

                @Override
                public void onError(VKError error) {
                    showError(error);
                }
            });
        }
    }

}
