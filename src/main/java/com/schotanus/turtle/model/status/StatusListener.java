package com.schotanus.turtle.model.status;

import java.util.EventListener;


/**
 * Listener interface for receiving status events.
 * @author Kees Schotanus
 * @version 1.1
 */
public interface StatusListener extends EventListener {

    /**
     * Status model has changed event.
     * @param statusEvent The status event.
     */
    void statusModelHasChanged(final StatusEvent statusEvent);

}

