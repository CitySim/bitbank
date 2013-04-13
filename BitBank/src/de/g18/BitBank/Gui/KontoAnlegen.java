package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.KontoAnlegenListener;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Klasse zum anlegen eines Kundens.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KontoAnlegen extends JPanel {
	public KontoAnlegen() {
		this.setLayout(new GridLayout(0, 3));

		JPanel links = new JPanel();
		JPanel mitte = new JPanel();
		JPanel rechts = new JPanel();
		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextField kundenNummerField = new JTextField(10);
		JRadioButton giroKontoRadioButton = new JRadioButton("GiroKonto");
		JRadioButton sparKontoRadioButton = new JRadioButton("SparKonto");
		JButton anlegenButton = new JButton("Anlegen");
		JButton beendenButton = new JButton("Beenden");

		mitte.setLayout(new FlowLayout(FlowLayout.LEFT));
		anlegenButton.setPreferredSize(new Dimension(100, 25));
		beendenButton.setPreferredSize(new Dimension(100, 25));
		links.setBorder(BorderFactory.createMatteBorder(20, 0, 0, 0,
				Color.decode("#EEEEEE")));
		mitte.setBorder(BorderFactory.createMatteBorder(20, 0, 0, 0,
				Color.decode("#EEEEEE")));
		rechts.setBorder(BorderFactory.createMatteBorder(75, 0, 0, 0,
				Color.decode("#EEEEEE")));

		this.add(links);
		this.add(mitte);
		this.add(rechts);
		links.add(kundenNummerLabel);
		mitte.add(kundenNummerField);
		mitte.add(giroKontoRadioButton);
		mitte.add(sparKontoRadioButton);
		rechts.add(anlegenButton);
		rechts.add(beendenButton);

		anlegenButton.addActionListener(new KontoAnlegenListener(
				kundenNummerField));
		beendenButton.addActionListener(new KontoAnlegenListener(this));

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new KontoAnlegen();
	}
}
