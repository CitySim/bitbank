package de.g18.BitBank.Gui.TableModels;

import javax.swing.table.AbstractTableModel;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;

/**
 * Tabelle zur Anzeige der Kunden.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class KundenTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -5572145010789838691L;
	private BankController controller;
	private String[] cols = { "Nr.", "Name", "Konten" };

	public KundenTableModel(final BankController controller) {
		this.controller = controller;
	}

	@Override
	public int getRowCount() {
		return controller.getKundenCount();
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
		Kunde k = controller.getKundeByIndex(rowIndex);

		switch (columnIndex) {
		case 0:
			return k.getKundenNummmer();
		case 1:
			return k.getName();
		case 2:
			return k.getKontenListe().size();
		default:
			return "Fehler";
		}
	}
}
