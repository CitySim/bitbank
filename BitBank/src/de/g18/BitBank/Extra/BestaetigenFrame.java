package de.g18.BitBank.Extra;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;

/**
 * Frame zur Bestaetigung von Druck und E-Mail Vorgaengen.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class BestaetigenFrame extends JFrame {

    private static final long serialVersionUID = 4251619441226397716L;

    public BestaetigenFrame(final BankController controller, final String operation) {

        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextField emailField = null;

        // Da das frame fuer zwei Faelle dient, wird die entsprechende Operation
        // beruecksichtigt.
        if (operation.equals("email")) {
            this.setSize(new Dimension(300, 140));
            this.setTitle("E-Mail");
            final JLabel emailLabel = new JLabel("E-Mail Adresse");
            emailField = new JTextField();

            c.gridx = 0;
            c.gridy = 0;
            c.weightx = 3;
            c.fill = GridBagConstraints.BOTH;
            this.add(emailLabel, c);

            c.gridx = 3;
            c.gridy = 0;
            c.weightx = 3;
            c.fill = GridBagConstraints.BOTH;
            this.add(emailField, c);
        }
        if (operation.equals("drucken")) {
            this.setSize(new Dimension(280, 100));
            this.setTitle("Drucken");
        }

        final JLabel kundenNummerLabel = new JLabel("KundenNummer");
        final JTextField kundenNummerField = new JTextField();
        final JButton bestaetigenButton = new JButton("Bestätigen");
        final JButton abbrechenButton = new JButton("Abbrechen");

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(kundenNummerLabel, c);

        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(kundenNummerField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(bestaetigenButton, c);

        c.gridx = 3;
        c.gridy = 3;
        c.weightx = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(abbrechenButton, c);

        this.setVisible(true);

        final BestaetigenFrameListener listener = new BestaetigenFrameListener(
                controller,
                operation,
                this,
                kundenNummerField,
                emailField);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);

    }
}
