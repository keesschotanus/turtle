
package com.schotanus.turtle.view;

import java.util.Hashtable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.schotanus.turtle.TurtleApp;
import com.schotanus.util.Util;


/**
 * Generates a localized menu bar and menu.
 * 
 * @author Kees Schotanus
 * @version 1.0
 */
public class GuiCreator {

    /**
     * Used to recognize a help menu in a resource file.
     */
    private static final String MENU_HELP = "mHelp";

    /**
     * Used to recognize a label in a resource file.
     */
    private static final String MENU_LABEL = "Label";

    /**
     * Used to recognize the menu bar in a resource file.
     */
    private static final String MENU_BAR = "menuBar";

    /**
     * Used to recognize a mnemonic in a resource file.
     */
    private static final String MENU_MNEMONIC = "Mnemonic";

    /**
     * Used to recognize a tool tip text in a resource file.
     */
    private static final String MENU_TOOL_TIP_TEXT = "ToolTip";


    /**
     * Private constructor prevents us from creating instances.
     */
    private GuiCreator() {
    }

    /**
     * Creates an entire menu bar from the supplied resource bundle and the
     * supplied actions.
     * @param resourceBundle The resource bundle that will be used to get
     *  resources from.
     * @param actions Hashtable containing {@link Action} objects that can be
     *  retrieved by using the key: {@link Action.NAME}.
     * @return Menu bar filled with menus and menu items.
     * @throws MissingResourceException When a required resource is missing.
     * @pre resourceBundle != null
     * @pre actions != null
     */
    public static JMenuBar createMenuBar(
            final ResourceBundle resourceBundle,
            final Hashtable<String, Action> actions)
            throws MissingResourceException {

        final JMenuBar menuBar = new JMenuBar();

        final String mbContent = resourceBundle.getString(MENU_BAR);
        final String [] menus = Util.tokenize(mbContent);
        for (int i = 0; i < menus.length; i++) {
            final JMenu menu = createMenu(resourceBundle, menus[i], actions);
            if (menus[i].equalsIgnoreCase(MENU_HELP)) {
                menuBar.setHelpMenu(menu);
            } else {
                menuBar.add(menu);
            }
        }
        return menuBar;
	}

    /**
     * Creates a complete menu from the supplied resource bundle,
     * key and the supplied actions.
     * This method is capable of handling nested menus.<br>
     * @param resourceBundle ResourceBundle to get resources from.
     * @key Key by which the contents of the menu can be retrieved from the
     *  supplied bundle.
     * @param actions Hashtable containing {@link Action} objects that can be
     *  retrieved by using the key: {@link Action.NAME}.
     * @return Menu bar filled with menus and menu items.
     * @pre resourceBundle != null && key != null && actions != null
     */
    public static JMenu createMenu(
            final ResourceBundle resourceBundle,
            final String key,
            final Hashtable<String, Action> actions) {
        // Label
        final String labelKey = key + MENU_LABEL;
        final String menuLabel = resourceBundle.getString(labelKey);
        final Menu menu = new Menu(menuLabel);

        // Tool tip
        final String toolTipKey = key + MENU_TOOL_TIP_TEXT;
        String toolTip = resourceBundle.getString(toolTipKey);
        if (toolTip == null) {
            toolTip = TurtleApp.getResourceBundle().getString(toolTipKey);
        }
        menu.setToolTipText(toolTip);

        // Mnemonic
        final String mnemonicKey = key + MENU_MNEMONIC;
        String mnemonic = resourceBundle.getString(mnemonicKey);
        if (mnemonic == null) {
            mnemonic = TurtleApp.getResourceBundle().getString(mnemonicKey);
        }
        if (mnemonic != null) {
            menu.setMnemonic(mnemonic.charAt(0));
        }

        // Fill menu with menus and menu items
        String menuContent = resourceBundle.getString(key);
        if (menuContent == null) {
            menuContent = TurtleApp.getResourceBundle().getString(key);
        }
        if (menuContent != null) {
            final String [] menuItems = Util.tokenize(menuContent);
            for (int i = 0; i < menuItems.length; i++) {
                final String menuItem = menuItems[i];
                if (menuItem.equals("-") || menuItem.equals("_")) {
                    menu.addSeparator();
                } else if (menuItem.startsWith("m") && !menuItem.startsWith("mi")) {
                    menu.add(createMenu(resourceBundle, menuItem, actions));
                } else {
                    final String actionKey = menuItem + Action.NAME;
                    String actionName = resourceBundle.getString(actionKey);
                    if (actionName == null) {
                        actionName = TurtleApp.getResourceBundle().getString(actionKey);
                    }
                    if (actionName != null) {
                        final Action action = (Action)actions.get(actionName);
                        if (action != null) {
                            menu.add(action);
                        }
                    }
                }
            }
        }

        return menu;
	}

}