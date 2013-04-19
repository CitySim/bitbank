package de.g18.BitBank.Exception;

/**
 * Created with IntelliJ IDEA. User: Sven Date: 17.04.13 Time: 21:37 To change
 * this template use File | Settings | File Templates.
 */
public class KontoLeerException extends Exception {
	private static final long serialVersionUID = -9013057245886843969L;

	public KontoLeerException(final String message) {
		super(message);
	}
}
