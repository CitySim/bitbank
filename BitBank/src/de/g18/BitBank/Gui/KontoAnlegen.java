package de.g18.BitBank.Gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KontoAnlegen {

	public static void main(String[] args) {
		// public void createGUI() {
		JFrame anlegenFrame = new JFrame();
		anlegenFrame.setSize(400, 400);
		anlegenFrame.setLocationRelativeTo(null);
		anlegenFrame.setTitle("Bank-Anwendung - Konto anlegen");

		JPanel anlegenPanel = new JPanel();
		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextField kundenNummerField = new JTextField(10);
		JRadioButton giroKontoButton = new JRadioButton("GiroKonto");
		JRadioButton sparKontoButton = new JRadioButton("SparKonto");
		JButton anlegenButton = new JButton("Anlegen");
		JButton beendenButton = new JButton("Beenden");

		anlegenFrame.add(BorderLayout.CENTER, anlegenPanel);
		anlegenPanel.add(BorderLayout.WEST, kundenNummerLabel);
		anlegenPanel.add(BorderLayout.CENTER, kundenNummerField);
		anlegenPanel.add(BorderLayout.CENTER, giroKontoButton);
		anlegenPanel.add(BorderLayout.CENTER, sparKontoButton);
		anlegenPanel.add(BorderLayout.SOUTH, anlegenButton);
		anlegenPanel.add(BorderLayout.SOUTH, beendenButton);

		anlegenFrame.pack();
		anlegenFrame.setVisible(true);

	}
}
