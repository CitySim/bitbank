package de.g18.BitBank.Gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import de.g18.BitBank.Gui.Listener.KontoAnlegenListener;

/**
 * Gui Klasse zum anlegen eines Kundens.
 * 
 * @author it1-markde
 * @since JRE6
 */

@SuppressWarnings("serial")
public class KontoAnlegen extends JFrame {

	public KontoAnlegen() {

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(0, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bank-Anwendung - Ein- / Auszahlung durchführen");

		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextField kundenNummerField = new JTextField(10);
		JRadioButton giroKontoRadioButton = new JRadioButton("GiroKonto");
		JRadioButton sparKontoRadioButton = new JRadioButton("SparKonto");
		JButton anlegenButton = new JButton("Anlegen");
		JButton beendenButton = new JButton("Beenden");

		this.add(kundenNummerLabel);

		this.add(kundenNummerField);

		this.add(giroKontoRadioButton);
		this.add(sparKontoRadioButton);

		this.add(anlegenButton);
		this.add(beendenButton);

		anlegenButton.addActionListener(new KontoAnlegenListener(
				kundenNummerField));
		beendenButton.addActionListener(new KontoAnlegenListener(null));

		this.setVisible(true);

	}

	public static void main(String[] args) {
		new KontoAnlegen();
	}
}
