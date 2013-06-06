package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei nicht auffindbaren Konten.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public final class KontoNichtGefundenException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -8811022158488793767L;

    public KontoNichtGefundenException(final long kontoNummer) {
        super("Konto " + Long.toString(kontoNummer) + " nicht gefunden");
    }

    @Override
    public void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);

    }
}
