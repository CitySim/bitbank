package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.KontoListe;
import de.g18.BitBank.Gui.TableModels.KontenTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der KontoListe Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KontonListeListener implements ActionListener {
	private KontoListe kontoListeFrame;
	BankController controller;

	public KontonListeListener(KontoListe kontoListeFrame, BankController controller) {
		this.kontoListeFrame = kontoListeFrame;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontoübersicht") == 0) {
			long kundenNummer = kontoListeFrame.getKundenNummer();
			kontoListeFrame.getTable().setModel(new KontenTableModel(controller, kundenNummer));
		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontoListeFrame.getTabsPane().remove(
					this.kontoListeFrame);
		}
	}
}
