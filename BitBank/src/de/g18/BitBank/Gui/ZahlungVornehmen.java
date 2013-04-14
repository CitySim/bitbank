package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.ZahlungVornehmenListener;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Klasse zum Ein - / Auszahlen eines Betrages auf ein Konto.
 *
 * @author it1-markde
 * @since JRE6
 */


public class ZahlungVornehmen extends JPanel {
	public JTabbedPane tabsPane;

	public ZahlungVornehmen(JTabbedPane tabsPane) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kontoNummerLabel = new JLabel("Kontonummer");
		JLabel alterKontoStandLabel = new JLabel("alter Kontostand");
		JLabel betragLabel = new JLabel("Betrag");
		JLabel neuerKontoStandLabel = new JLabel("neuer Kontostand");

		JTextField kontoNummerField = new JTextField(10);
		JTextField alterKontoStandField = new JTextField(10);
		JTextField betragField = new JTextField(10);
		JTextField neuerKontoStandField = new JTextField(10);

		JButton kontoStandButton = new JButton("Kontostand");
		JButton einzahlungButton = new JButton("Einzahlung");
		JButton auszahlungButton = new JButton("Auszahlung");
		JButton beendenButton = new JButton("Beenden");

		c.gridx = 0;
		c.gridy = 0;
		add(kontoNummerLabel, c);

		c.gridx = 0;
		c.gridy = 1;
		add(alterKontoStandLabel, c);

		c.gridx = 0;
		c.gridy = 2;
		add(betragLabel, c);

		c.gridx = 0;
		c.gridy = 3;
		add(neuerKontoStandLabel, c);


		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		add(kontoNummerField, c);

		c.gridx = 1;
		c.gridy = 1;
		add(alterKontoStandField, c);

		c.gridx = 1;
		c.gridy = 2;
		add(betragField, c);

		c.gridx = 1;
		c.gridy = 3;
		add(neuerKontoStandField, c);


		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 0;
		add(kontoStandButton, c);

		c.gridx = 3;
		c.gridy = 2;
		add(einzahlungButton, c);

		c.gridx = 3;
		c.gridy = 3;
		add(auszahlungButton, c);

		c.gridx = 3;
		c.gridy = 4;
		add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.weighty = 1;
		this.add(new JPanel(), c);

		kontoStandButton.addActionListener(new ZahlungVornehmenListener(null));
		einzahlungButton.addActionListener(new ZahlungVornehmenListener(null));
		auszahlungButton.addActionListener(new ZahlungVornehmenListener(null));
		beendenButton.addActionListener(new ZahlungVornehmenListener(this));
	}
}
