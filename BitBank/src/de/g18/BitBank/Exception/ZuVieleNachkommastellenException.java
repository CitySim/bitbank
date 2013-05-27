package de.g18.BitBank.Exception;

import javax.swing.JOptionPane;

/**
 * Exception bei zu vielen Nachkommastellen.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class ZuVieleNachkommastellenException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = 2013054086569775820L;

    public ZuVieleNachkommastellenException(final String message) {
        super(message);
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(
                null,
                "Es dürfen maximal zwei Nachkommastellen angegeben werde.",
                "Fehler",
                JOptionPane.ERROR_MESSAGE);
    }

}
