package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.KontostandsUebersichtAnzeigenListener;

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

public class KontostandsUebersichtAnzeigen extends JPanel {
	private static final long serialVersionUID = 5388389196936658751L;

	private JTabbedPane tabsPane;

	public KontostandsUebersichtAnzeigen(JTabbedPane tabsPane) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		JTextField kundenNummerField = new JTextField(10);

		JButton kontoUebersichtButton = new JButton("Kontoübersicht");
		JButton beendenButton = new JButton("Beenden");

		Object[][] data = this.generateTextObjects();
		Object[] columnNames = this.generateColumnNames();

		JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		JScrollPane tablePane = new JScrollPane(table);
		tablePane.setBorder(new BorderUIResource.MatteBorderUIResource(10, 10,
				10, 10, SystemColor.black));

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
		c.weighty = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		this.add(tablePane, c);

		kontoUebersichtButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener(
						null));
		beendenButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener(
						this));
	}

	public Object[][] generateTextObjects() {
		Object[][] data = { { "Giro", "1100001", "750.0" },
				{ "Spar", "1101002", "250.0" } };

		return data;
	}

	public Object[] generateColumnNames() {
		Object[] columnData = { "Kontoart", "Kontonummer", "Kontostand" };
		return columnData;
	}

	public JTabbedPane getTabsPane() {
		return tabsPane;
	}
}