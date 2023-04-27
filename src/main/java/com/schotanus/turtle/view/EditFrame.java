package com.schotanus.turtle.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

import com.schotanus.turtle.TurtleApp;
import com.schotanus.turtle.TurtleApp;


/**
 * Edit frame to edit turtle source code.
 */
public class EditFrame extends JInternalFrame {
    private JEditorPane editorPane;

    /**
     * Constructs an internal frame with all decorations and adds the given title.
     * The new frame will be: resizable, closable, maximizable and iconifiable.
     * @param title Title of the internal frame.
     */
    public EditFrame(final String title) {
        // Add all decorations to the frame.
        super(title, true, true, true, true);
    }

    /**
     * Constructs an internal frame with all decorations and a default title.
     * The new frame will be: resizable, closable, maximizable and iconifiable.
     */
    public EditFrame() {
        this("Turtle edit");

        editorPane = new JEditorPane();
        editorPane.setSize(500, 100);

        final JScrollPane scrollPane = new JScrollPane(editorPane);
        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        final JButton runButton = new JButton("Run");
        runButton.addActionListener(new RunHandler());
        getContentPane().add(runButton, BorderLayout.SOUTH);

        pack();
    }

    /**
     * Runs the turtle code by parsing the turtle source file
     * from the edit pane.
     */
    private class RunHandler implements ActionListener {

        public void actionPerformed(final ActionEvent event) {
            try {
                TurtleApp.getTurtleTerritoryModel().parse(editorPane.getText());
            } catch (Exception exception) {
                TurtleApp.changeStatusModel(exception.getMessage());
            }
        }
    }
}
