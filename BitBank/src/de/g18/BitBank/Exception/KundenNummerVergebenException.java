package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: it1-tattsv Date: 19.04.13 Time: 11:22 To
 * change this template use File | Settings | File Templates.
 */
public class KundenNummerVergebenException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -1918411222173099457L;

	public KundenNummerVergebenException(long kundenNummer) {
		super("Die Kundennummer " + Long.toString(kundenNummer)
				+ " ist bereits vergeben");
	}

	public void showDialog() {
		JOptionPane.showMessageDialog(new JFrame(), this.getMessage(),
				"Fehler", JOptionPane.ERROR_MESSAGE);
	}
}
