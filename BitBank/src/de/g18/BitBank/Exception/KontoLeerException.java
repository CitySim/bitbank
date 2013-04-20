package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 17.04.13 Time: 21:37 To change
 * this template use File | Settings | File Templates.
 */
public class KontoLeerException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = -9013057245886843969L;

	public KontoLeerException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}
}
