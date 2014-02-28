package com.jackzilla.feednom.rss;

/**
 * Created by maxm on 2/16/14.
 */
public class RssFeedItem {
    private String title = null;
    private String description = null;
    // link to the article/podcast
    private String link = null;
    private String category = null;
    // publication date
    private String pubdate = null;
    // link to the file
    private String enclosure = null;
    // globally unique identifier
    private String guid = null;
    // image
    private String image = null;

    public RssFeedItem()
    {
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setPubDate(String pubdate)
    {
        this.pubdate = pubdate;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getLink()
    {
        return link;
    }

    public String getCategory()
    {
        return category;
    }

    public String getPubDate()
    {
        return pubdate;
    }

    public String getEnclosure()
    {
        return enclosure;
    }

    public void setEnclosure(String _enclosure)
    {
        this.enclosure = _enclosure;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String _image)
    {
        this.image = _image;
    }

    public String getGuid()
    {
        return guid;
    }

    public void setGuid(String _guid)
    {
        this.guid = _guid;
    }

    public String toString()
    {
        // limit how much text you display
        if (title.length() > 80)
        {
            return title.substring(0, 80) + "...";
        }
        return title;
    }

}
