/**
 SpamSchutz - simple way to protect your mail addresses from naïve spammers
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
package de.aikiit.spamprotector.util;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Verify (Maven-filter)-included class is available.
 */
public class VersionTest {
    @Test
    public final void checkContents() {
        assertNotNull(de.aikiit.spamprotector.util.Version.VERSION);
    }
}
