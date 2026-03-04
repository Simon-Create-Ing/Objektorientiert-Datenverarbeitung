package view;

import resources.Konstanten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Enthnaelt alle methoden um etwas einzulesen
 */

public class Eingeben {
    // Reader fuer die Konsole
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Diese Methode dient dazu den Nutzer so lange dazu aufzuforden einen Wert einzugeben,
     * bis er eine natuerliche Zahl eingibt.
     *
     * @return Eine vom Nutzer eingegebene natuerliche Zahl
     * @Vorbedingung Keine
     * @Nachbedingung Eine vom Nutzer eingegebene natuerliche Zahl wird zuruckgegeben.
     */
    public static int wertEingeben() {
        String wertString = null;

        while (true) {
            try {
                // wertString und wertInt separat, um korrekte ausgaben zu bekommen,
                // wenn String nicht geparst werden kann.
                wertString = reader.readLine();


                int wertInt = Integer.parseInt(wertString);

                if (wertInt >= 0) {
                    return wertInt;
                } else {
                    Ausgeben.ausgeben(wertInt + Konstanten.EINGABE_FEHLER);
                }
            } catch (NumberFormatException | IOException e) {
                Ausgeben.ausgeben(wertString + Konstanten.EINGABE_FEHLER);
            }
        }
    }

    /**
     * Diese Methode dient dazu den Nutzer so lange dazu aufzuforden der Wert fuer eine passende Soerteirungmethode einzugeben,
     * bis er eine natuerliche Zahl zwischen 1 und 15 eingibt.
     *
     * @return Eine vom Nutzer eingegebene natuerliche Zahl
     * @Vorbedingung Keine
     * @Nachbedingung Eine vom Nutzer eingegebene natuerliche Zahl zwischen 1 und 15 wird zuruckgegeben.
     */
    public static int sortierungMethodenWertEingeben() {
        String wertString = null;

        while (true) {
            try {
                // wertString und wertInt separat, um korrekte ausgaben zu bekommen,
                // wenn String nicht geparst werden kann.
                wertString = reader.readLine();


                int wertInt = Integer.parseInt(wertString);

                if (wertInt >= 1 && wertInt <= 15) {
                    return wertInt;
                } else {
                    Ausgeben.ausgeben(wertInt + Konstanten.EINGABE_FEHLER_DER_SORTIERUNG);
                }
            } catch (NumberFormatException | IOException e) {
                Ausgeben.ausgeben(wertString + Konstanten.EINGABE_FEHLER);
            }
        }
    }
}

