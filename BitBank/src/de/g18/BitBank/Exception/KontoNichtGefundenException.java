package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: it1-tattsv Date: 19.04.13 Time: 09:55 To
 * change this template use File | Settings | File Templates.
 */
public class KontoNichtGefundenException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -8811022158488793767L;

	public KontoNichtGefundenException(final long kontoNummer) {
		super("Konto " + Long.toString(kontoNummer) + " nicht gefunden");
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler",
				JOptionPane.ERROR_MESSAGE);

	}
}
