package de.g18.BitBank;

import java.util.Scanner;

/**
 * Vorgegebene main Klasse zum testen.
 * 
 * @author dennis.markmann
 */

final class BankMain { // NO_UCD (unused code)

    private BankMain() {

    }

    public static void main(final String[] args) {
        try {
            final Scanner sc = new Scanner(System.in);
            System.out.print("Bitte Kundennummer eingeben: ");
            final int kundenNummer = sc.nextInt();
            System.out.print("Bitte Kundenname eingeben: ");
            final String kundenName = sc.next();
            sc.close();
            final Kunde kunde1 = new Kunde(kundenName, kundenNummer);
            final Konto konto1 = kunde1.anlegenKonto(Kontotyp.GIROKONTO);
            final Konto konto2 = kunde1.anlegenKonto(Kontotyp.SPARKONTO);
            System.out.println("(1) " + kunde1.anzeigenKontostandsUebersicht());
            konto1.einzahlen(1000);
            System.out.println("(2) " + kunde1.anzeigenKontostandsUebersicht());
            konto2.einzahlen(100);
            System.out.println("(3) " + kunde1.anzeigenKontostandsUebersicht());
            konto1.auszahlen(400);
            System.out.println("(4) " + kunde1.anzeigenKontostandsUebersicht());
            konto2.auszahlen(100);
            System.out.println("(5) " + kunde1.anzeigenKontostandsUebersicht());

            final Ueberweisung ueb = new Ueberweisung(konto1, konto2, 25, new java.util.Date());
            ueb.durchfuehrenUeberweisung();
            System.out.println("(6) " + kunde1.anzeigenKontostandsUebersicht());

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
