package com.jackzilla.feednom.event;

/**
 * Created by maxm on 3/20/14.
 */
public abstract class ApplicationEvent<T> {
    protected T eventObj;
    public T getEventObj() {
        return eventObj;
    }
}
