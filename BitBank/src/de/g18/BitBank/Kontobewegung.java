package de.g18.BitBank;

import java.util.Date;

/**
 * Gibt eine Kontobewegung (Einzahlung || Auszahlung || Überweisung) aus.
 *
 * @author it1-korebj
 * @since JRE6
 */

public class Kontobewegung {
	protected Date datum;
	protected double betrag;
	protected String text;

	public Kontobewegung(final Date datum, final double betrag) {
		this(datum, betrag, "");
	}

	public Kontobewegung(final Date datum, final double betrag, String text) {
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
