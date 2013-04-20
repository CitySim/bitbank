package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kontotyp;
import de.g18.BitBank.Exception.KeinKontotypException;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;
import de.g18.BitBank.Gui.KontoAnlegen;

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

	public KontoAnlegenListener(final JTextField kundenNummerField,
			final BankController controller,
			final JRadioButton giroKontoRadioButton,
			final JRadioButton sparKontoRadioButton) {
		this.kundenNummerField = kundenNummerField;
		this.controller = controller;
		this.giroKontoRadioButton = giroKontoRadioButton;
		this.sparKontoRadioButton = sparKontoRadioButton;
	}

	public KontoAnlegenListener(final KontoAnlegen kontoAnlegenFrame) {
		this.kontoAnlegenFrame = kontoAnlegenFrame;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {
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

		}

		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontoAnlegenFrame.getTabsPane().remove(this.kontoAnlegenFrame);
		}
	}

	public void showCreationDialog(long kundenNummer) {
		JOptionPane.showMessageDialog(new JFrame(),
				"Konto unter für Kunde Nr. \"" + kundenNummer + "\" angelegt.");
	}
}
