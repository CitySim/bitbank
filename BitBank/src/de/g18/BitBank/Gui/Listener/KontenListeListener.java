package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;
import de.g18.BitBank.Gui.KontenListe;
import de.g18.BitBank.Gui.TableModels.KontenTableModel;
import de.g18.BitBank.Kunde;

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
	private BankController controller;

	public KontenListeListener(final KontenListe kontenListeFrame,
			final BankController controller) {
		this.kontenListeFrame = kontenListeFrame;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontoübersicht") == 0) {
			long kundenNummer = 0;
			try {
				kundenNummer = Long.parseLong(kontenListeFrame
						.getKundenNummer().getText());
			} catch (NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Die Kundennummer");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}

			}

			Kunde kunde = null;
			try {
				kunde = controller.getKundeByNummer(kundenNummer);
			} catch (KundeNichtGefundenException e) {
				e.showDialog();
				return;
			}

			kontenListeFrame.getTable().setModel(new KontenTableModel(kunde));
			kontenListeFrame.getTabsPane().setTitleAt(
					kontenListeFrame.getTabsPane().getSelectedIndex(),
					"Kunde " + Long.toString(kundenNummer));
		}
		if (buttonClicked.getText().compareTo("Schließen") == 0) {
			this.kontenListeFrame.getTabsPane().remove(this.kontenListeFrame);
		}
	}
}
