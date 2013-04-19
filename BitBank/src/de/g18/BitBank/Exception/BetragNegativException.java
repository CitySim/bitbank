package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: it1-tattsv Date: 16.04.13 Time: 14:28 To
 * change this template use File | Settings | File Templates.
 */
public class BetragNegativException extends Exception {
	private static final long serialVersionUID = -2180366140800175258L;

	public BetragNegativException(String message) {
		JOptionPane.showMessageDialog(new JFrame(),
				"Der Betrag darf nicht negativ sein.", "Inane error",
				JOptionPane.ERROR_MESSAGE);
	}
}
