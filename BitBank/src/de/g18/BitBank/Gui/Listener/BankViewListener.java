package de.g18.BitBank.Gui.Listener;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Extra.BestaetigenFrame;
import de.g18.BitBank.Gui.KontenListe;
import de.g18.BitBank.Gui.KontoAnlegen;
import de.g18.BitBank.Gui.Kontobewegungen;
import de.g18.BitBank.Gui.KundenAnlegen;
import de.g18.BitBank.Gui.KundenListe;
import de.g18.BitBank.Gui.UeberFenster;
import de.g18.BitBank.Gui.UeberweisungVornehmen;
import de.g18.BitBank.Gui.ZahlungVornehmen;

/**
 * Listener zu dem Menue BankView Klasse.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class BankViewListener extends MouseAdapter {

    private final BankController controller;
    private final JTabbedPane tabsPane;

    public BankViewListener(
            final JMenu anwendungen,
            final JTabbedPane tabsPane,
            final BankController controller,
            final JMenu about) {
        for (final Component component : anwendungen.getMenuComponents()) {
            component.addMouseListener(this);
        }
        for (final Component component : about.getMenuComponents()) {
            component.addMouseListener(this);
        }

        this.controller = controller;
        this.tabsPane = tabsPane;
    }

    @Override
    public void mouseReleased(final MouseEvent event) {
        final JMenuItem menuItem = (JMenuItem) event.getSource();

        // Teil eins des Menues.
        if (menuItem.getText().equals("Kunde anlegen")) {
            this.addPane("Kunde anlegen", new KundenAnlegen(this.tabsPane, this.controller));
        } else if (menuItem.getText().equals("Konto anlegen")) {
            this.addPane("Konto anlegen", new KontoAnlegen(this.tabsPane, this.controller));
        } else if (menuItem.getText().equals("Ein-/Auszahlungen durchführen")) {
            this.addPane("Ein-/Auszahlung", new ZahlungVornehmen(this.tabsPane, this.controller));
        } else if (menuItem.getText().equals("Überweisungen durchführen")) {
            this.addPane("Überweisung", new UeberweisungVornehmen(this.tabsPane, this.controller));
        } else if (menuItem.getText().equals("Kontenliste")) {
            this.addPane("Kontenliste", new KontenListe(this.tabsPane, this.controller));
        } else if (menuItem.getText().equals("Kontobewegungen")) {
            this.addPane("Kontobewegungen", new Kontobewegungen(this.tabsPane, this.controller));
        } else if (menuItem.getText().equals("Kundenliste")) {
            this.addPane("Kundenliste", new KundenListe(this.tabsPane, this.controller));

            // Teil zwei des Menues.
        } else if (menuItem.getText().equals("Über")) {
            new UeberFenster();
        } else if (menuItem.getText().equals("Drucken")) {
            new BestaetigenFrame(this.controller, "drucken");
        } else if (menuItem.getText().equals("E-Mail")) {
            new BestaetigenFrame(this.controller, "email");
        } else if (menuItem.getText().equals("Beenden")) {
            System.exit(1);
        }

        this.tabsPane.setSelectedIndex(this.tabsPane.getTabCount() - 1);
    }

    // Methode zum Hinzufuegen von neuen Panes (Inklusive Closebutton etc.)
    private void addPane(final String title, final JPanel panel) {
        this.tabsPane.add(title, panel);

        final JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.add(new JLabel(title));

        ImageIcon buttonIcon = null;
        try {
            buttonIcon = new ImageIcon(ImageIO.read(this.getClass()
                    .getClassLoader()
                    .getResourceAsStream("de/g18/BitBank/Gui/Images/closeButton.png")));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final JButton closeButton = new JButton();
        closeButton.setIcon(buttonIcon);

        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.setPreferredSize(new Dimension(19, 19));

        titlePanel.add(closeButton);
        titlePanel.setPreferredSize(new Dimension(120, 22));

        closeButton.addActionListener(new CloseButtonListener(this.tabsPane, panel));

        this.tabsPane.setTabComponentAt(this.tabsPane.indexOfComponent(panel), titlePanel);
    }
}
