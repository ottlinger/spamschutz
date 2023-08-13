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
package de.aikiit.spamprotector.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Convert real-world examples in order to avoid regressions.
 */
public class SpamProtectorTest {

    @Test
    public void conversionRoundtripNull() {
        assertNull(SpamProtector.toEncoded(null));
        assertNull(SpamProtector.toPlain(null));

        assertEquals("", SpamProtector.toEncoded(""));
        assertEquals("", SpamProtector.toPlain(""));
    }

    @Test
    public void conversionExample() {
        assertEquals(CharacterConverter.SPACE.getReplacement(), SpamProtector.toEncoded(" "));
        assertEquals(CharacterConverter.SPACE.getPlain(), SpamProtector.toPlain("&nbsp;"));
    }

    @Test
    public void singleCharactersAreConverted() {
        assertEquals("&nbsp;", SpamProtector.toEncoded(String.valueOf(' ')));
        assertEquals("&nbsp;", SpamProtector.toEncoded(" "));
    }

    @Test
    public void asciiOnlyIsEncodedCompletelyWithSpacesAndAtSign() {
        String input = "mailto:w oo@suck.er";
        assertEquals("&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;&nbsp;&#111;" +
                "&#111;&#64;&#115;&#117;&#99;&#107;&#46;&#101;&#114;", SpamProtector.toEncoded(input));
    }

    @Test
    public void nonAsciCharactersAreNotEncodedButTheRest() {
        String input = "mailto:wフィリップoo@suck.нетer";
        assertEquals("&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;フィリップ&#111;" +
                "&#111;&#64;&#115;&#117;&#99;&#107;&#46;нет&#101;&#114;", SpamProtector.toEncoded(input));
    }

    @Test
    public void asciiIsConvertedToPlainText() {
        String input = "mailto:w oo@suck.er";
        String encoded = "&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;&nbsp;&#111;&#111;&#64;&#115;&#117;&#99;&#107;&#46;&#101;&#114;";

        assertEquals(input, SpamProtector.toPlain(encoded));
    }

    @Test
    public void mixOfEncodedAndNonAsciiPlainCanBeDecoded() {
        String plain = "mailto:wフィリップoo@suck.нетer";
        String encoded = "&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;フィリップ&#111;&#111;&#64;&#115;&#117;&#99;&#107;&#46;нет&#101;&#114;";
        assertEquals(plain, SpamProtector.toPlain(encoded));
    }

    @Test
    public void stupidInputDecode() {
        assertEquals("", SpamProtector.toPlain(""));
        assertNull(SpamProtector.toPlain(null));
        assertEquals("²", SpamProtector.toPlain("²"));
    }

    @Test
    public void stupidInputEncode() {
        assertEquals("", SpamProtector.toEncoded(""));
        assertNull(SpamProtector.toEncoded(null));
        assertEquals("²", SpamProtector.toEncoded("²"));
    }

    @Test
    public void issue24LowercasingIsDefaultBehaviour() {
        assertEquals("A", SpamProtector.toPlain(CharacterConverter.CAPITAL_A.getPlain()));
        assertEquals("a", SpamProtector.toPlain(CharacterConverter.A.getPlain()));
    }

}