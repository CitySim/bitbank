package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
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
	BankController controller;

	public KontenListeListener(KontenListe kontenListeFrame, BankController controller) {
		this.kontenListeFrame = kontenListeFrame;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kontoübersicht") == 0) {
			long kundenNummer;
			try {
				kundenNummer = Long.parseLong(kontenListeFrame.getKundenNummer().getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Kundenummer konnte nicht gelesen werden", "Fehler", JOptionPane.OK_OPTION);
				return;
			}

			Kunde kunde;
			try {
				kunde = controller.getKundeByNummer(kundenNummer);
			} catch (KundeNichtGefundenException e) {
				JOptionPane.showMessageDialog(null, "Kundenummer konnte nicht gelesen werden", "Fehler", JOptionPane.OK_OPTION);
				return;
			}

			kontenListeFrame.getTable().setModel(new KontenTableModel(kunde));
		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontenListeFrame.getTabsPane().remove(
					this.kontenListeFrame);
		}
	}
}
