package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei nicht gefuellten Pflichtfeldern.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class FeldLeerException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = 1207154093010098944L;

	public FeldLeerException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(null, "Der " + this.getMessage()
				+ " muss angegeben werden.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

}
