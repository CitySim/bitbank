package de.g18.BitBank.Gui.Listener;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Extra.BestaetigenFrame;
import de.g18.BitBank.Gui.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

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
			addPane("Kunde anlegen", new KundenAnlegen(this.tabsPane,
					this.controller));
		} else if (menuItem.getText().equals("Konto anlegen")) {
			addPane("Konto anlegen", new KontoAnlegen(this.tabsPane,
					this.controller));
		} else if (menuItem.getText().equals("Ein-/Auszahlungen durchführen")) {
			addPane("Ein-/Auszahlung", new ZahlungVornehmen(this.tabsPane,
					this.controller));
		} else if (menuItem.getText().equals("Überweisungen durchführen")) {
			addPane("Überweisung", new UeberweisungVornehmen(this.tabsPane,
					this.controller));
		} else if (menuItem.getText().equals("Kontenliste")) {
			addPane("Kontenliste", new KontenListe(this.tabsPane,
					this.controller));
		} else if (menuItem.getText().equals("Kontobewegungen")) {
			addPane("Kontobewegungen", new Kontobewegungen(this.tabsPane,
					this.controller));
		} else if (menuItem.getText().equals("Kundenliste")) {
			addPane("Kundenliste", new KundenListe(this.tabsPane,
					this.controller));

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

	private void addPane(final String title, final JPanel panel) {
		tabsPane.add(title, panel);

		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.add(new JLabel(title));

		ImageIcon buttonIcon = null;
		try {
			buttonIcon = new ImageIcon(ImageIO.read(getClass().getClassLoader()
					.getResourceAsStream("closeButton.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JButton closeButton = new JButton();
		closeButton.setIcon(buttonIcon);

		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setPreferredSize(new Dimension(19, 19));

		titlePanel.add(closeButton);
		titlePanel.setPreferredSize(new Dimension(120, 22));

		closeButton.addActionListener(new CloseButtonListener(this.tabsPane,
				panel));

		this.tabsPane.setTabComponentAt(this.tabsPane.indexOfComponent(panel),
				titlePanel);
	}
}
