package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei ungueltigen Daten.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class DateException extends Exception implements
		ExceptionDialogInterface {

	private static final long serialVersionUID = -6632898694055165592L;

	public DateException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}
}
