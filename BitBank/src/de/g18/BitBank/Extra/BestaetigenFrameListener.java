package de.g18.BitBank.Extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;

/**
 * Listener zu den Buttons der BestaetigenFrame Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class BestaetigenFrameListener implements ActionListener {

	private BankController controller;
	private String operation;
	private JFrame printFrame;
	private JTextArea kundenNummerArea;
	private JTextArea emailArea;

	public BestaetigenFrameListener(final BankController controller,
			final String operation, final JFrame printFrame,
			final JTextArea kundenNummerArea, final JTextArea emailArea) {

		this.controller = controller;
		this.operation = operation;
		this.printFrame = printFrame;
		this.kundenNummerArea = kundenNummerArea;
		this.emailArea = emailArea;

	}

	@Override
	public void actionPerformed(final ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Bestätigen") == 0) {

			long kundenNummer = 0;
			try {
				kundenNummer = Long.parseLong(this.kundenNummerArea.getText());
			} catch (NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Die Kundennummer");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}

			}

			Kunde kunde = null;
			try {
				kunde = controller.getKundeByNummer(kundenNummer);
			} catch (KundeNichtGefundenException e) {
				e.showDialog();
				return;
			}
			if (this.operation.equals("drucken")) {
				new PrintJob(null).printText(controller, kunde);

			} else if (this.operation.equals("email")) {
				try {
					try {
						new EmailJob().initializeEmailSending(controller,
								kunde, emailArea.getText());
					} catch (MessagingException e) {
						e.printStackTrace();
						return;
					}
				} catch (EmailAdresseUngueltigException e) {
					e.showDialog();
					return;
				}
			}
			this.printFrame.dispose();
		}

		else if (buttonClicked.getText().compareTo("Abbrechen") == 0) {
			this.printFrame.dispose();
		}
	}
}
