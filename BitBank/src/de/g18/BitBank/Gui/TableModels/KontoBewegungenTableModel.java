package de.g18.BitBank.Gui.TableModels;

import de.g18.BitBank.Konto;
import de.g18.BitBank.Kontobewegung;

import javax.swing.table.AbstractTableModel;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 17.04.13 Time: 22:38 To change
 * this template use File | Settings | File Templates.
 */
public class KontoBewegungenTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -5781280913032155581L;
	Konto konto;
	String[] cols = { "Datum", "von", "nach", "Betrag" };

	public KontoBewegungenTableModel(Konto konto) {
		this.konto = konto;
	}

	@Override
	public int getRowCount() {
		return konto.getKontoBewegungsListe().size();
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public String getColumnName(int col) {
		return cols[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kontobewegung kb = konto.getKontoBewegungsListe().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return kb.getDatum().toString();
		case 1:
			return "";
		case 2:
			return "";
		case 3:
			return Double.toString(kb.getBetrag());
		default:
			return "Fehler";
		}
	}
}
