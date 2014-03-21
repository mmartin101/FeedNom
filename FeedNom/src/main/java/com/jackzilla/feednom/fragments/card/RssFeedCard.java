package com.jackzilla.feednom.fragments.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackzilla.feednom.R;
import com.jackzilla.feednom.entities.RssFeed;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by maxm on 3/20/14.
 */
public class RssFeedCard extends Card {
    private String mTitle;
    private TextView mTitleTextView;
    private String mDescription;
    private TextView mDescriptionTextView;
    private ImageView mImageView;
    private Bitmap rssImage;

    private RssFeed rssFeed;

    public RssFeedCard(Context context, RssFeed r) {
        super(context, R.layout.rss_feed_card);
        rssFeed = r;
        init();
    }

    public RssFeedCard(Context context, int innerLayout) {
        super(context, innerLayout);
    }

    private void init() {
        mTitle = rssFeed.getTitle();
        mDescription = rssFeed.getDescription();
        // load/get image from cache here, maybe create a function that will load up the cache of images upon start up

        // maybe set up the image button to call a function in the activity? or post an event?
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        mTitleTextView = (TextView) view.findViewById(R.id.rss_feed_card_title);
        mDescriptionTextView = (TextView) view.findViewById(R.id.rss_feed_card_description);

        // get and set image view here
    }
}
