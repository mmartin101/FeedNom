package com.jackzilla.feednom.event;

import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;

/**
 * Created by maxm on 3/20/14.
 */
public class RssFeedsLoadedEvent extends ApplicationEvent<CardGridArrayAdapter> {

    public RssFeedsLoadedEvent(CardGridArrayAdapter arrayAdapter) {
        this.eventObj = arrayAdapter;
    }
}
