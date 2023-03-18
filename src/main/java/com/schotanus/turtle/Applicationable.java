package com.schotanus.turtle;

import com.schotanus.turtle.model.status.StatusModel;
import com.schotanus.turtle.model.MessageSeverity;


/**
 * Interface for applications that want to use a status model.
 * @author Kees Schotanus
 * @version 1.0
 * @see AbstractApplication
 */
public interface Applicationable {

    /**
     * Gets the used status model.
     * @return Status model used by the application.
     */
    StatusModel getStatusModel();

    /**
     * Changes the status model and notifies the listeners of this event.
     * @param message The new message for the status model.
     * @param severity Severity of the message.
     * @see StatusModel
     */
    void changeStatusModel(final String message, final MessageSeverity severity);

}
