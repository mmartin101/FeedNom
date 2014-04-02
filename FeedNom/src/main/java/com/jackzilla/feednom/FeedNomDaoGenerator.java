package com.jackzilla.feednom;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Created by maxm on 3/8/14.
 */
public class FeedNomDaoGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.jackzilla.feednom.entities");
        schema.enableKeepSectionsByDefault();

        addRssFeed(schema);

        try {
            new DaoGenerator().generateAll(schema, "FeedNom/src/main/java");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addRssFeed(Schema s) {
        Entity rssFeed = s.addEntity("RssFeed");
        rssFeed.setTableName("RSS_FEEDS");

        rssFeed.addIdProperty();
        rssFeed.addStringProperty("title").notNull();
        rssFeed.addStringProperty("description");
        rssFeed.addStringProperty("link");
        rssFeed.addStringProperty("lastPublished");
        rssFeed.addStringProperty("imagePath");
        rssFeed.addStringProperty("httpSource").notNull();

        Entity rssFeedItem = s.addEntity("RssFeedItem");
        rssFeedItem.setTableName("RSS_FEED_ITEMS");

        rssFeedItem.addIdProperty();
        rssFeedItem.addStringProperty("title");
        rssFeedItem.addStringProperty("description");
        rssFeedItem.addStringProperty("link");
        rssFeedItem.addStringProperty("category");
        rssFeedItem.addStringProperty("enclosure");
        rssFeedItem.addStringProperty("imagePath");
        rssFeedItem.addStringProperty("pubDate");


        Property feedId = rssFeedItem.addLongProperty("feedId").notNull().getProperty();
        rssFeedItem.addToOne(rssFeed, feedId);


        ToMany feedToItems = rssFeed.addToMany(rssFeedItem, feedId);
        feedToItems.setName("feedItems");
    }


}
