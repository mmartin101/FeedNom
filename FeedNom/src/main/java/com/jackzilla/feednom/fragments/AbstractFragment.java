package com.jackzilla.feednom.fragments;

import android.app.Fragment;

import com.jackzilla.feednom.FeedNomApplication;
import com.jackzilla.feednom.activity.AbstractActivity;
import com.jackzilla.feednom.controller.ApplicationController;

/**
 * Created by maxm on 3/20/14.
 */
public abstract class AbstractFragment<A extends AbstractActivity> extends Fragment {

    public void registerWithEventBus() {
        registerWithEventBus(0);
    }

    public void registerWithEventBus(int priority) {
        ApplicationController.getEventBus().register(this, priority);
    }

    public void unregisterEventBus() {
        ApplicationController.getEventBus().unregister(this);
    }

    public abstract A getActivityA();

    public FeedNomApplication getFeedNomApplication() {
        return getActivityA().getFeedNomApplication();
    }
}
