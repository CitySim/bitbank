package de.g18.BitBank.Gui.Listener;

import com.toedter.calendar.JDateChooser;
import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KeineGültigeZahlException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Gui.Ueberweisung;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Listener zu den Buttons der Ueberweisung Klasse.
 * <p/>
 * /** F Listener zu den Buttons der Ueberweisung Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class UeberweisungListener implements ActionListener {
	private Ueberweisung ueberweisungFrame;
	private JTextField vomKontoField;
	private JTextField nachKontoField;
	private JTextField betragField;
	private BankController controller;
	private JDateChooser chooser;

	public UeberweisungListener(final Ueberweisung ueberweisungFrame) {
		this.ueberweisungFrame = ueberweisungFrame;
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
			double betrag = 0;
			int vomKontoNummer = 0;
			int nachKontoNummer = 0;

			try {
				betrag = Double.parseDouble(this.betragField.getText());
				vomKontoNummer = Integer.parseInt(this.vomKontoField.getText());
				nachKontoNummer = Integer.parseInt(this.nachKontoField
						.getText());
			} catch (NumberFormatException e) {
				try {
					throw new KeineGültigeZahlException("Eine der Nummern");
				} catch (KeineGültigeZahlException e1) {
					e1.showDialog();
					return;
				}
			}

			Date datum = chooser.getDate();

			if (datum == null) {
				JOptionPane.showMessageDialog(null,
						"Bitte wählen sie ein Datum", "Fehler",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.showCreationDialog(vomKontoNummer, nachKontoNummer, betrag);
			try {
				this.controller.ueberweisen(nachKontoNummer, vomKontoNummer,
						betrag, datum);

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
		} else if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.ueberweisungFrame.getTabsPane().remove(this.ueberweisungFrame);
		}
	}

	public void showCreationDialog(int vomKontoNummer, int nachKontoNummer,
			double betrag) {
		JOptionPane.showMessageDialog(new JFrame(), "Ihre Überweisung über \""
				+ betrag + "\" von \"" + vomKontoNummer + "\" nach\""
				+ nachKontoNummer + "\" wurde erfolgreich durchgeführt.");
	}
}
