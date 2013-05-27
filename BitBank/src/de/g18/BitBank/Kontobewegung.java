package de.g18.BitBank;

import java.util.Date;

/**
 * Gibt eine Kontobewegung (Einzahlung || Auszahlung || Ueberweisung) aus.
 * 
 * @author it1-korebj
 * @since jdk1.7.0_17
 */

public class Kontobewegung {

    private final Date datum;
    private final double betrag;
    private final String text;

    public Kontobewegung(final Date datum, final double betrag) {
        this(datum, betrag, "");
    }

    private Kontobewegung(final Date datum, final double betrag, final String text) {
        this.datum = datum;
        this.betrag = betrag;
        this.text = text;
    }

    public Date getDatum() {
        return this.datum;
    }

    public double getBetrag() {
        return this.betrag;
    }

    public String getText() {
        return this.text;
    }
}
