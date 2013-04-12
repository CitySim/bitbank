package de.g18.BitBank.Gui;

import java.awt.*;

import javax.swing.*;

import de.g18.BitBank.Gui.Listener.UeberweisungDurchfuehrenListener;

/**
 * Gui Klasse zum Überweisen eines Betrages von einem Konto zum anderen.
 *
 * @author it1-markde
 * @since JRE6
 */

@SuppressWarnings("serial")
public class UeberweisungDurchfuehren extends JFrame {

    public UeberweisungDurchfuehren() {

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2, 2, 2, 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bank-Anwendung - Überweisung durchführen");

        JLabel vomKontoLabel = new JLabel("Vom Konto");
        JLabel nachKontoLabel = new JLabel("Nach Konto");
        JLabel datumLabel = new JLabel("Datum");
        JLabel betragLabel = new JLabel("Betrag");

        JTextField vomKontoField = new JTextField(10);
        JTextField nachKontoField = new JTextField(10);
        JTextField datumField = new JTextField(10);
        datumField.setEnabled(false);
        JTextField betragField = new JTextField(10);

        JButton datumAuswählenButton = new JButton("Datum auswählen");
        JButton überweisenButton = new JButton("Überweisen");
        JButton beendenButton = new JButton("Beenden");

        c.gridx = 0;
        c.gridy = 0;
        this.add(vomKontoLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(nachKontoLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(datumLabel, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add(betragLabel, c);


        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        this.add(vomKontoField, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(nachKontoField, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(datumField, c);

        c.gridx = 1;
        c.gridy = 3;
        this.add(betragField, c);

        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 2;
        this.add(datumAuswählenButton, c);

        c.gridx = 2;
        c.gridy = 3;
        this.add(überweisenButton, c);

        c.gridx = 2;
        c.gridy = 4;
        this.add(beendenButton, c);

        datumAuswählenButton
                .addActionListener(new UeberweisungDurchfuehrenListener());
        überweisenButton
                .addActionListener(new UeberweisungDurchfuehrenListener());
        beendenButton.addActionListener(new UeberweisungDurchfuehrenListener());

        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //test

        new UeberweisungDurchfuehren();
    }
}
