package de.g18.BitBank.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created with IntelliJ IDEA. User: it1-tattsv Date: 16.04.13 Time: 14:28 To
 * change this template use File | Settings | File Templates.
 */
public class KeinKontotypException extends Exception {
	private static final long serialVersionUID = -2180366140800175258L;

	public KeinKontotypException() {
		JOptionPane.showMessageDialog(new JFrame(),
				"Bitte wählen sie einen Kontotypen aus.", "Inane error",
				JOptionPane.ERROR_MESSAGE);
	}
}
