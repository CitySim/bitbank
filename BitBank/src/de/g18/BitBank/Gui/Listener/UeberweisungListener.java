package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import com.toedter.calendar.JDateChooser;
import de.g18.BitBank.BankController;
import de.g18.BitBank.NumberParser;
import de.g18.BitBank.Exception.*;
import de.g18.BitBank.Gui.UeberweisungVornehmen;

import javax.swing.*;

/**
 * Listener zu den Buttons der UeberweisungVornehmen Klasse.
 * <p/>
 * /** F Listener zu den Buttons der UeberweisungVornehmen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class UeberweisungListener implements ActionListener {
	private UeberweisungVornehmen ueberweisungVornehmenFrame;
	private JTextField vomKontoField;
	private JTextField nachKontoField;
	private JTextField betragField;
	private BankController controller;
	private JDateChooser chooser;

	public UeberweisungListener(
			final UeberweisungVornehmen ueberweisungVornehmenFrame) {
		this.ueberweisungVornehmenFrame = ueberweisungVornehmenFrame;
	}

	public UeberweisungListener(final JTextField vomKontoField,
			final JTextField nachKontoField, final JTextField betragField,
			final BankController controller, final JDateChooser chooser) {

		this.vomKontoField = vomKontoField;
		this.nachKontoField = nachKontoField;
		this.betragField = betragField;
		this.controller = controller;
		this.chooser = chooser;

	}

	@Override
	public void actionPerformed(final ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Überweisen") == 0) {
			double betrag;
			int vomKontoNummer;
			int nachKontoNummer;

			try {
				betrag = new NumberParser().parseDouble(this.betragField
						.getText());
				vomKontoNummer = Integer.parseInt(this.vomKontoField.getText());
				nachKontoNummer = Integer.parseInt(this.nachKontoField
						.getText());
			} catch (NumberFormatException e) {
				try {
					throw new KeineGueltigeZahlException("Eine der Nummern");
				} catch (KeineGueltigeZahlException e1) {
					e1.showDialog();
					return;
				}
			}

			Date datum = chooser.getDate();

			if (datum == null) {
				new DateException("Kein Datum gewählt").showDialog();
				return;
			}

			try {
				this.controller.ueberweisen(nachKontoNummer, vomKontoNummer,
						betrag, datum);

				this.cleanUp();
				this.showCreationDialog(vomKontoNummer, nachKontoNummer, betrag);

			} catch (KontoLeerException e) {
				e.showDialog();
				return;
			} catch (BetragNegativException e) {
				e.showDialog();
				return;
			} catch (KontoNichtGefundenException e) {
				e.showDialog();
				return;
			}
		} else if (buttonClicked.getText().compareTo("Schließen") == 0) {
			this.ueberweisungVornehmenFrame.getTabsPane().remove(
					this.ueberweisungVornehmenFrame);
		}
	}

	public final void showCreationDialog(final int vomKontoNummer,
			final int nachKontoNummer, final double betrag) {
		JOptionPane.showMessageDialog(null, "Ihre Überweisung über \"" + betrag
				+ "\" von \"" + vomKontoNummer + "\" nach\"" + nachKontoNummer
				+ "\" wurde erfolgreich durchgeführt.");
	}

	public void cleanUp() {
		// this.vomKontoField.setText("");
		this.nachKontoField.setText("");
		this.betragField.setText("");
		this.chooser.setDate(null);
	}
}
