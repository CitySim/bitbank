package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.UeberweisungDurchfuehren;

/**
 * Listener zu den Buttons der UeberweisungDurchfuehren Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class UeberweisungDurchfuehrenListener implements ActionListener {
	private UeberweisungDurchfuehren ueberweisungDurchfuehrenFrame;
	private JTextField vomKontoField;
	private JTextField nachKontoField;
	private JTextField betragField;
	private BankController controller;
	private JDateChooser chooser;

	public UeberweisungDurchfuehrenListener(
			UeberweisungDurchfuehren ueberweisungDurchfuehrenFrame) {
		this.ueberweisungDurchfuehrenFrame = ueberweisungDurchfuehrenFrame;
	}

	public UeberweisungDurchfuehrenListener(JTextField vomKontoField,
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

			double betrag = Double.parseDouble(this.betragField.getText());
			int vomKontoNummer = Integer.parseInt(this.vomKontoField.getText());
			int nachKontoNummer = Integer.parseInt(this.nachKontoField
					.getText());
			Date datum = chooser.getDate();

			this.controller.ueberweisen(nachKontoNummer, vomKontoNummer,
					betrag, datum);

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.ueberweisungDurchfuehrenFrame.getTabsPane().remove(
					this.ueberweisungDurchfuehrenFrame);
		}
	}

}
