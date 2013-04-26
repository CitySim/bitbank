package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
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
 * @since jdk1.7.0_17
 */

public class KontobewegungenListener implements ActionListener {
	private Kontobewegungen kontobewegungenFrame;
	private BankController controller;

	public KontobewegungenListener(final Kontobewegungen kontobewegungenFrame,
			final BankController controller) {
		this.kontobewegungenFrame = kontobewegungenFrame;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontobewegungen") == 0) {
			long kontonummer = 0;
			try {
				kontonummer = Long.parseLong(kontobewegungenFrame
						.getKontoNummer().getText());
			} catch (NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Die Kontonummer");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}

			}

			Konto konto = null;
			try {
				konto = controller.getKontoByKontoNummer(kontonummer);
				kontobewegungenFrame.getTabsPane().setTitleAt(
						kontobewegungenFrame.getTabsPane().getSelectedIndex(),
						"Konto " + Long.toString(kontonummer));
			} catch (KontoNichtGefundenException e) {
				e.showDialog();
				return;
			}

			kontobewegungenFrame.getTable().setModel(
					new KontoBewegungenTableModel(konto));
		} else if (buttonClicked.getText().compareTo("Schließen") == 0) {
			kontobewegungenFrame.getTabsPane().remove(kontobewegungenFrame);
		}
	}
}
