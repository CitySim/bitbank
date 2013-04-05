package de.g18.BitBank;

/**
 * @author it1-markde
 * @since JDK 1.7.0_11
 */
public class Sparkonto extends Konto {
	private double festzins;

	public Sparkonto(Kontotyp kontoTyp, int kundenNummer, int indexNummer) {
		super(kontoTyp, kundenNummer, indexNummer);
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
	public void auszahlen(int betrag) throws Exception {
		if (this.kontoStand - betrag <= 0) {
			this.kontoStand = this.kontoStand - betrag;
		} else {
			throw new Exception("Das Konto darf nicht überzogen werden.");
		}
	}
}
