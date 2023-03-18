package com.schotanus.turtle.view;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Color;

import com.schotanus.turtle.model.MessageSeverity;
import com.schotanus.turtle.model.status.StatusEvent;
import com.schotanus.turtle.model.status.StatusListener;
import com.schotanus.turtle.model.status.StatusModel;


/**
 * Simple implementation of a status bar bean.
 * <br>This version uses a JLabel as the status bar.
 * It is capable of showing messages differently depending upon the severity of the message.
 * @author Kees Schotanus
 * @version 1.2
 */
public class StatusBar extends JLabel implements Serializable, StatusListener {

    /**
     * Implementation note:
     * It is important to realize how initialization of this class works.
     * updateUI() gets called (using polymorphism) before member initialization!
     */

    /**
     * The status model to which this status bar is listening.
     */
    private StatusModel statusModel;

    /**
     * Determines whether the message should be displayed using different colors
     * for the different severity codes.
     * When true the severity code determines the color, when false the
     * standard look and feel color will be used no matter what the severity is.
     */
    private boolean useColoredText = false;

    /**
     * Determines if icons should be used in the status bar.
     * Icons normally reflect the severity of the message.
     */
    private boolean useIcons = false;

    /**
     * Look and feel color for a label for the current look and feel.
     */
    private Color lookAndFeelColor =
        UIManager.getDefaults().getColor("Label.foreground");

    /**
     * Determines the color to be used when a {@link MessageSeverity#NORMAL}
     * message is received and {@link #hasColoredText()} returns true.
     */
    private Color infoColor = Color.black;

    /**
     * Determines the color to be used when a {@link MessageSeverity#WARNING} is
     * received and {@link #hasColoredText()} returns true.
     */
    private Color warningColor = Color.orange;

    /**
     * Determines the color to be used when an {@link MessageSeverity#ERROR} is
     * received and {@link #hasColoredText()} returns true.
     */
    private Color errorColor = Color.red;

    /**
     * Determines the icon to be used when a {@link MessageSeverity#NORMAL}
     * message is received and {@link #hasIcons()} returns true.
     */
    private ImageIcon infoIcon = new ImageIcon(getClass().getResource(
        "/com/schotanus/turtle/view/images/NormalMessage.gif"));

    /**
     * Determines the icon to be used when a {@link MessageSeverity#WARNING}
     * message is received and {@link #hasIcons()} returns true.
     */
    private ImageIcon warningIcon = new ImageIcon(getClass().getResource(
        "/com/schotanus/turtle/view/images/WarningMessage.gif"));

    /**
     * Determines the icon to be used when a {@link MessageSeverity#ERROR}
     * message is received and {@link #hasIcons()} returns true.
     */
    private ImageIcon errorIcon = new ImageIcon(getClass().getResource(
        "/com/schotanus/turtle/view/images/ErrorMessage.gif"));

    /**
     * Constructor to make this a bean.
     */
    public StatusBar() {
        super();
    }

    /**
     * Constructs a status bar and automatically registers itself with the
     * specified status model.
     * @param statusModel StatusModel to which this statusbar should listen.
     * @param useColoredText Specify true to translate the severity of a message
     *  into colors used for the message.
     *  Specify false to use the default look and feel color.
     * @param useIcons Specify true to use an Icon to the left of the status
     *  bar.
     *  The icon image will depend on the severity of the message.
     *  Specify false to not use icons.
     * @throws NullPointerException When the supplied statusModel is null.
     */
    public StatusBar(
            final StatusModel statusModel,
            final boolean useColoredText,
            final boolean useIcons) {
        setStatusModel(statusModel);
        this.useColoredText = useColoredText;
        this.useIcons = useIcons;
    }

    /**
     * Gets the StatusModel.
     * @return Status model to which this status bar is listening.
     */
    public StatusModel getStatusModel() {
        return statusModel;
    }

    /**
     * Sets the status model to which this status bar should be listening.
     * When a current model exists, the current listener is removed from the
     * model, then the new model is saved and this status bar will listen to
     * the new model unless the supplied model is null.
     * @param statusModel Status model to which this status bar should be
     *  listening.
     *  Supplying null will effectively remove this status bar as a listener.
     */
    public void setStatusModel(final StatusModel statusModel) {
        if (this.statusModel != null) {
            statusModel.removeStatusListener(this);
        }
        this.statusModel = statusModel;
        if (statusModel != null) {
            statusModel.addStatusListener(this);
        }
    }

    /**
     * Determines whether colored text should be used.
     * @return True when messages are displayed with a color that depends upon
     *  the severity of the message, false when the standard look and feel
     *  color is used.
     */
    public boolean hasColoredText() {
        return useColoredText;
    }

    /**
     * Sets whether messages should be displayed with a color that depends
     * upon the severity of the message.
     * @param useColoredText True when text should be colored, false when the
     *  standard look and feel color should be used.
     */
    public void setColoredText(final boolean useColoredText) {
        this.useColoredText = useColoredText;
    }

    /**
     * Gets the color for messages with severity
     * {@link MessageSeverity#NORMAL}.
     * @return Color that will be used to display messages when a
     *  {@link MessageSeverity#NORMAL} message is received and
     *  {@link #hasColoredText()} returns true.
     */
    public Color getInfoColor() {
        return infoColor;
    }

    /**
     * Sets the color for messages with severity
     * {@link MessageSeverity#NORMAL}.
     * Note: this call only has effect when {@link #hasColoredText()}
     * returns true.
     * @param infoColor Color for messages with severity
     *  {@link MessageSeverity#NORMAL}.
     */
    public void setInfoColor(final Color infoColor) {
        if (infoColor != null) {
            this.infoColor = infoColor;
        }
    }

