package de.g18.BitBank.Gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.g18.BitBank.Gui.Listener.KundenAnlegenListener;

@SuppressWarnings("serial")
public class KundenAnlegen extends JFrame {
	public KundenAnlegen() {

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(0, 1));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Bank-Anwendung - Kunde anlegen");

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		JLabel kundenNamenLabel = new JLabel("Kundenname");
		JTextField kundenNummerField = new JTextField(10);
		JTextField kundenNamenField = new JTextField(10);
		JButton anlegenButton = new JButton("Anlegen");
		JButton beendenButton = new JButton("Beenden");

		this.add(kundenNummerLabel);
		this.add(kundenNamenLabel);

		this.add(kundenNamenField);
		this.add(kundenNummerField);

		this.add(anlegenButton);
		this.add(beendenButton);

		anlegenButton.addActionListener(new KundenAnlegenListener(
				kundenNummerField));
		beendenButton.addActionListener(new KundenAnlegenListener(null));

		this.setVisible(true);

	}

	public static void main(String[] args) {
		new KundenAnlegen();
	}
}
