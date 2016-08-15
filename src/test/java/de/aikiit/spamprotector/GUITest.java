/**
 SpamSchutz - simple way to protect your mail adresses from naiive spammers
 Copyright (C) 2011, Aiki IT

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.aikiit.spamprotector;

import de.aikiit.spamprotector.util.LocalizationHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static de.aikiit.spamprotector.util.LocalizationHelper.getParameterizedBundleString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author hirsch
 * @version 2011-12-28, 13:57
 */
@Category(UITest.class)
public class GUITest {

    /**
     * Logger.
     */
    private static final Logger LOG =
            LogManager.getLogger(GUITest.class);

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

    @Test
    public final void ensureYearIs4digits() {
        assertEquals(4, String.valueOf(GUI.now.getYear()).length());

        String msg = getParameterizedBundleString("spamschutz.ui.help.text",
                GUI.now.getYear(),
                de.aikiit.spamprotector.util.Version.VERSION);

        LOG.debug(msg);

        // FIXME issue#25: assertFalse(msg.contains("2."));
    }
}
