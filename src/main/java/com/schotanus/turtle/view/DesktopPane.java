package com.schotanus.turtle.view;

import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;


/**
 * DesktopPane to which internal frames can easily be added.
 * Desktop panes are used by {@link AbstractMDIFrame} to provide the MDI
 * (Multiple Document Interface) look & feel.
 * @author Kees Schotanus
 * @version 1.0
 */
public class DesktopPane extends JDesktopPane {

    /**
     * Adds an internal frame to the
     * {@link javax.swing.JDesktopPane#DEFAULT_LAYER} and makes it the selected
     * frame.
     * @param internalFrame The JInternalFrame to add.
     * @pre internalFrame != null.
     */
    public void addInternalFrame(final JInternalFrame internalFrame) {
        add(internalFrame, JLayeredPane.DEFAULT_LAYER);
        try {
            internalFrame.setSelected(true);
        } catch (Exception ignore) {
            // The frame isn't selected, so what, no need to handle this!
        }
    }

    /**
     * Closes all internal frames that have been added.
     * @throws PropertyVetoException When an internal frame uses its veto to
     *  prevent it from closing.
     */
    public void closeAllFrames() throws PropertyVetoException {
        final JInternalFrame [] frames = getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            frames[i].setClosed(true);
        }
    }

}
