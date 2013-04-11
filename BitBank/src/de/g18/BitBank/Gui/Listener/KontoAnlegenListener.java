package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Listener zu den Buttons der KontoAnlegen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KontoAnlegenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			System.exit(1);
		}

	}
}
