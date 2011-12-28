package de.aikiit.spamprotector;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author hirsch
 * @version 2011-12-28, 13:57
 */
public class GUITest {
    @Test
    public final void startGuiNoApplet() {
        GUI gui = new GUI(false);
        assertNotNull(gui);
    }

    @Test
    public final void startGuiApplet() {
        GUI gui = new GUI(true);
        assertNotNull(gui);
    }
}
