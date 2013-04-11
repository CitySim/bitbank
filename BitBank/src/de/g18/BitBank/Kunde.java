package de.g18.BitBank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author it1-markde
 * @since JRE6
 */

public class Kunde {

	private int kundenNummmer;
	private String name;
	private List<Konto> kontenListe = new ArrayList<Konto>();

	/**
	 * Ertsellt eine neue Instanz eines Kunden
	 * 
	 * @param kundenName
	 *            Name des Kunden
	 * @param kundenNummer
	 *            Kundennummer des Kunden
	 * @throws Exception
	 */

	public Kunde(String kundenName, int kundenNummer) throws Exception {
		if (kundenNummer < 0) {
			throw new Exception("Kundennummer darf nicht kleiner 0 sein");
		}
		this.name = kundenName;
		this.kundenNummmer = kundenNummer;
	}

	/**
	 * Gibt die Kundennummer des Kunden zurück
	 * 
	 * @return Kundennummer des Kunden
	 */

	public int getKundenNummmer() {
		return kundenNummmer;
	}

	/**
	 * Setzt die Kundennummer des Kunden neu
	 * 
	 * @param neue
	 *            Kundennummer des Kunden
	 */

	public void setKundenNummmer(int kundenNummmer) {
		this.kundenNummmer = kundenNummmer;
	}

	/**
	 * Gibt den Namen des Kunden zurück
	 * 
	 * @return Name des Kunden
	 */

	public String getName() {
		return name;
	}

	/**
	 * Setzt die Kundennummer des Kunden neu
	 * 
	 * @param neue
	 *            Kundennummer des Kunden
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gibt die Liste aller Konten des Kunden zurücks Namen des Kunden zurück
	 * 
	 * @return Name des Kunden
	 */

	public List<Konto> getKontenListe() {
		return kontenListe;
	}

	/**
	 * Führt die Ueberweisung über das entsprechende Quellkonto durch.
	 * 
	 * @param quellKonto
	 *            Konto von dem ueberwiesen wird.
	 * 
	 * @param zielKonto
	 *            Konto auf das ueberwiesen wird.
	 * @param betrag
	 *            zu ueberweisende Summe.
	 * @param datum
	 *            aktuelles Datum.F
	 * @throws Exception
	 */

	public void ueberweisen(Konto quellKonto, Konto zielKonto, int betrag,
			Date datum) throws Exception {
		quellKonto.ueberweisen(zielKonto, betrag, datum);
	}

	/**
	 * Legt ein neues Konto von angeben Typ und fügt es diesem Kunden hinzu
	 * 
	 * @param kontoTyp
	 *            Typ des neuen Kontos
	 * @return das neu angelegte Konto
	 */

	public Konto anlegenKonto(Kontotyp kontoTyp) {
		// Die Daten werden übergeben um die Kontonummer erzeugen zu können
		if (kontoTyp.toString().equals("GIROKONTO")) {
			Girokonto neuesKonto = new Girokonto(this.kundenNummmer,
					this.kontenListe.size());
			kontenListe.add(neuesKonto);
			return neuesKonto;

		} else {
			Sparkonto neuesKonto = new Sparkonto(kontoTyp, this.kundenNummmer,
					this.kontenListe.size());
			kontenListe.add(neuesKonto);
			return neuesKonto;

		}

	}

	/**
	 * Gibt einen mehrzeiligen String mit einer Übersicht aller Konten des
	 * Kunden zurück
	 * 
	 * @return mehrzeiliger String
	 */

	public String anzeigenKontostandsUebersicht() {
		String ubersicht = "\n";

		ubersicht += "┌────────────────────────────────────────────────────────────────────┐\n";
		ubersicht += "│ Kunde: " + String.format("%1$-60s", name) + "│\n";
		ubersicht += "├─────────────────────┬───────────────────────────┬──────────────────┤\n";
		ubersicht += "│ Nr.                 │ Kontostand                │ Typ              │\n";

		for (Konto konto : kontenListe) {
			ubersicht += "├─────────────────────┼───────────────────────────┼──────────────────┤\n";
			ubersicht += "│ "
					+ String.format("%1$-19s", konto.getKontoNummer()) + " │ "
					+ String.format("%1$-25s", konto.getKontoStand()) + " │ "
					+ String.format("%1$-16s", konto.getKontoTyp()) + " │\n";
		}

		ubersicht += "└─────────────────────┴───────────────────────────┴──────────────────┘\n";

		return ubersicht;
	}
}
