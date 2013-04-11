package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Listener zu den Buttons der KontoAnlegen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KontoAnlegenListener implements ActionListener {

	JTextField kundenNummerField;

	public KontoAnlegenListener(JTextField kundenNummerField) {
		this.kundenNummerField = kundenNummerField;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {
			try {
				int kundenNummer = Integer.parseInt(this.kundenNummerField
						.getText());

				JOptionPane.showMessageDialog(new JFrame(),
						"Konto unter Nummer " + kundenNummer + " angelegt.");

			} catch (java.lang.NumberFormatException exception) {

				JOptionPane.showMessageDialog(new JFrame(),
						"Die Kundennummer ist keine gültige Zahl.",
						"Inane error", JOptionPane.ERROR_MESSAGE);

			}

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			System.exit(1);
		}

	}
}
