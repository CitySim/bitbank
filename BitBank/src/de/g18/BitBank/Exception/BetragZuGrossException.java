package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei zu großen Betraegen.
 * 
 * @author it1-markde @* @since jdk1.7.0_21
 */

public class BetragZuGrossException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4856476696927674629L;

    public BetragZuGrossException(final String message) {
        super(message);
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, "Aus Sicherheitsgründen sind keine derartig großen Summen gestattet. +"
                + "Bitte geben sie einen zulässigen Betrag ein.", "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}
