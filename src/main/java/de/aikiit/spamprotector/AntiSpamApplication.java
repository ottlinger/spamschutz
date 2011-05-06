package de.aikiit.spamprotector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Application starter class to perform local testing.
 *
 * @author hirsch
 * @version 2011-04-29, 01:51
 */
public final class AntiSpamApplication {
    /**
     * Avoid instantiation of this class.
     */
    private AntiSpamApplication() {
        // empty default
    }

    /**
     * Main method that loads the application in a proper size.
     *
     * @param args Arguments from console.
     */
    public static void main(final String[] args) {
        JFrame frame = new JFrame();

        GUI g = new GUI(false);
        frame.setTitle("spamschutz - der einfachste "
                + "Schutz gegen Spider-Spam");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(GUI.APP_DIMENSION);
        frame.add(g);
        frame.setVisible(true);
    } // end of main
}
