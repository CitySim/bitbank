package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.g18.BitBank.Gui.KundenListe;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KundenListeListener implements ActionListener {

    private final KundenListe kundenListeFrame;

    public KundenListeListener(final KundenListe kundenListeFrame) {
        this.kundenListeFrame = kundenListeFrame;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {
        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Schließen") == 0) {
            this.kundenListeFrame.getTabsPane().remove(this.kundenListeFrame);
        }
    }
}
