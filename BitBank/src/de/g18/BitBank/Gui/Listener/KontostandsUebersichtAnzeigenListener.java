package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.Gui.KontostandsUebersichtAnzeigen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KontostandsUebersichtAnzeigenListener implements ActionListener {
	private KontostandsUebersichtAnzeigen kontostandsUebersichtAnzeigenFrame;

	public KontostandsUebersichtAnzeigenListener(
			KontostandsUebersichtAnzeigen kontostandsUebersichtAnzeigenFrame) {
		this.kontostandsUebersichtAnzeigenFrame = kontostandsUebersichtAnzeigenFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontoübersicht") == 0) {

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontostandsUebersichtAnzeigenFrame.getTabsPane().remove(
					this.kontostandsUebersichtAnzeigenFrame);
		}
	}
}
