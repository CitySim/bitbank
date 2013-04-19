package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.g18.BitBank.Gui.KundenListe;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenListeListener implements ActionListener {
	private KundenListe kundenListeFrame;

	public KundenListeListener(final KundenListe kundenListeFrame) {
		this.kundenListeFrame = kundenListeFrame;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			kundenListeFrame.getTabsPane().remove(kundenListeFrame);
		}
	}
}