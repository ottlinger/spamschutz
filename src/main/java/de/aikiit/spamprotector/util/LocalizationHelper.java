/**
 * SpamSchutz - simple way to protect your mail addresses from naiive spammers
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

import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Helper to deal with localizations and ease the usage of
 * resource bundles within spamprotector.
 *
 * @author hirsch
 * @version 23.08.11
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalizationHelper {

    /**
     * Logger.
     */
    private static final Logger LOG =
            LogManager.getLogger(LocalizationHelper.class);

    /**
     * ResourceBundle used for this application.
     */
    private static final String BASE_NAME = "spamprotector";
    private static final Locale FALLBACK_LOCALE = Locale.GERMANY;

    private static ResourceBundle BUNDLE;
    private static Locale LOCALE;
    private static MessageFormat FORMAT;

    static {
        setLocale();
    }

    /**
     * Set locale depending on system properties, in case of errors fallback is Locale.GERMANY.
     */
    public static void setLocale() {
        String userLanguage = System.getProperty("user.language");
        String userCountry = System.getProperty("user.country");

        LOG.info(String.format("Your system emits the following l10n-properties: language=%s, country=%s", userLanguage, userCountry));

        if (Strings.isNullOrEmpty(userLanguage) || Strings.isNullOrEmpty(userCountry)) {
            LOCALE = FALLBACK_LOCALE;
            LOG.info("Falling back to locale " + LOCALE);
        } else {
            LOCALE = new Locale(userLanguage, userCountry);
            LOG.info("Setting locale to " + LOCALE);
        }

        BUNDLE = ResourceBundle.getBundle(BASE_NAME, LOCALE);
        FORMAT = new MessageFormat("");
        FORMAT.setLocale(LOCALE);
    }

    /**
     * @return the currently set Locale of this application. Fallback is Locale.GERMANY.
     */
    public static Locale getLocale() {
        if (LOCALE == null) {
            LOG.warn("Returning fallback Locale for Germany - please make sure you've configured your environment correctly via system properties 'user.country'/'user.language'.");
            return FALLBACK_LOCALE;
        }
        return LOCALE;
    }

    /**
     * @return the currently set language
     */
    public static String getLanguage() {
        return getLocale().getLanguage();
    }

    /**
     * Helper function to retrieve a given key
     * from the underlying resource bundle.
     *
     * @param key Key to retrieve from the bundle,
     *            e.g. <i>spamprotector.foo.title</i>
     * @return Returns the value from the bundle.
     */
    public static String getBundleString(final String key) {
        LOG.debug("Retrieving key " + key);
        try {
            return BUNDLE.getString(key);
        } catch (MissingResourceException mre) {
            LOG.error("Retrieving unknown key " + key + ". Please fix your property files.");
            return key;
        }
        // l18n basics:
        // http://www.kodejava.org/examples/220.html
        // l18n buttons:
        // http://www.java2s.com/Code/Java/I18N/Createonebuttoninternationalizedly.htm
        // l18n with parameters:
        // http://www.java2s.com/Code/Java/I18N/ResourceBundlewithparameterposition.htm
        // parameters are a but uneasier than with grails -
        // http://download.oracle.com/javase/tutorial/i18n/format/messageFormat.html
        // encoding issues / eclipse plugin:
        // http://stackoverflow.com/questions/863838/problem-with-java-properties-utf8-encoding-in-eclipse
    }

    /**
     * Helper function to retrieve a given key
     * from the underlying resource bundle while
     * applying localization parameters.
     *
     * @param key        Key to retrieve from the bundle,
     *                   e.g. <i>fotorenamer.foo.parameteredtitle</i>.
     * @param parameters Object array with all parameters.
     * @return Returns the value from the bundle
     * with the given parameters applied.
     * @see <a href="http://download.oracle.com/javase/tutorial/i18n/format/messageFormat.html">
     * I18N-tutorial</a>
     */
    public static String getParameterizedBundleString(final String key, final Object... parameters) {
        LOG.debug("Applying " + ((parameters == null) ? null : Arrays.toString(parameters)) + " parameters to " + key);
        FORMAT.applyPattern(getBundleString(key));
        return FORMAT.format(parameters);
    }

}
