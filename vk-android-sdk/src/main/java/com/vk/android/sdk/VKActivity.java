/**
 * VKActivity.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 09.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.webkit.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.vk.android.sdk.exceptions.VKCaptchaException;
import com.vk.android.sdk.exceptions.VKValidationException;
import com.vk.android.sdk.models.VKAccessToken;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;

/**
 * SDK's Activity to handle all UI work.
 */
public class VKActivity extends Activity {

    final static String VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH";
    final static String ACTION_CAPTCHA = "com.vk.android.sdk.action.captcha";
    final static String ACTION_RESOLVE_AUTH = "com.vk.android.sdk.action.resolve_auth";
    final static String ACTION_AUTH = "com.vk.android.sdk.action.auth";
    final static String ACTION_VALIDATION = "com.vk.android.sdk.action.validation";

    final static String EXTRA_CAPTCHA_IMG = "com.vk.android.sdk.extra.captcha_img";
    final static String EXTRA_CAPTCHA_SID = "com.vk.android.sdk.extra.captcha_sid";
    final static String EXTRA_REDIRECT_URI = "com.vk.android.sdk.extra.captcha_img";

    static final String VK_EXTRA_CLIENT_ID = "client_id";
    static final String VK_EXTRA_SCOPE = "scope";
    static final String VK_EXTRA_API_VERSION = "version";
    static final String VK_APP_FINGERPRINT = "48761eef50ee53afc4cc9c5f10e6bde7f8f5b82f";


    static final String EXTRA_FORCE_OAUTH = "com.vk.android.sdk.extra.force_oauth";
    static final String VK_APP_PACKAGE_ID = "com.vkontakte.android";

    static final int REQUEST_VKONTAKTE_AUTH = 44;
    final static String sRedirectUri = "https://oauth.vk.com/blank.html";

    private int mClientId;
    private String mScopes;
    private boolean mResolveAuth = false;
    private Dialog mDialog;

    static void showCaptcha(Context context, VKCaptchaException e) {
        Intent intent = new Intent(context, VKActivity.class);
        intent.setAction(ACTION_CAPTCHA);
        intent.putExtra(EXTRA_CAPTCHA_IMG, e.getCaptchaImg());
        intent.putExtra(EXTRA_CAPTCHA_SID, e.getCaptchaSid());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    static void resolveAuth(Context context) {
        Intent intent = new Intent(context, VKActivity.class);
        intent.setAction(ACTION_RESOLVE_AUTH);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    static void showAuth(Activity activity, int client_id, boolean forceOAuth, String scopes, int requestCode) {
        Intent intent = new Intent(activity, VKActivity.class);
        intent.setAction(ACTION_AUTH);
        intent.putExtra(VK_EXTRA_CLIENT_ID, client_id);
        intent.putExtra(VK_EXTRA_SCOPE, scopes);
        intent.putExtra(EXTRA_FORCE_OAUTH, forceOAuth);
        activity.startActivityForResult(intent, requestCode);
    }

    static void showValidation(Context context, VKValidationException e) {
        Intent intent = new Intent(context, VKActivity.class);
        intent.setAction(ACTION_VALIDATION);
        intent.putExtra(EXTRA_REDIRECT_URI, e.getRedirectUri());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.VK_Transparent);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        Bundle extras = intent.getExtras();

        VKAccessToken account = Settings.get().getAccount();
        if(account != null) {
            mClientId = account.getAppId();
            mScopes = account.getScopes();
        }
        if (ACTION_CAPTCHA.equals(action) && extras != null) {
            String captchaImg = extras.getString(EXTRA_CAPTCHA_IMG);
            String captchaSid = extras.getString(EXTRA_CAPTCHA_SID);
            showCaptcha(captchaImg, captchaSid);
        } else if (ACTION_RESOLVE_AUTH.equals(action)) {
            mResolveAuth = true;
            showAuth(intent.getBooleanExtra(EXTRA_FORCE_OAUTH, false));
        } else if (ACTION_AUTH.equals(action) && extras != null) {
            mClientId = extras.getInt(VK_EXTRA_CLIENT_ID);
            mScopes = extras.getString(VK_EXTRA_SCOPE);
            showAuth(extras.getBoolean(EXTRA_FORCE_OAUTH, false));
        } else if (ACTION_VALIDATION.equals(action) && extras != null) {
            String redirectUri = extras.getString(EXTRA_REDIRECT_URI);
            showValidation(redirectUri);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VKONTAKTE_AUTH) {
            if(data != null && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                if (extras != null ) {
                    finishAuth(VKAccessToken.create(extras, mClientId, mScopes));
                }
            } else {
                if(resultCode == RESULT_CANCELED && data!= null) {
                    Intent intent = new Intent();
                    intent.putExtra(VK.EXTRA_ERROR, data.getStringExtra("error"));
                    intent.putExtra(VK.EXTRA_ERROR_REASON, data.getStringExtra("error_reason"));
                    intent.putExtra(VK.EXTRA_ERROR_DESCRIPTION, data.getStringExtra("error_description"));
                    setResult(RESULT_CANCELED, intent);
                }
                finish();
            }
        }
    }

    @Override
    public void finish() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
        super.finish();
    }

