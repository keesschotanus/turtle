package com.schotanus.turtle.model;

/**
 * Enumeration of the different types of severity.
 */
public enum MessageSeverity {
    NORMAL("Normal"),
    WARNING("Warning"),
    ERROR("Error");
 
    private String messageSeverity;
 
    MessageSeverity(String messageSeverity) {
        this.messageSeverity = messageSeverity;
    }
 
    public String getMessageSeverity() {
        return this.messageSeverity;
    }
    
}
