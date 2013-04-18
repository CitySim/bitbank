package de.g18.BitBank;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KundenNummerException;

import java.util.ArrayList;
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

	public double kontoStandAnzeigen(int kontoNummer) {
		return this.getKontoByKontonummer(kontoNummer).getKontoStand();
	}

	public void einzahlen(int kontoNummer, double betrag) {
		try {
			this.getKontoByKontonummer(kontoNummer).einzahlen(betrag);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		}
	}

	public void auszahlen(int kontoNummer, double betrag) {
		try {
			this.getKontoByKontonummer(kontoNummer).auszahlen(betrag);
		} catch (BetragNegativException e) {
			e.printStackTrace();
		} catch (KontoLeerException e) {
			e.printStackTrace();
		}
	}

	public void ueberweisen(int zielKontoNummer, int quellKontoNummer,
			double betrag) {

		try {
			this.getKontoByKontoNummer(quellKontoNummer).ueberweisen(
					this.getKontoByKontoNummer(zielKontoNummer), betrag,
					new java.util.Date());
		} catch (BetragNegativException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KontoLeerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Konto getKontoByKontonummer(long kontoNummer) {
		for (Kunde kunde : kundenListe) {
			for (Konto konto : kunde.getKontenListe()) {
				if (konto.getKontoNummer() == kontoNummer) {
					return konto;
				}
			}
		}
		return null;
	}
}
