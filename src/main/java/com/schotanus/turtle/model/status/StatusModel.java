 package com.schotanus.turtle.model.status;
 
 import java.io.Serializable;
 import java.util.ArrayList;
 import java.util.List;
 
 import com.schotanus.turtle.model.MessageSeverity;


 /**
  * Status Model.
  * A {@link StatusBar} can register as a listener so it will automatically
  * receive information about status messages.
  * @author Kees Schotanus
  * @version 1.2
  */
 public class StatusModel implements Serializable {
 
    /**
     * Stores all subscribed listeners.
     * Note: Assume we'll normally have only one listener.
     */
    private transient List<StatusListener> listeners = new ArrayList<>();
 
 
    /**
     * Constructor to make this StatusModel a Bean.
     */
    public StatusModel() {
    }
 
    /**
     * Sets the message and notifies the listeners of this event.
     * @param message The new message for the status model.
     *  The severity is assumed to be of type NORMAL.
     * @see #setMessage(String, MessageSeverity)
     */
    public void setMessage(final String message) {
        setMessage(message, MessageSeverity.NORMAL);
    }
 
    /**
     * Sets the message and notifies the listeners of this event.
     * @param message The new message for the status model.
     * @param severity Severity of the message.
     */
    public void setMessage(final String message, final MessageSeverity severity) {
        /*
         * Make a backup of the listeners and use this backup for event
         * dispatching. This avoids racing conditions. Listeners can now be
         * added and removed during dispatching.
         */
        final List<StatusListener> targets = new ArrayList<>(listeners);
 
        final StatusEvent statusEvent = new StatusEvent(this, message, severity);
        for (int i = 0; i < targets.size(); i++) {
            StatusListener statusListener = (StatusListener)targets.get(i);
            statusListener.statusModelHasChanged(statusEvent);
        }
    }
 
    /**
     * Add a component that wants to receive {@link StatusEvent} objects.
     * A component will only be added once as a registered listener.
     * @param statusListener Object that listens to changes made to the
     *  status model.
     * @pre statusListener != null.
     */
    public void addStatusListener(final StatusListener statusListener) {
        if (!listeners.contains(statusListener)) {
            listeners.add(statusListener);
        }
    }
 
    /**
     * Removes a previously registered listener.
     * @param statusListener The status listener to remove.
     */
    public void removeStatusListener(final StatusListener statusListener) {
        listeners.remove(statusListener);
    }
 }
 