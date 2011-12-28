package de.aikiit.spamprotector;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author hirsch
 * @version 2011-12-28, 13:20
 */
public class AntiSpamAppletTest {
    @Test
    public final void instantiationDone() {
        AntiSpamApplet applet = new AntiSpamApplet();
        applet.init();
        assertNotNull(applet);
    }
}
