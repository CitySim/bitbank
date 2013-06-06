package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Konto;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Gui.Kontobewegungen;
import de.g18.BitBank.Gui.TableModels.KontoBewegungenTableModel;

/**
 * Listener zu den Buttons der KontostandsUebersichtAnzeigen Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public final class KontobewegungenListener implements ActionListener {

    private final Kontobewegungen kontobewegungenFrame;
    private final BankController controller;

    public KontobewegungenListener(final Kontobewegungen kontobewegungenFrame, final BankController controller) {
        this.kontobewegungenFrame = kontobewegungenFrame;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Kontobewegungen") == 0) {
            long kontonummer = 0;
            try {
                kontonummer = Long.parseLong(this.kontobewegungenFrame.getKontoNummer().getText());
            } catch (final NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Die Kontonummer");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }

            }

            Konto konto = null;
            try {
                konto = this.controller.getKontoByKontoNummer(kontonummer);
                this.kontobewegungenFrame.getTabsPane().setTitleAt(
                        this.kontobewegungenFrame.getTabsPane().getSelectedIndex(),
                        "Konto " + Long.toString(kontonummer));
            } catch (final KontoNichtGefundenException e) {
                e.showDialog();
                return;
            }

            this.kontobewegungenFrame.getTable().setModel(new KontoBewegungenTableModel(konto));
        } else if (buttonClicked.getText().compareTo("Schließen") == 0) {
            this.kontobewegungenFrame.getTabsPane().remove(this.kontobewegungenFrame);
        }
    }
}
