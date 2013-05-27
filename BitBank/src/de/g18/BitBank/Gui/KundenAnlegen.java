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
import de.g18.BitBank.Gui.Listener.KundenAnlegenListener;

/**
 * Gui Klasse zum Anlegen eines neuen Kundens.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KundenAnlegen extends JPanel {

    private static final long serialVersionUID = -2795653707387451326L;

    private final JTabbedPane tabsPane;

    public KundenAnlegen(final JTabbedPane tabsPane, final BankController controller) {
        this.tabsPane = tabsPane;

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel kundenNummerLabel = new JLabel("Kundennummer");
        final JLabel kundenNamenLabel = new JLabel("Kundenname");
        final JTextField kundenNummerField = new JTextField();
        final JTextField kundenNamenField = new JTextField();
        final JButton anlegenButton = new JButton("Anlegen");
        final JButton beendenButton = new JButton("Schließen");

        c.gridx = 0;
        c.gridy = 0;
        this.add(kundenNummerLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(kundenNummerField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        this.add(kundenNamenLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(kundenNamenField, c);

        c.gridx = 3;
        c.gridy = 1;
        this.add(anlegenButton, c);

        c.gridx = 3;
        c.gridy = 2;
        this.add(beendenButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.weighty = 1;
        this.add(new JPanel(), c);

        anlegenButton.addActionListener(new KundenAnlegenListener(kundenNummerField, kundenNamenField, controller));
        beendenButton.addActionListener(new KundenAnlegenListener(this));
    }

    public final JTabbedPane getTabsPane() {
        return this.tabsPane;
    }
}
