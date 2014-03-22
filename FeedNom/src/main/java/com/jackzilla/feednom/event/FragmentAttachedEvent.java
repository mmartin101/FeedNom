package com.jackzilla.feednom.event;

/**
 * Created by maxm on 3/10/14.
 */
public class FragmentAttachedEvent extends ApplicationEvent<Integer> {

    public FragmentAttachedEvent(Integer titleId) {
        this.eventObj = titleId;
    }
}
