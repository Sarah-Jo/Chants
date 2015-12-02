package com.example.sarah.listview;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by sarah on 02/12/15.
 */

    public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private Context context;

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        //ParseCrashReporting.enable(this);

        Parse.initialize(this, "mguJKhzhaLLfwBR40DEQmmLERI4ZQzUKDU0b0yH0", "g48Vs9NLoje8nQccg010d2LK8oUHGGYX9B1qKoWu");
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.saveInBackground();

    }
}