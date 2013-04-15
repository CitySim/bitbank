package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.BankViewListener;

import javax.swing.*;
import java.awt.*;

/**
 * Vorgegebene BankMain.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class BankView extends JFrame {
	public BankView() {
		setSize(650, 400);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("BitBank");

		JMenu AktionenMenu = new JMenu("Aktionen");
		AktionenMenu.add(new JMenuItem("Kunde anlegen"));
		AktionenMenu.add(new JMenuItem("Konto anlegen"));
		AktionenMenu.add(new JMenuItem("Ein-/Auszahlungen durchführen"));
		AktionenMenu.add(new JMenuItem("Überweisungen durchführen"));
		AktionenMenu.add(new JMenuItem("Kontostandsübersicht anzeigen"));
		AktionenMenu.add(new JMenuItem("Kontobewegungen anzeigen"));
		AktionenMenu.add(new JMenuItem("Beenden"));
		AktionenMenu.insertSeparator(6);

		JMenu about = new JMenu("Hilfe");
		about.add(new JMenuItem("Über"));

		JMenuBar bankMenuBar = new JMenuBar();
		bankMenuBar.add(AktionenMenu);
		bankMenuBar.add(about);
		setJMenuBar(bankMenuBar);

		JTabbedPane tabsPane = new JTabbedPane();
		add(tabsPane);

		setMinimumSize(new Dimension(650, 400));
		setVisible(true);

		// BankViewListener listener = new BankViewListener(AktionenMenu,
		// tabsPane);
		// about.getMenuComponents()[0].addMouseListener(listener);
		new BankViewListener(AktionenMenu, tabsPane);
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