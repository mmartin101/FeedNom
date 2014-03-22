package com.jackzilla.feednom.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jackzilla.feednom.R;
import com.jackzilla.feednom.activity.MainActivity;
import com.jackzilla.feednom.controller.ApplicationController;
import com.jackzilla.feednom.entities.RssFeed;
import com.jackzilla.feednom.event.FragmentAttachedEvent;
import com.jackzilla.feednom.event.RssFeedsLoadedEvent;
import com.jackzilla.feednom.fragments.card.RssFeedCard;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardListView;


public class MyRssFeedsFragment extends AbstractFragment<MainActivity> {
    private List<Card> rssFeedCards = new ArrayList<Card>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MyRssFeedsFragment.
     */
    public static MyRssFeedsFragment newInstance() {
        MyRssFeedsFragment fragment = new MyRssFeedsFragment();
        return fragment;
    }
    public MyRssFeedsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerWithEventBus();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_rss_feeds, container, false);
        // create a CardGridArrayAdapter object and give it the list
        // maybe post to the event bus here and do an onEventAsync method to load the feeds from the db
        // pass the adapter to the event too...
        CardGridArrayAdapter arrayAdapter = new CardGridArrayAdapter(getActivityA(), rssFeedCards);
        CardGridView cardGridView = (CardGridView) v.findViewById(R.id.rss_feed_card_grid_view);
        if (cardGridView != null) {
            cardGridView.setAdapter(arrayAdapter);
        }

        ApplicationController.getEventBus().post(new RssFeedsLoadedEvent(arrayAdapter));
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ApplicationController.getEventBus().post(new FragmentAttachedEvent(R.string.title_my_feeds));

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public MainActivity getActivityA() {
        return (MainActivity) getActivity();
    }

    public void onEventAsync(RssFeedsLoadedEvent event) {
        CardGridArrayAdapter arrayAdapter = event.getEventObj();

        List<RssFeed> feeds = getFeedNomApplication().getApplicationController().getFeedDao().loadAll();
        if (feeds.isEmpty()) {
            RssFeed feed = new RssFeed();
            feed.setTitle("Dummy Rss Feed");
            feed.setDescription("Some useful description");
            feeds.add(feed);
            feeds.add(feed);
            feeds.add(feed);
        }
        for (RssFeed f : feeds) {
            RssFeedCard card = new RssFeedCard(getActivityA(), f);
            rssFeedCards.add(card);
        }
        arrayAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterEventBus();
    }
}
