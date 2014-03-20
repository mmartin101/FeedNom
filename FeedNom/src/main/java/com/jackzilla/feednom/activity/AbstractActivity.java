package com.jackzilla.feednom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.jackzilla.feednom.FeedNomApplication;
import com.jackzilla.feednom.R;
import com.jackzilla.feednom.controller.ApplicationController;

/**
 * Created by maxm on 3/7/14.
 */
public abstract class AbstractActivity<A> extends Activity {
    protected static final int DEFAULT_TOAST_DURATION = 2000;

    public static String tag;
    public boolean eventBusRegistered = false;
    protected Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        tag = getResources().getString(R.string.app_default_tag);
    }

    public void registerWithEventBus() {
        registerWithEventBus(getActivity(), 0);
    }

    public void registerWithEventBus(A a, int priority) {
        ApplicationController.getEventBus().register(a, priority);
    }

    public void unregisterEventBus() {
        ApplicationController.getEventBus().unregister(this);
    }

    public FeedNomApplication getFeedNomApplication() {
        return (FeedNomApplication) getApplicationContext();
    }

    protected abstract A getActivity();

    protected void navigateTo(Class<? extends Activity> activity) {
        Intent i = new Intent(getApplicationContext(), activity);
        startActivity(i);
    }

    protected void toast(String msg) {
        toast(msg, DEFAULT_TOAST_DURATION);
    }

    protected void toast(String msg, int duration) {
        if (toast == null) {
            toast = Toast.makeText(this, msg, 0);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        else {
            toast.setText(msg);
        }

        toast.setDuration(duration);
        toast.show();
    }

}
