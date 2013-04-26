package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.Gui.KundenListe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KundenListeListener implements ActionListener {
	private KundenListe kundenListeFrame;

	public KundenListeListener(final KundenListe kundenListeFrame) {
		this.kundenListeFrame = kundenListeFrame;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Schließen") == 0) {
			kundenListeFrame.getTabsPane().remove(kundenListeFrame);
		}
	}
}