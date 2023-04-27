
package com.schotanus.turtle.view;

import java.util.Map;
import java.util.MissingResourceException;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.schotanus.turtle.AbstractApplication;
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
     * @param actions Map containing {@link Action} objects that can be
     *  retrieved by using the key: {@link Action.NAME}.
     * @return Menu bar filled with menus and menu items.
     * @throws MissingResourceException When a required resource is missing.
     * @pre actions != null
     */
    public static JMenuBar createMenuBar(final Map<String, Action> actions)
            throws MissingResourceException {

        final JMenuBar menuBar = new JMenuBar();

        final String mbContent = AbstractApplication.getLocalizedString(MENU_BAR);

        final String [] menus = Util.tokenize(mbContent);
        for (int i = 0; i < menus.length; i++) {
            System.out.println("Menu:" + menus[i]);

            final JMenu menu = createMenu(menus[i], actions);
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
     * @key Key by which the contents of the menu can be retrieved from the
     *  supplied bundle.
     * @param actions Map containing {@link Action} objects that can be
     *  retrieved by using the key: {@link Action.NAME}.
     * @return Menu bar filled with menus and menu items.
     * @pre resourceBundle != null && key != null && actions != null
     */
    public static JMenu createMenu(final String key, final Map<String, Action> actions) {
        // Label
        final String labelKey = key + MENU_LABEL;
        final String menuLabel = AbstractApplication.getLocalizedString(labelKey);
        final Menu menu = new Menu(menuLabel);
System.out.println(menuLabel);
        GuiCreator.createTooltip(key, menu);

        GuiCreator.createMnemonic(key, menu);

        // Fill menu with menus and menu items
        String menuContent = AbstractApplication.getLocalizedString(key);

        if (menuContent != null) {
            GuiCreator.createMenuItems(actions, menu, menuContent);
        }

        return menu;
	}

    /**
     * Creates a tooltip for the supplied menu.
     * @param key Key to the resource bundle.
     * @param menu The menu to create a tooltip for.
     */
    private static void createTooltip(final String key, final Menu menu) {
        final String toolTipKey = key + MENU_TOOL_TIP_TEXT;
        String toolTip = AbstractApplication.getLocalizedString(toolTipKey);
        if (toolTip != null) {
            menu.setToolTipText(toolTip);
        }
    }

    /**
     * Creates a mnemonic for the supplied menu.
     * @param key Key to the resource bundle.
     * @param menu The mnemonic to create for the supplied menu.
     */
    private static void createMnemonic(final String key, final Menu menu) {
        final String mnemonicKey = key + MENU_MNEMONIC;
        String mnemonic = AbstractApplication.getLocalizedString(mnemonicKey);
        if (mnemonic != null) {
            menu.setMnemonic(mnemonic.charAt(0));
        }
    }

    /**
     * Create menu items for the supplied menu.
     * @param actions Actions for the menu.
     * @param menu The menu for which the menu items should be created.
     */
    private static void createMenuItems(final Map<String, Action> actions,
            final Menu menu, String menuContent) {
        final String [] menuItems = Util.tokenize(menuContent);
System.out.println(menuContent + menuItems.length)        ;
        for (int i = 0; i < menuItems.length; i++) {
            final String menuItem = menuItems[i];
            GuiCreator.createMenuItem(actions, menu, menuItem);
        }
    }

    private static void createMenuItem(final Map<String, Action> actions,
            final Menu menu, final String menuItem) {
        if (menuItem.equals("-") || menuItem.equals("_")) {
            menu.addSeparator();
        } else if (menuItem.startsWith("m") && !menuItem.startsWith("mi")) {
            menu.add(createMenu(menuItem, actions));
        } else {
            final String actionKey = menuItem + Action.NAME;
            String actionName = AbstractApplication.getLocalizedString(actionKey);
System.out.println("actionName" + actionName + actions.get(actionName));            
            if (actionName != null) {
                final Action action = actions.get(actionName);
                if (action != null) {
                    menu.add(action);
                }
            }
        }
    }

}