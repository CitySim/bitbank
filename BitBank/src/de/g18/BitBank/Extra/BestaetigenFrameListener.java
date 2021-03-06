package de.g18.BitBank.Extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;

/**
 * Listener zu den Buttons der BestaetigenFrame Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

class BestaetigenFrameListener implements ActionListener {

    private final BankController controller;
    private final String operation;
    private final JFrame printFrame;
    private final JTextField kundenNummerField;
    private final JTextField emailField;

    public BestaetigenFrameListener(
            final BankController controller,
            final String operation,
            final JFrame printFrame,
            final JTextField kundenNummerField,
            final JTextField emailField) {

        this.controller = controller;
        this.operation = operation;
        this.printFrame = printFrame;
        this.kundenNummerField = kundenNummerField;
        this.emailField = emailField;

    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Bestätigen") == 0) {

            long kundenNummer = 0;
            try {
                kundenNummer = Long.parseLong(this.kundenNummerField.getText());
            } catch (final NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Die Kundennummer");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }

            }

            Kunde kunde = null;
            try {
                kunde = this.controller.getKundeByNummer(kundenNummer);
            } catch (final KundeNichtGefundenException e) {
                e.showDialog();
                return;
            }
            if (this.operation.equals("drucken")) {
                new PrintJob(null).printText(kunde);

            } else if (this.operation.equals("email")) {
                try {
                    try {
                        new EmailJob().initializeEmailSending(kunde, this.emailField.getText());
                    } catch (final MessagingException e) {
                        new EmailException(e.getMessage()).showDialog();
                        return;
                    }
                } catch (final EmailAdresseUngueltigException e) {
                    e.showDialog();
                    return;
                }
            }

            this.printFrame.dispose();

        } else if (buttonClicked.getText().compareTo("Abbrechen") == 0) {
            this.printFrame.dispose();
        }
    }
}
