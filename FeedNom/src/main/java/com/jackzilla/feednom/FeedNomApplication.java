package com.jackzilla.feednom;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.jackzilla.feednom.controller.ApplicationController;

/**
 * Created by maxm on 3/7/14.
 */
public class FeedNomApplication extends Application {
    private ApplicationController applicationController;
    private SharedPreferences sharedPreferences;


    @Override
    public void onCreate() {
        super.onCreate();
        applicationController = ApplicationController.start(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        applicationController = null;
        ApplicationController.stop();
    }

    public ApplicationController getApplicationController() {
        return applicationController;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
