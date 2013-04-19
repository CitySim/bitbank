package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.FeldLeerException;
import de.g18.BitBank.Gui.KundenAnlegen;

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

				long kundenNummer = Long.parseLong(this.kundenAnlegenField
						.getText());
				String kundenName = this.kundenNamenField.getText();
				if (kundenName.equals("")) {
					throw new FeldLeerException("Kundenname nicht angegeben.");
				}
				this.controller.createKunde(kundenName, kundenNummer);

				JOptionPane.showMessageDialog(new JFrame(),
						"Kunde mit dem Namen \"" + kundenName
								+ "\" und der Kundennummer \"" + kundenNummer
								+ "\" angelegt.");

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Die Kundennummer ist keine gültige Zahl.", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			} catch (FeldLeerException e) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Der Kundenname muss angegeben werden.", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		if (buttonClicked.getText().compareTo("Beenden") == 0) {
			this.kundenAnlegenFrame.getTabsPane().remove(
					this.kundenAnlegenFrame);
		}
	}
}
