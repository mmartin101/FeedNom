package com.jackzilla.feednom.entities;

import com.jackzilla.feednom.entities.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table RSS_FEED_ITEMS.
 */
public class RssFeedItem {

    private Long id;
    private String title;
    private String description;
    private String link;
    private String category;
    private String enclosure;
    private String imagePath;
    private String pubDate;
    private long feedId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RssFeedItemDao myDao;

    private RssFeed rssFeed;
    private Long rssFeed__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    private static final String TAG = "RssFeedItem";
    // KEEP FIELDS END

    public RssFeedItem() {
    }

    public RssFeedItem(Long id) {
        this.id = id;
    }

    public RssFeedItem(Long id, String title, String description, String link, String category, String enclosure, String imagePath, String pubDate, long feedId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.category = category;
        this.enclosure = enclosure;
        this.imagePath = imagePath;
        this.pubDate = pubDate;
        this.feedId = feedId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRssFeedItemDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public long getFeedId() {
        return feedId;
    }

    public void setFeedId(long feedId) {
        this.feedId = feedId;
    }

    /** To-one relationship, resolved on first access. */
    public RssFeed getRssFeed() {
        long __key = this.feedId;
        if (rssFeed__resolvedKey == null || !rssFeed__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RssFeedDao targetDao = daoSession.getRssFeedDao();
            RssFeed rssFeedNew = targetDao.load(__key);
            synchronized (this) {
                rssFeed = rssFeedNew;
            	rssFeed__resolvedKey = __key;
            }
        }
        return rssFeed;
    }

    public void setRssFeed(RssFeed rssFeed) {
        if (rssFeed == null) {
            throw new DaoException("To-one property 'feedId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.rssFeed = rssFeed;
            feedId = rssFeed.getId();
            rssFeed__resolvedKey = feedId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
