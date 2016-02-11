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
package de.aikiit.spamprotector.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author hirsch
 * @version 2015-12-04, 21:39
 */
public class CharacterConverterTest {

    @Test
    public void numberOfConvertibleCharacters() {
        assertEquals(95, CharacterConverter.values().length);
    }

    @Test
    public void getPlainAndEncodedValue() {
        assertEquals(" ", CharacterConverter.SPACE.getPlain());
        assertEquals("&nbsp;", CharacterConverter.SPACE.getReplacement());
    }

}