package de.g18.BitBank.Gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.g18.BitBank.Gui.Listener.KontoAnlegenListener;

/**
 * Gui Klasse zum Ein - / Auszahlen eines Betrages auf ein Konto.
 * 
 * @author it1-markde
 * @since JRE6
 */

@SuppressWarnings("serial")
public class ZahlungVornehmen extends JFrame {

	public ZahlungVornehmen() {

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(0, 1));
		this.setTitle("Bank-Anwendung - Konto anlegen");

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

		kontoStandButton.addActionListener(new KontoAnlegenListener());
		einzahlungButton.addActionListener(new KontoAnlegenListener());
		auszahlungButton.addActionListener(new KontoAnlegenListener());
		beendenButton.addActionListener(new KontoAnlegenListener());

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

	public static void main(String[] args) {
		new ZahlungVornehmen();
	}
}
