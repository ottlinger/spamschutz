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

import lombok.NoArgsConstructor;

import java.awt.Toolkit;

/**
 * Created by IntelliJ IDEA. User: hirsch Date: Apr 10, 2003 Time: 1:16:44 PM
 */
@NoArgsConstructor
public class AsciiConverter implements Converter {

    /**
     * Replaces each character with its ASCII-code representation or does
     * nothing if character is not in the range of 'normal' characters.
     *
     * @param input Not encoded or replaced value (should be a character).
     * @return Returns replaced input values.
     */
    public final String replaceString(final String input) {
        StringBuilder codedResult = new StringBuilder();

        for (Character character : input.toCharArray()) {
            // zeichenweise kodieren
            codedResult.append(replaceChar(character));
        }
        Toolkit.getDefaultToolkit().beep();
        return codedResult.toString();
    }     // end of replaceString

    /**
     * zeichenweise in ASCII-Darstellung umwandeln!
     *
     * @param input (Einzelzeichen)
     * @return ASCI-String
     */
    // REVIEW 2011-05-05 check whether this can be replaced by conversion from
    // int/char to get the ascii code of a given character,
    // add testing first to
    // ensure proper functionality
    private static String replaceChar(final char input) {
        switch (input) {
            case '!':
                return "&#33;";

            case '"':
                return "&#34;";

            case '#':
                return "&#35;";

            case '$':
                return "&#36;";

            case '%':
                return "&#37;";

            case '&':
                return "&amp;";

            case '\'':
                return "&#39;";

            case '(':
                return "&#40;";

            case ')':
                return "&#41;";

            case '*':
                return "&#42;";

            case '+':
                return "&#43;";

            case ',':
                return "&#44;";

            case '-':
                return "&#45;";

            case '.':
                return "&#46;";

            case '/':
                return "&#47;";

            case '0':
                return "&#48;";

            case '1':
                return "&#49;";

            case '2':
                return "&#50;";

            case '3':
                return "&#51;";

            case '4':
                return "&#52;";

            case '5':
                return "&#53;";

            case '6':
                return "&#54;";

            case '7':
                return "&#55;";

            case '8':
                return "&#56;";

            case '9':
                return "&#57;";

            case ':':
                return "&#58;";

            case ';':
                return "&#59;";

            case '<':
                return "&#60;";

            case '=':
                return "&#61;";

            case '>':
                return "&#62;";

            case '?':
                return "&#63;";

            case '@':
                return "&#64;";

            case 'A':
                return "&#65;";

            case 'B':
                return "&#66;";

            case 'C':
                return "&#67;";

            case 'D':
                return "&#68;";

            case 'E':
                return "&#69;";

            case 'F':
                return "&#70;";

            case 'G':
                return "&#71;";

            case 'H':
                return "&#72;";

            case 'I':
                return "&#73;";

            case 'J':
                return "&#74;";

            case 'K':
                return "&#75;";

            case 'L':
                return "&#76;";

            case 'M':
                return "&#77;";

            case 'N':
                return "&#78;";

            case 'O':
                return "&#79;";

            case 'P':
                return "&#80;";

            case 'Q':
                return "&#81;";

            case 'R':
                return "&#82;";

            case 'S':
                return "&#83;";

            case 'T':
                return "&#84;";

            case 'U':
                return "&#85;";

            case 'V':
                return "&#86;";

            case 'W':
                return "&#87;";

            case 'X':
                return "&#88;";

            case 'Y':
                return "&#89;";

            case 'Z':
                return "&#90;";

            case '[':
                return "&#91;";

            case '\\':
                return "&#92;";

            case ']':
                return "&#93;";

            case '^':
                return "&#94;";

            case '_':
                return "&#95;";

            case '`':
                return "&#96;";

            case 'a':
                return "&#97;";

            case 'b':
                return "&#98;";

            case 'c':
                return "&#99;";

            case 'd':
                return "&#100;";

            case 'e':
                return "&#101;";

            case 'f':
                return "&#102;";

            case 'g':
                return "&#103;";

            case 'h':
                return "&#104;";

            case 'i':
                return "&#105;";

            case 'j':
                return "&#106;";

            case 'k':
                return "&#107;";

            case 'l':
                return "&#108;";

            case 'm':
                return "&#109;";

            case 'n':
                return "&#110;";

            case 'o':
                return "&#111;";

            case 'p':
                return "&#112;";

            case 'q':
                return "&#113;";

            case 'r':
                return "&#114;";

            case 's':
                return "&#115;";

            case 't':
                return "&#116;";

            case 'u':
                return "&#117;";

            case 'v':
                return "&#118;";

            case 'w':
                return "&#119;";

            case 'x':
                return "&#120;";

            case 'y':
                return "&#121;";

            case 'z':
                return "&#122;";

            case '{':
                return "&#123;";

            case '|':
                return "&#124;";

            case '}':
                return "&#125;";

            case '~':
                return "&#126;";

            // do nothing if any other character is found
            default:
                return String.valueOf(input);
        } // switch
    }   // end of replaceChar

} // end of AsciiConverter
