package com.jackzilla.feednom.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.jackzilla.feednom.entities.DaoMaster;
import com.jackzilla.feednom.entities.DaoSession;
import com.jackzilla.feednom.entities.RssFeedDao;
import com.jackzilla.feednom.event.FeedCreatedEvent;
import com.jackzilla.feednom.event.NewRssFeedEvent;
import com.jackzilla.feednom.rss.RssHandler;
import com.octo.android.robospice.SpiceManager;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import de.greenrobot.event.EventBus;

/**
 * Created by maxm on 3/7/14.
 */
public class ApplicationController {
    private static final String TAG = "ApplicationController";
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

    // not sure if we need this at all :/
    public RssFeedDao getFeedDao() {
        return feedDao;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void onEvent(FeedCreatedEvent event) {

    }

    public void onEventAsync(NewRssFeedEvent event) {
        processRSS(event.getEventObj());
    }

    private void processRSS(String s) {
        try {
//            Log.i(tag, "getting the feed " + param);
            // setup the url
            URL url = new URL(s);

            // create the factory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // create a parser
            SAXParser parser = factory.newSAXParser();

            // create the reader (scanner)
            XMLReader xmlreader = parser.getXMLReader();
            // instantiate our handler
            RssHandler rssHandler = new RssHandler();
            // assign our handler
            xmlreader.setContentHandler(rssHandler);
            // get our data via the url class
            InputSource is = new InputSource(url.openStream());
            // perform the synchronous parse
            xmlreader.parse(is);
//            if (feeds[i].getImage() != null)
//            {
//                Log.i(tag,"loading image");
//                try {
//                    URL imgurl = new URL(feeds[i].getImage());
//                    InputStream imgIs = (InputStream) imgurl.getContent();
//                    Drawable d = Drawable.createFromStream(imgIs, "src");
//                    feeds[i].setDrawable(d);
//                } catch (Exception e) {
//                    Log.i(tag,"something broke :/", e);
//                    e.printStackTrace();
//                }
//            }
        }
        catch (Exception ee) {
            Log.e(TAG, "Exception thrown, there was a problem...", ee);
        }
    }
}
