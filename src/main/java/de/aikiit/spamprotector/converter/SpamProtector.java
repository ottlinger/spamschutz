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

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Class encapsulates the actual character conversion logics.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpamProtector {

    private static final Map<String, CharacterConverter> ENCODED = Maps.newHashMap();
    private static final Map<Character, CharacterConverter> PLAIN = Maps.newHashMap();

    static {
        // split up characters
        for (CharacterConverter character : CharacterConverter.values()) {
            ENCODED.put(character.getReplacement().toLowerCase(), character);
            PLAIN.put(character.getPlain().charAt(0), character);
        }
    }

    /**
     * Converts an encoded value into a plain one.
     *
     * @param input encoded value as set in an enumeration instance of this class.
     * @return encoded value or input if no mapping is found.
     */
    public static String toPlain(String input) {
        if (!Strings.isNullOrEmpty(input)) {
            String toTransform = input;
            StringBuilder result = new StringBuilder();

            while (!Strings.isNullOrEmpty(toTransform)) {
                int lengthBeforeConversion = toTransform.length();

                for(Map.Entry<String, CharacterConverter> entry : ENCODED.entrySet()) {
                    // cut out any found items
                    String prefix = entry.getKey();
                    if (toTransform.startsWith(prefix)) {
                        result.append(entry.getValue().getPlain());
                        toTransform = toTransform.substring(prefix.length());
                    }
                }

                // in case we did not replace any character trim one and restart
                if (toTransform.length() == lengthBeforeConversion) {
                    result.append(toTransform.charAt(0));
                    toTransform = toTransform.substring(1);
                }
            }

            return result.toString();

        }
        return input;
    }

    /**
     * Converts a plain value into an encoded one.
     *
     * @param input plain value that is transformed by an enumeration instance of this class.
     * @return encoded value or input if no mapping is found.
     */
    public static String toEncoded(String input) {
        if (!Strings.isNullOrEmpty(input)) {
            StringBuilder result = new StringBuilder();

            for (Character character : input.toCharArray()) {
                result.append(PLAIN.containsKey(character) ? PLAIN.get(character).getReplacement() : character);
            }

            return result.toString();
        }
        return input;
    }
}
