package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import de.g18.BitBank.Gui.KundenAnlegen;

/**
 * Listener zu den Buttons der KundenAnlegen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenAnlegenListener implements ActionListener {

	JTextField kundenAnlegenField;
	JFrame kundenAnlegenFrame;

	public KundenAnlegenListener(JTextField kundenNummerField) {
		this.kundenAnlegenField = kundenNummerField;
	}

	public KundenAnlegenListener(KundenAnlegen kundenAnlegenFrame) {
		this.kundenAnlegenFrame = kundenAnlegenFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {
		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			kundenAnlegenFrame.dispose();
		}
	}

}
