package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.Gui.Kontobewegungen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KontobewegungenListener implements ActionListener {
	Kontobewegungen KontobewegungenFrame;

	public KontobewegungenListener(
			Kontobewegungen KontobewegungenFrame) {
		this.KontobewegungenFrame = KontobewegungenFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontobewegungen") == 0) {

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			KontobewegungenFrame.tabsPane.remove(KontobewegungenFrame);
		}
	}
}
