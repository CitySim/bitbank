package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei nicht auffindbaren Kunden.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KundeNichtGefundenException extends Throwable implements ExceptionDialogInterface {

    private static final long serialVersionUID = -982313113253885226L;

    public KundeNichtGefundenException(final long kundenNummer) {
        super("Kunde " + Long.toString(kundenNummer) + " nicht gefunden");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);

    }
}
