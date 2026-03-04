package utilities;

import resources.Konstanten;
import resources.Literal;

/**
 * Diese Klasse stellt Hilfsmethoden zum Vergleichen und Bearbeiten von Daten zur Verfuegung.
 * Die Methoden sind fuer den Vergleich von Strings, Doubles und Booleans sowie
 * für die Verarbeitung von Zeichenketten optimiert.
 */
public class HilfsMethoden {


    /**
     * Konvertiert einen String in einen Double-Wert. Gibt `null` zurück, wenn der String leer oder null ist.
     *
     * @param value1 Der Eingabestring, der in einen Double-Wert konvertiert werden soll.
     * @return Der konvertierte Double-Wert oder `null`, wenn der Eingabestring leer oder null ist.
     *
     * @Vorbedingung Der String enthaelt einen gültigen Double-Wert oder ist leer/null.
     * @Nachbedingung Gibt den Double-Wert des Strings oder `null` zurück.
     */
    public static Double parsingDouble(String value1) {
        if (value1 == null || value1.trim().isEmpty()) {
            // Rückgabe von null für unbekannte Werte
            return null;
        }
        return Double.parseDouble(value1.trim());
    }

    /**
     * Vergleicht zwei Strings und behandelt spezielle Faelle wie "UNKNOWN" oder `null`.
     *
     * @param s1 Erster String zum Vergleich.
     * @param s2 Zweiter String zum Vergleich.
     * @return Ein Integer-Wert:
     *         <ul>
     *         <li>1, wenn der erste String `null` ist oder "UNKNOWN".</li>
     *         <li>-1, wenn der zweite String `null` ist oder "UNKNOWN".</li>
     *         <li>Ein Standardvergleichswert, wenn beide Strings gültig sind.</li>
     *         </ul>
     *
     * @Vorbedingung Keine, aber die Eingabestrings können `null` sein.
     * @Nachbedingung Gibt einen Vergleichswert zurück, der die speziellen Regeln für "UNKNOWN" und `null` berücksichtigt.
     */
    public static int compareStrings(String s1, String s2) {
        if(s1 == null && s2 == null) return Literal.NULL;
        if (Konstanten.UNKNOWN.equalsIgnoreCase(s1)) return Literal.EINS;
        if (Konstanten.UNKNOWN.equalsIgnoreCase(s2)) return Literal.MINUS_EINS;
        if (s1 == null) return Literal.EINS;
        if (s2 == null) return Literal.MINUS_EINS;
        return s1.compareTo(s2);
    }


    /**
     * Konvertiert einen String in einen Boolean-Wert. Interpretiert "0" als `false` und "1" als `true`.
     * Gibt `null` zurück, wenn der String nicht "0" oder "1" ist.
     *
     * @param value1 Der Eingabestring, der in einen Boolean-Wert konvertiert werden soll.
     * @return Der konvertierte Boolean-Wert (`true`, `false`) oder `null`, wenn der String nicht interpretierbar ist.
     *
     * @Vorbedingung Der String enthaelt "0", "1" oder ist leer/null.
     * @Nachbedingung Gibt `true`, `false` oder `null` zurück, basierend auf dem Eingabestring.
     */
    public static Boolean parsingBoolean(String value1) {
        Boolean value2 = null;
        if (value1 == null || value1.trim().isEmpty()) {
            return null;
        }
        if (value1.equals(Konstanten.ZERO)) {
            return value2 = false;
        } else if (value1.equals(Konstanten.ONE)) {
            return value2 = true;
        } else {
            return value2;
        }
    }

    /**
     * Vergleicht zwei Double-Werte und behandelt `null`-Faelle.
     *
     * @param d1 Erster Double-Wert zum Vergleich.
     * @param d2 Zweiter Double-Wert zum Vergleich.
     * @return Ein Integer-Wert:
     *         <ul>
     *         <li>1, wenn der erste Wert `null` ist.</li>
     *         <li>-1, wenn der zweite Wert `null` ist.</li>
     *         <li>Das Ergebnis von `Double.compareTo`, wenn beide Werte gültig sind.</li>
     *         </ul>
     *
     * @Vorbedingung Keine, aber die Eingabewerte können `null` sein.
     * @Nachbedingung Gibt einen Vergleichswert zurück, der `null`-Werte korrekt behandelt.
     */
    public static int compareDoubles(Double d1, Double d2) {
        if(d1==null && d2==null) return Literal.NULL;
        if (d1 == null) return Literal.EINS;
        if (d2 == null) return Literal.MINUS_EINS;
        return d1.compareTo(d2);
    }

    /**
     * Vergleicht zwei Boolean-Werte und behandelt `null`-Faelle.
     *
     * @param b1 Erster Boolean-Wert zum Vergleich.
     * @param b2 Zweiter Boolean-Wert zum Vergleich.
     * @return Ein Integer-Wert:
     *         <ul>
     *         <li>1, wenn der erste Wert `null` ist.</li>
     *         <li>-1, wenn der zweite Wert `null` ist.</li>
     *         <li>Das Ergebnis von `Boolean.compareTo`, wenn beide Werte gültig sind.</li>
     *         </ul>
     *
     * @Vorbedingung Keine, aber die Eingabewerte können `null` sein.
     * @Nachbedingung Gibt einen Vergleichswert zurück, der `null`-Werte korrekt behandelt.
     */
    public static int compareBoolean(Boolean b1, Boolean b2) {
        if(b1==null && b2==null) return Literal.NULL;
        if (b1 == null) return Literal.EINS;
        if (b2 == null) return Literal.MINUS_EINS;
        return b1.compareTo(b2);
    }

    /**
     * Ersetzt alle Unterstriche ("_") in einem String durch Bindestriche ("-").
     *
     * @param input Der Eingabestring, der verarbeitet werden soll.
     * @return Der String, bei dem alle Unterstriche durch Bindestriche ersetzt wurden.
     *
     * @Vorbedingung Der Eingabestring darf nicht `null` sein.
     * @Nachbedingung Gibt einen neuen String zurück, in dem alle Unterstriche durch Bindestriche ersetzt sind.
     */
    public static String replaceUnderscore(String input) {
        return input.replace(Konstanten.UNDERSCORE, Konstanten.STRICHE);
    }
}
