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
     * Preferred size of the complete application window.
     */
    static final Dimension APP_DIMENSION = new Dimension(800, 300);

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
    }   // end of Konstruktor

    /**
     * Internal helper to initialize the UI depending on the surrounding this
     * application is started.
     *
     * @param isApplet Defines whether the application is started as standalone
     *                 <code>false</code> or applet <code>true</code>.
     */
    private void init(final boolean isApplet) {
        final JTextField eingabe;
        final JTextField ausgabe;
        JPanel knoepfe;
        JButton ende;
        JButton start;
        JButton reset;
        JButton hilfe;
        JPanel ioBereich;
        JLabel eing;
        JLabel ausg;

        final Calendar calendar = Calendar.getInstance();

        // command help
        knoepfe = new JPanel();
        hilfe = new JButton("Hilfe");
        hilfe.setMnemonic('H');
        hilfe.addActionListener(e -> JOptionPane.showMessageDialog(null, "Einfach ins Eingabefeld "
                + "HTML-Code einfügen!\nDann konvertieren "
                + "und schon sind weniger SpamAttacken "
                + "wahrscheinlich"
                + "\n(C) AIKI IT 2003-"
                + calendar.get(Calendar.YEAR)
                + ", Version: "
                + de.aikiit.spamprotector.util.Version.VERSION,
                "Spam-Schutz - Hilfe",
                JOptionPane.INFORMATION_MESSAGE));

        eingabe = new JTextField();
        eingabe.setSize(BOX_DIMENSION);
        eingabe.setPreferredSize(BOX_DIMENSION);
        ausgabe = new JTextField("Bitte Text eingeben und Button betätigen!");
        ausgabe.setSize(BOX_DIMENSION);
        ausgabe.setPreferredSize(BOX_DIMENSION);


        start = new JButton("Umwandeln");
        start.setMnemonic('U');
        start.addActionListener(e -> {
            // Eingabefeld auslesen
            ausgabe.setText(new AsciiConverter().
                    replaceString(eingabe.getText()));
        });

        reset = new JButton("Reset");
        reset.setMnemonic('R');
        reset.addActionListener(e -> eingabe.setText(""));

        knoepfe.add(start);
        knoepfe.add(reset);

        // Feldbereich
        ioBereich = new JPanel(new FlowLayout());

        eing = new JLabel("1: Eingabe:");
        eing.setDisplayedMnemonic('1');
        eing.setLabelFor(eingabe);
        ioBereich.add(eing);
        ioBereich.add(eingabe);

        ausg = new JLabel("2: Ausgabe:");
        ausg.setDisplayedMnemonic('2');
        ausg.setLabelFor(ausgabe);
        ioBereich.add(ausg);
        ioBereich.add(ausgabe);

        // Gesamtkonfiguration des Fensters
        this.setLayout(new BorderLayout());
        this.add(knoepfe, BorderLayout.NORTH);
        this.add(ioBereich, BorderLayout.CENTER);

        // if started standalone we do need a quit-button
        if (!isApplet) {
            ende = new JButton("Ende");
            ende.setMnemonic('E');
            // Programmende
            ende.addActionListener(e -> System.exit(0));

            knoepfe.add(ende);
        }
        knoepfe.add(hilfe);

        this.setVisible(true);
    }   // end of init
} // end of class
