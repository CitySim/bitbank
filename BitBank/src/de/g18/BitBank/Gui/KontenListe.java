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
import de.g18.BitBank.Gui.Listener.KontenListeListener;

/**
 * Gui Klasse zum Anzeigen des aktuellen Kontostandes aller Konten eines Kundens.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KontenListe extends JPanel {

    private static final long serialVersionUID = 5388389196936658751L;
    private final JTabbedPane tabsPane;
    private final JTable table;
    private final JTextField kundenNummerField;

    public KontenListe(final JTabbedPane tabsPane, final BankController controller) {
        this.tabsPane = tabsPane;

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel kundenNummerLabel = new JLabel("Kundennummer");
        this.kundenNummerField = new JTextField(10);

        final JButton kontoUebersichtButton = new JButton("Kontoübersicht");
        final JButton beendenButton = new JButton("Schließen");

        this.table = new JTable();
        this.table.setFillsViewportHeight(true);
        final JScrollPane tablePane = new JScrollPane(this.table);
        tablePane.setBorder(new BorderUIResource.MatteBorderUIResource(10, 10, 10, 10, SystemColor.black));

        c.gridx = 0;
        c.gridy = 0;
        this.add(kundenNummerLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(this.kundenNummerField, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0;
        this.add(kontoUebersichtButton, c);

        c.gridx = 2;
        c.gridy = 1;
        this.add(beendenButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        this.add(tablePane, c);

        final KontenListeListener listener = new KontenListeListener(this, controller);
        kontoUebersichtButton.addActionListener(listener);
        beendenButton.addActionListener(listener);
    }

    public final JTabbedPane getTabsPane() {
        return this.tabsPane;
    }

    public final JTable getTable() {
        return this.table;
    }

    public final JTextField getKundenNummer() {
        return this.kundenNummerField;
    }
}
