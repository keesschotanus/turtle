package com.schotanus.turtle.model;

/**
 * Enumeration of the different types of severity.
 */
public enum MessageSeverity {
    NORMAL("Normal"),
    WARNING("Warning"),
    ERROR("Error");
 
    private String severity;
 
    MessageSeverity(String messageSeverity) {
        this.severity = messageSeverity;
    }
 
    public String getSeverity() {
        return this.severity;
    }
    
}
