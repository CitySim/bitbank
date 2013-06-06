package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.NumberParser;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.BetragZuGrossException;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Exception.ZuVieleNachkommastellenException;
import de.g18.BitBank.Gui.ZahlungVornehmen;

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

    public ZahlungVornehmenListener(
            final JTextField kontoNummerField,
            final JTextField alterKontoStandField,
            final JTextField neuerKontoStandField,
            final JTextField betragField,
            final BankController controller) {
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
            final JTextField betragField,
            final BankController controller) {
        new ZahlungVornehmenListener(betragField, betragField, betragField, betragField, controller);
        this.zahlungVornehmenFrame = zahlungVornehmenFrame;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();
        final NumberParser parser = new NumberParser();

        if (buttonClicked.getText().compareTo("Kontostand") == 0) {
            long kontoNummer = 0;
            this.cleanUp();
            try {
                kontoNummer = this.ermittleKontoNummer();
            } catch (final KeineGueltigeZahlException e) {
                e.showDialog();
                return;
            }

            try {

                this.alterKontoStandField.setText(NumberFormat.getCurrencyInstance().format(
                        this.controller.kontoStandAnzeigen(kontoNummer)));

            } catch (final KontoNichtGefundenException e1) {
                e1.showDialog();
                return;
            }
        } else if (buttonClicked.getText().compareTo("Einzahlung") == 0) {
            long kontoNummer;
            try {
                kontoNummer = this.ermittleKontoNummer();
            } catch (final KeineGueltigeZahlException e) {
                e.showDialog();
                return;
            }
            double betrag = 0;

            try {
                betrag = parser.parseDouble(this.betragField.getText());
            } catch (final NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Der Betrag");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }
            } catch (final ZuVieleNachkommastellenException e) {
                e.showDialog();
                return;
            } catch (final BetragZuGrossException e) {
                e.showDialog();
                return;
            }

            try {
                this.controller.einzahlen(kontoNummer, betrag);
            } catch (final KontoNichtGefundenException e) {
                e.showDialog();
                return;
            } catch (final BetragNegativException e) {
                e.showDialog();
                return;
            }

            this.aktualisieren(kontoNummer);

        } else if (buttonClicked.getText().compareTo("Auszahlung") == 0) {
            long kontoNummer = 0;
            try {
                kontoNummer = this.ermittleKontoNummer();
            } catch (final KeineGueltigeZahlException e) {
                e.showDialog();
            }
            double betrag = 0;

            try {
                betrag = parser.parseDouble(this.betragField.getText());
            } catch (final NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Der Betrag");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }
            } catch (final ZuVieleNachkommastellenException e) {
                e.showDialog();
                return;
            } catch (final BetragZuGrossException e) {
                e.showDialog();
                return;
            }

            try {
                this.controller.auszahlen(kontoNummer, betrag);
            } catch (final KontoNichtGefundenException e) {
                e.showDialog();
                return;
            } catch (final KontoLeerException e) {
                e.showDialog();
                return;
            } catch (final BetragNegativException e) {
                e.showDialog();
                return;
            }

            this.aktualisieren(kontoNummer);
        } else if (buttonClicked.getText().compareTo("Schließen") == 0) {
            this.zahlungVornehmenFrame.getTabsPane().remove(this.zahlungVornehmenFrame);
        }
    }

    private void aktualisieren(final long kontoNummer) {
        if (!this.neuerKontoStandField.getText().equals("")) {
            this.alterKontoStandField.setText(this.neuerKontoStandField.getText());
        }

        try {

            this.neuerKontoStandField.setText(NumberFormat.getCurrencyInstance().format(
                    (this.controller.kontoStandAnzeigen(kontoNummer))));
        } catch (final KontoNichtGefundenException e) {
            e.showDialog();
        }
    }

    // Methode zum ermitteln der Kontonummer.
    private long ermittleKontoNummer() throws KeineGueltigeZahlException {
        long kontoNummer;
        try {
            kontoNummer = Long.parseLong(this.kontoNummerField.getText());
        } catch (final NumberFormatException e) {
            throw new KeineGueltigeZahlException("Kontonummer");
        }
        return kontoNummer;
    }

    // Methode zum clearen des Frames.
    private void cleanUp() {
        this.neuerKontoStandField.setText("");
        this.betragField.setText("");
    }
}
