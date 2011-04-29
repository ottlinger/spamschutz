package de.aikiit.spamprotector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Application starter class to work.
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
        frame.setTitle("AntiSpamApplication - der einfachste Schutz for "
                + "Spider-Spam");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        frame.add(g);
        frame.setVisible(true);
    } // end of main
}
