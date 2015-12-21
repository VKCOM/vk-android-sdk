package com.vk.vktestapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.vk.sdk.VKSdk;
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
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.model.VKWallPostResult;
import com.vk.sdk.api.photo.VKImageParameters;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.dialogs.VKShareDialog;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import com.vk.sdk.payments.VKPaymentsCallback;

import org.json.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestActivity extends ActionBarActivity {

	private static final int[] IDS = {R.id.users_get, R.id.friends_get, R.id.messages_get, R.id.dialogs_get,
			R.id.captcha_force, R.id.upload_photo, R.id.wall_post, R.id.wall_getById, R.id.test_validation,
			R.id.test_share, R.id.upload_photo_to_wall, R.id.upload_doc, R.id.upload_several_photos_to_wall,
			R.id.test_send_request};

	public static final int TARGET_GROUP = 60479154;
	public static final int TARGET_ALBUM = 181808365;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		VKSdk.requestUserState(this, new VKPaymentsCallback() {
			@Override
			public void onUserState(final boolean userIsVk) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
//						Toast.makeText(TestActivity.this, userIsVk ? "user is vk's" : "user is not vk's", Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_test, container, false);
			for (int id : IDS) {
				view.findViewById(id).setOnClickListener(this);
			}
			return view;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.test_send_request: {
					makeRequest();
				}
				break;
				case R.id.users_get: {
					VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS,
							"id,first_name,last_name,sex,bdate,city,country,photo_50,photo_100," +
									"photo_200_orig,photo_200,photo_400_orig,photo_max,photo_max_orig,online," +
									"online_mobile,lists,domain,has_mobile,contacts,connections,site,education," +
									"universities,schools,can_post,can_see_all_posts,can_see_audio,can_write_private_message," +
									"status,last_seen,common_count,relation,relatives,counters"));
					request.secure = false;
					request.useSystemLanguage = false;
					startApiCall(request);
				}
				break;
				case R.id.friends_get:
					startApiCall(VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "id,first_name,last_name,sex,bdate,city")));
					break;
				case R.id.messages_get:
					startApiCall(VKApi.messages().get());
					break;
				case R.id.dialogs_get:
					startApiCall(VKApi.messages().getDialogs());
					break;
				case R.id.captcha_force:
					startApiCall(new VKApiCaptcha().force());
					break;
				case R.id.upload_photo: {
					final Bitmap photo = getPhoto();
					VKRequest request = VKApi.uploadAlbumPhotoRequest(new VKUploadImage(photo, VKImageParameters.pngImage()), TARGET_ALBUM, TARGET_GROUP);
					request.executeWithListener(new VKRequestListener() {
						@Override
						public void onComplete(VKResponse response) {
							recycleBitmap(photo);
							VKPhotoArray photoArray = (VKPhotoArray) response.parsedModel;
							Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://vk.com/photo-%d_%s", TARGET_GROUP, photoArray.get(0).id)));
							startActivity(i);
						}

						@Override
						public void onError(VKError error) {
							showError(error);
						}
					});
				}
				break;
				case R.id.wall_post:
					makePost(null, "Hello, friends!");
					break;
				case R.id.wall_getById:
					startApiCall(VKApi.wall().getById(VKParameters.from(VKApiConst.POSTS, "1_45558")));
					break;
				case R.id.test_validation:
					startApiCall(new VKRequest("account.testValidation"));
					break;
				case R.id.test_share: {
					final Bitmap b = getPhoto();
					VKPhotoArray photos = new VKPhotoArray();
					photos.add(new VKApiPhoto("photo-47200925_314622346"));
					new VKShareDialogBuilder()
							.setText("I created this post with VK Android SDK\nSee additional information below\n#vksdk")
							.setUploadedPhotos(photos)
							.setAttachmentImages(new VKUploadImage[]{
									new VKUploadImage(b, VKImageParameters.pngImage())
							})
							.setAttachmentLink("VK Android SDK information", "https://vk.com/dev/android_sdk")
							.setShareDialogListener(new VKShareDialog.VKShareDialogListener() {
								@Override
								public void onVkShareComplete(int postId) {
									recycleBitmap(b);
								}

								@Override
								public void onVkShareCancel() {
									recycleBitmap(b);
								}

								@Override
								public void onVkShareError(VKError error) {
									recycleBitmap(b);
								}
							})
							.show(getFragmentManager(), "VK_SHARE_DIALOG");
				}
				break;
				case R.id.upload_photo_to_wall: {
					final Bitmap photo = getPhoto();
					VKRequest request = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), 0, TARGET_GROUP);
					request.executeWithListener(new VKRequestListener() {
						@Override
						public void onComplete(VKResponse response) {
							recycleBitmap(photo);
							VKApiPhoto photoModel = ((VKPhotoArray) response.parsedModel).get(0);
							makePost(new VKAttachments(photoModel));
						}

						@Override
						public void onError(VKError error) {
							showError(error);
						}
					});
				}
				break;
				case R.id.upload_doc:
					startApiCall(VKApi.docs().uploadDocRequest(getFile()));
					break;
				case R.id.upload_several_photos_to_wall: {
					final Bitmap photo = getPhoto();
					VKRequest request1 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.9f)), 0, TARGET_GROUP);
					VKRequest request2 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.5f)), 0, TARGET_GROUP);
					VKRequest request3 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.jpgImage(0.1f)), 0, TARGET_GROUP);
					VKRequest request4 = VKApi.uploadWallPhotoRequest(new VKUploadImage(photo, VKImageParameters.pngImage()), 0, TARGET_GROUP);

					VKBatchRequest batch = new VKBatchRequest(request1, request2, request3, request4);
					batch.executeWithListener(new VKBatchRequestListener() {
						@Override
						public void onComplete(VKResponse[] responses) {
							super.onComplete(responses);
							recycleBitmap(photo);
							VKAttachments attachments = new VKAttachments();
							for (VKResponse response : responses) {
								VKApiPhoto photoModel = ((VKPhotoArray) response.parsedModel).get(0);
								attachments.add(photoModel);
							}
							makePost(attachments);
						}

						@Override
						public void onError(VKError error) {
							showError(error);
						}
					});
				}
				break;
			}
		}

		private void startApiCall(VKRequest request) {
			Intent i = new Intent(getActivity(), ApiCallActivity.class);
			i.putExtra("request", request.registerObject());
			startActivity(i);
		}

		private void showError(VKError error) {
			new AlertDialog.Builder(getActivity())
					.setMessage(error.toString())
					.setPositiveButton("OK", null)
					.show();
			if (error.httpError != null) {
				Log.w("Test", "Error in request or upload", error.httpError);
			}
		}

		private Bitmap getPhoto() {
			try {
				return BitmapFactory.decodeStream(getActivity().getAssets().open("android.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		private static void recycleBitmap(@Nullable final Bitmap bitmap) {
			if (bitmap != null) {
				bitmap.recycle();
			}
		}

		private File getFile() {
			try {
				InputStream inputStream = getActivity().getAssets().open("android.jpg");
				File file = new File(getActivity().getCacheDir(), "android.jpg");
				OutputStream output = new FileOutputStream(file);
				byte[] buffer = new byte[4 * 1024]; // or other buffer size
				int read;

				while ((read = inputStream.read(buffer)) != -1) {
					output.write(buffer, 0, read);
				}
				output.flush();
				output.close();
				return file;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		private void makePost(VKAttachments attachments) {
			makePost(attachments, null);
		}

		private void makeRequest() {
			VKRequest request = new VKRequest("apps.getFriendsList", VKParameters.from("extended", 1, "type", "request"));
			request.executeWithListener(new VKRequestListener() {
				@Override
				public void onComplete(VKResponse response) {
					final Context context = getContext();
					if (context == null || !isAdded()) {
						return;
					}
					try {
						JSONArray jsonArray = response.json.getJSONObject("response").getJSONArray("items");
						int length = jsonArray.length();
						final VKApiUser[] vkApiUsers = new VKApiUser[length];
						CharSequence[] vkApiUsersNames = new CharSequence[length];
						for (int i = 0; i < length; i++) {
							VKApiUser user = new VKApiUser(jsonArray.getJSONObject(i));
							vkApiUsers[i] = user;
							vkApiUsersNames[i] = user.first_name + " " + user.last_name;
						}
						new AlertDialog.Builder(context)
								.setTitle(R.string.send_request_title)
								.setItems(vkApiUsersNames, new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										startApiCall(new VKRequest("apps.sendRequest",
												VKParameters.from("user_id", vkApiUsers[which].id, "type", "request")));
									}
								}).create().show();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		private void makePost(VKAttachments attachments, String message) {
			VKRequest post = VKApi.wall().post(VKParameters.from(VKApiConst.OWNER_ID, "-" + TARGET_GROUP, VKApiConst.ATTACHMENTS, attachments, VKApiConst.MESSAGE, message));
			post.setModelClass(VKWallPostResult.class);
			post.executeWithListener(new VKRequestListener() {
				@Override
				public void onComplete(VKResponse response) {
					if (isAdded()) {
						VKWallPostResult result = (VKWallPostResult) response.parsedModel;
						Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://vk.com/wall-%d_%s", TARGET_GROUP, result.post_id)));
						startActivity(i);
					}
				}

				@Override
				public void onError(VKError error) {
					showError(error.apiError != null ? error.apiError : error);
				}
			});
		}
	}
}