    /**
     * Gets the color for messages with severity
     * {@link MessageSeverity#WARNING}.
     * @return Color that will be used to display messages when a
     *  {@link MessageSeverity#WARNING} message is received and
     *  {@link #hasColoredText()} returns true.
     */
    public Color getWarningColor() {
        return warningColor;
    }

    /**
     * Sets the color for messages with severity
     * {@link MessageSeverity#WARNING}.
     * Note: this call only has effect when {@link #hasColoredText()}
     * returns true.
     * @param warningColor Color for messages with severity
     *  {@link StatusModel#WARNING}.
     */
    public void setWarningColor(final Color warningColor) {
        if (warningColor != null) {
            this.warningColor = warningColor;
        }
    }

    /**
     * Gets the color for messages with severity {@link MessageSeverity#ERROR}.
     * @return Color that will be used to display messages when a
     *  {@link MessageSeverity#ERROR} message is received and
     *  {@link #hasColoredText()} returns true.
     */
    public Color getErrorColor() {
        return errorColor;
    }

    /**
     * Sets the color for messages with severity {@link MessageSeverity#ERROR}.
     * Note: this call only has effect when {@link #hasColoredText()}
     * returns true.
     * @param errorColor Color for messages with severity
     *  {@link MessageSeverity#ERROR}.
     */
    public void setErrorColor(final Color errorColor) {
        if (errorColor != null) {
            this.errorColor = errorColor;
        }
    }

    /**
     * Determines whether icons should be used with messages.
     * @return True when an icon should be displayed in front of the message,
     *  false otherwise.
     *  The displayed icon will depend upon the severity of the message.
     */
    public boolean hasIcons() {
        return useIcons;
    }

    /**
     * Sets whether an icon should be displayed in front of the message.
     * @param useIcons True when icons should be used, false otherwise.
     */
    public void setIcons(final boolean useIcons) {
        this.useIcons = useIcons;
    }

    /**
     * Gets the icon for messages with severity {@link MessageSeverity#NORMAL}.
     * @return Icon that will be used to display messages when a
     *  {@link MessageSeverity#NORMAL} message is received and
     *  {@link #hasIcons()} returns true.
     */
    public ImageIcon getInfoIcon() {
        return infoIcon;
    }

    /**
     * Sets the icon for messages with severity {@link MessageSeverity#NORMAL}.
     * Note: this call only has effect when {@link #hasIcons()} returns true.
     * @param infoIcon Icon for messages with severity
     *  {@link MessageSeverity#NORMAL}.
     */
    public void setInfoIcon(final ImageIcon infoIcon) {
        this.infoIcon = infoIcon;
    }

    /**
     * Gets the icon for messages with severity
     * {@link MessageSeverity#WARNING}.
     * @return Icon that will be used to display messages when a
     *  {@link MessageSeverity#WARNING} message is received and
     *  {@link #hasIcons()} returns true.
     */
    public ImageIcon getWarningIcon() {
        return warningIcon;
    }

    /**
     * Sets the icon for messages with severity
     * {@link MessageSeverity#WARNING}.
     * Note: this call only has effect when {@link #hasIcons()} returns true.
     * @param warningIcon Icon for messages with severity
     *  {@link MessageSeverity#WARNING}.
     */
    public void setWarningIcon(final ImageIcon warningIcon) {
        this.warningIcon = warningIcon;
    }

    /**
     * Gets the icon for messages with severity {@link MessageSeverity#ERROR}.
     * @return Icon that will be used to display messages when a
     *  {@link MessageSeverity#ERROR} message is received and
     *  {@link #hasIcons()} returns true.
     */
    public ImageIcon getErrorIcon() {
        return errorIcon;
    }

    /**
     * Sets the icon for messages with severity {@link MessageSeverity#ERROR}.
     * Note: this call only has effect when {@link #hasIcons()} returns true.
     * @param errorIcon Icon for messages with severity
     *  {@link MessageSeverity#ERROR}.
     */
    public void setErrorIcon(final ImageIcon errorIcon) {
        this.errorIcon = errorIcon;
    }

    /**
     * Called when the model of the status model to which we are registered
     * changed.
     * All we do here is display the data (in the proper color and with the
     * proper icon).
     * @param statusEvent Status event supplied to us by the status model.
     */
    public void statusModelHasChanged(final StatusEvent statusEvent) {
        final MessageSeverity severity = statusEvent.getSeverity();

        // Handle messages in different colors.
        if (useColoredText) {
            if (severity == MessageSeverity.ERROR) {
                setForeground(errorColor);
            } else if (severity == MessageSeverity.WARNING) {
                setForeground(warningColor);
            } else {
                setForeground(infoColor);
            }
        } else {
            setForeground(lookAndFeelColor);
        }

        // Handle icons
        if (useIcons) {
            ImageIcon icon;
            if (severity == MessageSeverity.ERROR) {
                icon = errorIcon;
            } else if (severity == MessageSeverity.WARNING) {
                icon = warningIcon;
            } else {
                icon = infoIcon;
            }
            if (getIcon() != icon) {
                setIcon(icon);
            }
        }

        setText(statusEvent.getMessage());
    }

    /**
     * Retrieves and stores the color for a Label.
     */
    public void updateUI() {
        super.updateUI();
        /**
         * This method automatically gets called when this object has to update
         * its user interface (when the look and feel is initialized or changed).
         */
        lookAndFeelColor = UIManager.getDefaults().getColor("Label.foreground");
        if (lookAndFeelColor == null) {
            // Use black when the default color has not been set!
            lookAndFeelColor = Color.black;
        }
    }

}
