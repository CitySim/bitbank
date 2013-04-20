package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Exception bei Eintraegen in Felder, die nicht dem gueltigen Zahlenformat
 * entsprechen.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KeineGueltigeZahlException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = 6273227693708900483L;

	public KeineGueltigeZahlException(final String message) {
		super(message);
	}

	public void showDialog() {
		JOptionPane.showMessageDialog(new JFrame(), this.getMessage()
				+ " ist keine gueltige Zahl.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

}
