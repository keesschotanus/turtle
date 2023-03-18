package com.schotanus.turtle.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import com.schotanus.turtle.AbstractApplication;


/**
 * Abstraction of a MDI (Multiple Document Interface) Frame.
 * @author Kees Schotanus
 * @version 1.0
 */
abstract class AbstractMDIFrame extends JFrame {

    /**
     * Desktop pane to which internal frames should be added.
     */
    private DesktopPane desktopPane = new DesktopPane();

    /**
     * Constructs this frame to hold multiple internal frames.
     * It will get a status bar and actually make this frame visible,
     * using reasonable dimensions.
     */
    public AbstractMDIFrame() {
        /*
         * Add desktop pane to CENTER of content pane.
         * Some swing examples replace the content pane with a desktop pane but
         * this prevents a status bar to appear in the main frame.
         */
        getContentPane().add(desktopPane, BorderLayout.CENTER);

        addStatusBar();

        // Add a window listener to close this frame.
        WindowListener windowListener = new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                close();
            }
        };
        addWindowListener(windowListener);

        // Show with a reasonable size.
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(50, 50, (int)(screenSize.width * 0.75),
            (int)(screenSize.height * 0.75));
        setVisible(true);
    }

    /**
     * Constructs this frame using the supplied title.
     * @param title Title of this frame.
     * @see #AbstractMDIFrame()
     */
    public AbstractMDIFrame(final String title) {
        this();
        setTitle(title);
    }

    /**
     * Adds an internal frame to this MDIframe.
     * Actually the internal frame is added to the desktop pane.
     * @param internalFrame The JInternalFrame to add.
     * @pre internalFrame != null
     */
    public void addInternalFrame(final JInternalFrame internalFrame) {
        desktopPane.addInternalFrame(internalFrame);
        internalFrame.setVisible(true);
    }

    /**
     * Adds a status bar to the main frame.
     * This implementation actually adds a status bar panel to the frame and
     * adds a status bar to this panel.<br>
     */
    protected void addStatusBar() {
        final StatusBar statusBar = new StatusBar(
            AbstractApplication.getStatusModel(), true, true);
        final StatusBarPanel statusBarPanel = new StatusBarPanel(statusBar);
        getContentPane().add(statusBarPanel, BorderLayout.SOUTH);
        AbstractApplication.changeStatusModel("Initializing...");
    }

    /**
     * Closes the internal frames this MDI frame contains.
     * It surprised me that internal frames do not receive events to notify
     * the closing of the MDI frame hence I added this method.
     */
    private void close() {
        try {
            desktopPane.closeAllFrames();
            System.exit(0);
        } catch (PropertyVetoException exception) {
            // Frame used veto to prevent it from closing
        }
    }

}
