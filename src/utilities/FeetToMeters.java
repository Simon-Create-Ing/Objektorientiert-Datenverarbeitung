package utilities;

import resources.Literal;

/**
 * Die Klasse enthaelt alle Methoden zur Umrechnung der Daten
 */

public class FeetToMeters {

    /**
     * wert in Fuße und rechnet sich in meters um.
     * Diese methode nimmt ein
     *
     * @vorbedingung wert in Fueß muss schon gegeben werden.
     * @Nachbedingung wert in meters wird herausbekommen.
     *
     * @param valueInFeet (double)
     * @return die passende wert in meters (double)
     */
    public static double convertFeetToMeters(double valueInFeet) {
        return valueInFeet * Literal.FEET_TO_METERS;
    }
}
