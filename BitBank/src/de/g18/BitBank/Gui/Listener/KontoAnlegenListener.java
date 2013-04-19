package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.KeinKontotypException;
import de.g18.BitBank.Exception.KundenNummerException;
import de.g18.BitBank.Gui.KontoAnlegen;
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

	public KontoAnlegenListener(JTextField kundenNummerField,
			BankController controller, JRadioButton giroKontoRadioButton,
			JRadioButton sparKontoRadioButton) {
		this.kundenNummerField = kundenNummerField;
		this.controller = controller;
		this.giroKontoRadioButton = giroKontoRadioButton;
		this.sparKontoRadioButton = sparKontoRadioButton;
	}

	public KontoAnlegenListener(KontoAnlegen kontoAnlegenFrame) {
		this.kontoAnlegenFrame = kontoAnlegenFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {
			try {

				long kundenNummer = Long.parseLong(this.kundenNummerField
						.getText());

				if (!this.giroKontoRadioButton.isSelected()
						&& !this.sparKontoRadioButton.isSelected()) {
					new KeinKontotypException();

				} else {
					if (this.giroKontoRadioButton.isSelected()) {

						controller
								.createKonto(kundenNummer, Kontotyp.GIROKONTO);
					} else if (this.sparKontoRadioButton.isSelected()) {
						controller
								.createKonto(kundenNummer, Kontotyp.SPARKONTO);
					}

					JOptionPane.showMessageDialog(new JFrame(),
							"Konto unter für Kunde Nr. \"" + kundenNummer
									+ "\" angelegt.");
				}
			} catch (java.lang.NumberFormatException exception) {
			}

		}

		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontoAnlegenFrame.getTabsPane().remove(this.kontoAnlegenFrame);
		}
	}
}
