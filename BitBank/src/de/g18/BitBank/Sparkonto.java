package de.g18.BitBank;

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
	public void auszahlen(double betrag) throws Exception {
		if (super.getKontoStand() - betrag < 0) {
			throw new Exception("Das Konto darf nicht überzogen werden.");
		}

		super.auszahlen(betrag);
	}
}
