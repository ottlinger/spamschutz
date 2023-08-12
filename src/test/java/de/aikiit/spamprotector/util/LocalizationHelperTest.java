/**
 * SpamSchutz - simple way to protect your mail addresses from naïve spammers
 * Copyright (C) 2011, Aiki IT
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.aikiit.spamprotector.util;

import org.junit.Test;

import java.util.Locale;

import static de.aikiit.spamprotector.util.LocalizationHelper.*;

import static org.junit.Assert.assertEquals;

/**
 * Testing resource bundling.
 *
 * @author hirsch
 * @version 23.08.11
 */
public class LocalizationHelperTest {

    /**
     * Retrieve a i18n-value with parameters.
     */
    @Test
    public final void checkParametrizedValueExtraction() {
        assertEquals("Erfolg und dann folgt noch die 7", getParameterizedBundleString("spamschutz.test.param",
                "Erfolg", 7));
        // ignore warning, we want to test what happens here! An empty String or null changes the output.
        assertEquals("{0} und dann folgt noch die {1}", getParameterizedBundleString("spamschutz.test.param",
                new Object[]{}));
    }

    @Test
    public final void fallbackLocale() {
        // WHEN: reset system properties
        System.setProperty("user.language", "");
        System.setProperty("user.country", "");
        setLocale();

        assertEquals(Locale.GERMANY, getLocale());
        assertEquals("de", getLanguage());
    }

    @Test
    public final void setLocaleViaSystemProperties() {
        // WHEN: reset system properties
        final String french = "fr";
        System.setProperty("user.language", french);
        System.setProperty("user.country", "CA");
        setLocale();

        assertEquals(Locale.CANADA_FRENCH, getLocale());
        assertEquals(french, getLanguage());
    }

    @Test
    public final void umlautEncodingWorksCorrectly() {
        assertEquals("ßäü", getBundleString("spamschutz.test.umlauts"));
    }

    @Test
    public final void unknownKey() {
        String unknown = "abcde.unknown";
        assertEquals(unknown, getBundleString(unknown));
    }
}
