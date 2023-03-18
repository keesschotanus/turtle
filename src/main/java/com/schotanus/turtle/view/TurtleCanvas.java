package com.schotanus.turtle.view;

import java.awt.*;
import java.awt.image.*;

import javax.swing.JPanel;

import com.schotanus.turtle.TurtleApp;
import com.schotanus.turtle.model.TurtleModel;
import com.schotanus.turtle.model.TurtleTerritoryModel;

/**
 * The canvas on which all turtle graphics will be drawn.
 */
public class TurtleCanvas extends JPanel implements
        TurtleTerritoryModel.TurtleTerritoryListener,
        TurtleModel.TurtleListener {

    private final BufferedImage bufferedImage =
        new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
    private final Graphics graphics = bufferedImage.createGraphics();

    /**
     * Paints the canvas.
     */
    public void paintComponent(Graphics graphics) {
        graphics.drawImage(bufferedImage, 0, 0, new ImageObserver() {
            public boolean imageUpdate(Image i, int i1, int i2, int i3, int i4, int i5) {
                return true;
            }
        });
    }

    /**
     * Constructs this canvas, by setting the color and initializing the turtle
     * models.
     */
    public TurtleCanvas() {
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, 0, 800, 600);
        final TurtleTerritoryModel turtleTerritoryModel =
            TurtleApp.getTurtleTerritoryModel();
        turtleTerritoryModel.addTurtleTerritoryListener(this);

        final TurtleModel[] turtleModels = turtleTerritoryModel.getTurtleModels();
        for (int i = 0; i < turtleModels.length; i++) {
            turtleModels[i].addTurtleListener(this);
        }
    }

    /**
     * Called when the TurtleTerritoryModel is cleared.
     * @param event The TurtleTerritoryModel.TurtleTerritoryEvent.
     */
    public void turtleTerritoryCleared(
            final TurtleTerritoryModel.TurtleTerritoryEvent event) {
        final Graphics graphics = getGraphics();
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Called when the color of TurtleTerritoryModel has changed.
     * @param event The TurtleTerritoryModel.TurtleTerritoryEvent.
     */
    public void turtleTerritoryColorChanged(
            final TurtleTerritoryModel.TurtleTerritoryEvent event) {
        final Graphics graphics = getGraphics();
        graphics.setColor(event.getColor());
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(event.getColor());
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Called when the turtle has turned.
     * @param event The TurtleTerritoryModel.TurtleTerritoryEvent.
     * @param oldHeading Previous heading of the turtle.
     */
    public void turtleTurned(
        final TurtleModel.TurtleEvent event, final double oldHeading) {
    }

    /**
     * Called when the turtle has moved.
     * @param event The TurtleTerritoryModel.TurtleTerritoryEvent.
     * @param oldX Previous X-position of the turtle.
     * @param oldY Previous Y-position of the turtle.
     */
    public void turtleMoved(
            final TurtleModel.TurtleEvent event, double oldX, double oldY) {
        if (event.isPenDown()) {
            final Graphics graphics = getGraphics();
            graphics.setColor(event.getColor());
            graphics.setColor(event.getColor());

            final double xCenter = getWidth() / 2;
            final double yCenter = getHeight() / 2;

            final int x1 = (int) Math.round(oldX + xCenter);
            final int y1 = (int) Math.round(yCenter - oldY);

            final int x2 = (int) Math.round(event.getX() + xCenter);
            final int y2 = (int) Math.round(yCenter - event.getY());
            graphics.drawLine(x1, y1, x2, y2);
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * Called when the turtle has changed color.
     * @param event The TurtleTerritoryModel.TurtleTerritoryEvent.
     * @param oldColor Previous color of the turtle.
     */
    public void turtleColorChanged(
            final TurtleModel.TurtleEvent event, final Color oldColor) {
    }

    /**
     * Required override.
     * @param event The dispatched event.
     */
    public void eventDispatched(java.awt.AWTEvent event) {
        ; // Empty implementation
    }
}