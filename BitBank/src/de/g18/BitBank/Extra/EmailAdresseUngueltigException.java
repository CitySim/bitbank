package de.g18.BitBank.Extra;

import javax.swing.JOptionPane;

import de.g18.BitBank.Exception.ExceptionDialogInterface;

/**
 * Exception bei ungueltigen E-mail Adressen.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

class EmailAdresseUngueltigException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -610479602115622187L;

    EmailAdresseUngueltigException(final String message) {
        super(message);
    }

    @Override
    public void showDialog() {
        JOptionPane.showMessageDialog(
                null,
                "Die E-Mail Adresse: " + this.getMessage() + " ist ungültig.",
                "Fehler",
                JOptionPane.ERROR_MESSAGE);
    }

}
