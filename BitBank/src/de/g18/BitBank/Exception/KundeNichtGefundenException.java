package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Exception bei nicht auffindbaren Kunden.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class KundeNichtGefundenException extends Throwable implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -982313113253885226L;

	public KundeNichtGefundenException(final long kundenNummer) {
		super("Kunde " + Long.toString(kundenNummer) + " nicht gefunden");
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(new JFrame(), this.getMessage(),
				"Fehler", JOptionPane.ERROR_MESSAGE);

	}
}
