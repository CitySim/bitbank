package de.g18.BitBank.Gui.TableModels;

import de.g18.BitBank.BankController;
import de.g18.BitBank.Konto;

import javax.swing.table.AbstractTableModel;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 17.04.13 Time: 22:38
 */
public class KontenTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -3758449082711896808L;
	BankController controller;
	long kundenNummer;
	String[] cols = { "Kontoart", "Kontonummer", "Kontostand" };

	public KontenTableModel(BankController controller, long kundenNummer) {
		this.controller = controller;
		this.kundenNummer = kundenNummer;
	}

	@Override
	public int getRowCount() {
		return controller.getKundenKonten(kundenNummer).size();
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
		Konto k = controller.getKundenKonten(kundenNummer).get(rowIndex);

		switch (columnIndex) {
		case 0:
			return k.getKontoTyp().toString();
		case 1:
			return Long.toString(k.getKontoNummer());
		case 2:
			return Double.toString(k.getKontoStand());
		default:
			return "Fehler";
		}
	}
}
