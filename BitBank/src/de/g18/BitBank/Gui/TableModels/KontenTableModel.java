package de.g18.BitBank.Gui.TableModels;

import java.text.NumberFormat;

import de.g18.BitBank.Konto;
import de.g18.BitBank.Kunde;

import javax.swing.table.AbstractTableModel;

/**
 * Tabelle zur Anzeige der Konten.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class KontenTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -3758449082711896808L;
	private Kunde kunde;
	private String[] cols = { "Kontoart", "Kontonummer", "Kontostand" };

	public KontenTableModel(final Kunde kunde) {
		this.kunde = kunde;
	}

	@Override
	public int getRowCount() {
		return kunde.getKontenListe().size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public String getColumnName(final int col) {
		return cols[col];
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
		Konto k = kunde.getKontenListe().get(rowIndex);

		switch (columnIndex) {
		case 0:
			switch (k.getKontoTyp()) {
			case GIROKONTO:
				return "GIRO";
			case SPARKONTO:
				return "SPAR";
			default:
				return "UNBEKANNT";
			}
		case 1:
			return Long.toString(k.getKontoNummer());
		case 2:
			return NumberFormat.getCurrencyInstance().format(k.getKontoStand());
		default:
			return "Fehler";
		}
	}
}
