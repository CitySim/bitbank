package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.KundenNummerException;
import de.g18.BitBank.Gui.KundenAnlegen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public KundenAnlegenListener(JTextField kundenNummerField,
			JTextField kundenNamenField, BankController controller) {
		this.kundenAnlegenField = kundenNummerField;
		this.kundenNamenField = kundenNamenField;
		this.controller = controller;
	}

	public KundenAnlegenListener(KundenAnlegen kundenAnlegenFrame) {
		this.kundenAnlegenFrame = kundenAnlegenFrame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton buttonClicked = (JButton) event.getSource();

		if (buttonClicked.getText().compareTo("Anlegen") == 0) {

			try {
				this.controller.createKunde(this.kundenNamenField.getText(),
						Long.parseLong(this.kundenAnlegenField.getText()));

				JOptionPane.showMessageDialog(
						new JFrame(),
						"Kunde mit dem Namen \""
								+ kundenNamenField.getText()
								+ "\" und der Kontonummer \""
								+ Integer.parseInt(this.kundenAnlegenField
										.getText()) + "\" angelegt.");

			} catch (NumberFormatException e) {
				new KundenNummerException();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kundenAnlegenFrame.getTabsPane().remove(
					this.kundenAnlegenFrame);
		}
	}
}
