package de.g18.BitBank.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.UeberweisungListener;

/**
 * Gui Klasse zum Ueberweisen eines Betrages von einem Konto zum anderen.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class UeberweisungVornehmen extends JPanel {

    private static final long serialVersionUID = 3658600368625899293L;

    private final JTabbedPane tabsPane;

    public UeberweisungVornehmen(final JTabbedPane tabsPane, final BankController controller) {
        this.tabsPane = tabsPane;

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel vomKontoLabel = new JLabel("Vom Konto");
        final JLabel nachKontoLabel = new JLabel("Nach Konto");
        final JLabel datumLabel = new JLabel("Datum");
        final JLabel betragLabel = new JLabel("Betrag");

        final JTextField vomKontoField = new JTextField();
        final JTextField nachKontoField = new JTextField();
        final JDateChooser chooser = new JDateChooser();
        final JTextField betragField = new JTextField();

        final JButton ueberweisenButton = new JButton("Überweisen");
        final JButton beendenButton = new JButton("Schließen");

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
        this.add(chooser, c);

        c.gridx = 1;
        c.gridy = 3;
        this.add(betragField, c);

        c.gridx = 2;
        c.gridy = 3;
        c.weightx = 0;
        this.add(ueberweisenButton, c);

        c.gridx = 2;
        c.gridy = 4;
        this.add(beendenButton, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.weighty = 1;
        this.add(new JPanel(), c);

        ueberweisenButton.addActionListener(new UeberweisungListener(
                vomKontoField,
                nachKontoField,
                betragField,
                controller,
                chooser));
        beendenButton.addActionListener(new UeberweisungListener(this));
    }

    public final JTabbedPane getTabsPane() {
        return this.tabsPane;
    }
}
