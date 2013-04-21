package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.FeldLeerException;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundenNummerUnzulaessigException;
import de.g18.BitBank.Exception.KundenNummerVergebenException;
import de.g18.BitBank.Gui.KundenAnlegen;

import javax.swing.*;
import java.awt.event.*;

/**
 * Listener zu den Buttons der KundenAnlegen Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KundenAnlegenListener implements ActionListener {
	private JTextField kundenAnlegenField;
	private JTextField kundenNamenField;
	private KundenAnlegen kundenAnlegenFrame;
	private BankController controller;

	public KundenAnlegenListener(final JTextField kundenNummerField,
								 final JTextField kundenNamenField,
								 final BankController controller) {
		this.kundenAnlegenField = kundenNummerField;
		this.kundenNamenField = kundenNamenField;
		this.controller = controller;
	}

	public KundenAnlegenListener(final KundenAnlegen kundenAnlegenFrame) {
		this.kundenAnlegenFrame = kundenAnlegenFrame;
	}

	@Override
	public void actionPerformed(final ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {

			try {

				long kundenNummer = Long.parseLong(this.kundenAnlegenField
						.getText());
				if (kundenNummer <= 0) {
					throw new KundenNummerUnzulaessigException(
							"Kundennummer darf nicht kleiner 0 sein");
				}
				String kundenName = this.kundenNamenField.getText();
				if (kundenName.equals("")) {
					throw new FeldLeerException("Kundenname");
				}

				this.controller.createKunde(kundenName, kundenNummer);
				this.showCreationDialog(kundenName, kundenNummer);

			} catch (NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Die Kundennummer");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}

			} catch (FeldLeerException e) {
				e.showDialog();
				return;

			} catch (KundenNummerVergebenException e) {
				e.showDialog();
				return;

			} catch (KundenNummerUnzulaessigException e) {
				e.showDialog();
				return;
			}

		}
		if (buttonClicked.getText().compareTo("Schließen") == 0) {
			this.kundenAnlegenFrame.getTabsPane().remove(
					this.kundenAnlegenFrame);
		}
	}

	public final void showCreationDialog(final String kundenName,
			final long kundenNummer) {
		JOptionPane.showMessageDialog(null, "Kunde mit dem Namen \""
				+ kundenName + "\" und der Kundennummer \"" + kundenNummer
				+ "\" angelegt.");

	}
}
