package com.vk.vktestapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.dialogs.VKCaptchaDialog;
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
public class LoginActivity extends FragmentActivity {

    /**
     * Scope is set of required permissions for your application
     * @see <a href="https://vk.com/dev/permissions">vk.com api permissions documentation</a>
     */
    private static final String[] sMyScope = new String[] {
            VKScope.FRIENDS,
            VKScope.WALL,
            VKScope.PHOTOS,
            VKScope.NOHTTPS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        VKUIHelper.onCreate(this);
        VKSdk.initialize(sdkListener, "3974615");
        if (VKSdk.wakeUpSession()) {
            startTestActivity();
            return;
        }

        String[] fingerprint = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        Log.d("Fingerprint", fingerprint[0]);
    }
    private void showLogout() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LogoutFragment())
                .commit();
    }
    private void showLogin() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        VKUIHelper.onResume(this);
        if (VKSdk.isLoggedIn()) {
            showLogout();
        } else {
            showLogin();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VKUIHelper.onDestroy(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKUIHelper.onActivityResult(this, requestCode, resultCode, data);
    }

    private final VKSdkListener sdkListener = new VKSdkListener() {
        @Override
        public void onCaptchaError(VKError captchaError) {
            new VKCaptchaDialog(captchaError).show();
        }

        @Override
        public void onTokenExpired(VKAccessToken expiredToken) {
            VKSdk.authorize(sMyScope);
        }

        @Override
        public void onAccessDenied(final VKError authorizationError) {
            new AlertDialog.Builder(VKUIHelper.getTopActivity())
                    .setMessage(authorizationError.toString())
                    .show();
        }

        @Override
        public void onReceiveNewToken(VKAccessToken newToken) {
            startTestActivity();
        }

        @Override
        public void onAcceptUserToken(VKAccessToken token) {
            startTestActivity();
        }
    };
    private void startTestActivity() {
	    startActivity(new Intent(this, TestActivity.class));
    }

    public static class LoginFragment extends android.support.v4.app.Fragment {
	    public LoginFragment() {
		    super();
	    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_login, container, false);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            getView().findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VKSdk.authorize(sMyScope, true, false);
                }
            });

	        getView().findViewById(R.id.force_oauth_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VKSdk.authorize(sMyScope, true, true);
                }
            });
        }
    }
	public static class LogoutFragment extends android.support.v4.app.Fragment {
	    public LogoutFragment() {
		    super();
	    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_logout, container, false);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
	        getView().findViewById(R.id.continue_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
	                ((LoginActivity)getActivity()).startTestActivity();
                }
            });

	        getView().findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VKSdk.logout();
                    if (!VKSdk.isLoggedIn()) {
	                    ((LoginActivity)getActivity()).showLogin();
                    }
                }
            });
        }
    }
}
