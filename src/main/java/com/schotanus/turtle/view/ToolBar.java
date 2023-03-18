package com.schotanus.turtle.view;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * Localizable ToolBar.
 * The problem with the {@link JToolBar} is that actions added to this
 * tool bar are not properly localized (at least around the year 2000).
 * This class solves this problem.
 * @author Kees Schotanus
 * @version 1.0
 */
public class ToolBar extends JToolBar {

    /**
     * Constructs a localizable tool bar.
     */
    public ToolBar() {
    }

    /**
     * Creates and returns a JButton based upon a Swing Action.
     * Sun's implementation does not set the tooltip text but this one does!
     * @param action Action used to create a JButton.
     *  Normally you will supply an object of type {@link CommandBasedAction}.
     * @return A JButton initialized with data from the supplied action.
     */
    public JButton add(final Action action) {
        final JButton button = super.add(action);

        button.setToolTipText((String)action.getValue(Action.SHORT_DESCRIPTION));
        return button;
    }

}
