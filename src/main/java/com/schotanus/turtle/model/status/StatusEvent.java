package com.schotanus.turtle.model.status;

import java.util.EventObject;

import com.schotanus.turtle.model.MessageSeverity;


/**
 * Definition of a status event.
 * <br>The status bar listens to these events to display status information.
 * @author Kees Schotanus.
 * @version 1.1
 */
public class StatusEvent extends EventObject {

    /**
     * The status message.
     */
    private String message;

    /**
     * Status message severity.
     * <br>The idea behind severity is that we can have messages that are
     * displayed differently depending on the severity.
     * For the actual values see: {@link MessageSeverity}.
     */
    private MessageSeverity severity;

    /**
     * Creates a StatusEvent from the supplied source, message and severity.
     * @param source The object that generated the event.
     * @param message The message to display.
     * @param severity The severity of the message.
     */
    public StatusEvent(
            final Object source,
            final String message,
            final MessageSeverity severity) {
        super(source);

        this.message = message;
        this.severity = severity;
    }

    /**
     * Gets the message.
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the severity of the message.
     * @return The severity of the message.
     */
    public MessageSeverity getSeverity() {
        return severity;
    }
}

