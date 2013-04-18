package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * @author it1-markde
 * @since JRE6
 */

public class Sparkonto extends Konto {
	private double festzins;

	public Sparkonto(long kundenNummmer, int indexNummer) {
		super(Kontotyp.SPARKONTO, kundenNummmer, indexNummer);
	}

	public double getFestzins() {
		return festzins;
	}

	public void setFestzins(double festzins) {
		this.festzins = festzins;
	}

	/**
	 * Zieht einen Betrag vom aktuellen Kontostand ab. Kann nicht unter 0
	 * sinken.
	 */

	@Override
	public void auszahlen(double betrag) throws KontoLeerException,
			BetragNegativException {
		if (super.getKontoStand() - betrag < 0) {
			throw new KontoLeerException(
					"Das Konto darf nicht überzogen werden.");
		}

		super.auszahlen(betrag);
	}
}
