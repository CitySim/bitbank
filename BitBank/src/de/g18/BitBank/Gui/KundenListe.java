package de.g18.BitBank.Gui;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.KundenListeListener;
import de.g18.BitBank.Gui.TableModels.KundenTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Klasse zum Anzeigen des aktuellen Kontostandes aller Konten eines
 * Kundens.
 * 
 * Gui Klasse zum Anzeigen aller Kunden.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenListe extends JPanel {
	private static final long serialVersionUID = 5388389196936658751L;
	private JTabbedPane tabsPane;

	public KundenListe(final JTabbedPane tabsPane,
			final BankController controller) {
		this.tabsPane = tabsPane;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JButton beendenButton = new JButton("Schließen");

		JTable table = new JTable(new KundenTableModel(controller));
		table.setFillsViewportHeight(true);
		JScrollPane tablePane = new JScrollPane(table);

		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		this.add(new JPanel(), c);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		this.add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		this.add(tablePane, c);

		beendenButton.addActionListener(new KundenListeListener(this));
	}

	public final JTabbedPane getTabsPane() {
		return tabsPane;
	}
}