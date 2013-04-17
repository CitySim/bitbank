package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

/**
 * @author it1-markde
 * @since JRE6
 */

public class Sparkonto extends Konto {
	private double festzins;

	public Sparkonto(int kundenNummer, int indexNummer) {
		super(Kontotyp.SPARKONTO, kundenNummer, indexNummer);
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
	public void auszahlen(double betrag) throws KontoLeerException, BetragNegativException {
		if (super.getKontoStand() - betrag < 0) {
			throw new KontoLeerException("Das Konto darf nicht überzogen werden.");
		}

		super.auszahlen(betrag);
	}
}
