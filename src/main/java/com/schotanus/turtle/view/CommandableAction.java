package com.schotanus.turtle.view;

import javax.swing.Action;


/**
 * Interface part for the Command pattern.
 * @author Kees Schotanus
 * @version 1.0
 */
public interface CommandableAction {

    /**
     * This method will be called upon execution of a Swing Action.
     * Consider this to be the real action part of a Swing Action.
     */
    void execute();

    /**
     * This method should return the corresponding Action.
     * @return Corresponding Swing Action.
     */
    Action getAction();

    /**
     * This method sets the corresponding Action.
     * @param action Corresponding Swing Action.
     */
    void setAction(Action action);
}

