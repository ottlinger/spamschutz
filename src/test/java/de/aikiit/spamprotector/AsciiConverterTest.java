package de.aikiit.spamprotector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: hirsch
 * Date: Apr 10, 2003
 * Time: 1:20:02 PM
 * To change this template use Options | File Templates.
 */

public class AsciiConverterTest {
    @org.junit.Test
    public void testConversionOnString() {
        AsciiConverter converter = new AsciiConverter();
        String in = "mailto:woo@suck.er";

        String out = converter.replaceString(in);
        assertEquals("&#109;&#97;&#105;&#108;&#116;&#111;&#58;&#119;&#111;" +
                "&#111;&#64;&#115;&#117;&#99;&#107;&#46;&#101;&#114;", out);
        // System.out.println("Umwandlg: "+ k.replaceChar(c));
    }   // end of main

    @org.junit.Test
    public void testConversionOnSingleCharacter() {
        AsciiConverter converter = new AsciiConverter();
        assertEquals("&#42;", converter.replaceString("*"));
        // TODO insert encoding into conversion
        // TODO http://www.herongyang.com/Unicode/Encoding-Conversion-Enter-Unicode-Data-in-Java-Program.html
        // assertEquals("U+00A5", converter.replaceString("U+00A5"));
    }

} // end of class
