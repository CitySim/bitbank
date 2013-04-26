package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Unterklasse von Konto.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 * @see Konto
 */

public class Girokonto extends Konto {

	public Girokonto(final long kundenNummmer, final int indexNummer) {
		super(Kontotyp.GIROKONTO, kundenNummmer, indexNummer);
	}

	private double limit;

	public final double getLimit() {
		return limit;
	}

	public final void setLimit(final double limit) {
		this.limit = limit;
	}

	/**
	 * Zieht einen Betrag vom aktuellen Kontostand ab. Kann nicht unter 0 - das
	 * festgelegte Limit fallen.
	 * 
	 * @throws KontoLeerException
	 *             Fehler wenn Konto überzogen wird
	 * 
	 * @throws BetragNegativException
	 *             Fehler bei negativen Beträgen
	 * @param betrag
	 *            zu zahlender Betrag
	 */

	@Override
	public void auszahlen(final double betrag) throws BetragNegativException,
			KontoLeerException {
		if (super.getKontoStand() - betrag < -limit) {
			throw new KontoLeerException(
					"Das Konto kann nicht weiter als um das zugelassene Limit überzogen werden.");
		}

		super.auszahlen(betrag);
	}
}
