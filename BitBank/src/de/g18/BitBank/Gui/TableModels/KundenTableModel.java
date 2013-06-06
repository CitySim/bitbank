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
    private final BankController controller;
    private final String[] cols = { "Nr.", "Name", "Konten" };

    public KundenTableModel(final BankController controller) {
        this.controller = controller;
    }

    @Override
    public final int getRowCount() {
        return this.controller.getKundenCount();
    }

    @Override
    public final int getColumnCount() {
        return this.cols.length;
    }

    @Override
    public final String getColumnName(final int col) {
        return this.cols[col];
    }

    @Override
    public final Object getValueAt(final int rowIndex, final int columnIndex) {
        final Kunde k = this.controller.getKundeByIndex(rowIndex);

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
