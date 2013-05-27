package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;
import de.g18.BitBank.Gui.KontenListe;
import de.g18.BitBank.Gui.TableModels.KontenTableModel;

/**
 * Listener zu den Buttons der KontenListe Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KontenListeListener implements ActionListener {

    private final KontenListe kontenListeFrame;
    private final BankController controller;

    public KontenListeListener(final KontenListe kontenListeFrame, final BankController controller) {
        this.kontenListeFrame = kontenListeFrame;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Kontoübersicht") == 0) {
            long kundenNummer = 0;
            try {
                kundenNummer = Long.parseLong(this.kontenListeFrame.getKundenNummer().getText());
            } catch (final NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Die Kundennummer");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }

            }

            Kunde kunde = null;
            try {
                kunde = this.controller.getKundeByNummer(kundenNummer);
            } catch (final KundeNichtGefundenException e) {
                e.showDialog();
                return;
            }

            this.kontenListeFrame.getTable().setModel(new KontenTableModel(kunde));
            this.kontenListeFrame.getTabsPane().setTitleAt(
                    this.kontenListeFrame.getTabsPane().getSelectedIndex(),
                    "Kunde " + Long.toString(kundenNummer));
        }
        if (buttonClicked.getText().compareTo("Schließen") == 0) {
            this.kontenListeFrame.getTabsPane().remove(this.kontenListeFrame);
        }
    }
}
