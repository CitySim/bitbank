package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import de.g18.BitBank.Kunde;
import de.g18.BitBank.Gui.KundenAnlegen;

/**
 * Listener zu den Buttons der KundenAnlegen Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenAnlegenListener implements ActionListener {

	JTextField kundenAnlegenField;
	JTextField kundenNamenField;
	JFrame kundenAnlegenFrame;

	public KundenAnlegenListener(JTextField kundenNummerField,
			JTextField kundenNamenField) {
		this.kundenAnlegenField = kundenNummerField;
		this.kundenNamenField = kundenNamenField;
	}

	public KundenAnlegenListener(KundenAnlegen kundenAnlegenFrame) {
		this.kundenAnlegenFrame = kundenAnlegenFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {

			try {
				Kunde kunde = new Kunde(this.kundenNamenField.getText(),
						Integer.parseInt(this.kundenAnlegenField.getText()));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Die Kundennummer ist keine gültige Zahl.",
						"Inane error", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kundenAnlegenFrame.dispose();
		}
	}
}
