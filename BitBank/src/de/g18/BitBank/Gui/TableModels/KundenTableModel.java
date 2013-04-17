package de.g18.BitBank.Gui.TableModels;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Kunde;

import javax.swing.table.AbstractTableModel;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 17.04.13
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class KundenTableModel extends AbstractTableModel {
	BankController controller;
	String[] cols = {"Nr.", "Name", "Konten"};

	public KundenTableModel(BankController controller) {
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
	public String getColumnName(int col) {
		return cols[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
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
