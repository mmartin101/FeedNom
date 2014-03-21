package com.jackzilla.feednom.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jackzilla.feednom.R;
import com.jackzilla.feednom.activity.MainActivity;
import com.jackzilla.feednom.controller.ApplicationController;
import com.jackzilla.feednom.entities.RssFeed;
import com.jackzilla.feednom.event.FragmentAttachedEvent;

import java.util.ArrayList;
import java.util.List;


public class MyRssFeedsFragment extends AbstractFragment<MainActivity> {
    private List rssFeedList;

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
//        rssFeedList = getFeedNomApplication().getApplicationController().getFeedDao().loadAll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_rss_feeds, container, false);
        // create a CardGridArrayAdapter object and give it the list
        // maybe post to the event bus here and do an onEventAsync method to load the feeds from the db
        // pass the adapter to the event too...
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
}
