package de.g18.BitBank.Gui.Listener;

import com.toedter.calendar.JDateChooser;
import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Gui.Ueberweisung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Listener zu den Buttons der Ueberweisung Klasse.
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

	public UeberweisungListener(
			Ueberweisung ueberweisungFrame) {
		this.ueberweisungFrame = ueberweisungFrame;
	}

	public UeberweisungListener(JTextField vomKontoField,
								JTextField nachKontoField, JTextField betragField,
								BankController controller, JDateChooser chooser) {

		this.vomKontoField = vomKontoField;
		this.nachKontoField = nachKontoField;
		this.betragField = betragField;
		this.controller = controller;
		this.chooser = chooser;

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Überweisen") == 0) {
			double betrag = 0;
			int vomKontoNummer = 0;
			int nachKontoNummer = 0;

			try {
				betrag = Double.parseDouble(this.betragField.getText());
				vomKontoNummer = Integer.parseInt(this.vomKontoField.getText());
				nachKontoNummer = Integer.parseInt(this.nachKontoField.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Bitee prüfen zahl eingabe dU§$", "zHAl", JOptionPane.OK_OPTION);
				return;
			}

			Date datum = chooser.getDate();

			try {
				this.controller.ueberweisen(nachKontoNummer, vomKontoNummer, betrag, datum);
			} catch (KontoLeerException e) {
				JOptionPane.showMessageDialog(null, "Konto leer:", "Fehler", JOptionPane.OK_OPTION);
				return;
			} catch (BetragNegativException e) {
				JOptionPane.showMessageDialog(null, "betrag nicht negativvvröjrea", "Fehler", JOptionPane.OK_OPTION);
				return;
			}

		} else if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.ueberweisungFrame.getTabsPane().remove(
					this.ueberweisungFrame);
		}
	}

}
