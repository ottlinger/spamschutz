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
package de.aikiit.spamprotector;

import com.google.common.annotations.VisibleForTesting;
import de.aikiit.spamprotector.converter.SpamProtector;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import static de.aikiit.spamprotector.util.LocalizationHelper.getBundleString;
import static de.aikiit.spamprotector.util.LocalizationHelper.getParameterizedBundleString;

/**
 * This class contains the main UI of this application (both input windows
 * and all command buttons).
 */
class GUI extends JPanel {

    /**
     * Constant to define the dimension of a text box.
     */
    private static final Dimension BOX_DIMENSION = new Dimension(300, 200);

    @VisibleForTesting
    static final LocalDate now = LocalDate.now();

    /**
     * Launches and configures the main UI component.
     */
    GUI() {
        SwingUtilities.invokeLater(this::init);
    }

    /**
     * Internal helper to initialize the UI depending on the surrounding this
     * application is started.
     */
    private void init() {
        // command help
        final JPanel buttonArea = new JPanel();
        JButton help = new JButton(getBundleString("spamschutz.ui.help"));
        help.setMnemonic(getBundleString("spamschutz.ui.help.mnemonic").charAt(0));
        help.addActionListener(e -> JOptionPane.showMessageDialog(null, getParameterizedBundleString("spamschutz.ui.help.text",
                        String.valueOf(now.getYear()),
                        // TODO remove me, once #94 is resolved
                        "de.aikiit.spamprotector.util.Version.VERSION"),
                getBundleString("spamschutz.ui.help.title"),
                JOptionPane.INFORMATION_MESSAGE));

        final JTextField input = new JTextField();
        input.setSize(BOX_DIMENSION);
        input.setPreferredSize(BOX_DIMENSION);
        final JTextField output = new JTextField(getBundleString("spamschutz.ui.default.output"));
        output.setSize(BOX_DIMENSION);
        output.setPreferredSize(BOX_DIMENSION);

        // read input field
        final JButton start = new JButton(getBundleString("spamschutz.ui.button.rtl"));
        start.setMnemonic(getBundleString("spamschutz.ui.button.rtl.mnemonic").charAt(0));
        start.addActionListener(e -> output.setText(SpamProtector.toEncoded(input.getText())));

        // read output field
        final JButton revert = new JButton(getBundleString("spamschutz.ui.button.ltr"));
        revert.setMnemonic(getBundleString("spamschutz.ui.button.ltr.mnemonic").charAt(0));
        revert.addActionListener(e -> input.setText(SpamProtector.toPlain(output.getText())));

        final JButton reset = new JButton(getBundleString("spamschutz.ui.reset"));
        reset.setMnemonic(getBundleString("spamschutz.ui.reset.mnemonic").charAt(0));
        reset.addActionListener(e -> {
            input.setText("");
            output.setText("");
        });

        buttonArea.add(revert);
        buttonArea.add(start);
        buttonArea.add(reset);

        // fields
        final JPanel ioArea = new JPanel(new FlowLayout());

        final JLabel inputLabel = new JLabel(getBundleString("spamschutz.ui.input"));
        inputLabel.setDisplayedMnemonic(getBundleString("spamschutz.ui.input.mnemonic").charAt(0));
        inputLabel.setLabelFor(input);
        ioArea.add(inputLabel);
        ioArea.add(input);

        final JLabel outputLabel = new JLabel(getBundleString("spamschutz.ui.output"));
        outputLabel.setDisplayedMnemonic(getBundleString("spamschutz.ui.output.mnemonic").charAt(0));
        outputLabel.setLabelFor(output);
        ioArea.add(outputLabel);
        ioArea.add(output);

        // window layout
        this.setLayout(new BorderLayout());
        this.add(buttonArea, BorderLayout.NORTH);
        this.add(ioArea, BorderLayout.CENTER);

        final JButton end = new JButton(getBundleString("spamschutz.ui.end"));
        end.setMnemonic(getBundleString("spamschutz.ui.end.mnemonic").charAt(0));
        end.addActionListener(e -> System.exit(0));
        buttonArea.add(end);
        buttonArea.add(help);
        this.setVisible(true);
    }
}
