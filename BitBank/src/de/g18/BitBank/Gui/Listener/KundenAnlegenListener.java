package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Listener zu den Buttons der KundenAnlegen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenAnlegenListener implements ActionListener {

	JTextField kundenAnlegenField;

	public KundenAnlegenListener(JTextField kundenNummerField) {
		this.kundenAnlegenField = kundenNummerField;
	}

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
