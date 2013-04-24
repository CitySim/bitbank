package de.g18.BitBank.Gui.Listener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
 * @since JRE6
 */

public class BankViewListener implements MouseListener {
	private BankController controller;
	private JTabbedPane tabsPane;

	public BankViewListener(final JMenu anwendungen,
			final JTabbedPane tabsPane, final BankController controller,
			final JMenu about) {
		for (Component component : anwendungen.getMenuComponents()) {
			component.addMouseListener(this);
		}
		for (Component component : about.getMenuComponents()) {
			component.addMouseListener(this);
		}

		this.controller = controller;
		this.tabsPane = tabsPane;
	}

	@Override
	public void mouseClicked(final MouseEvent event) {
		// not in use
	}

	@Override
	public void mouseEntered(final MouseEvent event) {
		// not in use
	}

	@Override
	public void mouseExited(final MouseEvent event) {
		// not in use
	}

	@Override
	public void mousePressed(final MouseEvent event) {
		// not in use
	}

	@Override
	public void mouseReleased(final MouseEvent event) {
		JMenuItem menuItem = (JMenuItem) event.getSource();

		if (menuItem.getText().equals("Kunde anlegen")) {
			tabsPane.add("Kunde anlegen", new KundenAnlegen(this.tabsPane,
					this.controller));
			this.addCloseButton("Kunde anlegen");
		} else if (menuItem.getText().equals("Konto anlegen")) {
			tabsPane.add("Konto anlegen", new KontoAnlegen(this.tabsPane,
					this.controller));
			this.addCloseButton("Konto anlegen");
		} else if (menuItem.getText().equals("Ein-/Auszahlungen durchführen")) {
			tabsPane.add("Ein-/Auszahlung", new ZahlungVornehmen(this.tabsPane,
					this.controller));
			this.addCloseButton("Ein-/Auszahlung");
		} else if (menuItem.getText().equals("Überweisungen durchführen")) {
			tabsPane.add("Überweisung", new UeberweisungVornehmen(
					this.tabsPane, this.controller));
			this.addCloseButton("Überweisung");
		} else if (menuItem.getText().equals("Kontenliste")) {
			tabsPane.add("Kontenliste", new KontenListe(this.tabsPane,
					this.controller));
			this.addCloseButton("Kontenliste");
		} else if (menuItem.getText().equals("Kontobewegungen")) {
			tabsPane.add("Kontobewegungen", new Kontobewegungen(this.tabsPane,
					this.controller));
			this.addCloseButton("Kontobewegungen");
		} else if (menuItem.getText().equals("Kundenliste")) {
			tabsPane.add("Kundenliste", new KundenListe(this.tabsPane,
					this.controller));
			this.addCloseButton("Kundenliste");
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

	private final void addCloseButton(final String tabName) {

		JPanel titlePanel = new JPanel();
		titlePanel.add(new JLabel(tabName));
		// ImageIcon image = new ImageIcon("closeButton.png");

		// JButton closeButton = new JButton(image);
		// closeButton.setIcon(new ImageIcon("closeButton.png"));
		JButton closeButton = new JButton("X");
		titlePanel.add(closeButton);

		closeButton.addActionListener(new CloseButtonListener(this.tabsPane,
				tabName));
		this.tabsPane.setTabComponentAt(tabsPane.indexOfTab(tabName),
				titlePanel);
	}
}
