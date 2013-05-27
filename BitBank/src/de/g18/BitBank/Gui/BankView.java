package de.g18.BitBank.Gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.BankViewListener;

/**
 * Vorgegebene BankMain.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class BankView extends JFrame {

    private static final long serialVersionUID = -6398346930903875436L;

    public BankView(final BankController controller) {
        this.setSize(650, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 1));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Image appIcon = null;
        try {
            appIcon = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("de/g18/BitBank/Gui/Images/icon.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
        this.setIconImage(appIcon);
        this.setTitle("BitBank");

        // erster Teil des Menues
        final JMenu actionMenu = new JMenu("Aktionen");
        actionMenu.add(new JMenuItem("Kunde anlegen"));
        actionMenu.add(new JMenuItem("Konto anlegen"));
        actionMenu.add(new JMenuItem("Ein-/Auszahlungen durchführen"));
        actionMenu.add(new JMenuItem("Überweisungen durchführen"));
        actionMenu.add(new JMenuItem("Kontenliste"));
        actionMenu.add(new JMenuItem("Kontobewegungen"));
        actionMenu.add(new JMenuItem("Kundenliste"));
        actionMenu.add(new JMenuItem("Beenden"));
        actionMenu.insertSeparator(7);

        // zweiter Teil des Menues
        final JMenu about = new JMenu("Hilfe");
        about.add(new JMenuItem("Über"));
        about.add(new JMenuItem("Drucken"));
        about.add(new JMenuItem("E-Mail"));

        final JMenuBar bankMenuBar = new JMenuBar();
        bankMenuBar.add(actionMenu);
        bankMenuBar.add(about);
        this.setJMenuBar(bankMenuBar);

        final JTabbedPane tabsPane = new JTabbedPane();
        this.add(tabsPane);

        this.setMinimumSize(new Dimension(650, 400));
        this.setVisible(true);

        new BankViewListener(actionMenu, tabsPane, controller, about);
    }

    public static void main(final String[] args) {
        final BankController controller = new BankController();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final Exception e) {
            e.printStackTrace();
        }

        new BankView(controller);
    }
}
