package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

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
	 * @throws BetragNegativException
	 * @throws KontoLeerException
	 */
	public void durchfuehrenUeberweisung() throws BetragNegativException, KontoLeerException {
		quellKonto.auszahlen(betrag);
		zielKonto.einzahlen(betrag);

		quellKonto.getUeberweisungsListe().add(this);
		zielKonto.getUeberweisungsListe().add(this);
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
