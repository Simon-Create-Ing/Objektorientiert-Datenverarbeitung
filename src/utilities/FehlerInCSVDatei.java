package utilities;

import resources.Konstanten;
import resources.Literal;

/**
 * Diese Klasse bietet Hilfsmethoden zur Verarbeitung und Fehlerbehandlung von CSV-Dateieintraegen.
 * Sie enthaelt Methoden zur Umwandlung von Strings in verschiedene Datentypen,
 * um fehlerhafte oder unvollstaendige Eingaben zu handhaben.
 */
public class FehlerInCSVDatei {


    /**
     * ueberprüft, ob ein String leer oder null ist, und ersetzt ihn durch "UNKNOWN".
     *
     * @param value1 Der Eingabestring, der überprüft werden soll.
     * @return Der ursprüngliche String oder "UNKNOWN", wenn der String leer oder null ist.
     *
     * @Vorbedingung Keine.
     * @Nachbedingung Gibt "UNKNOWN" zurück, wenn der Eingabestring leer oder null ist, sonst den Eingabestring.
     */
    public static String LehresStringFehler(String value1) {
        String value2;
        if (value1 == null || value1.trim().isEmpty()) {
            value2 = Konstanten.UNKNOWN;
            return value2;
        } else {
            return value1;
        }
    }

    /**
     * Überprüft und korrigiert den Longitude-Wert, falls er außerhalb des gültigen Bereichs liegt.
     * Falls der Wert ungültig ist, wird er durch Division durch 1000 skaliert, weil die Daten ein drei-stellen Fehler haben.
     *
     * @param value1 Der zu überprüfende Longitude-Wert (kann `null` sein).
     * @return Der korrigierte Longitude-Wert:
     *         <ul>
     *         <li>Falls `value1` außerhalb des Bereichs [-90.00, 90.00] liegt, wird `value1 / 1000` zurückgegeben.</li>
     *         <li>Falls `value1` innerhalb des gültigen Bereichs liegt oder `null` ist, wird `value1` unveraendert zurückgegeben.</li>
     *         </ul>
     *
     * @Vorbedingung Keine, der Eingabewert kann `null` sein.
     * @Nachbedingung Gibt entweder den korrigierten oder den ursprünglichen Longitude-Wert zurück.
     */

    public static Double longitudeFehler(Double value1) {
        Double value2 = null;
        if (value1 != null && ( value1 < Literal.MINUS_HUNDERT_ACHTIG || value1 > Literal.HUNDERT_ACHTIG )) {
            value2 = value1 / Literal.THOUSAND;
            return value2;
        }
        return value1;
    }


    /**
     * Überprüft und korrigiert den Latitude-Wert, falls er außerhalb des gültigen Bereichs liegt.
     * Falls der Wert ungültig ist, wird er durch Division durch 1000 skaliert, weil die Daten ein drei-stellen Fehler haben.
     *
     * @param value1 Der zu überprüfende Latitude-Wert (kann `null` sein).
     * @return Der korrigierte Latitude-Wert:
     *         <ul>
     *         <li>Falls `value1` außerhalb des Bereichs [-180.00, 180.00] liegt, wird `value1 / 1000` zurückgegeben.</li>
     *         <li>Falls `value1` innerhalb des gültigen Bereichs liegt oder `null` ist, wird `value1` unveraendert zurückgegeben.</li>
     *         </ul>
     *
     * @Vorbedingung Keine, der Eingabewert kann `null` sein.
     * @Nachbedingung Gibt entweder den korrigierten oder den ursprünglichen Latitude-Wert zurück.
     */
    public static Double latitudeFehler(Double value1) {
        Double value2 = null;
        if (value1 != null && (value1 < Literal.MINUS_NEUNZIG || value1 > Literal.NEUNZIG)) {
            value2 = value1 / Literal.THOUSAND;
            return value2;
        }
        return value1;
    }
}


