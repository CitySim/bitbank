package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragZuGrossException;
import de.g18.BitBank.Exception.ZuVieleNachkommastellenException;

/**
 * Hilfsklasse zum Parsen von String zu double.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class NumberParser {

	/**
	 * Ermöglicht das Umwandeln vom Komma separierten Zahlen.
	 * 
	 * @param text
	 *            eingelesener Text
	 * @return betrag - Summe als double
	 * @throws ZuVieleNachkommastellenException
	 *             Exception bei Zahlen mit zu vielen Nachkommastellen
	 * @throws BetragZuGroßException
	 */
	public final double parseDouble(String text)
			throws ZuVieleNachkommastellenException, BetragZuGrossException {

		if (text.contains(",")) {
			text = (text.substring(0, text.indexOf(",")) + "." + (text
					.substring(text.indexOf(",") + 1)));
		}

		final double betrag = Double.parseDouble(text);

		if (betrag > Long.MAX_VALUE) {
			throw new BetragZuGrossException("Betrag zu groß");
		}

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
	private void checkNumber(final double betrag)
			throws ZuVieleNachkommastellenException {

		final long l = (long) (betrag * 100.0);

		if (l != betrag * 100) {
			throw new ZuVieleNachkommastellenException(
					"Anzahl Nachkommastellen: ");
		}
	}
}
