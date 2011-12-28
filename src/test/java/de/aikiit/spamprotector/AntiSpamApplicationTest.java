package de.aikiit.spamprotector;

import org.junit.Test;

/**
 * @author hirsch
 * @version 2011-12-28, 13:26
 */
public class AntiSpamApplicationTest {
    @Test
    public final void instantiationDone() {
        AntiSpamApplication.initApplication();
        AntiSpamApplication.main(null);
    }
}
