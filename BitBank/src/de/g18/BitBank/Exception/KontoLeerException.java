package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception unzulaessig weit uerzogenem Kontostand.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class KontoLeerException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -9013057245886843969L;

	public KontoLeerException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}
}
