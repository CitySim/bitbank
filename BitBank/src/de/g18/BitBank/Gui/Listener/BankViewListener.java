package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
			final JTabbedPane tabsPane, final BankController controller) {
		for (Component component : anwendungen.getMenuComponents()) {
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
			tabsPane.add("Kunde anlegen", new KundenAnlegen(tabsPane,
					controller));
		} else if (menuItem.getText().equals("Konto anlegen")) {
			tabsPane.add("Konto anlegen",
					new KontoAnlegen(tabsPane, controller));
		} else if (menuItem.getText().equals("Ein-/Auszahlungen durchführen")) {
			tabsPane.add("Ein-/Auszahlung", new ZahlungVornehmen(tabsPane,
					controller));
		} else if (menuItem.getText().equals("Überweisungen durchführen")) {
			tabsPane.add("Überweisung", new UeberweisungVornehmen(tabsPane,
					controller));
		} else if (menuItem.getText().equals("Kontenliste")) {
			tabsPane.add("Kontenliste", new KontenListe(tabsPane, controller));
		} else if (menuItem.getText().equals("Kontobewegungen")) {
			tabsPane.add("Kontobewegungen", new Kontobewegungen(tabsPane,
					controller));
		} else if (menuItem.getText().equals("Kundenliste")) {
			tabsPane.add("Kundenliste", new KundenListe(tabsPane, controller));
		} else if (menuItem.getText().equals("Über")) {
			new UeberFenster();
		} else if (menuItem.getText().equals("Beenden")) {
			System.exit(1);
		}

		this.tabsPane.setSelectedIndex(this.tabsPane.getTabCount() - 1);
	}
}
