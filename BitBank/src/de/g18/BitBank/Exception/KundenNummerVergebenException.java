package de.g18.BitBank.Exception;

/**
 * Created with IntelliJ IDEA.
 * User: it1-tattsv
 * Date: 19.04.13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class KundenNummerVergebenException extends Exception {
	public KundenNummerVergebenException(long kundenNummer) {
		super("Die Kundennummer " + Long.toString(kundenNummer) + " ist bereits vergeben");
	}
}
