
package com.schotanus.turtle.view;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import com.schotanus.turtle.TurtleApp;

/**
 * Swing Action that uses the Command pattern.
 * Many times the user interface of an Action can be re-used but the
 * implementation of the actionPerformed(...) method can not be re-used.
 * The command pattern is used here to separate the user interface from the
 * action.
 * @author Kees Schotanus
 * @version 1.0
 */
public class CommandBasedAction extends AbstractAction {

    /**
     * Key used to get the label for an action.
     */
    public static final String LABEL = "Label";

    /**
     * Key used to get the mnemonic for an action.
     */
    public static final String MNEMONIC = "Mnemonic";

    /**
     * Key used to get the accelerator for an action.
     */
    public static final String ACCELERATOR = "Accelerator";

    /**
     * Commandable that will execute a command.
     * this is the actual 'action' part of a Swing Action.
     */
    private CommandableAction commandable;

    /**
     * Constructs a localizable, command based Action.
     * The following keys are appended to the supplied key and then read from a
     * resource file:
     * <table><th>Key</th><th>Description</th>
     * <tr><td>Name</td><td>Name of the action</td></tr>
     * <tr><td>Label</td><td>Label on button or menu item</td></tr>
     * <tr><td>Mnemonic</td><td>Mnemonic for menu item</td></tr>
     * <tr><td>Accelerator</td><td>Keyboard accelerator</td></tr>
     * <tr><td>ShortDescription</td><td>Tool tip text</td></tr>
     * <tr><td>LongDescription</td><td>Status bar text</td></tr>
     * <tr><td>SmallIcon</td><td>Icon on button or menu item</td></tr>
     * </table>
     * @param resourceBundle Used to fetch localized information from.
     * @param key Key to get information from the resource bundle.
     * @param commandable Object containing the actual action part of a Swing
     *  Action.
     * @return Localized Action.
     *  On the returned action you will always get a value
     *  (using getValue(...)) when using one of the following keys:
     *  {@link LABEL}, {@link Action.NAME}.
     * @pre resourceBundle != null
     * @pre key != null
     * @pre commandable != null
     */
    public CommandBasedAction(
            final ResourceBundle resourceBundle,
            final String key,
            final CommandableAction commandable) {

        this.commandable = commandable;
        commandable.setAction(this);

        String value;
        String compositeKey;

        // Handle mandatory (for an Action) name.
        compositeKey = key + NAME;
        value = resourceBundle.getString(compositeKey);
        if (value == null) {
            value = TurtleApp.getResourceBundle().getString(compositeKey);
        }
        putValue(NAME, value);

        // Handle optional label
        compositeKey = key + LABEL;
        value = resourceBundle.getString(compositeKey);
        if (value == null) {
            value = TurtleApp.getResourceBundle().getString(compositeKey);
        }
        putValue(LABEL, value);

        // Handle optional mnemonic
        compositeKey = key + MNEMONIC;
        value = resourceBundle.getString(compositeKey);
        if (value == null) {
            value = TurtleApp.getResourceBundle().getString(compositeKey);
        }
        putValue(MNEMONIC, value);

        // Handle optional accelerator
        compositeKey = key + ACCELERATOR;
        value = resourceBundle.getString(compositeKey);
        if (value == null) {
            value = TurtleApp.getResourceBundle().getString(compositeKey);
        }
        putValue(ACCELERATOR, value);

        // Handle short description
        compositeKey = key + SHORT_DESCRIPTION;
        value = resourceBundle.getString(compositeKey);
        if (value == null) {
            value = TurtleApp.getResourceBundle().getString(compositeKey);
        }
        if (value != null) {
            putValue(SHORT_DESCRIPTION, value);
        }

        // Handle long description
        compositeKey = key + LONG_DESCRIPTION;
        value = resourceBundle.getString(compositeKey);
        if (value == null) {
            value = TurtleApp.getResourceBundle().getString(compositeKey);
        }
        if (value != null) {
            putValue(LONG_DESCRIPTION, value);
        }

        // Handle icon
        compositeKey = key + SMALL_ICON;
        value = resourceBundle.getString(compositeKey);
        if (value == null) {
            value = TurtleApp.getResourceBundle().getString(compositeKey);
        }
        if (value != null) {
            final URL url = getClass().getResource(value);
            if (url != null) {
                putValue(SMALL_ICON, new ImageIcon(url));
            }
        }

    }

    /**
     * Patches the action through to the real action part of this Swing Action.
     * @param event ActionEvent.
     */
    public void actionPerformed(final ActionEvent event) {
        commandable.execute();
    }
}

