package de.g18.BitBank.Gui;

import de.g18.BitBank.Gui.Listener.KontostandsUebersichtAnzeigenListener;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Klasse zum Anzeigen des aktuellen Kontostandes aller Konten eines
 * Kundens.
 *
 * @author it1-markde
 * @since JRE6
 */

public class KontostandsUebersichtAnzeigen extends JPanel {

	public KontostandsUebersichtAnzeigen() {
		this.setLayout(new GridLayout(0, 1));

		JLabel kundenNummerLabel = new JLabel("KundenNummer");
		JTextField kundenNummerField = new JTextField(10);

		JButton kontoUebersichtButton = new JButton("Kontoübersicht");
		JButton beendenButton = new JButton("Beenden");

		Object[][] data = this.generateTextObjects();
		Object[] columnNames = this.generateColumnNames();

		JTable table = new JTable(data, columnNames);

		this.add(kundenNummerLabel);

		this.add(kundenNummerField);

		this.add(kontoUebersichtButton);
		this.add(beendenButton);
		this.add(table);

		kontoUebersichtButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener(
						null));
		beendenButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener(
						this));

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new KontostandsUebersichtAnzeigen();
	}

	public Object[][] generateTextObjects() {
		Object[][] data = {{"Giro", "1100001", "750.0"},
				{"Spar", "1101002", "250.0"}};

		return data;
	}

	public Object[] generateColumnNames() {
		Object[] data = {"Kontoart", "Kontonummer", "Kontostand"};
		return data;
	}
}