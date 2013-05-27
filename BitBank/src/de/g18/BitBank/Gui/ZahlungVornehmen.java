package de.g18.BitBank.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.ZahlungVornehmenListener;

/**
 * Gui Klasse zum Ein - / Auszahlen eines Betrages auf ein Konto.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class ZahlungVornehmen extends JPanel {

    private static final long serialVersionUID = -260972803425184120L;

    private final JTabbedPane tabsPane;

    public final JTabbedPane getTabsPane() {
        return this.tabsPane;
    }

    public ZahlungVornehmen(final JTabbedPane tabsPane, final BankController controller) {
        this.tabsPane = tabsPane;

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel kontoNummerLabel = new JLabel("Kontonummer");
        final JLabel alterKontoStandLabel = new JLabel("Jetziger Kontostand");
        final JLabel betragLabel = new JLabel("Betrag");
        final JLabel neuerKontoStandLabel = new JLabel("Neuer Kontostand");

        final JTextField kontoNummerField = new JTextField();
        final JTextField alterKontoStandField = new JTextField();
        alterKontoStandField.setEnabled(false);
        final JTextField betragField = new JTextField();
        final JTextField neuerKontoStandField = new JTextField();
        neuerKontoStandField.setEnabled(false);

        final JButton kontoStandButton = new JButton("Kontostand");
        final JButton einzahlungButton = new JButton("Einzahlung");
        final JButton auszahlungButton = new JButton("Auszahlung");
        final JButton beendenButton = new JButton("Schließen");

        c.gridx = 0;
        c.gridy = 0;
        this.add(kontoNummerLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(alterKontoStandLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(betragLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add(neuerKontoStandLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(kontoNummerField, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(alterKontoStandField, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(betragField, c);

        c.gridx = 1;
        c.gridy = 3;
        this.add(neuerKontoStandField, c);

        c.gridx = 3;
        c.gridy = 0;
        c.weightx = 0;
        this.add(kontoStandButton, c);

        c.gridx = 3;
        c.gridy = 2;
        this.add(einzahlungButton, c);

        c.gridx = 3;
        c.gridy = 3;
        this.add(auszahlungButton, c);

        c.gridx = 3;
        c.gridy = 4;
        this.add(beendenButton, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.weighty = 1;
        this.add(new JPanel(), c);

        kontoStandButton.addActionListener(new ZahlungVornehmenListener(
                kontoNummerField,
                alterKontoStandField,
                neuerKontoStandField,
                betragField,
                controller));
        einzahlungButton.addActionListener(new ZahlungVornehmenListener(
                kontoNummerField,
                alterKontoStandField,
                neuerKontoStandField,
                betragField,
                controller));
        auszahlungButton.addActionListener(new ZahlungVornehmenListener(
                kontoNummerField,
                alterKontoStandField,
                neuerKontoStandField,
                betragField,
                controller));
        beendenButton.addActionListener(new ZahlungVornehmenListener(
                this,
                kontoNummerField,
                alterKontoStandField,
                neuerKontoStandField,
                betragField,
                controller));
    }
}
