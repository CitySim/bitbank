package de.g18.BitBank.Gui;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.BankViewListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Vorgegebene BankMain.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class BankView extends JFrame {
	private static final long serialVersionUID = -6398346930903875436L;

	public BankView(final BankController controller) {
		setSize(650, 400);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			setIconImage(ImageIO.read(this.getClass().getResource("icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("BitBank");

		JMenu actionMenu = new JMenu("Aktionen");
		actionMenu.add(new JMenuItem("Kunde anlegen"));
		actionMenu.add(new JMenuItem("Konto anlegen"));
		actionMenu.add(new JMenuItem("Ein-/Auszahlungen durchführen"));
		actionMenu.add(new JMenuItem("Überweisungen durchführen"));
		actionMenu.add(new JMenuItem("Kontenliste"));
		actionMenu.add(new JMenuItem("Kontobewegungen"));
		actionMenu.add(new JMenuItem("Kundenliste"));
		actionMenu.add(new JMenuItem("Beenden"));
		actionMenu.insertSeparator(7);

		JMenu about = new JMenu("Hilfe");
		about.add(new JMenuItem("Über"));
		about.add(new JMenuItem("Drucken"));
		about.add(new JMenuItem("E-Mail"));

		JMenuBar bankMenuBar = new JMenuBar();
		bankMenuBar.add(actionMenu);
		bankMenuBar.add(about);
		setJMenuBar(bankMenuBar);

		JTabbedPane tabsPane = new JTabbedPane();
		add(tabsPane);

		setMinimumSize(new Dimension(650, 400));
		setVisible(true);

		new BankViewListener(actionMenu, tabsPane, controller, about);
	}

	public static void main(final String[] args) {
		BankController controller = new BankController();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new BankView(controller);
	}
}