package com.jackzilla.feednom.rss;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Created by maxm on 2/27/14.
 */
public class RssHandler {
    RssFeed feed;
    RssFeedItem feedItem;
    String lastElementName = "";
    boolean bFoundChannel = false;
    final int RSS_TITLE = 1;
    final int RSS_LINK = 2;
    final int RSS_DESCRIPTION = 3;
    final int RSS_CATEGORY = 4;
    final int RSS_PUBDATE = 5;
    final int RSS_IMAGE_URL = 6;
    final int RSS_ENCLOSURE = 7;

    int depth = 0;
    int currentstate = 0;

    RssHandler()
    {
    }

    /*
     * getFeed - this returns our feed when all of the parsing is complete
     */
    RssFeed getFeed()
    {
        return feed;
    }


    public void startDocument() throws SAXException
    {
        // initialize our RSSFeed object - this will hold our parsed contents
        feed = new RssFeed();
        // initialize the RSSItem object - you will use this as a crutch to grab
        // the info from the channel
        // because the channel and items have very similar entries..
        feedItem = new RssFeedItem();

    }
    public void endDocument() throws SAXException
    {
    }

    private String iurl;
    public void startElement(String namespaceURI, String localName,String qName, Attributes atts) throws SAXException
    {
        depth++;
        if (localName.equals("channel"))
        {
            currentstate = 0;
            return;
        }
        if (localName.equals("url"))
        {
            currentstate = RSS_IMAGE_URL;
            return;
        }
        if (qName.equals("itunes:image"))
        {
            iurl = atts.getValue(0);
            currentstate = RSS_IMAGE_URL;
            return;
        }
        if (localName.equals("item"))
        {
            // create a new item
            feedItem = new RssFeedItem();
            return;
        }
        if (localName.equals("title"))
        {
            currentstate = RSS_TITLE;
            return;
        }
        if (localName.equals("description"))
        {
            currentstate = RSS_DESCRIPTION;
            return;
        }
        if (localName.equals("link"))
        {
            currentstate = RSS_LINK;
            return;
        }
        if (localName.equals("category"))
        {
            currentstate = RSS_CATEGORY;
            return;
        }
        if (localName.equals("pubDate"))
        {
            currentstate = RSS_PUBDATE;
            return;
        }
        if (localName.equals("enclosure"))
        {
            currentstate = RSS_ENCLOSURE;
            return;
        }
        // if you don't explicitly handle the element, make sure you don't wind
        // up erroneously storing a newline or other bogus data into one of our
        // existing elements
        currentstate = 0;
    }

    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException
    {
        depth--;
        if (localName.equals("item"))
        {
            // add our item to the list!
            feed.addItem(feedItem);
//            itemAdded();
            return;
        }
    }

    public void itemAdded()
    {
    }

    public void characters(char ch[], int start, int length)
    {
        String theString = new String(ch,start,length);

        switch (currentstate)
        {
            case RSS_TITLE:
                if (depth == 3)
                {
                    feed.setTitle(theString);
                }
                else if(depth == 4)
                {
                    feedItem.setTitle(theString);
                }
                currentstate = 0;
                break;
            case RSS_LINK:
                feedItem.setLink(theString);
                currentstate = 0;
                break;
            case RSS_DESCRIPTION:
                feedItem.setDescription(theString);
                currentstate = 0;
                break;
            case RSS_CATEGORY:
                feedItem.setCategory(theString);
                currentstate = 0;
                break;
            case RSS_PUBDATE:
                if (depth == 3)
                {
                    feed.setPubDate(theString);
                }
                else if(depth == 4)
                {
                    feedItem.setPubDate(theString);
                }
                currentstate = 0;
                break;
            case RSS_IMAGE_URL:
                if (iurl != null)
                {
                    feed.setImage(iurl);
                }
                else
                {
                    feed.setImage(theString);
                }
                currentstate = 0;
                break;
            case RSS_ENCLOSURE:
                feedItem.setEnclosure(theString);
                currentstate = 0;
                break;
            default:
                return;
        }

    }

}
