package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.Gui.ZahlungVornehmen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der ZahlungVornehmen Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class ZahlungVornehmenListener implements ActionListener {
	JPanel zahlungVornehmenFrame;

	public ZahlungVornehmenListener(ZahlungVornehmen zahlungVornehmenFrame) {
		this.zahlungVornehmenFrame = zahlungVornehmenFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontostand") == 0) {

		}
		if (buttonClicked.getText().compareTo("Einzahlung") == 0) {

		}
		if (buttonClicked.getText().compareTo("Auszahlung") == 0) {

		}
		//if (buttonClicked.getText().compareTo("Beenden") == 0) {
		//	this.zahlungVornehmenFrame.dispose();
		//}
	}
}
