package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.KontobewegungenListener;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 14.04.13
 * Time: 14:42
 */
public class Kontobewegungen extends JPanel {
	public JTabbedPane tabsPane;

	public Kontobewegungen(JTabbedPane tabsPane) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		JTextField kundenNummerField = new JTextField(10);

		JButton kontobewegungenButton = new JButton("Kontobewegungen");
		JButton beendenButton = new JButton("Beenden");

		Object[][] data = this.generateTextObjects();
		Object[] columnNames = this.generateColumnNames();

		JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		JScrollPane tablePane = new JScrollPane(table);
		tablePane.setBorder(new BorderUIResource.MatteBorderUIResource(10, 10, 10, 10, SystemColor.black));

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


		kontobewegungenButton
				.addActionListener(new KontobewegungenListener(
						null));
		beendenButton
				.addActionListener(new KontobewegungenListener(
						this));
	}

	public Object[][] generateTextObjects() {
		Object[][] data = {};

		return data;
	}

	public Object[] generateColumnNames() {
		Object[] columnData = {"Datum", "von", "nach", "Betrag"};
		return columnData;
	}
}