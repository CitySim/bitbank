package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Exception bei unzulaessigen Kundennummern.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenNummerUnzulaessigException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = 1207154093010098944L;

	public KundenNummerUnzulaessigException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(new JFrame(),
				"Die Kundennummer darf nicht negativ sein.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}
}