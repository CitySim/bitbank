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
	 * @param text eingelesener Text
	 * @return betrag - Summe als double
	 * @throws ZuVieleNachkommastellenException
	 *          Exception bei Zahlen mit zu vielen Nachkommastellen
	 */
	public final double parseDouble(String text)
			throws ZuVieleNachkommastellenException {

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
	 * @param betrag Summe als double
	 * @throws ZuVieleNachkommastellenException
	 *          Exception bei Zahlen mit zu vielen Nachkommastellen
	 */
	private void checkNumber(final double betrag)
			throws ZuVieleNachkommastellenException {

		long l = (long) (betrag * 100.0);


		if (l != betrag * 100) {
			throw new ZuVieleNachkommastellenException(
					"Anzahl Nachkommastellen: ");
		}
	}
}
