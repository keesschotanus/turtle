package com.schotanus.turtle.model;

import java.awt.Color;
import java.awt.event.AWTEventListener;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import com.schotanus.turtle.TurtleApp;
import com.schotanus.turtle.parser.SimpleNode;
import com.schotanus.turtle.parser.TurtleParser;


/**
 * This is a model of where turtles live.
 * @author Kees Schotanus
 * @version 1.0
 */
public class TurtleTerritoryModel implements Serializable {

    /**
     * Maximum number of supported turtles.
     */
    public static final int MAX_TURTLE_POPULATION = 10;

    /**
     * Each turtle has its own TurtleModel.
     */
    private TurtleModel [] turtleModels = new TurtleModel[MAX_TURTLE_POPULATION];

    /**
     * Only one turtle can be active at any given time.
     * Initially it is turtle number 0.
     */
    private int activeTurtle = 0;

    /**
     * Parser to parse turtle graphics commands.
     */
    private TurtleParser turtleParser;

    /**
     * Color of the turtle territory.
     */
    private Color color;

    /**
     * Stores all subscribed listeners.
     */
    private transient List<TurtleTerritoryListener> listeners = new ArrayList<>();

    /**
     * Creates a new TurtleTerritoryModel by setting the color and
     * initializing all the TurtleModels.
     */
    public TurtleTerritoryModel() {
        color = Color.gray;

        for (int i = 0; i < turtleModels.length; i++) {
            turtleModels[i] = new TurtleModel();
        }
    }

    /**
     * Gets all the TurtleModels.
     * @return The TurtleModels.
     */
    public TurtleModel [] getTurtleModels() {
        return turtleModels;
    }

    /**
     * Gets the number of the active turtle.
     * @return The number of the active turtle.
     */
    public int getActiveTurtle() {
        return activeTurtle;
    }

    /**
     * Sets the number of the active turtle.
     * @param activeTurtle The number of the active turtle.
     */
    public void setActiveTurtle(final int activeTurtle) {
        if (activeTurtle >= 0 && activeTurtle < MAX_TURTLE_POPULATION) {
            this.activeTurtle = activeTurtle;
        }
    }

    /**
     * Parses the supplied turtle source code.
     * @param source The source code to parse.
     * @throws Exception When the source could not be parsed.
     */
    public void parse(final String source) throws Exception {
        TurtleApp.changeStatusModel("Running...");

        StringReader stringReader = new StringReader(source + "\n");
        if (turtleParser == null) {
            turtleParser = new TurtleParser(stringReader);
        } else {
            TurtleParser.ReInit(stringReader);
        }

        SimpleNode node = TurtleParser.parseUnit();
        node.interpret();

        TurtleApp.changeStatusModel("Ready.");
    }

    /**
     * Clears the screen.
     * This also involves initializing all TurtleModels.
     */
    public void clearScreen() {
        activeTurtle = 0;
        for (int i = 0; i < turtleModels.length; i++) {
            turtleModels[i].init();
        }

        final List<TurtleTerritoryListener> targets = new ArrayList<>(listeners);
        TurtleTerritoryEvent event = new TurtleTerritoryEvent(this);
        for (int i = 0; i < targets.size(); i++) {
            TurtleTerritoryListener listener = targets.get(i);
            listener.turtleTerritoryCleared(event);
        }
    }

    /**
     * Sets the color of the TurtleTerritory.
     * @param color The color of the TurtleTerritory.
     */
    public void setColor(final Color color) {
        this.color = color;

        final List<TurtleTerritoryListener> targets = new ArrayList<>(listeners);
        TurtleTerritoryEvent event = new TurtleTerritoryEvent(this);
        for (int i = 0; i < targets.size(); i++) {
            TurtleTerritoryListener listener = targets.get(i);
            listener.turtleTerritoryColorChanged(event);
        }

    }

    /**
     * Add a component that wants to receive {@link TurtleTerritoryEvent}
     * objects.
     * @param listener Object that listens to changes made to this model.
     * @pre listener != null.
     */
    public void addTurtleTerritoryListener(
            final TurtleTerritoryListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * Removes a previously registered listener.
     * @param listener The listener to remove.
     */
    public void removeTurtleTerritoryListener(
            final TurtleTerritoryListener listener) {
        listeners.remove(listener);
    }

    /**
     * TurtleTerritoryEvent.
     * @author Kees Schotanus
     * @version 1.0
     */
    public class TurtleTerritoryEvent extends EventObject {

        /**
         * Color of the turtle territory.
         */
        private Color color;

        /**
         * Creates this TurtleTerritoryEvent from the supplied turtleTerritoryModel.
         * @param turtleTerritoryModel The object that generated the event.
         */
        public TurtleTerritoryEvent(final TurtleTerritoryModel source) {
            super(source);

            this.color = source.color;
        }

        /**
         * Retrieves the color of the turtle territory.
         * @return Color of the turtle territory.
         *  Logo would call this the background color.
         */
        public Color getColor() {
            return color;
        }
    }

    /**
     * The listener interface for receiving TurtleTerritoryEvents.
     * @author Kees Schotanus
     * @version 1.0
     */
    public interface TurtleTerritoryListener extends AWTEventListener {
        /**
         * Turtle territory is cleared event.
         * @param turtleTerritoryEvent The event.
         */
        void turtleTerritoryCleared(
            final TurtleTerritoryEvent turtleTerritoryEvent);

        /**
         * Turtle territory has changed color event.
         * @param turtleTerritoryEvent The event.
         */
        void turtleTerritoryColorChanged(final TurtleTerritoryEvent event);
    }
}
