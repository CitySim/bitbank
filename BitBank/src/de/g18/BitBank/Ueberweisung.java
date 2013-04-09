package de.g18.BitBank;

import java.util.Date;

/**
 * @author it1-markde
 * @since JRE6
 */

public class Ueberweisung {

	private double betrag;
	private Konto quellKonto;
	private Konto zielKonto;
	private Date datum;

	public Ueberweisung(Konto quellKonto, Konto zielKonto, double betrag,
			Date datum) {

		this.quellKonto = quellKonto;
		this.zielKonto = zielKonto;
		this.betrag = betrag;
		this.datum = datum;

	}

	/**
	 * Ueberträgt den betrag der ueberweisung von einem Konto zum anderen.
	 * 
	 * @throws Exception
	 */

	public void durchfuehrenUeberweisung() throws Exception {

		this.quellKonto.auszahlen(betrag);
		this.zielKonto.einzahlen(betrag);

	}

	public double getBetrag() {
		return betrag;
	}

	public Konto getQuellKlasse() {
		return quellKonto;
	}

	public Konto getZielKlasse() {
		return zielKonto;
	}

	public Date getDatum() {
		return datum;
	}
}
