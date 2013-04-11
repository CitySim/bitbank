package de.g18.BitBank.Gui.Listener;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

import com.theotherbell.ui.DatePicker;

/**
 * Listener zu den Buttons der UeberweisungDurchfuehren Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class UeberweisungDurchfuehrenListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Datum auswählen") == 0) {
			this.createCalender();

		}
		if (buttonClicked.getText().compareTo("Überweisen") == 0) {

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			System.exit(1);
		}

	}

	public JDialog createCalender() {

		JDialog dlg = new JDialog(new Frame(), true);
		DatePicker dp = new DatePicker();
		dp.setHideOnSelect(false);
		dlg.getContentPane().add(dp);
		dlg.pack();
		dlg.setVisible(true);
		System.out.println(dp.getDate().toString());

		return dlg;

	}
}
