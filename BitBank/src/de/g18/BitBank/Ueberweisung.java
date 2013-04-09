package de.g18.BitBank;

import java.util.Date;

/**
 * @author it1-markde
 * @since JRE6
 */
public class Ueberweisung {

	private double betrag;
	private Konto quellKlasse;
	private Konto zielKlasse;
	private Date datum;

	public Ueberweisung(Konto quellKlasse, Konto zielKlasse, double betrag,
			Date datum) {

		this.quellKlasse = quellKlasse;
		this.zielKlasse = zielKlasse;
		this.betrag = betrag;
		this.datum = datum;

	}

	public void durchfuehrenUeberweisung() {

	}

	public double getBetrag() {
		return betrag;
	}

	public Konto getQuellKlasse() {
		return quellKlasse;
	}

	public Konto getZielKlasse() {
		return zielKlasse;
	}

	public Date getDatum() {
		return datum;
	}
}
