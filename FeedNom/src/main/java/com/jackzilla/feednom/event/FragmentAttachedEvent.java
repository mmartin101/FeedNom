package com.jackzilla.feednom.event;

/**
 * Created by maxm on 3/10/14.
 */
public class FragmentAttachedEvent {
    private int titleId;

    public FragmentAttachedEvent(int titleId) {
        this.titleId = titleId;
    }

    public int getTitleId() {
        return titleId;
    }
}
