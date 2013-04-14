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

		this.setLayout(new GridLayout(0, 1));

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

		kontoStandButton.addActionListener(new ZahlungVornehmenListener(null));
		einzahlungButton.addActionListener(new ZahlungVornehmenListener(null));
		auszahlungButton.addActionListener(new ZahlungVornehmenListener(null));
		beendenButton.addActionListener(new ZahlungVornehmenListener(this));

		this.add(kontoNummerLabel);
		this.add(alterKontoStandLabel);
		this.add(betragLabel);
		this.add(neuerKontoStandLabel);

		this.add(kontoNummerField);
		this.add(alterKontoStandField);
		this.add(betragField);
		this.add(neuerKontoStandField);

		this.add(kontoStandButton);
		this.add(einzahlungButton);
		this.add(auszahlungButton);
		this.add(beendenButton);

		this.setVisible(true);
	}
}
