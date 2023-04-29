package com.schotanus.turtle.view;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.schotanus.turtle.TurtleApp;


/**
 * Multiple Document Interface for the turtle program.
 */
public class TurtleMDI extends AbstractMDIFrame {

    /** 
     * Map containing {@link Action} objects that can be                                
     * retrieved by using the key: {@link Action.NAME}.
     */
    private final Map<String, Action> actions = new HashMap<>();


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

        actions.put("file-new", new CommandBasedAction("aFileNew", new NewCommand()));
        actions.put("file-open", new CommandBasedAction("aFileOpen", new OpenCommand()));
        actions.put("file-save", new CommandBasedAction("aFileSave", new SaveCommand()));
        actions.put("file-exit", new CommandBasedAction("aFileExit", new ExitCommand()));

        setJMenuBar(GuiCreator.createMenuBar(actions));
        getContentPane().add(createToolBar(), BorderLayout.NORTH);
    }

    /**
     * Creates the toolbar.
     * @return The toolbar.
     */
    private JToolBar createToolBar() {
        final JToolBar toolBar = new ToolBar();

        JButton button = toolBar.add(actions.get("file-new"));
        button.setText("");

        button = toolBar.add(actions.get("file-save"));
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
     * Open command.
     */
    private class OpenCommand extends AbstractCommand {
        public void execute() {
            TurtleApp.changeStatusModel("Open not implemented yet!");
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