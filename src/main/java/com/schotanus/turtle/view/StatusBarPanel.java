package com.schotanus.turtle.view;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.BorderFactory;


/**
 * Statusbar panel to easily add a statusbar to a panel and other components to
 * the right of the statusbar in the same panel.
 * @author Kees Schotanus
 * @version 1.0
 */
public class StatusBarPanel extends JPanel {

    /**
     * The next column to which a component may be added.
     * Note that the status bar itself is always added to column 0.
     */
    private int nextComponentColumn = 1;

    /**
     * Constructs a panel capable of holding the supplied status bar
     * (and other optional components) to the right of this status bar.
     * This panel uses GridBagLayout.
     * Do not change this LayoutManager!
     * @param statusBar The status bar to add to this panel.
     * @pre statusBar != null.
     */
    public StatusBarPanel(final Component statusBar) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLoweredBevelBorder());
        addStatusBar(statusBar);
    }

    /**
     * Adds the specified status bar to this panel.
     * <br>The status bar will appear in column 0.
     * @param statusBar The status bar to add to this panel.
     * @pre statusBar != null
     */
    protected void addStatusBar(final Component statusBar) {
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;

        final GridBagLayout gridBagLayout = (GridBagLayout)getLayout();
        gridBagLayout.setConstraints(statusBar, gridBagConstraints);
        add(statusBar);
    }

    /**
     * Helper method to easily add a component to the status bar panel.
     * Components are added from left to right with the status bar itself
     * being the leftmost component.
     * @param component The component to add to the right.
     * @pre component != null.
     */
    public void addComponent(final Component component) {
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = nextComponentColumn++;

        final GridBagLayout gridBagLayout = (GridBagLayout)getLayout();
        gridBagLayout.setConstraints(component, gridBagConstraints);
        add(component);
    }

}
