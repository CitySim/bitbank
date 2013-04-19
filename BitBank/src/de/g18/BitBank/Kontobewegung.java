package de.g18.BitBank;

import java.util.Date;

/**
 * Gibt eine Kontobewegung (Einzahlung || Auszahlung || Überweisung) aus.
 * 
 * @author it1-korebj
 * @since JRE6
 */

public class Kontobewegung {

	private Date datum;
	private double betrag;

	public Kontobewegung(final Date datum, final double betrag) {
		this.datum = datum;
		this.betrag = betrag;
	}

	public Date getDatum() {
		return datum;
	}

	public double getBetrag() {
		return betrag;
	}
}
