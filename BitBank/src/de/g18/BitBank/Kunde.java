package de.g18.BitBank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.g18.BitBank.Exception.BetragNegativException;
import de.g18.BitBank.Exception.KontoLeerException;
import de.g18.BitBank.Exception.KundenNummerException;

/**
 * @author it1-markde
 * @since JRE6
 */
public class Kunde {
	private long kundenNummmer;
	private String name;
	private List<Konto> kontenListe = new ArrayList<Konto>();

	/**
	 * Ertsellt eine neue Instanz eines Kunden.
	 * 
	 * @param kundenName
	 *            Name des Kunden
	 * @param kundenNummer
	 *            Kundennummer des Kunden
	 * @throws ExceptionF
	 */
	public Kunde(final String kundenName, final long kundenNummer)
			throws KundenNummerException {
		if (kundenNummer < 0) {
			throw new KundenNummerException(
					"Kundennummer darf nicht kleiner 0 sein");
		}
		this.name = kundenName;
		this.kundenNummmer = kundenNummer;
	}

	/**
	 * Gibt die Kundennummer des Kunden zurück.
	 * 
	 * @return Kundennummer des Kunden
	 */
	public long getKundenNummmer() {
		return kundenNummmer;
	}

	/**
	 * Setzt die Kundennummer des Kunden neu.
	 */
	public void setKundenNummmer(final int kundenNummmer) {
		this.kundenNummmer = kundenNummmer;
	}

	/**
	 * Gibt den Namen des Kunden zurück.
	 * 
	 * @return Name des Kunden
	 */
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gibt die Liste aller Konten des Kunden zurücks Namen des Kunden zurück.
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
	 * @param zielKonto
	 *            Konto auf das ueberwiesen wird.
	 * @param betrag
	 *            zu ueberweisende Summe.
	 * @param datum
	 *            aktuelles Datum.F
	 * @throws KontoLeerException
	 * @throws BetragNegativException
	 */
	public void ueberweisen(final Konto quellKonto, final Konto zielKonto,
			final int betrag, final Date datum) throws KontoLeerException,
			BetragNegativException {
		quellKonto.ueberweisen(zielKonto, betrag, datum);
	}

	/**
	 * Legt ein neues Konto von angeben Typ und fügt es diesem Kunden hinzu.
	 * 
	 * @param kontoTyp
	 *            Typ des neuen Kontos
	 * @return das neu angelegte Konto
	 */
	public Konto anlegenKonto(final Kontotyp kontoTyp) {
		// Die Daten werden übergeben um die Kontonummer erzeugen zu können
		if (kontoTyp.toString().equals("GIROKONTO")) {
			Girokonto neuesKonto = new Girokonto(this.kundenNummmer,
					this.kontenListe.size());
			kontenListe.add(neuesKonto);
			return neuesKonto;

		} else {
			Sparkonto neuesKonto = new Sparkonto(this.kundenNummmer,
					this.kontenListe.size());
			kontenListe.add(neuesKonto);
			return neuesKonto;

		}
	}

	/**
	 * Gibt einen mehrzeiligen String mit einer Übersicht aller Konten des
	 * Kunden zurück.
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
