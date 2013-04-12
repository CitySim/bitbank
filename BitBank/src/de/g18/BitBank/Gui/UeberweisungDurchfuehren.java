package de.g18.BitBank.Gui;

import java.awt.GridLayout;

import javax.swing.*;

import de.g18.BitBank.Gui.Listener.UeberweisungDurchfuehrenListener;

/**
 * Gui Klasse zum Überweisen eines Betrages von einem Konto zum anderen.
 * 
 * @author it1-markde
 * @since JRE6
 */

@SuppressWarnings("serial")
public class UeberweisungDurchfuehren extends JFrame {

	public UeberweisungDurchfuehren() {

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(0, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bank-Anwendung - Überweisung durchführen");

		JLabel vomKontoLabel = new JLabel("Vom Konto");
		JLabel nachKontoLabel = new JLabel("Nach Konto");
		JLabel datumLabel = new JLabel("Datum");
		JLabel betragLabel = new JLabel("Betrag");

		JTextField vomKontoField = new JTextField(10);
		JTextField nachKontoField = new JTextField(10);
		JTextField datumField = new JTextField(10);
		JTextField betragField = new JTextField(10);

		JButton datumAuswählenButton = new JButton("Datum auswählen");
		JButton überweisenButton = new JButton("Überweisen");
		JButton beendenButton = new JButton("Beenden");

		this.add(vomKontoLabel);
		this.add(nachKontoLabel);
		this.add(datumLabel);
		this.add(betragLabel);

		this.add(vomKontoField);
		this.add(nachKontoField);
		this.add(datumField);
		this.add(betragField);

		this.add(datumAuswählenButton);
		this.add(überweisenButton);
		this.add(beendenButton);

		datumAuswählenButton
				.addActionListener(new UeberweisungDurchfuehrenListener());
		überweisenButton
				.addActionListener(new UeberweisungDurchfuehrenListener());
		beendenButton.addActionListener(new UeberweisungDurchfuehrenListener());

		this.setVisible(true);
	}

	public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

		new UeberweisungDurchfuehren();
	}
}
