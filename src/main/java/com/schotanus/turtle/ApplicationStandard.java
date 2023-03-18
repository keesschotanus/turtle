package com.schotanus.turtle;

import com.schotanus.turtle.model.MessageSeverity;
import com.schotanus.turtle.model.status.StatusModel;


/**
 * Standard application class.
 * @author Kees Schotanus
 * @version 1.0
 */
public class ApplicationStandard implements Applicationable {

    /**
     * Status model.
     */
    private StatusModel statusModel = new StatusModel();


    /**
     * Protected constructor prevents users from instantiating an object from
     * within another package unless it extends this class.
     */
    protected ApplicationStandard() {
    }

    /**
     * Gets the status model.
     * @return The status model.
     */
    public StatusModel getStatusModel() {
        return statusModel;
    }

    /**
     * Changes the status model and notifies the listeners of this event.
     * @param message The new message for the status model.
     * @param severity Severity of the message.
     */
    public void changeStatusModel(
            final String message, final MessageSeverity severity) {
        statusModel.setMessage(message, severity);
    }

}