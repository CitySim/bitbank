package de.g18.BitBank;

/**
 * @author it1-markde
 * @since JRE6
 */

public class Girokonto extends Konto {

	public Girokonto(Kontotyp kontoTyp, int kundenNummer, int indexNummer) {
		super(kontoTyp, kundenNummer, indexNummer);
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
	public void auszahlen(double betrag) throws Exception {

		if (this.kontoStand - betrag >= 0 - this.limit) {
			this.kontoStand = this.kontoStand - betrag;
		} else {
			throw new Exception(
					"Das Konto kann nicht weiter als um das zugelassene Limit überzogen werden.");
		}
	}
}
