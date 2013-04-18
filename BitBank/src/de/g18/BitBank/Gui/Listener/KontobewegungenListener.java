package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Kontobewegungen;
import de.g18.BitBank.Gui.TableModels.KontoBewegungenTableModel;
import de.g18.BitBank.Konto;

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
	private Kontobewegungen kontobewegungenFrame;
	private BankController controller;

	public KontobewegungenListener(Kontobewegungen kontobewegungenFrame,
			BankController controller) {
		this.kontobewegungenFrame = kontobewegungenFrame;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontobewegungen") == 0) {
			Konto konto = controller.getKontoByKontoNummer(kontobewegungenFrame
					.getKontoNummer());
			kontobewegungenFrame.getTable().setModel(
					new KontoBewegungenTableModel(konto));
		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			kontobewegungenFrame.getTabsPane().remove(kontobewegungenFrame);
		}
	}
}
