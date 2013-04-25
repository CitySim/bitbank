package de.g18.BitBank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Exception.KundeNichtGefundenException;
import de.g18.BitBank.Exception.KundenNummerUnzulaessigException;
import de.g18.BitBank.Exception.KundenNummerVergebenException;

/**
 * BankController Klasse als Schnittstelle zwischen Listenern und ausfuehrenden
 * Klassen.
 * 
 * @author it1-markde
 * @since JRE6
 */

public class BankController {
	private List<Kunde> kundenListe = new ArrayList<Kunde>();

	public final int getKundenCount() {
		return kundenListe.size();
	}

	public final List<Kunde> getKundenListe() {
		return kundenListe;
	}

	public final Kunde getKundeByIndex(final int i) {
		return kundenListe.get(i);
	}

	private Kunde getKundeByKundenNummer(final long kundenNummer)
			throws KundeNichtGefundenException {
		for (Kunde kunde : this.kundenListe) {
			if (kunde.getKundenNummmer() == kundenNummer) {
				return kunde;
			}
		}
		throw new KundeNichtGefundenException(kundenNummer);
	}

	// Geht durch jedes Konto von jedem Kunten um das entsprechende Konto zu
	// finden.
	public final Konto getKontoByKontoNummer(final long kontoNummer)
			throws KontoNichtGefundenException {
		for (Kunde kunde : kundenListe) {
			for (Konto konto : kunde.getKontenListe()) {
				if (konto.getKontoNummer() == kontoNummer) {
					return konto;
				}
			}
		}
		throw new KontoNichtGefundenException(kontoNummer);
	}

	public final void createKunde(final String kundenName,
			final long kundenNummer) throws KundenNummerVergebenException {
		for (Kunde kunde : kundenListe) {
			if (kunde.getKundenNummmer() == kundenNummer) {
				throw new KundenNummerVergebenException(kundenNummer);
			}
		}

		try {
			Kunde kunde = new Kunde(kundenName, kundenNummer);
			this.kundenListe.add(kunde);
		} catch (KundenNummerUnzulaessigException e) {
			e.printStackTrace();
		}
	}

	public final Konto createKonto(final long kundenNummer,
			final Kontotyp kontoTyp) throws KundeNichtGefundenException {
		Kunde kunde = getKundeByKundenNummer(kundenNummer);
		return kunde.anlegenKonto(kontoTyp);
	}

	public final double kontoStandAnzeigen(final int kontoNummer)
			throws KontoNichtGefundenException {
		return this.getKontoByKontoNummer(kontoNummer).getKontoStand();
	}

	public final void einzahlen(final int kontoNummer, final double betrag)
			throws KontoNichtGefundenException, BetragNegativException {
		this.getKontoByKontoNummer(kontoNummer).einzahlen(betrag);
	}

	public final void auszahlen(final int kontoNummer, final double betrag)
			throws KontoNichtGefundenException, KontoLeerException,
			BetragNegativException {
		this.getKontoByKontoNummer(kontoNummer).auszahlen(betrag);
	}

	public final void ueberweisen(final int zielKontoNummer,
			final long quellKontoNummer, final double betrag, final Date datum)
			throws KontoNichtGefundenException, KontoLeerException,
			BetragNegativException {
		Konto von = getKontoByKontoNummer(quellKontoNummer);
		Konto nach = this.getKontoByKontoNummer(zielKontoNummer);

		if (von == null) {
			throw new KontoNichtGefundenException(quellKontoNummer);
		}
		if (nach == null) {
			throw new KontoNichtGefundenException(zielKontoNummer);
		}

		von.ueberweisen(nach, betrag, datum);
	}

	public final Kunde getKundeByNummer(final long kundenNummer)
			throws KundeNichtGefundenException {
		for (Kunde kunde : kundenListe) {
			if (kunde.getKundenNummmer() == kundenNummer) {
				return kunde;
			}
		}
		throw new KundeNichtGefundenException(kundenNummer);
	}
}
