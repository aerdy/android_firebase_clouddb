package com.necis.firebasesample.manage;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Jarcode on 2016-03-24.
 */
public class AppConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
