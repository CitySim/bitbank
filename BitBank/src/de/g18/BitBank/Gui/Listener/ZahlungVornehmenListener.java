package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Gui.ZahlungVornehmen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener zu den Buttons der ZahlungVornehmen Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class ZahlungVornehmenListener implements ActionListener {

	private ZahlungVornehmen zahlungVornehmenFrame;
	private JTextField kontoNummerField;
	private BankController controller;
	private JTextField alterKontoStandField;
	private JTextField neuerKontoStandField;
	private JTextField betragField;

	public ZahlungVornehmenListener(ZahlungVornehmen zahlungVornehmenFrame) {
		this.zahlungVornehmenFrame = zahlungVornehmenFrame;
	}

	public ZahlungVornehmenListener(JTextField kontoNummerField,
									JTextField alterKontoStandField, JTextField neuerKontoStandField,
									JTextField betragField, BankController controller) {
		this.kontoNummerField = kontoNummerField;
		this.alterKontoStandField = alterKontoStandField;
		this.neuerKontoStandField = neuerKontoStandField;
		this.betragField = betragField;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();
		int kontoNummer = 0;
		try {
			kontoNummer = Integer.parseInt(this.kontoNummerField.getText());
		} catch (java.lang.NumberFormatException exception) {

		}

		if (buttonClicked.getText().compareTo("Kontostand") == 0) {
			try {
				alterKontoStandField.setText(Double.toString(this.controller.kontoStandAnzeigen(kontoNummer)));
			} catch (KontoNichtGefundenException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.OK_OPTION);
				return;
			}
		} else if (buttonClicked.getText().compareTo("Einzahlung") == 0) {
			double betrag;

			try {
				betrag = Double.parseDouble(this.betragField.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Betrag konnte nicht gelesen werden", "Fehler", JOptionPane.OK_OPTION);
				return;
			}

			try {
				this.controller.einzahlen(kontoNummer, betrag);
			} catch (KontoNichtGefundenException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.OK_OPTION);
				return;
			} catch (BetragNegativException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Betrag Negativ", JOptionPane.OK_OPTION);
				return;
			}

			this.aktualisieren(kontoNummer);

		} else if (buttonClicked.getText().compareTo("Auszahlung") == 0) {
			double betrag;

			try {
				betrag = Double.parseDouble(this.betragField.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Betrag konnte nicht gelesen werden", "Fehler", JOptionPane.OK_OPTION);
				return;
			}

			try {
				this.controller.auszahlen(kontoNummer, betrag);
			} catch (KontoNichtGefundenException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.OK_OPTION);
				return;
			} catch (KontoLeerException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.OK_OPTION);
				return;
			} catch (BetragNegativException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.OK_OPTION);
				return;
			}

			this.aktualisieren(kontoNummer);
		} else if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.zahlungVornehmenFrame.getTabsPane().remove(
					this.zahlungVornehmenFrame);
		}
	}

	public void aktualisieren(int kontoNummer) {
		if (!this.neuerKontoStandField.getText().equals("")) {
			this.alterKontoStandField.setText(this.neuerKontoStandField.getText());
		}

		try {
			this.neuerKontoStandField.setText(Double.toString(this.controller.kontoStandAnzeigen(kontoNummer)));
		} catch (KontoNichtGefundenException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler", JOptionPane.OK_OPTION);
			return;
		}
	}
}
