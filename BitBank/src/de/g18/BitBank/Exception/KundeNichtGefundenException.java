package de.g18.BitBank.Exception;

/**
 * Created with IntelliJ IDEA.
 * User: it1-tattsv
 * Date: 19.04.13
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
public class KundeNichtGefundenException extends Throwable {
	public KundeNichtGefundenException(long kundenNummer) {
		super("Kunde " + Long.toString(kundenNummer) + " nicht gefunden");
	}
}
