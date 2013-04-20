package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class KeineGültigeZahlException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = 6273227693708900483L;

	public KeineGültigeZahlException(final String message) {
		super(message);
	}

	public void showDialog() {
		JOptionPane.showMessageDialog(new JFrame(), this.getMessage()
				+ " ist keine gültige Zahl.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

}
