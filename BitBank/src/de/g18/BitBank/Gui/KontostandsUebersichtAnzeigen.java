package de.g18.BitBank.Gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bank-Anwendung - Kontostandsübersicht anzeigen");

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
				.addActionListener(new KontostandsUebersichtAnzeigenListener());
		beendenButton
				.addActionListener(new KontostandsUebersichtAnzeigenListener());

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new KontostandsUebersichtAnzeigen();
	}

	public Object[][] generateTextObjects() {
		Object[][] data = { { "Giro", "1100001", "750.0" },
				{ "Spar", "1101002", "250.0" } };

		return data;
	}

	public Object[] generateColumnNames() {
		Object[] data = { "Kontoart", "Kontonummer", "Kontostand" };
		return data;
	}
}