package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Exception.FeldLeerException;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KundenNummerUnzulaessigException;
import de.g18.BitBank.Exception.KundenNummerVergebenException;
import de.g18.BitBank.Gui.KundenAnlegen;

/**
 * Listener zu den Buttons der KundenAnlegen Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KundenAnlegenListener implements ActionListener {

    private JTextField kundenAnlegenField;
    private JTextField kundenNamenField;
    private KundenAnlegen kundenAnlegenFrame;
    private BankController controller;

    public KundenAnlegenListener(
            final JTextField kundenNummerField,
            final JTextField kundenNamenField,
            final BankController controller) {
        this.kundenAnlegenField = kundenNummerField;
        this.kundenNamenField = kundenNamenField;
        this.controller = controller;
    }

    public KundenAnlegenListener(final KundenAnlegen kundenAnlegenFrame) {
        this.kundenAnlegenFrame = kundenAnlegenFrame;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {
        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Anlegen") == 0) {

            try {

                final long kundenNummer = Long.parseLong(this.kundenAnlegenField.getText());
                if (kundenNummer <= 0) {
                    throw new KundenNummerUnzulaessigException("Kundennummer darf nicht kleiner 0 sein");
                }
                final String kundenName = this.kundenNamenField.getText();
                if (kundenName.equals("")) {
                    throw new FeldLeerException("Kundenname");
                }

                this.controller.createKunde(kundenName, kundenNummer);
                this.kundenAnlegenField.setText("");
                this.kundenNamenField.setText("");
                this.showCreationDialog(kundenName, kundenNummer);

            } catch (final NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Die Kundennummer");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }

            } catch (final FeldLeerException e) {
                e.showDialog();
                return;

            } catch (final KundenNummerVergebenException e) {
                e.showDialog();
                return;

            } catch (final KundenNummerUnzulaessigException e) {
                e.showDialog();
                return;
            }

        }
        if (buttonClicked.getText().compareTo("Schließen") == 0) {
            this.kundenAnlegenFrame.getTabsPane().remove(this.kundenAnlegenFrame);
        }
    }

    // zeigt den Dialog für erfolgreiches Anlegen an.
    private void showCreationDialog(final String kundenName, final long kundenNummer) {
        JOptionPane.showMessageDialog(null, "Kunde mit dem Namen \"" + kundenName + "\" und der Kundennummer \"" + kundenNummer
                + "\" angelegt.");

    }
}
