package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.g18.BitBank.Gui.KontostandsUebersichtAnzeigen;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KontostandsUebersichtAnzeigenListener implements ActionListener {

	JFrame kontostandsUebersichtAnzeigenFrame;

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
			this.kontostandsUebersichtAnzeigenFrame.dispose();
		}

	}

}
