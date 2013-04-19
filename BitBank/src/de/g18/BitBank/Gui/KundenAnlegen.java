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
 * @since JRE6
 */

public class KundenAnlegen extends JPanel {
	private static final long serialVersionUID = -2795653707387451326L;

	private JTabbedPane tabsPane;

	public KundenAnlegen(final JTabbedPane tabsPane,
			final BankController controller) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		JLabel kundenNamenLabel = new JLabel("Kundenname");
		JTextField kundenNummerField = new JTextField();
		JTextField kundenNamenField = new JTextField();
		JButton anlegenButton = new JButton("Anlegen");
		JButton beendenButton = new JButton("Beenden");

		c.gridx = 0;
		c.gridy = 0;
		add(kundenNummerLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		add(kundenNummerField, c);

		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		add(kundenNamenLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		add(kundenNamenField, c);

		c.gridx = 3;
		c.gridy = 1;
		add(anlegenButton, c);

		c.gridx = 3;
		c.gridy = 2;
		add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		c.weighty = 1;
		this.add(new JPanel(), c);

		anlegenButton.addActionListener(new KundenAnlegenListener(
				kundenNummerField, kundenNamenField, controller));
		beendenButton.addActionListener(new KundenAnlegenListener(this));
	}

	public JTabbedPane getTabsPane() {
		return tabsPane;
	}
}
