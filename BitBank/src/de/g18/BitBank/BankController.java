package de.g18.BitBank;

import java.util.ArrayList;
import java.util.List;

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

	public Kunde getKundeByKundenNummer(long kundenNummer) {

		for (Kunde kunde : this.kundenListe) {
			if (kunde.getKundenNummmer() == kundenNummer) {
				return kunde;
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

		Konto konto = getKundeByKundenNummer(kundenNummer).anlegenKonto(
				kontoTyp);
		this.kontenListe.add(konto);

	}
}
