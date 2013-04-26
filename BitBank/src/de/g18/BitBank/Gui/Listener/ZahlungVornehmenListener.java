package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.*;
import de.g18.BitBank.Gui.ZahlungVornehmen;
import de.g18.BitBank.NumberParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Listener zu den Buttons der ZahlungVornehmen Klasse.
 *
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class ZahlungVornehmenListener implements ActionListener {

	private ZahlungVornehmen zahlungVornehmenFrame;
	private JTextField kontoNummerField;
	private BankController controller;
	private JTextField alterKontoStandField;
	private JTextField neuerKontoStandField;
	private JTextField betragField;

	public ZahlungVornehmenListener(final JTextField kontoNummerField,
									final JTextField alterKontoStandField,
									final JTextField neuerKontoStandField,
									final JTextField betragField, final BankController controller) {
		this.kontoNummerField = kontoNummerField;
		this.alterKontoStandField = alterKontoStandField;
		this.neuerKontoStandField = neuerKontoStandField;
		this.betragField = betragField;
		this.controller = controller;
	}

	public ZahlungVornehmenListener(
			final ZahlungVornehmen zahlungVornehmenFrame,
			final JTextField kontoNummerField,
			final JTextField alterKontoStandField,
			final JTextField neuerKontoStandField,
			final JTextField betragField, final BankController controller) {
		new ZahlungVornehmenListener(betragField, betragField, betragField,
				betragField, controller);
		this.zahlungVornehmenFrame = zahlungVornehmenFrame;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();
		NumberParser parser = new NumberParser();

		if (buttonClicked.getText().compareTo("Kontostand") == 0) {
			long kontoNummer = 0;
			this.cleanUp();
			try {
				kontoNummer = this.ermittleKontoNummer();
			} catch (KeineGueltigeZahlException e) {
				e.showDialog();
				return;
			}

			try {

				this.alterKontoStandField
						.setText(NumberFormat.getCurrencyInstance()
								.format(this.controller
										.kontoStandAnzeigen(kontoNummer)));

			} catch (KontoNichtGefundenException e1) {
				e1.showDialog();
				return;
			}
		} else if (buttonClicked.getText().compareTo("Einzahlung") == 0) {
			long kontoNummer;
			try {
				kontoNummer = this.ermittleKontoNummer();
			} catch (KeineGueltigeZahlException e) {
				e.showDialog();
				return;
			}
			double betrag = 0;

			try {
				betrag = parser.parseDouble(this.betragField.getText());
			} catch (NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Der Betrag");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}
			} catch (ZuVieleNachkommastellenException e) {
				e.showDialog();
				return;
			} catch (BetragZuGroßException e) {
				e.showDialog();
				return;
			}

			try {
				this.controller.einzahlen(kontoNummer, betrag);
			} catch (KontoNichtGefundenException e) {
				e.showDialog();
				return;
			} catch (BetragNegativException e) {
				e.showDialog();
				return;
			}

			this.aktualisieren(kontoNummer);

		} else if (buttonClicked.getText().compareTo("Auszahlung") == 0) {
			long kontoNummer = 0;
			try {
				kontoNummer = this.ermittleKontoNummer();
			} catch (KeineGueltigeZahlException e) {
				e.showDialog();
			}
			double betrag = 0;

			try {
				betrag = parser.parseDouble(this.betragField.getText());
			} catch (NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Der Betrag");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}
			} catch (ZuVieleNachkommastellenException e) {
				e.showDialog();
				return;
			} catch (BetragZuGroßException e) {
				e.showDialog();
				return;
			}

			try {
				this.controller.auszahlen(kontoNummer, betrag);
			} catch (KontoNichtGefundenException e) {
				e.showDialog();
				return;
			} catch (KontoLeerException e) {
				e.showDialog();
				return;
			} catch (BetragNegativException e) {
				e.showDialog();
				return;
			}

			this.aktualisieren(kontoNummer);
		} else if (buttonClicked.getText().compareTo("Schließen") == 0) {
			this.zahlungVornehmenFrame.getTabsPane().remove(
					this.zahlungVornehmenFrame);
		}
	}

	private void aktualisieren(final long kontoNummer) {
		if (!this.neuerKontoStandField.getText().equals("")) {
			this.alterKontoStandField.setText(this.neuerKontoStandField
					.getText());
		}

		try {

			this.neuerKontoStandField.setText(NumberFormat
					.getCurrencyInstance().format(
							(this.controller.kontoStandAnzeigen(kontoNummer))));
		} catch (KontoNichtGefundenException e) {
			e.showDialog();
		}
	}

	private long ermittleKontoNummer() throws KeineGueltigeZahlException {
		long kontoNummer;
		try {
			kontoNummer = Long.parseLong(this.kontoNummerField.getText());
		} catch (NumberFormatException e) {
			throw new KeineGueltigeZahlException("Kontonummer");
		}
		return kontoNummer;
	}

	private void cleanUp() {
		this.neuerKontoStandField.setText("");
		this.betragField.setText("");
	}
}
