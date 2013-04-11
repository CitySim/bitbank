package de.g18.BitBank.Gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.g18.BitBank.Gui.Listener.KontostandsUebersichtAnzeigenListener;

/**
 * Gui Klasse zum Anzeigen des aktuellen Kontostandes aller Konten eines
 * Kundens.
 * 
 * @author it1-markde
 * @since JRE6
 */

@SuppressWarnings("serial")
public class KontostandsUebersichtAnzeigen extends JFrame {

	public KontostandsUebersichtAnzeigen() {

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(0, 1));
		this.setTitle("Bank-Anwendung - Kontostandsübersicht anzeigen");

		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextField kundenNummerField = new JTextField(10);

		JButton kontoUebersichtButton = new JButton("Kontoübersicht");
		JButton beendenButton = new JButton("Beenden");

		this.add(kundenNummerLabel);

		this.add(kundenNummerField);

		this.add(kontoUebersichtButton);
		this.add(beendenButton);

		kontoUebersichtButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener());
		beendenButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener());

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new KontostandsUebersichtAnzeigen();
	}
}