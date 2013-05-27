package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kontotyp;
import de.g18.BitBank.Exception.KeinKontotypException;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;
import de.g18.BitBank.Gui.KontoAnlegen;
import de.g18.BitBank.Gui.KundenAuswahl;

/**
 * Listener zu den Buttons der KontoAnlegen Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KontoAnlegenListener implements ActionListener {

    private final JTextField kundenNummerField;
    private final KontoAnlegen kontoAnlegenFrame;
    private final BankController controller;
    private final JRadioButton giroKontoRadioButton;
    private final JRadioButton sparKontoRadioButton;

    public KontoAnlegenListener(
            final BankController controller,
            final KontoAnlegen kontoAnlegenFrame,
            final JTextField kundenNummerField,
            final JRadioButton giroKontoRadioButton,
            final JRadioButton sparKontoRadioButton) {

        this.controller = controller;
        this.kontoAnlegenFrame = kontoAnlegenFrame;
        this.kundenNummerField = kundenNummerField;
        this.giroKontoRadioButton = giroKontoRadioButton;
        this.sparKontoRadioButton = sparKontoRadioButton;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Kunde suchen") == 0) {
            new KundenAuswahl(this.controller, this.kundenNummerField);

        } else if (buttonClicked.getText().compareTo("Anlegen") == 0) {
            try {

                final long kundenNummer = Long.parseLong(this.kundenNummerField.getText());

                if (!this.giroKontoRadioButton.isSelected() && !this.sparKontoRadioButton.isSelected()) {
                    throw new KeinKontotypException("Kein Kontotyp ausgewählt.");

                } else {
                    if (this.giroKontoRadioButton.isSelected()) {
                        this.controller.createKonto(kundenNummer, Kontotyp.GIROKONTO);
                    } else if (this.sparKontoRadioButton.isSelected()) {
                        this.controller.createKonto(kundenNummer, Kontotyp.SPARKONTO);
                    }

                    this.showCreationDialog(kundenNummer);
                }
            } catch (final java.lang.NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Die Kundennummer");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }
            } catch (final KeinKontotypException e) {
                e.showDialog();
                return;
            } catch (final KundeNichtGefundenException e) {
                e.showDialog();
                return;
            }

        } else if (buttonClicked.getText().compareTo("Schließen") == 0) {
            this.kontoAnlegenFrame.getTabsPane().remove(this.kontoAnlegenFrame);
        }
    }

    // zeigt den Dialog für erfolgreiches Anlegen an.
    private void showCreationDialog(final long kundenNummer) {
        JOptionPane.showMessageDialog(new JFrame(), "Konto unter für Kunde Nr. \"" + kundenNummer + "\" angelegt.");
    }
}
