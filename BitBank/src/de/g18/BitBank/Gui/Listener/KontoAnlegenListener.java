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
					throw new KeinKontotypException("Kein Kontotyp ausgewählt.");

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
				JOptionPane.showMessageDialog(new JFrame(),
						"Die Kundennummer ist keine gültige Zahl.",
						"Inane error", JOptionPane.ERROR_MESSAGE);
			} catch (KeinKontotypException exception) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Bitte wählen sie einen Kontotypen aus.",
						"Inane error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kontoAnlegenFrame.getTabsPane().remove(this.kontoAnlegenFrame);
		}
	}
}
