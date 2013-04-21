package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * Unterklasse von Konto.
 * 
 * @author it1-markde
 * @since JRE6
 * @see Konto
 */

public class Sparkonto extends Konto {
	private double festzins;

	public Sparkonto(final long kundenNummmer, final int indexNummer) {
		super(Kontotyp.SPARKONTO, kundenNummmer, indexNummer);
	}

	public final double getFestzins() {
		return festzins;
	}

	public final void setFestzins(final double festzins) {
		this.festzins = festzins;
	}

	/**
	 * Zieht einen Betrag vom aktuellen Kontostand ab. Kann nicht unter 0
	 * sinken.
	 * 
	 * @throws KontoLeerException
	 *             Fehler wenn Konto überzogen wird
	 * @throws BetragNegativException
	 *             Fehler bei negativen Beträgen
	 * @param betrag
	 *            zu zahlender betrag
	 */

	@Override
	public void auszahlen(final double betrag) throws KontoLeerException,
			BetragNegativException {
		if (super.getKontoStand() - betrag < 0) {
			throw new KontoLeerException(
					"Das Konto darf nicht überzogen werden.");
		}

		super.auszahlen(betrag);
	}
}
