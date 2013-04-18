package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import de.g18.BitBank.Gui.ZahlungVornehmen;

/**
 * Listener zu den Buttons der ZahlungVornehmen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class ZahlungVornehmenListener implements ActionListener {

	private ZahlungVornehmen zahlungVornehmenFrame;
	private JTextField kontoNummerField;

	public ZahlungVornehmenListener(ZahlungVornehmen zahlungVornehmenFrame) {
		this.zahlungVornehmenFrame = zahlungVornehmenFrame;
	}

	public ZahlungVornehmenListener(JTextField kontoNummerField) {
		this.kontoNummerField = kontoNummerField;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		int kontoNummer = Integer.parseInt(this.kontoNummerField.getText());

		if (buttonClicked.getText().compareTo("Kontostand") == 0) {

		}
		if (buttonClicked.getText().compareTo("Einzahlung") == 0) {

		}
		if (buttonClicked.getText().compareTo("Auszahlung") == 0) {

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.zahlungVornehmenFrame.getTabsPane().remove(
					this.zahlungVornehmenFrame);
		}
	}
}
