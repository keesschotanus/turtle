package com.schotanus.turtle.model;


import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;


/**
 * In MVC terms, this is the Turtle's model.
 * @author Kees Schotanus
 * @version 1.0
 */
public class TurtleModel implements Serializable {

    /**
     * Stores all subscribed listeners.
     * Note: Assume we'll normally have only one listener.
     */
    private transient List<TurtleListener> listeners = new ArrayList<>();

    /**
     * X-coordinate of the turtle.
     */
    private double x;

    /**
     * Y-coordinate of the turtle.
     */
    private double y;

    /**
     * Heading in which the turtle is directing.
     */
    private double heading;

    /**
     * Color of the turtle.
     */
    private Color color;

    /**
     * Determines whether the pen is up (false) or down (true).
     */
    private boolean penDown;

    /**
     * Constructs a new Turtle by initializing it.
     * See {@link #init()}.
     */
    public TurtleModel() {
        this.init();
    }

    /**
     * Initializes the model by setting the turtle in the middle,
     * heading north (90 degrees), with the pen down, color black.
     */
    public void init() {
        x = 0.0;
        y = 0.0;

        heading = 90.0;
        color = Color.black;
        penDown = true;
    }

    /**
     * Sets the heading of the turtle.
     * @param heading Heading of the turtle.
     *  A heading of 90 is straight up.
     */
    public void setHeading(double heading) {
        turn(heading - this.heading);
    }

    /**
     * Turns the turtle the specified number of degrees.
     * @param degrees The number of degrees to turn the turtle.
     *  When positive a right turn is made, when negative,
     *  the turtle turns left.
     */
    public void turn(double degrees) {
        double oldHeading = heading;
        heading = (heading + degrees) % 360;
        if (heading < 0) {
            heading+=360;
        }

        final List<TurtleListener> targets = new ArrayList<>(listeners);
        TurtleEvent event = new TurtleEvent(this);
        for (int i = 0; i < targets.size(); i++) {
            TurtleListener listener = targets.get(i);
            listener.turtleTurned(event, oldHeading);
        }
    }

    /**
     * Moves the turtle the specified distance.
     * @param distance The distance to move the turtle.
     */
    public void move(double distance) {
        double oldX = x;
        double oldY = y;

        x = oldX + distance * Math.cos(Math.toRadians(heading));
        y = oldY + distance * Math.sin(Math.toRadians(heading));

        final List<TurtleListener> targets = new ArrayList<>(listeners);
        TurtleEvent event = new TurtleEvent(this);
        for (int i = 0; i < targets.size(); i++) {
            TurtleListener listener = targets.get(i);
            listener.turtleMoved(event, oldX, oldY);
        }

    }

    /**
     * Sets the turtle to the supplied color.
     * @param color The color to set the turtle to.
     */
    public void setColor(Color color) {
        Color oldColor = this.color;
        this.color = color;

        final List<TurtleListener> targets = new ArrayList<>(listeners);
        TurtleEvent event = new TurtleEvent(this);
        for (int i = 0; i < targets.size(); i++) {
            TurtleListener listener = targets.get(i);
            listener.turtleColorChanged(event, oldColor);
        }
    }

    /**
     * Sets the pen down or up.
     * @param penDown When true the pen is set down, otherwise it is up.
     */
    public void setPenDown(final boolean penDown) {
        this.penDown = penDown;
    }

    /**
     * Sets the turtle to the supplied x and y coordinates.
     * @param x X-coordinate of the turtle.
     * @param y Y-coordinate of the turtle.
     */
    public void setPosition(final double x, final double y) {
        double oldX = this.x;
        double oldY = this.y;

        this.x = x;
        this.y = y;

        final List<TurtleListener> targets = new ArrayList<>(listeners);
        TurtleEvent event = new TurtleEvent(this);
        for (int i = 0; i < targets.size(); i++) {
            TurtleListener listener = targets.get(i);
            listener.turtleMoved(event, oldX, oldY);
        }
    }

    /**
     * Sets the X-coordinate of the turtle.
     * @param x X-coordinate of the turtle.
     */
    public void setXPosition(final double x) {
        setPosition(x, this.y);
    }

    /**
     * Sets the Y-coordinate of the turtle.
     * @param y Y-coordinate of the turtle.
     */
    public void setYPosition(final double y) {
        setPosition(this.x, y);
    }

    /**
     * Adds a component that wants to be receive {link TurtleEvent TurtleEvents}.
     * @param listener Object that listens to changes made to this model.
     * @pre listener != null.
     */
    public void addTurtleListener(final TurtleListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * Removes a previously registered TurtleListener.
     * @param listener The listener to remove.
     */
    public void removeTurtleListener(final TurtleListener listener) {
        listeners.remove(listener);
    }

    /**
     * A TurtleEvent.
     * @author Kees Schotanus
     * @version 1.0
     */
    public class TurtleEvent extends EventObject {
        private double x;
        private double y;

        private double heading;
        private Color color;
        private boolean penDown;

        /**
         * Creates ths TurtleEvent from the supplied turtleModel.
         * @param turtleModel The object that generated the event.
         */
        public TurtleEvent(TurtleModel turtleModel) {
            super(turtleModel);

            this.x = turtleModel.x;
            this.y = turtleModel.y;

            this.heading = turtleModel.heading;

            this.color = turtleModel.color;
            this.penDown = turtleModel.penDown;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getHeading() {
            return heading;
        }

        public Color getColor() {
            return color;
        }

        public boolean isPenDown() {
            return penDown;
        }

    }

    /**
     * The listener interface for receiving Turtle events.
     * @author Kees Schotanus
     * @version 1.0
     */
    public interface TurtleListener extends EventListener {
        void turtleTurned(TurtleEvent event, double oldHeading);
        void turtleMoved(TurtleEvent event, double oldX, double oldY);
        void turtleColorChanged(TurtleEvent event, Color oldColor);
    }
}