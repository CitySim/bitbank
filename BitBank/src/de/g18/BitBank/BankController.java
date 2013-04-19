package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KontoNichtGefundenException;
import de.g18.BitBank.Exception.KundenNummerException;

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

	public List<Konto> getKundenKonten(long kundenNummer) {
		return getKundeByKundenNummer(kundenNummer).getKontenListe();
	}

	public Konto getKontoByKontoNummer(long kontoNummer) {
		for (Kunde kunde : kundenListe) {
			for (Konto konto : kunde.getKontenListe()) {
				if (konto.getKontoNummer() == kontoNummer) {
					return konto;
				}
			}
		}
		return null;
	}

	public void createKunde(String kundenName, long kundenNummer) {
		try {
			Kunde kunde = new Kunde(kundenName, kundenNummer);
			this.kundenListe.add(kunde);
		} catch (KundenNummerException e) {
			new KundenNummerException();
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

	public double kontoStandAnzeigen(int kontoNummer) {
		return this.getKontoByKontoNummer(kontoNummer).getKontoStand();
	}

	public void einzahlen(int kontoNummer, double betrag) {
		try {
			this.getKontoByKontoNummer(kontoNummer).einzahlen(betrag);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		}
	}

	public void auszahlen(int kontoNummer, double betrag) {
		try {
			this.getKontoByKontoNummer(kontoNummer).auszahlen(betrag);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		} catch (KontoLeerException e) {
			e.printStackTrace();
		}
	}

	public void ueberweisen(long zielKontoNummer, long quellKontoNummer, double betrag, Date datum) throws KontoLeerException, BetragNegativException, KontoNichtGefundenException {
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

}
