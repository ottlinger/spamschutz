package de.aikiit.spamprotector;
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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: hirsch
 * Date: Apr 10, 2003
 * Time: 1:20:02 PM
 */

public class AsciiConverterTest {
    @Test
    public void testConversionOnString() {
        AsciiConverter converter = new AsciiConverter();
        String in = "mailto:woo@suck.er";

        String out = converter.replaceString(in);
        assertEquals("&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;&#111;" +
                "&#111;&#64;&#115;&#117;&#99;&#107;&#46;&#101;&#114;", out);
        // System.out.println("Umwandlg: "+ k.replaceChar(c));
    }   // end of main

    @Test
    public void testConversionOnSingleCharacter() {
        AsciiConverter converter = new AsciiConverter();
        assertEquals("&#42;", converter.replaceString("*"));
        // TODO insert encoding into conversion
        // TODO http://www.herongyang.com/Unicode/Encoding-Conversion-Enter-Unicode-Data-in-Java-Program.html
        // assertEquals("U+00A5", converter.replaceString("U+00A5"));
    }

} // end of class
