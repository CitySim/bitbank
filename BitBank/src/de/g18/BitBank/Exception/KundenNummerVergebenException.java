package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei bereits vergebenen Kundennummern.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundenNummerVergebenException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -1918411222173099457L;

	public KundenNummerVergebenException(final long kundenNummer) {
		super("Die Kundennummer " + Long.toString(kundenNummer)
				+ " ist bereits vergeben");
	}

	public void showDialog() {
		JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}
}
