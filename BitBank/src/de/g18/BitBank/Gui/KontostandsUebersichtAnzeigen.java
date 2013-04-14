package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.KontostandsUebersichtAnzeigenListener;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Klasse zum Anzeigen des aktuellen Kontostandes aller Konten eines
 * Kundens.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KontostandsUebersichtAnzeigen extends JPanel {
	public JTabbedPane tabsPane;

	public KontostandsUebersichtAnzeigen(JTabbedPane tabsPane) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextField kundenNummerField = new JTextField(10);

		JButton kontoUebersichtButton = new JButton("Kontoübersicht");
		JButton beendenButton = new JButton("Beenden");

		Object[][] data = this.generateTextObjects();
		Object[] columnNames = this.generateColumnNames();

		JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		JScrollPane tablePane = new JScrollPane(table);

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
		this.add(kontoUebersichtButton, c);

		c.gridx = 2;
		c.gridy = 1;
		this.add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 3;
		this.add(tablePane, c);

		kontoUebersichtButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener(
						null));
		beendenButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener(
						this));

		this.setVisible(true);
	}

	public Object[][] generateTextObjects() {
		Object[][] data = {{"Giro", "1100001", "750.0"},
				{"Spar", "1101002", "250.0"}};

		return data;
	}

	public Object[] generateColumnNames() {
		Object[] data = {"Kontoart", "Kontonummer", "Kontostand"};
		return data;
	}
}