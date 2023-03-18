package com.schotanus.turtle.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

/**
 * The Turtle Frame is a frame for turtle graphics.
 */
public class TurtleFrame extends JInternalFrame {

    /**
     * Constructs an internal frame with all decorations and adds the given title.
     * The new frame will be: resizable, closable, maximizable and iconifiable.
     * @param title Title of the internal frame.
     */
    public TurtleFrame(final String title) {
        // Add all decorations to the frame.
        super(title, true, true, true, true);
    }

    public TurtleFrame() {
        this("Turtle");

        final TurtleCanvas canvas = new TurtleCanvas();
        canvas.setLayout(null);
        canvas.setPreferredSize(new Dimension(800, 600));
        final JScrollPane scrollPane = new JScrollPane(canvas);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        pack();

        // Need generic method to center the scroll pane
        scrollPane.getViewport().scrollRectToVisible(
            new Rectangle(300, 200, 100, 100));
    }

}
