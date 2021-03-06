package de.g18.BitBank.Gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import de.g18.BitBank.BankController;
import de.g18.BitBank.NumberParser;
import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.BetragZuGrossException;
import de.g18.BitBank.Exception.DateException;
import de.g18.BitBank.Exception.KeineGueltigeZahlException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Exception.ZuVieleNachkommastellenException;
import de.g18.BitBank.Gui.UeberweisungVornehmen;

/**
 * Listener zu den Buttons der UeberweisungVornehmen Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class UeberweisungListener implements ActionListener {

    private UeberweisungVornehmen ueberweisungVornehmenFrame;
    private JTextField vomKontoField;
    private JTextField nachKontoField;
    private JTextField betragField;
    private BankController controller;
    private JDateChooser chooser;

    public UeberweisungListener(final UeberweisungVornehmen ueberweisungVornehmenFrame) {
        this.ueberweisungVornehmenFrame = ueberweisungVornehmenFrame;
    }

    public UeberweisungListener(
            final JTextField vomKontoField,
            final JTextField nachKontoField,
            final JTextField betragField,
            final BankController controller,
            final JDateChooser chooser) {

        this.vomKontoField = vomKontoField;
        this.nachKontoField = nachKontoField;
        this.betragField = betragField;
        this.controller = controller;
        this.chooser = chooser;

    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Überweisen") == 0) {
            double betrag = 0;
            int vomKontoNummer;
            int nachKontoNummer = 0;

            try {

                vomKontoNummer = Integer.parseInt(this.vomKontoField.getText());
                nachKontoNummer = Integer.parseInt(this.nachKontoField.getText());
                betrag = new NumberParser().parseDouble(this.betragField.getText());

            } catch (final NumberFormatException e) {
                try {
                    throw new KeineGueltigeZahlException("Eine der Nummern");
                } catch (final KeineGueltigeZahlException e1) {
                    e1.showDialog();
                    return;
                }
            } catch (final ZuVieleNachkommastellenException e) {
                e.showDialog();
                return;
            } catch (final BetragZuGrossException e) {
                e.showDialog();
                return;
            }

            final Date datum = this.chooser.getDate();

            if (datum == null) {
                new DateException("Es wurde kein Datum ausgewählt.").showDialog();
                return;
            }

            if (datum.compareTo(this.getDate()) < 0) {
                new DateException("Überweisungen in der Vergangenheit sind unzulässig.").showDialog();
                return;
            }

            try {
                this.controller.ueberweisen(nachKontoNummer, vomKontoNummer, betrag, datum);

                this.cleanUp();
                this.showCreationDialog(vomKontoNummer, nachKontoNummer, betrag);

            } catch (final KontoLeerException e) {
                e.showDialog();
                return;
            } catch (final BetragNegativException e) {
                e.showDialog();
                return;
            } catch (final KontoNichtGefundenException e) {
                e.showDialog();
                return;
            }
        } else if (buttonClicked.getText().compareTo("Schließen") == 0) {
            this.ueberweisungVornehmenFrame.getTabsPane().remove(this.ueberweisungVornehmenFrame);
        }
    }

    // zeigt den Dialog für erfolgreiches Anlegen an.
    private void showCreationDialog(final int vomKontoNummer, final int nachKontoNummer, final double betrag) {
        JOptionPane.showMessageDialog(null, "Ihre Überweisung über \"" + betrag + "\" von \"" + vomKontoNummer + "\" nach\""
                + nachKontoNummer + "\" wurde erfolgreich durchgeführt.");
    }

    // Methode zum clearen des Frames.
    private void cleanUp() {
        // this.vomKontoField.setText("");
        this.nachKontoField.setText("");
        this.betragField.setText("");
        this.chooser.setDate(null);
    }

    // Methode zum Ermitteln des heutigen Datums.
    public final Date getDate() {
        final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        final Calendar c = df.getCalendar();
        c.setTimeInMillis(System.currentTimeMillis());
        Date date = null;
        try {
            date = df.parse(c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR));
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
