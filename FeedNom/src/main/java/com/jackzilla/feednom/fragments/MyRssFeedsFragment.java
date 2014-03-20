package com.jackzilla.feednom.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jackzilla.feednom.R;
import com.jackzilla.feednom.controller.ApplicationController;
import com.jackzilla.feednom.event.FragmentAttachedEvent;

import java.util.ArrayList;


public class MyRssFeedsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private ArrayList rssFeedList;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 ArrayList<T implements Parcelable
     * @return A new instance of fragment MyRssFeedsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyRssFeedsFragment newInstance(ArrayList param1) {
        MyRssFeedsFragment fragment = new MyRssFeedsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    public MyRssFeedsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            rssFeedList = getArguments().getParcelableArrayList(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_rss_feeds, container, false);
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
}
