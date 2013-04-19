package de.g18.BitBank.Gui;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.KontenListeListener;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

/**
 * Gui Klasse zum Anzeigen des aktuellen Kontostandes aller Konten eines
 * Kundens.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KontenListe extends JPanel {
	private static final long serialVersionUID = 5388389196936658751L;
	private JTabbedPane tabsPane;
	private JTable table;
	private JTextField kundenNummerField;

	public KontenListe(final JTabbedPane tabsPane,
			final BankController controller) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		kundenNummerField = new JTextField(10);

		JButton kontoUebersichtButton = new JButton("Kontoübersicht");
		JButton beendenButton = new JButton("Beenden");

		table = new JTable();
		table.setFillsViewportHeight(true);
		JScrollPane tablePane = new JScrollPane(table);
		tablePane.setBorder(new BorderUIResource.MatteBorderUIResource(10, 10,
				10, 10, SystemColor.black));

		c.gridx = 0;
		c.gridy = 0;
		add(kundenNummerLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		add(kundenNummerField, c);

		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0;
		add(kontoUebersichtButton, c);

		c.gridx = 2;
		c.gridy = 1;
		add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 3;
		c.weighty = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		add(tablePane, c);

		KontenListeListener listener = new KontenListeListener(this, controller);
		kontoUebersichtButton.addActionListener(listener);
		beendenButton.addActionListener(listener);
	}

	public JTabbedPane getTabsPane() {
		return tabsPane;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getKundenNummer() {
		return kundenNummerField;
	}
}