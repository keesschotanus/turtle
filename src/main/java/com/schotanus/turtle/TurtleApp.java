package com.schotanus.turtle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.schotanus.turtle.model.MessageSeverity;
import com.schotanus.turtle.model.TurtleTerritoryModel;
import com.schotanus.turtle.model.status.StatusModel;
import com.schotanus.turtle.view.TurtleMDI;


/**
 * Turtle Application Class.
 * This class initializes and starts the Turtle Application.
 * @author Kees Schotanus
 * @version 1.0
 */
public class TurtleApp {

    /**
     * Locale to be used for this application.
     */
    private static Locale locale = Locale.getDefault();
  
    /**
     * Resource bundle containing all localizable properties.
     */
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("com.schotanus.turtle.Turtle", locale);
 
    /**
     * The territory in which turtles live.
     */
    private static TurtleTerritoryModel turtleTerritoryModel =
        new TurtleTerritoryModel();

    /**
     * Status model.
     */
    private static StatusModel statusModel = new StatusModel();

    /**
     * Constructs the Turtle Application and creates an MDI frame.
     * @wish Create MDI frame as large as possible.
     */
    private TurtleApp() {
        TurtleMDI mdi = new TurtleMDI();
        mdi.setSize(800, 600);
        mdi.setVisible(true);
    }

    /**
     * Member access.
     * @return {@link #turtleTerritoryModel}.
     */
    public static TurtleTerritoryModel getTurtleTerritoryModel() {
        return turtleTerritoryModel;
    }

    /**
     * Constructs this class.
     * @param args Unused.
     */
    public static void main(final String [] args) {
        new TurtleApp();
    }

    /**
     * Gets a localized string from the resource bundle.
     * @return The localized string or null when the supplied key was not found.
     */
    public static String getLocalizedString(final String key) {
        try {
            return resourceBundle.getString(key);
        } catch (final MissingResourceException exception) {
            return null;
        }
     }

    /**
     * Gets the status model from the contained {@link #application}.
     * @return Status model of the contained {@link #application}.
     */
    public static StatusModel getStatusModel() {
        return statusModel;
    }

    /**
     * Changes the status model and notifies the listeners of this event.
     * @param message The new message for the status model.
     * The severity is assumed to be of type NORMAL.
     * @see #changeStatusModel(String, MessageSeverity)
     */
    public static void changeStatusModel(final String message) {
        statusModel.setMessage(message);
    }

    /**
     * Changes the status model and notifies the listeners of this event.
     * @param message The new message for the status model.
     * @param severity Severity code of the message.
     */
    public static void changeStatusModel(final String message, final MessageSeverity severity) {
        statusModel.setMessage(message, severity);
    }

    /**
     * Terminates the application.
     * Use this method after a fatal error occurs from which you can't
     * recover.
     * @param reason Reason why the application is terminated.
     * @post Application terminated with error code 1.
     */
    public static void terminate(final String reason) {
        System.out.println(reason);
        System.exit(1);
    }

}
