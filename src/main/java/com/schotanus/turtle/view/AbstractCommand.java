package com.schotanus.turtle.view;

import javax.swing.Action;

/**
 * Partial implementation of the {@link CommandableAction} interface.
 * <br>This class avoids the duplication of the member access methods in every
 * class that implements the {@link CommandableAction} interface.
 * @author Kees Schotanus
 * @version 1.0
 */
public abstract class AbstractCommand implements CommandableAction {

    /**
     * Corresponding Swing Action.
     */
    private Action action;

    /**
     * Gets the Swing action..
     * @return The Swing action.
     */
    public Action getAction() {
        return action;
    }

    /**
     * Sets the Swing action.
     * @param action The Swing action.
     */
    public void setAction(final Action action) {
        this.action = action;
    }

}