package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei negativen Kontonummern.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KontoNummerException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = 1207154093010098944L;

	public KontoNummerException(final String message) {
		super(message);
	}

	public void showDialog() {
		JOptionPane.showMessageDialog(null,
				"Die Kundennummer darf nicht negativ sein.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}
}
