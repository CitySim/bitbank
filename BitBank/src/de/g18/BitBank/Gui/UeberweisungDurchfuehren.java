package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.UeberweisungDurchfuehrenListener;

import javax.swing.*;

import java.awt.*;

/**
 * Gui Klasse zum Überweisen eines Betrages von einem Konto zum anderen.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class UeberweisungDurchfuehren extends JPanel {
	private static final long serialVersionUID = 3658600368625899293L;

	private JTabbedPane tabsPane;

	public UeberweisungDurchfuehren(JTabbedPane tabsPane) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel vomKontoLabel = new JLabel("Vom Konto");
		JLabel nachKontoLabel = new JLabel("Nach Konto");
		JLabel datumLabel = new JLabel("Datum");
		JLabel betragLabel = new JLabel("Betrag");

		JTextField vomKontoField = new JTextField();
		JTextField nachKontoField = new JTextField();
		JTextField datumField = new JTextField();
		datumField.setEnabled(false);
		JTextField betragField = new JTextField();

		JButton datumAuswaehlenButton = new JButton("Datum auswählen");
		JButton ueberweisenButton = new JButton("Überweisen");
		JButton beendenButton = new JButton("Beenden");

		c.gridx = 0;
		c.gridy = 0;
		this.add(vomKontoLabel, c);

		c.gridx = 0;
		c.gridy = 1;
		this.add(nachKontoLabel, c);

		c.gridx = 0;
		c.gridy = 2;
		this.add(datumLabel, c);

		c.gridx = 0;
		c.gridy = 3;
		this.add(betragLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		this.add(vomKontoField, c);

		c.gridx = 1;
		c.gridy = 1;
		this.add(nachKontoField, c);

		c.gridx = 1;
		c.gridy = 2;
		this.add(datumField, c);

		c.gridx = 1;
		c.gridy = 3;
		this.add(betragField, c);

		c.weightx = 0;
		c.gridx = 2;
		c.gridy = 2;
		this.add(datumAuswaehlenButton, c);

		c.gridx = 2;
		c.gridy = 3;
		this.add(ueberweisenButton, c);

		c.gridx = 2;
		c.gridy = 4;
		this.add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.weighty = 1;
		this.add(new JPanel(), c);

		datumAuswaehlenButton
				.addActionListener(new UeberweisungDurchfuehrenListener(null));
		ueberweisenButton
				.addActionListener(new UeberweisungDurchfuehrenListener(null));
		beendenButton.addActionListener(new UeberweisungDurchfuehrenListener(
				this));
	}

	public JTabbedPane getTabsPane() {
		return tabsPane;
	}
}
