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

import de.aikiit.spamprotector.converter.SpamProtector;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * This class contains the main UI of this application (both input windows
 * and all command buttons).
 *
 * Created by IntelliJ IDEA. User: hirsch Date: Apr 10, 2003 Time: 3:12:32 PM
 */
class GUI extends JPanel {

    /**
     * Constant to define the dimension of a text box.
     */
    private static final Dimension BOX_DIMENSION = new Dimension(300, 200);

    /**
     * Launches and configures the main UI component, while taking care whether
     * the application is started as an applet or standalone.
     *
     * @param isApplet Defines whether the application is started as standalone
     *                 <code>false</code> or applet <code>true</code>.
     */
    GUI(final boolean isApplet) {
        SwingUtilities.invokeLater(
                () -> init(isApplet)
        );
    }

    /**
     * Internal helper to initialize the UI depending on the surrounding this
     * application is started.
     *
     * @param isApplet Defines whether the application is started as standalone
     *                 <code>false</code> or applet <code>true</code>.
     */
    private void init(final boolean isApplet) {
        final Calendar calendar = Calendar.getInstance();

        // command help
        final JPanel buttonArea = new JPanel();
        JButton help = new JButton("Hilfe");
        help.setMnemonic('H');
        help.addActionListener(e -> JOptionPane.showMessageDialog(null, "Einfach ins Eingabefeld "
                        + "HTML-Code einfügen!\nDann konvertieren "
                        + "und schon sind weniger SpamAttacken "
                        + "wahrscheinlich"
                        + "\n(C) AIKI IT 2003-"
                        + calendar.get(Calendar.YEAR)
                        + ", Version: "
                        + de.aikiit.spamprotector.util.Version.VERSION,
                "Spam-Schutz - Hilfe",
                JOptionPane.INFORMATION_MESSAGE));

        final JTextField input = new JTextField();
        input.setSize(BOX_DIMENSION);
        input.setPreferredSize(BOX_DIMENSION);
        final JTextField output = new JTextField("Bitte Text eingeben und Button betätigen!");
        output.setSize(BOX_DIMENSION);
        output.setPreferredSize(BOX_DIMENSION);

        // read input field
        final JButton start = new JButton("--->");
        start.setMnemonic('U');
        start.addActionListener(e -> {
            output.setText(SpamProtector.toEncoded(input.getText()));
        });

        // read output field
        final JButton revert = new JButton("<---");
        revert.setMnemonic('v');
        revert.addActionListener(e -> {
            input.setText(SpamProtector.toPlain(output.getText()));
        });

        final JButton reset = new JButton("Reset");
        reset.setMnemonic('R');
        reset.addActionListener(e -> {
            input.setText("");
            output.setText("");
        });

        buttonArea.add(revert);
        buttonArea.add(start);
        buttonArea.add(reset);

        // fields
        final JPanel ioArea = new JPanel(new FlowLayout());

        final JLabel inputLabel = new JLabel("1: Eingabe:");
        inputLabel.setDisplayedMnemonic('1');
        inputLabel.setLabelFor(input);
        ioArea.add(inputLabel);
        ioArea.add(input);

        final JLabel outputLabel = new JLabel("2: Ausgabe:");
        outputLabel.setDisplayedMnemonic('2');
        outputLabel.setLabelFor(output);
        ioArea.add(outputLabel);
        ioArea.add(output);

        // window layout
        this.setLayout(new BorderLayout());
        this.add(buttonArea, BorderLayout.NORTH);
        this.add(ioArea, BorderLayout.CENTER);

        // if started standalone we do need a quit-button
        if (!isApplet) {
            final JButton end = new JButton("Ende");
            end.setMnemonic('E');
            end.addActionListener(e -> System.exit(0));
            buttonArea.add(end);
        }
        buttonArea.add(help);
        this.setVisible(true);
    }
}
