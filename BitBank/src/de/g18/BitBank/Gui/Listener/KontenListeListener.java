package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.KontenListe;
import de.g18.BitBank.Gui.TableModels.KontenTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der KontenListe Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KontenListeListener implements ActionListener {
	private KontenListe kontenListeFrame;
	BankController controller;

	public KontenListeListener(KontenListe kontenListeFrame,
							   BankController controller) {
		this.kontenListeFrame = kontenListeFrame;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontoübersicht") == 0) {
			long kundenNummer = kontenListeFrame.getKundenNummer();
			kontenListeFrame.getTable().setModel(
					new KontenTableModel(controller, kundenNummer));
		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontenListeFrame.getTabsPane().remove(this.kontenListeFrame);
		}
	}
}
