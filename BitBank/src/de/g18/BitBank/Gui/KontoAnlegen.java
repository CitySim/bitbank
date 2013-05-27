package de.g18.BitBank.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.KontoAnlegenListener;

/**
 * Gui Klasse zum anlegen eines Kundens.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KontoAnlegen extends JPanel {

    private static final long serialVersionUID = -4665144187936969278L;

    private final JTabbedPane tabsPane;

    public KontoAnlegen(final JTabbedPane tabsPane, final BankController controller) {
        this.tabsPane = tabsPane;

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel kundenNummerLabel = new JLabel("Kundennummer");
        final JTextField kundenNummerField = new JTextField();
        final JLabel kontoTypLabel = new JLabel("Kontotyp");
        final JRadioButton giroKontoRadioButton = new JRadioButton("GiroKonto");
        final JRadioButton sparKontoRadioButton = new JRadioButton("SparKonto");
        final JButton anlegenButton = new JButton("Anlegen");
        final JButton kundeAuswaehlenButton = new JButton("Kunde suchen");
        final JButton beendenButton = new JButton("Schließen");

        final ButtonGroup kontoTypSelect = new ButtonGroup();
        kontoTypSelect.add(giroKontoRadioButton);
        kontoTypSelect.add(sparKontoRadioButton);

        c.gridx = 0;
        c.gridy = 0;
        this.add(kundenNummerLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(kundenNummerField, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0;
        this.add(kundeAuswaehlenButton, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        this.add(kontoTypLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(giroKontoRadioButton, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(sparKontoRadioButton, c);

        c.gridx = 2;
        c.gridy = 2;
        this.add(anlegenButton, c);

        c.gridx = 2;
        c.gridy = 3;
        this.add(beendenButton, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;
        c.weighty = 1;
        this.add(new JPanel(), c);

        final KontoAnlegenListener listener = new KontoAnlegenListener(
                controller,
                this,
                kundenNummerField,
                giroKontoRadioButton,
                sparKontoRadioButton);

        anlegenButton.addActionListener(listener);
        beendenButton.addActionListener(listener);
        kundeAuswaehlenButton.addActionListener(listener);
    }

    public final JTabbedPane getTabsPane() {
        return this.tabsPane;
    }
}
