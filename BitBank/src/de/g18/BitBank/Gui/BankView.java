package de.g18.BitBank.Gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import de.g18.BitBank.Gui.Listener.BankViewListener;

/**
 * Vorgegebene BankMain.
 *
 * @author it1-markde
 * @since JRE6
 */

public class BankView extends JFrame {
	private static final long serialVersionUID = -6398346930903875436L;

	public BankView() {
		setSize(650, 400);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("BitBank");

		JMenu actionMenu = new JMenu("Aktionen");
		actionMenu.add(new JMenuItem("Kunde anlegen"));
		actionMenu.add(new JMenuItem("Konto anlegen"));
		actionMenu.add(new JMenuItem("Ein-/Auszahlungen durchführen"));
		actionMenu.add(new JMenuItem("Überweisungen durchführen"));
		actionMenu.add(new JMenuItem("Kontostandsübersicht anzeigen"));
		actionMenu.add(new JMenuItem("Kontobewegungen anzeigen"));
		actionMenu.add(new JMenuItem("Kundenliste anzeigen"));
		actionMenu.add(new JMenuItem("Beenden"));
		actionMenu.insertSeparator(7);

		JMenu about = new JMenu("Hilfe");
		about.add(new JMenuItem("Über"));

		JMenuBar bankMenuBar = new JMenuBar();
		bankMenuBar.add(actionMenu);
		bankMenuBar.add(about);
		setJMenuBar(bankMenuBar);

		JTabbedPane tabsPane = new JTabbedPane();
		add(tabsPane);

		setMinimumSize(new Dimension(650, 400));
		setVisible(true);

		BankViewListener listener = new BankViewListener(actionMenu, tabsPane);
		about.getMenuComponents()[0].addMouseListener(listener);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new BankView();
	}
}