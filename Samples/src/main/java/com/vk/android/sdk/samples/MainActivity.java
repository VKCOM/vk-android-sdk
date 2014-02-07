/**
 * MainActivity.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 20.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.samples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import com.vk.android.sdk.VK;
import com.vk.android.sdk.models.VKAccessToken;
import com.vk.android.sdk.models.VKScopes;

public class MainActivity extends Activity {

    private static final int REQUEST_AUTH = 11;
    private LogFragment logFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.root_fragment, new PickFragment()).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        logFragment = (LogFragment) getFragmentManager().findFragmentById(R.id.log_fragment);

        // Try to restore account from preferences
        if(!VK.with(this).isAuthorized()) {
            VKAccessToken account = VKAccessToken.restore("account", PreferenceManager.getDefaultSharedPreferences(this));
            if(account != null) {
                log("Account restored from preferences");
                VK.with(this).authorize(account);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.https: {
                VK.with(this).setHttpsEnabled(item.isChecked());
            } break;
            case R.id.clear: {
                if(logFragment != null) {
                    logFragment.clear();
                }
            } break;
        }
        return super.onOptionsItemSelected(item);
    }


    void requestOAuth() {
        VK.with(this).requestAuthorisation(this, 4132359, true, REQUEST_AUTH,  VKScopes.NOHTTPS, VKScopes.WALL, VKScopes.FRIENDS, VKScopes.PHOTOS, VKScopes.GROUPS);
    }

    void requestAuth() {
        VK.with(this).requestAuthorisation(this, 4132359, REQUEST_AUTH,  VKScopes.NOHTTPS, VKScopes.WALL, VKScopes.FRIENDS, VKScopes.PHOTOS, VKScopes.GROUPS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_AUTH && resultCode == RESULT_OK && data != null) {
            VKAccessToken account = data.getParcelableExtra(VK.EXTRA_ACCOUNT);
            VK.with(this).authorize(account);
            log("Authorization success, access_token is: " + account.getAccessToken());

            // Save an account
            VKAccessToken.save("account", account, PreferenceManager.getDefaultSharedPreferences(this));
            log("Account is saved");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        logFragment = null;
    }

    public void log(CharSequence info) {
        if(logFragment != null) {
            logFragment.log(info);
        }
    }
}
