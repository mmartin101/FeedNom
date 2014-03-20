package com.jackzilla.feednom.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jackzilla.feednom.entities.DaoMaster;
import com.jackzilla.feednom.entities.DaoSession;
import com.jackzilla.feednom.entities.RssFeedDao;
import com.jackzilla.feednom.event.FeedCreatedEvent;
import com.octo.android.robospice.SpiceManager;

import de.greenrobot.event.EventBus;

/**
 * Created by maxm on 3/7/14.
 */
public class ApplicationController {
    private static ApplicationController instance;
    private SpiceManager spiceManager;
    private static boolean started;

    public static EventBus eventBus;

    // db connection
    private DaoMaster.DevOpenHelper devOpenHelper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private RssFeedDao feedDao;
    // user?
    private final Context context;

    public static ApplicationController start(Context c) {
        if (!started) {
            instance = new ApplicationController(c);
            started = true;
        }
        else {
            throw new RuntimeException("ApplicationController is already running");
        }

        return instance;
    }

    public static void stop() {
        if (started && instance != null) {
            // stop spiceManager here too
            eventBus.unregister(ApplicationController.instance);
            instance = null;
        }
        else {
            throw new RuntimeException("ApplicationController has not been started");
        }
    }

    private ApplicationController(Context context) {
        this.context = context;

        // SpiceManager should be initialized here too

        eventBus = EventBus.getDefault();
        eventBus.register(this);

        devOpenHelper = new DaoMaster.DevOpenHelper(context, "feednom-db", null);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        feedDao = daoSession.getRssFeedDao();

    }

    public static ApplicationController getInstance() {
        return instance;
    }

    public static EventBus getEventBus() {
        return eventBus;
    }

    public RssFeedDao getFeedDao() {
        return feedDao;
    }

    public void onEvent(FeedCreatedEvent event) {

    }
}
