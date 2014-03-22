package com.jackzilla.feednom.event;

/**
 * Created by maxm on 3/21/14.
 */
public class NewRssFeedEvent extends ApplicationEvent<String> {
    public NewRssFeedEvent(String url) {
        eventObj = url;
    }
}
