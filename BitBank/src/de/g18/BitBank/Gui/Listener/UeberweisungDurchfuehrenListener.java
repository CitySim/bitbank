package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Listener zu den Buttons der UeberweisungDurchfuehren Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class UeberweisungDurchfuehrenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Datum auswählen") == 0) {

		}
		if (buttonClicked.getText().compareTo("Überweisen") == 0) {

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			System.exit(1);
		}

	}
}
