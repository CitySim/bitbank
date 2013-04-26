package de.g18.BitBank.Gui;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Gui.Listener.KontoAnlegenListener;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Klasse zum anlegen eines Kundens.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KontoAnlegen extends JPanel {
	private static final long serialVersionUID = -4665144187936969278L;

	private JTabbedPane tabsPane;

	public KontoAnlegen(final JTabbedPane tabsPane,
			final BankController controller) {
		this.tabsPane = tabsPane;

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		JLabel kundenNummerLabel = new JLabel("Kundennummer");
		JTextField kundenNummerField = new JTextField();
		JLabel kontoTypLabel = new JLabel("Kontotyp");
		JRadioButton giroKontoRadioButton = new JRadioButton("GiroKonto");
		JRadioButton sparKontoRadioButton = new JRadioButton("SparKonto");
		JButton anlegenButton = new JButton("Anlegen");
		JButton kundeAuswaehlenButton = new JButton("Kunde suchen");
		JButton beendenButton = new JButton("Schließen");

		ButtonGroup kontoTypSelect = new ButtonGroup();
		kontoTypSelect.add(giroKontoRadioButton);
		kontoTypSelect.add(sparKontoRadioButton);

		c.gridx = 0;
		c.gridy = 0;
		this.add(kundenNummerLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		this.add(kundenNummerField, c);

		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0;
		this.add(kundeAuswaehlenButton, c);

		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		this.add(kontoTypLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		this.add(giroKontoRadioButton, c);

		c.gridx = 1;
		c.gridy = 2;
		this.add(sparKontoRadioButton, c);

		c.gridx = 2;
		c.gridy = 2;
		this.add(anlegenButton, c);

		c.gridx = 2;
		c.gridy = 3;
		this.add(beendenButton, c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.weighty = 1;
		this.add(new JPanel(), c);

		KontoAnlegenListener listener = new KontoAnlegenListener(controller,
				this, kundenNummerField, giroKontoRadioButton,
				sparKontoRadioButton);

		anlegenButton.addActionListener(listener);
		beendenButton.addActionListener(listener);
		kundeAuswaehlenButton.addActionListener(listener);
	}

	public final JTabbedPane getTabsPane() {
		return tabsPane;
	}
}
