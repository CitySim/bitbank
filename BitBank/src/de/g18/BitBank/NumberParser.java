package de.g18.BitBank;

import de.g18.BitBank.Exception.ZuVieleNachkommastellenException;

/**
 * Hilfsklasse zum parsen von String zu double.
 * 
 * @author it1-korebj
 * @since JRE6
 */

public class NumberParser {

	/**
	 * Ermöglicht das Umwandeln vom Komma separierten Zahlen.
	 * 
	 * @param text
	 *            eingelesener Text
	 * @return betrag - Summe als double
	 * @throws NumberFormatException
	 *             Exception beim Parsen von nicht-Zahlen
	 * @throws ZuVieleNachkommastellenException
	 *             Exception bei Zahlen mit zu vielen Nachkommastellen
	 */
	public double parseDouble(String text) throws NumberFormatException,
			ZuVieleNachkommastellenException {

		if (text.contains(",")) {
			text = (text.substring(0, text.indexOf(",")) + "." + (text
					.substring(text.indexOf(",") + 1)));
		}

		double betrag = Double.parseDouble(text);
		this.checkNumber(betrag);
		return betrag;
	}

	/**
	 * Fuehrt eine Kontrolle auf zahlen mit unlogisch vielen Nachkommastellen
	 * durch.
	 * 
	 * @param betrag
	 *            Summe als double
	 * @throws ZuVieleNachkommastellenException
	 *             Exception bei Zahlen mit zu vielen Nachkommastellen
	 */
	public void checkNumber(double betrag)
			throws ZuVieleNachkommastellenException {

		String s = Double.toString(betrag);
		s = s.substring(s.indexOf(".") + 1);
		if (s.length() > 2) {
			throw new ZuVieleNachkommastellenException(
					"Anzahl Nachkommastellen: " + s.length());
		}
	}
}