    private void showAuth(boolean forceOauth) {
        Intent intent = new Intent(VK_APP_AUTH_ACTION);
        if (getPackageManager().queryIntentActivities(intent, 0).size() > 0
                && !forceOauth
                && VK_APP_FINGERPRINT.equals(getCertificateFingerprint(VK_APP_PACKAGE_ID))) {
            intent.putExtra(VK_EXTRA_API_VERSION, Settings.API_VERSION);
            intent.putExtra(VK_EXTRA_CLIENT_ID, mClientId);
            intent.putExtra(VK_EXTRA_SCOPE, mScopes);
            startActivityForResult(intent, REQUEST_VKONTAKTE_AUTH);
        } else {
            WebDialog dialog = new WebDialog(this) {
                public void onPageStarted(WebView view, String stringUrl, Bitmap favicon) {
                    try {
                        URL url = new URL(stringUrl);
                        if ((url.getProtocol() + "://" + url.getHost() + url.getPath()).equals(sRedirectUri)) {
                            finishAuth(VKAccessToken.create(url.getRef(), mClientId, mScopes));
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            };
            dialog.setCancelable(!mResolveAuth);
            dialog.show();
            String url = String.format("https://oauth.vk.com/authorize?client_id=%d&scope=%s&redirect_uri=%s&display=touch&response_type=token", mClientId, mScopes, sRedirectUri);
            dialog.loadUrl(url);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    finish();
                }
            });
            mDialog = dialog;
        }
    }

    private void showValidation(String redirectUri) {
        WebDialog dialog = new WebDialog(this) {
            public void onPageStarted(WebView view, String stringUrl, Bitmap favicon) {
                try {
                    URL url = new URL(stringUrl);
                    if ((url.getProtocol() + "://" + url.getHost() + url.getPath()).equals(sRedirectUri)) {
                        String ref = url.getRef();
                        if(ref != null && (ref.startsWith("success=1") || ref.startsWith("cancel=1") || ref.startsWith("fail=1"))) {
                            finishValidation(VKAccessToken.create(url.getRef(), mClientId, mScopes));
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        };
        dialog.setCancelable(false);
        dialog.show();
        dialog.loadUrl(redirectUri);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });
        mDialog = dialog;
    }

    private void showCaptcha(final String captchaImg, final String captchaSid) {
        View dialogContent = getLayoutInflater().inflate(R.layout.vk_dialog_captcha, null);
        final ImageView captchaImage = (ImageView) dialogContent.findViewById(R.id.vk_image);
        final EditText input = (EditText) dialogContent.findViewById(R.id.vk_input);
        dialogContent.findViewById(R.id.vk_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(input.getText())) {
                    finishCaptcha(captchaSid, input.getText().toString());
                }
            }
        });

        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {
                while (true) {
                    try {
                        byte[] result = HttpRequest.get(captchaImg).bytes();
                        return BitmapFactory.decodeByteArray(result, 0, result.length);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (captchaImage != null) {
                    captchaImage.setImageBitmap(bitmap);
                }
            }
        }.execute();

        mDialog = new Dialog(this);
        mDialog.setContentView(dialogContent);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    private void finishCaptcha(String captchaSid, String text) {
        RequestQueue.resolveCaptcha(captchaSid, text);
        finish();
    }

    private void finishAuth(VKAccessToken account) {
        if (account != null) {
            if (mResolveAuth) {
                RequestQueue.resolveAuth(account);
            } else {
                Intent intent = new Intent();
                intent.putExtra(VK.EXTRA_ACCOUNT, account);
                setResult(RESULT_OK, intent);
            }
            finish();
        }
    }

    private void finishValidation(VKAccessToken account) {
        RequestQueue.resolveValidation(account);
        finish();
    }

    static class Dialog extends android.app.Dialog {

        public Dialog(Context context) {
            super(context);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setBackgroundDrawableResource(R.drawable.vk_dialog_bg);
        }

        public Dialog(Context context, int theme) {
            super(context, theme);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setBackgroundDrawableResource(R.drawable.vk_dialog_bg);
        }
    }

    static class WebDialog extends Dialog {

        private final WebView web;
        private boolean loadingFinished = false;

        public WebDialog(Context context) {
            super(context);
            View root = getLayoutInflater().inflate(R.layout.vk_dialog_browser, null);

            web = (WebView) root.findViewById(R.id.vk_webview);
            final ProgressBar progress = (ProgressBar) root.findViewById(R.id.vk_progress_circle);
            // Setup progress
            final ProgressBar progressHorizontal = (ProgressBar) root.findViewById(R.id.vk_progress_horizontal);
            progressHorizontal.setMax(100);
            web.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    progressHorizontal.setProgress(newProgress);
                    progressHorizontal.setVisibility(newProgress >= 0 && newProgress <= 99 && loadingFinished ? View.VISIBLE : View.INVISIBLE);
                }
            });

            // Disable text selection
            web.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return true;
                }
            });
            web.setLongClickable(false);

            // Other settings
            WebSettings settings = web.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            settings.setSavePassword(false);

            web.setWebViewClient(new WebViewClient() {
                public void onPageStarted(WebView view, String stringUrl, Bitmap favicon) {
                    WebDialog.this.onPageStarted(view, stringUrl, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    progress.setVisibility(View.GONE);
                    web.setVisibility(View.VISIBLE);
                    loadingFinished = true;
                    WebDialog.this.onPageFinished(view, url);
                }

                public boolean shouldOverrideUrlLoading(WebView view, String stringUrl) {
                    return false;
                }
            });

            setContentView(root);
        }

        private void onPageFinished(WebView view, String url) {

        }

        public void onPageStarted(WebView view, String stringUrl, Bitmap favicon) {

        }

        public void loadUrl(String url) {
            web.loadUrl(url);
        }
    }

    String getCertificateFingerprint(String packageName) {
        try {
            if (getPackageManager() == null) {
                return null;
            }
            PackageInfo info = getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            if (info.signatures == null) {
                return null;
            }
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                byte[] array = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte anArray : array) {
                    sb.append(String.format("%02x", anArray & 0xFF));
                }
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
