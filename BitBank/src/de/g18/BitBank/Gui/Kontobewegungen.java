package de.g18.BitBank.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.KontobewegungenListener;

/**
 * Gui Klasse zum Ausfuehren einer Kontobewegung (Einzahlung || Auszahlung || Ueberweisung) aus.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class Kontobewegungen extends JPanel {

    private static final long serialVersionUID = -7895660068030891020L;
    private final JTabbedPane tabsPane;
    private final JTextField kontoNummerField;
    private final JTable table;

    public Kontobewegungen(final JTabbedPane tabsPane, final BankController controller) {
        this.tabsPane = tabsPane;

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel kontoNummerLabel = new JLabel("Kontonummer");
        this.kontoNummerField = new JTextField(10);

        final JButton kontobewegungenButton = new JButton("Kontobewegungen");
        final JButton beendenButton = new JButton("Schließen");

        this.table = new JTable();
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        this.table.setFillsViewportHeight(true);
        final JScrollPane tablePane = new JScrollPane(this.table);
        tablePane.setBorder(new BorderUIResource.MatteBorderUIResource(10, 10, 10, 10, SystemColor.black));

        c.gridx = 0;
        c.gridy = 0;
        this.add(kontoNummerLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(this.kontoNummerField, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0;
        this.add(kontobewegungenButton, c);

        c.gridx = 2;
        c.gridy = 1;
        this.add(beendenButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(tablePane, c);

        final KontobewegungenListener listener = new KontobewegungenListener(this, controller);
        kontobewegungenButton.addActionListener(listener);
        beendenButton.addActionListener(listener);
    }

    public final JTabbedPane getTabsPane() {
        return this.tabsPane;
    }

    public final JTextField getKontoNummer() {
        return this.kontoNummerField;
    }

    public final JTable getTable() {
        return this.table;
    }
}
