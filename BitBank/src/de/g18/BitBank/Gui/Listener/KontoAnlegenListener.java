package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.KeinKontotypException;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;
import de.g18.BitBank.Gui.KontoAnlegen;
import de.g18.BitBank.Gui.KundenAuswahl;
import de.g18.BitBank.Kontotyp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der KontoAnlegen Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KontoAnlegenListener implements ActionListener {
	private JTextField kundenNummerField;
	private KontoAnlegen kontoAnlegenFrame;
	private BankController controller;
	private JRadioButton giroKontoRadioButton;
	private JRadioButton sparKontoRadioButton;

	public KontoAnlegenListener(final BankController controller,
								final KontoAnlegen kontoAnlegenFrame,
								final JTextField kundenNummerField,
								final JRadioButton giroKontoRadioButton,
								final JRadioButton sparKontoRadioButton) {

		this.controller = controller;
		this.kontoAnlegenFrame = kontoAnlegenFrame;
		this.kundenNummerField = kundenNummerField;
		this.giroKontoRadioButton = giroKontoRadioButton;
		this.sparKontoRadioButton = sparKontoRadioButton;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Kunde suchen") == 0) {
			KundenAuswahl kundenAuswahl = new KundenAuswahl(controller);

		} else if (buttonClicked.getText().compareTo("Anlegen") == 0) {
			try {

				long kundenNummer = Long.parseLong(this.kundenNummerField
						.getText());

				if (!this.giroKontoRadioButton.isSelected()
						&& !this.sparKontoRadioButton.isSelected()) {
					throw new KeinKontotypException("Kein Kontotyp ausgewählt.");

				} else {
					if (this.giroKontoRadioButton.isSelected()) {
						controller
								.createKonto(kundenNummer, Kontotyp.GIROKONTO);
					} else if (this.sparKontoRadioButton.isSelected()) {
						controller
								.createKonto(kundenNummer, Kontotyp.SPARKONTO);
					}

					this.showCreationDialog(kundenNummer);
				}
			} catch (java.lang.NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Die Kundennummer");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}
			} catch (KeinKontotypException e) {
				e.showDialog();
				return;
			} catch (KundeNichtGefundenException e) {
				e.showDialog();
				return;
			}

		} else if (buttonClicked.getText().compareTo("Schließen") == 0) {
			this.kontoAnlegenFrame.getTabsPane().remove(this.kontoAnlegenFrame);
		}
	}

	public void showCreationDialog(long kundenNummer) {
		JOptionPane.showMessageDialog(new JFrame(),
				"Konto unter für Kunde Nr. \"" + kundenNummer + "\" angelegt.");
	}
}
