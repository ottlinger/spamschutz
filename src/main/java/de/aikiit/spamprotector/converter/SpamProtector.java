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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author hirsch
 * @version 2015-12-05, 21:52
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpamProtector {

    /**
      * Converts an encoded value into a plain one.
      * @param input encoded value as set in an enumeration instance of this class.
      * @return encoded value or input if no mapping is found.
      */
     public static String toPlain(String input) {
         return input;
     }

     /**
      * Converts a plain value into an encoded one.
      * @param input plain value that is transformed by an enumeration instance of this class.
      * @return encoded value or input if no mapping is found.
      */
     public static String toEncoded(String input) {
         return input;
     }
}
