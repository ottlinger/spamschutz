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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Convert real-world examples in order to avoid regressions.
 */
public class SpamProtectorTest {

    @Test
    public void conversionRoundtripNull() {
        assertThat(SpamProtector.toEncoded(null)).isNull();
        assertThat(SpamProtector.toPlain(null)).isNull();

        assertThat(SpamProtector.toEncoded("")).isEmpty();
        assertThat(SpamProtector.toPlain("")).isEmpty();
    }

    @Test
    public void conversionExample() {
        assertThat(SpamProtector.toEncoded(" ")).isEqualTo(CharacterConverter.SPACE.getReplacement());
        assertThat(SpamProtector.toPlain("&nbsp;")).isEqualTo(CharacterConverter.SPACE.getPlain());
    }

    @Test
    public void singleCharactersAreConverted() {
        assertThat(SpamProtector.toEncoded(String.valueOf(' '))).isEqualTo("&nbsp;");
        assertThat(SpamProtector.toEncoded(" ")).isEqualTo("&nbsp;");
    }

    @Test
    public void asciiOnlyIsEncodedCompletelyWithSpacesAndAtSign() {
        String input = "mailto:w oo@suck.er";
        assertThat(SpamProtector.toEncoded(input)).isEqualTo("&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;&nbsp;&#111;" +
                "&#111;&#64;&#115;&#117;&#99;&#107;&#46;&#101;&#114;");
    }

    @Test
    public void nonAsciCharactersAreNotEncodedButTheRest() {
        String input = "mailto:wフィリップoo@suck.нетer";
        assertThat(SpamProtector.toEncoded(input)).isEqualTo("&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;フィリップ&#111;" +
                "&#111;&#64;&#115;&#117;&#99;&#107;&#46;нет&#101;&#114;");
    }

    @Test
    public void asciiIsConvertedToPlainText() {
        String input = "mailto:w oo@suck.er";
        String encoded = "&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;&nbsp;&#111;&#111;&#64;&#115;&#117;&#99;&#107;&#46;&#101;&#114;";

        assertThat(SpamProtector.toPlain(encoded)).isEqualTo(input);
    }

    @Test
    public void mixOfEncodedAndNonAsciiPlainCanBeDecoded() {
        String plain = "mailto:wフィリップoo@suck.нетer";
        String encoded = "&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;フィリップ&#111;&#111;&#64;&#115;&#117;&#99;&#107;&#46;нет&#101;&#114;";
        assertThat(SpamProtector.toPlain(encoded)).isEqualTo(plain);
    }

    @Test
    public void stupidInputDecode() {
        assertThat(SpamProtector.toPlain("")).isEmpty();
        assertThat(SpamProtector.toPlain(null)).isNull();
        assertThat(SpamProtector.toPlain("²")).isEqualTo("²");
    }

    @Test
    public void stupidInputEncode() {
        assertThat(SpamProtector.toEncoded("")).isEmpty();
        assertThat(SpamProtector.toEncoded(null)).isNull();
        assertThat(SpamProtector.toEncoded("²")).isEqualTo("²");
    }

    @Test
    public void issue24LowercasingIsDefaultBehaviour() {
        assertThat(SpamProtector.toPlain(CharacterConverter.CAPITAL_A.getPlain())).isEqualTo("A");
        assertThat(SpamProtector.toPlain(CharacterConverter.A.getPlain())).isEqualTo("a");
    }

}