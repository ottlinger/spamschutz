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
import static org.junit.Assert.assertNull;

/**
 * @author hirsch
 * @version 2015-12-05, 21:53
 */
public class SpamProtectorTest {

    @Test
    public void conversionRoundtripNull() {
        assertNull(SpamProtector.toEncoded(null));
        assertNull(SpamProtector.toPlain(null));
    }

    @Test
    public void conversionExample() {
        assertEquals(CharacterConverter.SPACE.getReplacement(), SpamProtector.toEncoded(" "));
        assertEquals(CharacterConverter.SPACE.getPlain(), SpamProtector.toPlain("&nbsp;"));
    }

}
