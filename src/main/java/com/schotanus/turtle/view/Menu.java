package com.schotanus.turtle.view;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Localizable Menu.
 * @author Kees Schotanus
 * @version 1.0
 */
public class Menu extends JMenu {

    /**
     * Constructs a localizable menu from the supplied label.
     * @param label Label for this menu.
     */
    public Menu(final String label) {
        super(label);
    }

    /**
     * Creates and returns a JMenuItem based upon a Swing Action.
     * Sun's implementation only sets the text whereas this implementation
     * sets the tooltip text and other localizable items as well.
     * @param action Action used to create a JMenuItem.
     *  Normally you will supply an object of type {@link CCommandBasedAction}.
     * @return A JMenuItem initialized with data from the supplied action.
     */
    @Override
    public JMenuItem add(Action action) {
        final JMenuItem menuItem = super.add(action);
        menuItem.setText((String)action.getValue(CommandBasedAction.LABEL));

        final String mnemonic = (String)action.getValue(CommandBasedAction.MNEMONIC);
        if (mnemonic != null) {
            menuItem.setMnemonic(mnemonic.charAt(0));
        }

        final String accelerator =
            (String)action.getValue(CommandBasedAction.ACCELERATOR);
        if (accelerator != null) {
            menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator));
        }

        menuItem.setToolTipText(
            (String)action.getValue(Action.SHORT_DESCRIPTION));

        return menuItem;
    }

}
