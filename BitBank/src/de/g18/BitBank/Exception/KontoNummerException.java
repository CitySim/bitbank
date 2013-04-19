package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 17.04.13 Time: 22:23 To change
 * this template use File | Settings | File Templates.
 */
public class KontoNummerException extends Exception {
	private static final long serialVersionUID = 1207154093010098944L;

	public KontoNummerException(String message) {
		JOptionPane.showMessageDialog(new JFrame(),
				"Die Kontonnummer ist keine gültige Zahl.", "Inane error",
				JOptionPane.ERROR_MESSAGE);
	}
}
