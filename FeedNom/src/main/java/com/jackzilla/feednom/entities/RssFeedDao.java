package com.jackzilla.feednom.entities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.jackzilla.feednom.entities.RssFeed;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table RSS_FEED.
*/
public class RssFeedDao extends AbstractDao<RssFeed, Long> {

    public static final String TABLENAME = "RSS_FEED";

    /**
     * Properties of entity RssFeed.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property LastPublished = new Property(2, java.util.Date.class, "lastPublished", false, "LAST_PUBLISHED");
        public final static Property ImagePath = new Property(3, String.class, "imagePath", false, "IMAGE_PATH");
        public final static Property HttpSource = new Property(4, String.class, "httpSource", false, "HTTP_SOURCE");
    };

    private DaoSession daoSession;


    public RssFeedDao(DaoConfig config) {
        super(config);
    }
    
    public RssFeedDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'RSS_FEED' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TITLE' TEXT NOT NULL ," + // 1: title
                "'LAST_PUBLISHED' INTEGER," + // 2: lastPublished
                "'IMAGE_PATH' TEXT," + // 3: imagePath
                "'HTTP_SOURCE' TEXT NOT NULL );"); // 4: httpSource
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'RSS_FEED'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, RssFeed entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());
 
        java.util.Date lastPublished = entity.getLastPublished();
        if (lastPublished != null) {
            stmt.bindLong(3, lastPublished.getTime());
        }
 
        String imagePath = entity.getImagePath();
        if (imagePath != null) {
            stmt.bindString(4, imagePath);
        }
        stmt.bindString(5, entity.getHttpSource());
    }

    @Override
    protected void attachEntity(RssFeed entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public RssFeed readEntity(Cursor cursor, int offset) {
        RssFeed entity = new RssFeed( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // lastPublished
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // imagePath
            cursor.getString(offset + 4) // httpSource
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, RssFeed entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.getString(offset + 1));
        entity.setLastPublished(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setImagePath(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setHttpSource(cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(RssFeed entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(RssFeed entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}