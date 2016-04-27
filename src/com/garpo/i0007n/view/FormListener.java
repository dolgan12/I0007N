package com.garpo.i0007n.view;

import org.w3c.dom.events.Event;

import java.util.EventListener;

/**
 * Created by Conny Garpö on 4/25/2016.
 */
public interface FormListener extends EventListener{
    void formEventOccured(FormEvent event);
}
