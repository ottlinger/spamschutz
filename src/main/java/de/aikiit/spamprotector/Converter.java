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
package de.aikiit.spamprotector;

/**
 * Main interface to define spam replacement strategies.
 *
 * @author hirsch
 * @version 2011-04-29, 00:53
 */
public interface Converter {

    /**
     * Main method to replace a given input (not encoded) and returns the
     * converted input.
     *
     * @param input Not encoded or replaced value (should be a character).
     * @return Converted input changed depending on the implemented strategy.
     */
    String replaceString(String input);
}
