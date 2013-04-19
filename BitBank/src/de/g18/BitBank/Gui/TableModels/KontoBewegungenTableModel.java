package de.g18.BitBank.Gui.TableModels;

import javax.swing.table.AbstractTableModel;

import de.g18.BitBank.Konto;
import de.g18.BitBank.Kontobewegung;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 17.04.13 Time: 22:38 To change
 * this template use File | Settings | File Templates.
 */
public class KontoBewegungenTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -5781280913032155581L;
	private Konto konto;
	private String[] cols = { "Datum", "von", "nach", "Betrag" };

	public KontoBewegungenTableModel(final Konto konto) {
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
	public String getColumnName(final int col) {
		return cols[col];
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
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
