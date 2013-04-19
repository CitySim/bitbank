package de.g18.BitBank.Gui.Listener;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

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

	public UeberweisungDurchfuehrenListener(
			UeberweisungDurchfuehren ueberweisungDurchfuehrenFrame) {
		this.ueberweisungDurchfuehrenFrame = ueberweisungDurchfuehrenFrame;
	}

	public UeberweisungDurchfuehrenListener(JTextField vomKontoField,
			JTextField nachKontoField, JTextField betragField,
			BankController controller) {

		this.vomKontoField = vomKontoField;
		this.nachKontoField = nachKontoField;
		this.betragField = betragField;
		this.controller = controller;

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Date datum = new java.util.Date();
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Datum auswählen") == 0) {
			this.createCalender();

			datum = new java.util.Date();

		}
		if (buttonClicked.getText().compareTo("Überweisen") == 0) {

			double betrag = Double.parseDouble(this.betragField.getText());
			int vomKontoNummer = Integer.parseInt(this.vomKontoField.getText());
			int nachKontoNummer = Integer.parseInt(this.nachKontoField
					.getText());

			this.controller.ueberweisen(nachKontoNummer, vomKontoNummer,
					betrag, datum);

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.ueberweisungDurchfuehrenFrame.getTabsPane().remove(
					this.ueberweisungDurchfuehrenFrame);
		}
	}

	public JDialog createCalender() {
		JDialog dlg = new JDialog(new Frame(), true);
		JCalendar calender = new JCalendar();

		dlg.add(calender);
		// calender.set
		// dp.setHideOnSelect(false);
		// dlg.getContentPane().add(dp);
		// dlg.pack();
		// dlg.setVisible(true);
		// System.out.println(dp.getDate().toString());

		return dlg;
	}
}
