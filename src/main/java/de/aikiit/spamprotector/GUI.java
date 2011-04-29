package de.aikiit.spamprotector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA. User: hirsch Date: Apr 10, 2003 Time: 3:12:32 PM To
 * change this template use Options | File Templates.
 */
public class GUI extends JPanel {

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
    public GUI(final boolean isApplet) {
        init(isApplet);
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


        // command help
        knoepfe = new JPanel();
        hilfe = new JButton("Hilfe");
        hilfe.setMnemonic('H');
        hilfe.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Einfach ins Eingabefeld "
                        + "HTML-Code einfügen!\nDann konvertieren "
                        + "und schon sind weniger SpamAttacken "
                        + "wahrscheinlich"
                        + "\n(C) AIKI IT 2003"
                        + ", Version: "
                        + de.aikiit.spamprotector.util.Version.VERSION,
                        "Spam-Schutz - Hilfe",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        eingabe = new JTextField();
        eingabe.setSize(BOX_DIMENSION);
        eingabe.setPreferredSize(BOX_DIMENSION);
        ausgabe = new JTextField("Bitte Text eingeben und Button betätigen!");
        ausgabe.setSize(BOX_DIMENSION);
        ausgabe.setPreferredSize(BOX_DIMENSION);


        start = new JButton("Umwandeln");
        start.setMnemonic('U');
        start.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                // Eingabefeld auslesen
                ausgabe.setText((new AsciiConverter()).
                        replaceString(eingabe.getText()));
            }
        });

        reset = new JButton("Reset");
        reset.setMnemonic('R');
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                eingabe.setText("");
            }
        });

        knoepfe.add(start);
        knoepfe.add(reset);

        // Feldbereich
        ioBereich = new JPanel(new FlowLayout());

        eing = new JLabel("1: Eingabe:");
        // TODO Label so anlegen, dass sie auf ALT+1 reagieren!
        eing.setDisplayedMnemonic('1');
        eing.setLabelFor(eingabe);
        ioBereich.add(eing);
        ioBereich.add(eingabe);

        ausg = new JLabel("2: Ausgabe:");
        // TODO Label so anlegen, dass sie auf ALT+2 reagieren!
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
            ende.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    System.exit(0);
                }
            });

            knoepfe.add(ende);
        }
        knoepfe.add(hilfe);

        this.setVisible(true);
    }   // end of init
} // end of class
