package com.vk.vktestapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCaptchaDialog;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKSdkListener;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

    /**
     * SharedPreferences key for VK access token
     */
    private static final String SP_KEY_VK_ACCESS_TOKEN = "SP_KEY_VK_ACCESS_TOKEN";

    /**
     * Scope is set of required permissions for your application
     * @see <a href="https://vk.com/dev/permissions">vk.com api permissions documentation</a>
     */
    private static String[] sMyScope = new String[] {
            VKScope.FRIENDS,
            VKScope.WALL,
            VKScope.PHOTOS,
            VKScope.NOHTTPS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VKSdk.initialize(sdkListener, "3974615", VKAccessToken.tokenFromSharedPreferences(this, SP_KEY_VK_ACCESS_TOKEN));
        setContentView(R.layout.activity_login);

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VKSdk.authorize(sMyScope, true, false);
            }
        });

        findViewById(R.id.force_oauth_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VKSdk.authorize(sMyScope, true, true);
            }
        });

        String[] fingerprint = VKUtil.getCertificateFingerprint(this, this.getPackageName());

        Log.d("Fingerprint", fingerprint[0]);
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

    private VKSdkListener sdkListener = new VKSdkListener() {
        @Override
        public void onCaptchaError(VKError captchaError) {
            new VKCaptchaDialog(captchaError).show();
        }

        @Override
        public void onTokenExpired(VKAccessToken expiredToken) {
            VKSdk.authorize(sMyScope);
        }

        @Override
        public void onAccessDenied(VKError authorizationError) {
            new AlertDialog.Builder(LoginActivity.this)
                    .setMessage(authorizationError.errorMessage)
                    .show();
        }

        @Override
        public void onReceiveNewToken(VKAccessToken newToken) {
            newToken.saveTokenToSharedPreferences(LoginActivity.this, SP_KEY_VK_ACCESS_TOKEN);
            startActivity(new Intent(LoginActivity.this, TestActivity.class));
        }

        @Override
        public void onAcceptUserToken(VKAccessToken token) {
            startActivity(new Intent(LoginActivity.this, TestActivity.class));
        }
    };
}
