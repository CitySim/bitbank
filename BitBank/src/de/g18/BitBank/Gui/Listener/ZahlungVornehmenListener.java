package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ZahlungVornehmenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontostand") == 0) {

		}
		if (buttonClicked.getText().compareTo("Einzahlung") == 0) {

		}
		if (buttonClicked.getText().compareTo("Auszahlung") == 0) {

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			System.exit(0);
		}

	}
}
