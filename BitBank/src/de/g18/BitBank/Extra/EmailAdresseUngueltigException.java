package de.g18.BitBank.Extra;

import javax.swing.JOptionPane;

import de.g18.BitBank.Exception.ExceptionDialogInterface;

public class EmailAdresseUngueltigException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -610479602115622187L;

	public EmailAdresseUngueltigException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(null,
				"Die E-Mail Adresse: " + this.getMessage() + " ist ungültig.",
				"Fehler", JOptionPane.ERROR_MESSAGE);
	}

}
