package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * @author it1-markde
 * @since JRE6
 */

public class Girokonto extends Konto {

	public Girokonto(int kundenNummer, int indexNummer) {
		super(Kontotyp.GIROKONTO, kundenNummer, indexNummer);
	}

	/**
	 */
	private double limit;

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	/**
	 * Zieht einen Betrag vom aktuellen Kontostand ab. Kann nicht unter 0 - das
	 * festgelegte Limit fallen.
	 */

	@Override
	public void auszahlen(double betrag) throws BetragNegativException, KontoLeerException {
		if (super.getKontoStand() - betrag < -limit) {
			throw new KontoLeerException(
					"Das Konto kann nicht weiter als um das zugelassene Limit überzogen werden.");
		}

		super.auszahlen(betrag);
	}
}
