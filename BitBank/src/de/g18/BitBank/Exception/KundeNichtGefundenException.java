package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: it1-tattsv Date: 19.04.13 Time: 10:19 To
 * change this template use File | Settings | File Templates.
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
