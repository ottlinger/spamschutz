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

import static de.aikiit.spamprotector.util.LocalizationHelper.getBundleString;
import static de.aikiit.spamprotector.util.LocalizationHelper.getLanguage;
import static de.aikiit.spamprotector.util.LocalizationHelper.getLocale;
import static de.aikiit.spamprotector.util.LocalizationHelper.getParameterizedBundleString;
import static de.aikiit.spamprotector.util.LocalizationHelper.setLocale;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing resource bundling and i18n handling.
 */
public class LocalizationHelperTest {

    /**
     * Retrieve a i18n-value with parameters.
     */
    @Test
    public final void checkParametrizedValueExtraction() {
        assertThat(getParameterizedBundleString("spamschutz.test.param", "Erfolg", 7))
                .isEqualTo("Erfolg und dann folgt noch die 7");
        // ignore warning, we want to test what happens here! An empty String or null changes the output.
        assertThat(getParameterizedBundleString("spamschutz.test.param", new Object[]{}))
                .isEqualTo("{0} und dann folgt noch die {1}");
    }

    @Test
    public final void fallbackLocale() {
        // WHEN: reset system properties
        System.setProperty("user.language", "");
        System.setProperty("user.country", "");
        setLocale();

        assertThat(getLocale()).isEqualTo(Locale.GERMANY);
        assertThat(getLanguage()).isEqualTo("de");
    }

    @Test
    public final void setLocaleViaSystemProperties() {
        // WHEN: reset system properties
        final String french = "fr";
        System.setProperty("user.language", french);
        System.setProperty("user.country", "CA");
        setLocale();

        assertThat(getLocale()).isEqualTo(Locale.CANADA_FRENCH);
        assertThat(getLanguage()).isEqualTo(french);
    }

    @Test
    public final void umlautEncodingWorksCorrectly() {
        assertThat(getBundleString("spamschutz.test.umlauts")).isEqualTo("ßäü");
    }

    @Test
    public final void unknownKey() {
        String unknown = "abcde.unknown";
        assertThat(getBundleString(unknown)).isEqualTo(unknown);
    }
}
