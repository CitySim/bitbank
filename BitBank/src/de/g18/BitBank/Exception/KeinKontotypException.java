package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei nicht gewähltem Kontotypen.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KeinKontotypException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -2180366140800175258L;

    public KeinKontotypException(final String message) {
        super(message);
    }

    @Override
    public void showDialog() {
        JOptionPane.showMessageDialog(null, "Bitte wählen sie einen Kontotypen aus.", "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}
