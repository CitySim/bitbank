package de.g18.BitBank.Gui;

import com.toedter.calendar.JDateChooser;
import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.UeberweisungListener;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Klasse zum Überweisen eines Betrages von einem Konto zum anderen.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class Ueberweisung extends JPanel {
	private static final long serialVersionUID = 3658600368625899293L;

	private JTabbedPane tabsPane;

	public Ueberweisung(final JTabbedPane tabsPane,
			final BankController controller) {
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
		JDateChooser chooser = new JDateChooser();
		JTextField betragField = new JTextField();

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
		this.add(chooser, c);

		c.gridx = 1;
		c.gridy = 3;
		this.add(betragField, c);

		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 0;
		this.add(ueberweisenButton, c);

		c.gridx = 2;
		c.gridy = 4;
		this.add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.weighty = 1;
		this.add(new JPanel(), c);

		ueberweisenButton
				.addActionListener(new UeberweisungListener(vomKontoField,
						nachKontoField, betragField, controller, chooser));
		beendenButton.addActionListener(new UeberweisungListener(this));
	}

	public JTabbedPane getTabsPane() {
		return tabsPane;
	}
}
