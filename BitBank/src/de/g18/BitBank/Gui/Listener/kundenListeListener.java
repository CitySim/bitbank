package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.Gui.kundenListe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class kundenListeListener implements ActionListener {
	private kundenListe kundenListeFrame;

	public kundenListeListener(kundenListe kundenListeFrame) {
		kundenListeFrame = kundenListeFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			kundenListeFrame.getTabsPane().remove(
					kundenListeFrame);
		}
	}
}
