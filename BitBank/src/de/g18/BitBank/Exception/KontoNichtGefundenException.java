package de.g18.BitBank.Exception;

/**
 * Created with IntelliJ IDEA.
 * User: it1-tattsv
 * Date: 19.04.13
 * Time: 09:55
 * To change this template use File | Settings | File Templates.
 */
public class KontoNichtGefundenException extends Exception {
	public KontoNichtGefundenException(long kontoNummer) {
		super("Konto " + Long.toString(kontoNummer) + " nicht gefunden");
	}
}
