package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 17.04.13 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class FeldLeerException extends Exception implements
		ExceptionDialogInterface {
	private static final long serialVersionUID = 1207154093010098944L;

	public FeldLeerException(final String message) {
		super(message);
	}

	@Override
	public void showDialog() {
		JOptionPane.showMessageDialog(new JFrame(), "Der " + this.getMessage()
				+ " muss angegeben werden.", "Fehler",
				JOptionPane.ERROR_MESSAGE);
	}

}
