package com.jackzilla.feednom.rss;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxm on 2/16/14.
 */
public class RssFeed implements Parcelable{
    private String title = null;
    private String pubdate = null;
    private int itemcount = 0;
    private List<RssFeedItem> itemlist;
    private String image = null;
    // don't need the drawable because it will be handled by the caching mechanism


    public RssFeed() {
        itemlist = new ArrayList<RssFeedItem>();
    }

    public RssFeed(Parcel in) {
        title = in.readString();
        pubdate = in.readString();
        image = in.readString();
        in.readTypedList(itemlist, RssFeedItem.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(pubdate);
        dest.writeString(image);
        dest.writeTypedList(itemlist);
    }

    public int addItem(RssFeedItem item) {
        itemlist.add(item);
        itemcount++;
        return itemcount;
    }

    public RssFeedItem getItem(int location) {
        return itemlist.get(location);
    }

    public List getAllItems() {
        return itemlist;
    }

    public int getItemCount() {
        return itemcount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPubDate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String _image) {
        this.image = _image;
    }

    public static final Creator<RssFeed> CREATOR = new Creator<RssFeed>() {
        @Override
        public RssFeed createFromParcel(Parcel source) {
            return new RssFeed(source);
        }

        @Override
        public RssFeed[] newArray(int size) {
            return new RssFeed[size];
        }
    };
}
