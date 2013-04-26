package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei negativen Betraegen.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */
public class BetragNegativException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -2180366140800175258L;

	public BetragNegativException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}
}
