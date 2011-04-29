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
