package com.schotanus.turtle.view;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.schotanus.turtle.TurtleApp;

/**
 * Multiple Document Interface for the turtle program.
 */
public class TurtleMDI extends AbstractMDIFrame {

    /** 
     * Hashtable containing {@link Action} objects that can be                                
     * retrieved by using the key: {@link Action.NAME}.
     */
    private final Hashtable<String, Action> actions = new Hashtable<>();


    /**
     * Creates this Multiple Document Interface by
     * creating the different frames, panels and menus.
     */
    public TurtleMDI() {
        super("Turtle");
        final EditFrame editFrame = new EditFrame();
        editFrame.setSize(200, 300);
        editFrame.setLocation(10, 10);
        addInternalFrame(editFrame);

        final TurtleFrame turtleFrame = new TurtleFrame();
        turtleFrame.setSize(500, 400);
        turtleFrame.setLocation(220, 10);
        addInternalFrame(turtleFrame);

        actions.put("file-new", new CommandBasedAction(TurtleApp.getResourceBundle(), "aFileNew", new NewCommand()));
        actions.put("file-save", new CommandBasedAction(TurtleApp.getResourceBundle(), "aFileSave", new SaveCommand()));
        actions.put("file-exit", new CommandBasedAction(TurtleApp.getResourceBundle(), "aFileExit", new ExitCommand()));

        setJMenuBar(GuiCreator.createMenuBar(TurtleApp.getResourceBundle(), actions));
        getContentPane().add(createToolBar(), BorderLayout.NORTH);
    }

    /**
     * Creates the toolbar.
     * @return The toolbar.
     */
    private JToolBar createToolBar() {
        final JToolBar toolBar = new ToolBar();

        JButton button = toolBar.add((Action)actions.get("file-new"));
        button.setText("");

        button = toolBar.add((Action)actions.get("file-save"));
        button.setText("");

        return toolBar;
    }

    /**
     * New command.
     */
    private class NewCommand extends AbstractCommand {
        public void execute() {
            EditFrame editFrame = new EditFrame();
            editFrame.setSize(200, 300);
            editFrame.setLocation(10, 10);
            addInternalFrame(editFrame);
        }
    }

    /**
     * Save command.
     */
    private class SaveCommand extends AbstractCommand {
        public void execute() {
            TurtleApp.changeStatusModel("Save not implemented yet!");
        }
    }

    /**
     * Exit command.
     */
    private class ExitCommand extends AbstractCommand {
        public void execute() {
            System.exit(0);
        }
    }
}