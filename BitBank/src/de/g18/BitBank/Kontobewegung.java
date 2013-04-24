package de.g18.BitBank;

import java.util.Date;

/**
 * Gibt eine Kontobewegung (Einzahlung || Auszahlung || Ueberweisung) aus.
 * 
 * @author it1-korebj
 * @since JRE6
 */

public class Kontobewegung {
	private Date datum;
	private double betrag;
	private String text;

	public Kontobewegung(final Date datum, final double betrag) {
		this(datum, betrag, "");
	}

	private Kontobewegung(final Date datum, final double betrag,
			final String text) {
		this.datum = datum;
		this.betrag = betrag;
		this.text = text;
	}

	public Date getDatum() {
		return datum;
	}

	public double getBetrag() {
		return betrag;
	}

	public String getText() {
		return text;
	}
}
