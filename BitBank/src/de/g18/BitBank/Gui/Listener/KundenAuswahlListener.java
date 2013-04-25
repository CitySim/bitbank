package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.KundenAuswahl;

/**
 * Listener zur KundenAuswahl Klasse.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenAuswahlListener implements ActionListener {

	private JList<Object> liste;
	private KundenAuswahl kundenAuswahl;

	private BankController controller;

	public KundenAuswahlListener(JList<Object> liste,
			KundenAuswahl kundenAuswahl, BankController controller) {

		this.liste = liste;
		this.kundenAuswahl = kundenAuswahl;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.kundenAuswahl.setKundenNummerField(this.controller
				.getKundeByIndex(liste.getSelectedIndex()));
		this.kundenAuswahl.dispose();
	}
}
