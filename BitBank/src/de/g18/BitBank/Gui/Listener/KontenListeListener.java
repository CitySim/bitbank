package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;
import de.g18.BitBank.Gui.KontenListe;
import de.g18.BitBank.Gui.TableModels.KontenTableModel;

/**
 * Listener zu den Buttons der KontenListe Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KontenListeListener implements ActionListener {
	private KontenListe kontenListeFrame;
	private BankController controller;

	public KontenListeListener(KontenListe kontenListeFrame,
			BankController controller) {
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
		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontenListeFrame.getTabsPane().remove(this.kontenListeFrame);
		}
	}
}
