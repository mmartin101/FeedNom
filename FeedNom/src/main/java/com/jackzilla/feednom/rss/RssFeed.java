package com.jackzilla.feednom.rss;

import android.graphics.drawable.Drawable;

import java.util.List;
import java.util.Vector;

/**
 * Created by maxm on 2/16/14.
 */
public class RssFeed {
    private String title = null;
    private String pubdate = null;
    private int itemcount = 0;
    private List<RssFeedItem> itemlist;
    private String image = null;
    private Drawable drawable = null;


    public RssFeed()
    {
        itemlist = new Vector(0);
    }

    public int addItem(RssFeedItem item)
    {
        itemlist.add(item);
        itemcount++;
        return itemcount;
    }

    public RssFeedItem getItem(int location)
    {
        return itemlist.get(location);
    }
    public List getAllItems()
    {
        return itemlist;
    }

    public int getItemCount()
    {
        return itemcount;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setPubDate(String pubdate)
    {
        this.pubdate = pubdate;
    }

    public String getTitle()
    {
        return title;
    }

    public String getPubDate()
    {
        return pubdate;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String _image)
    {
        this.image = _image;
    }

    public Drawable getDrawable()
    {
        return drawable;
    }

    public void setDrawable(Drawable drawable)
    {
        this.drawable = drawable;
    }

}
