package com.schotanus.turtle;

import java.util.ResourceBundle;

import com.schotanus.turtle.model.TurtleTerritoryModel;
import com.schotanus.turtle.view.TurtleMDI;


/**
 * Turtle Application Class.
 * This class initializes and starts the Turtle Application.
 * @author Kees Schotanus
 * @version 1.0
 */
public class TurtleApp extends AbstractApplication {

    /**
     * Use: turtle/app/Turtle.properties from classpath.
     */
    static {
        setResourceBundle(ResourceBundle.getBundle("com.schotanus.turtle.Turtle"));
    }

    /**
     * The territory in which turtles live.
     */
    private static TurtleTerritoryModel turtleTerritoryModel =
        new TurtleTerritoryModel();

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

}
