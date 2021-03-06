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
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;

import static de.aikiit.spamprotector.util.LocalizationHelper.getBundleString;
/**
 * Application starter class.
 *
 * @author hirsch
 * @version 2011-04-29, 01:51
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AntiSpamApplication {

    /**
     * Helper that starts and initializes the application itself.
     */
    private static void initApplication() {
        SwingUtilities.invokeLater(
                () -> {
                    JFrame frame = new JFrame();
                    GUI g = new GUI(false);
                    frame.setTitle(getBundleString("spamschutz.main.title"));
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setSize(new Dimension(800, 300));
                    frame.add(g);
                    frame.setVisible(true);
                }
        );
    }

    /**
     * Main method that loads the application in a proper size.
     *
     * @param args Arguments from console.
     */
    public static void main(final String[] args) {
        initApplication();
    }
}
