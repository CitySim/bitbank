package de.g18.BitBank;

import de.g18.BitBank.Exception.KundenNummerException;

import java.util.ArrayList;
import java.util.List;

public class BankController {

	List<Kunde> kundenListe = new ArrayList<Kunde>();

	public void createKunde(String kundenName, int kundenNummer) {
		try {
			Kunde kunde = new Kunde(kundenName, kundenNummer);
			this.kundenListe.add(kunde);
		} catch (KundenNummerException e) {
			e.printStackTrace();
		}
	}

	public int getKundenCount() {
		return kundenListe.size();
	}

	public Kunde getKundeByIndex(int i) {
		return kundenListe.get(i);
	}
}
