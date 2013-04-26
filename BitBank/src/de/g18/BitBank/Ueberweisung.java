package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;

import java.util.Date;

/**
 * Klasse zum uebertragen von Geld zwischen Konten.
 * 
 * @author it1-markde
 * @since jdk1.7.0_17
 */

public class Ueberweisung extends Kontobewegung {
	private Konto quellKonto;
	private Konto zielKonto;

	public Ueberweisung(final Konto quellKonto, final Konto zielKonto,
			final double betrag, final Date datum) {

		super(datum, betrag);

		this.quellKonto = quellKonto;
		this.zielKonto = zielKonto;
	}

	/**
	 * Uebertraegt den betrag der ueberweisung von einem Konto zum anderen.
	 * 
	 * @throws BetragNegativException
	 *             Fehler bei negativen Beträgen
	 * @throws KontoLeerException
	 *             Fehler bei nicht bekannten Konten
	 */
	public void durchfuehrenUeberweisung() throws BetragNegativException,
			KontoLeerException {
		quellKonto.auszahlen(super.getBetrag());
		zielKonto.einzahlen(super.getBetrag());

		quellKonto.getUeberweisungsListe().add(this);
		zielKonto.getUeberweisungsListe().add(this);
		quellKonto.getKontoBewegungsListe().add(this);
		zielKonto.getKontoBewegungsListe().add(this);
	}

	public Konto getQuellKlasse() {
		return quellKonto;
	}

	public Konto getZielKlasse() {
		return zielKonto;
	}

	@Override
	public String getText() {
		return "Überweisun von " + getQuellKlasse().getKontoNummer() + " auf "
				+ getZielKlasse().getKontoNummer();
	}
}
