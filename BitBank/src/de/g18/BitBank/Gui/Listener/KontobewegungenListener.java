package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Gui.Kontobewegungen;
import de.g18.BitBank.Gui.TableModels.KontoBewegungenTableModel;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
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
			} catch (KontoNichtGefundenException e) {
				e.showDialog();
				return;
			}

			kontobewegungenFrame.getTable().setModel(
					new KontoBewegungenTableModel(konto));
		} else if (buttonClicked.getText().compareTo("Beenden") == 0) {
			kontobewegungenFrame.getTabsPane().remove(kontobewegungenFrame);
		}
	}
}
