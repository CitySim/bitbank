package de.g18.BitBank.Gui.Listener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import de.g18.BitBank.Gui.KontoAnlegen;
import de.g18.BitBank.Gui.KontostandsUebersichtAnzeigen;
import de.g18.BitBank.Gui.UeberweisungDurchfuehren;
import de.g18.BitBank.Gui.ZahlungVornehmen;

public class BankViewListener implements MouseListener {

	public BankViewListener(JMenu anwendungen) {

		for (Component component : anwendungen.getMenuComponents()) {
			component.addMouseListener(this);
		}

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
			System.out.println("Kunde anlegen");
		} else if (menuItem.getText().equals("Konto anlegen")) {
			new KontoAnlegen();
		} else if (menuItem.getText().equals("Ein-/Auszahlungen durchführen")) {
			new ZahlungVornehmen();
		} else if (menuItem.getText().equals("Überweisungen durchführen")) {
			new UeberweisungDurchfuehren();
		} else if (menuItem.getText().equals("Kontostandsübersicht anzeigen")) {
			new KontostandsUebersichtAnzeigen();
		} else if (menuItem.getText().equals("Beenden")) {
			System.exit(1);
		}

	}
}
