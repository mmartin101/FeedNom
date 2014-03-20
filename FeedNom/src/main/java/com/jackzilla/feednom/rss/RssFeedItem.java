package com.jackzilla.feednom.rss;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by maxm on 2/16/14.
 */
public class RssFeedItem implements Parcelable{
    private String title = null;
    private String description = null;
    // link to the article/podcast
    private String link = null;
    private String category = null;
    // publication date
    private String pubdate = null;
    // link to the file (http)
    private String enclosure = null;
    // globally unique identifier
    private String guid = null;
    // imagePath
    private String imagePath = null;

    public RssFeedItem() {
    }

    public RssFeedItem(Parcel in) {
        title = in.readString();
        description = in.readString();
        link = in.readString();
        category = in.readString();
        pubdate = in.readString();
        enclosure = in.readString();
        guid = in.readString();
        imagePath = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(link);
        dest.writeString(category);
        dest.writeString(pubdate);
        dest.writeString(enclosure);
        dest.writeString(guid);
        dest.writeString(imagePath);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPubDate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getCategory() {
        return category;
    }

    public String getPubDate() {
        return pubdate;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String _enclosure) {
        this.enclosure = _enclosure;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String _image) {
        this.imagePath = _image;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String _guid) {
        this.guid = _guid;
    }

    public String toString() {
        // limit how much text you display
        if (title.length() > 80) {
            return title.substring(0, 80) + "...";
        }
        return title;
    }

    public static final Creator<RssFeedItem> CREATOR = new Creator<RssFeedItem>() {
        @Override
        public RssFeedItem createFromParcel(Parcel source) {
            return new RssFeedItem(source);
        }

        @Override
        public RssFeedItem[] newArray(int size) {
            return new RssFeedItem[size];
        }
    };

}
