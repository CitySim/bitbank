package de.g18.BitBank;

import java.util.ArrayList;
import java.util.List;

public class BankController {

	List<Kunde> kundenListe = new ArrayList<Kunde>();

	public void createKunde(String kundenName, int kundenNummer) {

		try {
			Kunde kunde = new Kunde(kundenName, 0);
			this.kundenListe.add(kunde);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
