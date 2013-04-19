package de.g18.BitBank;

import de.g18.BitBank.Exception.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankController {
	List<Kunde> kundenListe = new ArrayList<Kunde>();

	public int getKundenCount() {
		return kundenListe.size();
	}

	public Kunde getKundeByIndex(int i) {
		return kundenListe.get(i);
	}

	private Kunde getKundeByKundenNummer(long kundenNummer) {
		for (Kunde kunde : this.kundenListe) {
			if (kunde.getKundenNummmer() == kundenNummer) {
				return kunde;
			}
		}
		return null;
	}

	public Konto getKontoByKontoNummer(long kontoNummer) throws KontoNichtGefundenException {
		for (Kunde kunde : kundenListe) {
			for (Konto konto : kunde.getKontenListe()) {
				if (konto.getKontoNummer() == kontoNummer) {
					return konto;
				}
			}
		}
		throw new KontoNichtGefundenException(kontoNummer);
	}

	public void createKunde(String kundenName, long kundenNummer) {
		try {
			Kunde kunde = new Kunde(kundenName, kundenNummer);
			this.kundenListe.add(kunde);
		} catch (KundenNummerException e) {
			e.printStackTrace();
		}
	}

	public Konto createKonto(long kundenNummer, Kontotyp kontoTyp) {
		Kunde kunde = getKundeByKundenNummer(kundenNummer);

		if (kunde != null) {
			return kunde.anlegenKonto(kontoTyp);
		} else {
			// TODO throw exception, oder so
			return null;
		}
	}

	public double kontoStandAnzeigen(int kontoNummer) throws KontoNichtGefundenException {
		return this.getKontoByKontoNummer(kontoNummer).getKontoStand();
	}

	public void einzahlen(int kontoNummer, double betrag) throws KontoNichtGefundenException, BetragNegativException {
		this.getKontoByKontoNummer(kontoNummer).einzahlen(betrag);
	}

	public void auszahlen(int kontoNummer, double betrag) throws KontoNichtGefundenException, KontoLeerException, BetragNegativException {
		this.getKontoByKontoNummer(kontoNummer).auszahlen(betrag);
	}

	public void ueberweisen(int zielKontoNummer, long quellKontoNummer, double betrag, Date datum) throws KontoNichtGefundenException, KontoLeerException, BetragNegativException {
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

	public Kunde getKundeByNummer(long kundenNummer) throws KundeNichtGefundenException {
		for (Kunde kunde : kundenListe) {
			if (kunde.getKundenNummmer() == kundenNummer) {
				return kunde;
			}
		}
		throw new KundeNichtGefundenException(kundenNummer);
	}
}
