package de.g18.BitBank.Extra;

import javax.swing.JOptionPane;

import de.g18.BitBank.Exception.ExceptionDialogInterface;

/**
 * Exception bei Problemen mit der E-Mail Versendung.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class EmailException extends Exception implements
		ExceptionDialogInterface {

	private static final long serialVersionUID = 6533752400390467570L;

	EmailException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane
				.showMessageDialog(
						null,
						"Die E-Mail konnte nicht verschickt werden. Bitte überprüfen Sie ihre Internetverbindung.",
						"Fehler", JOptionPane.ERROR_MESSAGE);
	}

}
