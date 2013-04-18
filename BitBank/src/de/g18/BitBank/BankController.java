package de.g18.BitBank;

import java.util.ArrayList;
import java.util.List;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KundenNummerException;

public class BankController {

	List<Kunde> kundenListe = new ArrayList<Kunde>();
	List<Konto> kontenListe = new ArrayList<Konto>();

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

	private Konto getKontoByKontoNummer(long kontoNummer) {

		for (Konto konto : this.kontenListe) {
			if (konto.getKontoNummer() == kontoNummer) {
				return konto;
			}
		}
		return null;

	}

	public void createKunde(String kundenName, long kundenNummer) {
		try {
			Kunde kunde = new Kunde(kundenName, kundenNummer);
			this.kundenListe.add(kunde);
		} catch (KundenNummerException e) {
			e.printStackTrace();
		}
	}

	public void createKonto(long kundenNummer, Kontotyp kontoTyp) {

		Konto konto = this.getKundeByKundenNummer(kundenNummer).anlegenKonto(
				kontoTyp);
		this.kontenListe.add(konto);
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
}
