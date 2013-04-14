package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.Gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Listener zu dem Menü BankView Klasse.
 *
 * @author it1-markde
 * @since JRE6
 */

public class BankViewListener implements MouseListener {
	JTabbedPane tabsPane;

	public BankViewListener(JMenu anwendungen, JTabbedPane tabsPane) {
		for (Component component : anwendungen.getMenuComponents()) {
			component.addMouseListener(this);
		}

		this.tabsPane = tabsPane;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// not in use
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		// not in use

	}

	@Override
	public void mouseExited(MouseEvent event) {
		// not in use
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// not in use
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		JMenuItem menuItem = (JMenuItem) event.getSource();

		if (menuItem.getText().equals("Kunde anlegen")) {
			tabsPane.add("Kunde anlegen", new KundenAnlegen(tabsPane));
		} else if (menuItem.getText().equals("Konto anlegen")) {
			tabsPane.add("Konto anlegen", new KontoAnlegen(tabsPane));
		} else if (menuItem.getText().equals("Ein-/Auszahlungen durchführen")) {
			tabsPane.add("Ein-/Auszahlung", new ZahlungVornehmen(tabsPane));
		} else if (menuItem.getText().equals("Überweisungen durchführen")) {
			tabsPane.add("Überweisungen", new UeberweisungDurchfuehren(tabsPane));
		} else if (menuItem.getText().equals("Kontostandsübersicht anzeigen")) {
			tabsPane.add("Kontostandsübersicht", new KontostandsUebersichtAnzeigen(tabsPane));
		} else if (menuItem.getText().equals("Beenden")) {
			System.exit(1);
		}

		tabsPane.setSelectedIndex(tabsPane.getTabCount() - 1);
	}
}
