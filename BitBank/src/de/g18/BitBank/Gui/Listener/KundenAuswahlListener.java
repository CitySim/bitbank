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
 * @since jdk1.7.0_17
 */

public class KundenAuswahlListener implements ActionListener {

    private final JList<Object> liste;
    private final KundenAuswahl kundenAuswahl;

    private final BankController controller;

    public KundenAuswahlListener(final JList<Object> liste, final KundenAuswahl kundenAuswahl, final BankController controller) {

        this.liste = liste;
        this.kundenAuswahl = kundenAuswahl;
        this.controller = controller;
    }

    @Override
    public final void actionPerformed(final ActionEvent e) {
        this.kundenAuswahl.setKundenNummerField(this.controller.getKundeByIndex(this.liste.getSelectedIndex()));
        this.kundenAuswahl.dispose();
    }
}
