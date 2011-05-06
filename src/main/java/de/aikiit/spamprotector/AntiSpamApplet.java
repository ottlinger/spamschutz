package de.aikiit.spamprotector;

import java.applet.Applet;

/**
 * Main class that starts an applet with the main UI component.
 * <p/>
 * User: hirsch Date: Apr 10, 2003 Time: 1:24:52 PM
 */
public class AntiSpamApplet extends Applet {
    /**
     * Loads UI for this applet.
     */
    public final void init() {
        add(new GUI(true));
        setSize(GUI.APP_DIMENSION);
    }  // end of init
} // end of class
