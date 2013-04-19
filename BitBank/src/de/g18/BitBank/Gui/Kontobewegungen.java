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
 * Created with IntelliJ IDEA. User: Sven Date: 14.04.13 Time: 14:42
 */
public class Kontobewegungen extends JPanel {
	private static final long serialVersionUID = -7895660068030891020L;
	private JTabbedPane tabsPane;
	private JTextField kontoNummerField;
	private JTable table;

	public Kontobewegungen(final JTabbedPane tabsPane,
			final BankController controller) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		kontoNummerField = new JTextField(10);

		JButton kontobewegungenButton = new JButton("Kontobewegungen");
		JButton beendenButton = new JButton("Beenden");

		table = new JTable();
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
		this.add(kontoNummerField, c);

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

		KontobewegungenListener listener = new KontobewegungenListener(this,
				controller);
		kontobewegungenButton.addActionListener(listener);
		beendenButton.addActionListener(listener);
	}

	public JTabbedPane getTabsPane() {
		return tabsPane;
	}

	public JTextField getKontoNummer() {
		return kontoNummerField;
	}

	public JTable getTable() {
		return table;
	}
}