package model;


/**
 *  Diese Klasse ist eine enum Klasse enthielt alle enum Objekte nach ICAO-Standards und Methoden eines Continent.
 */
public enum Continent {
    AF,
    AN,
    AS,
    EU,
    NA,
    OC,
    SA;

    /**
     * Gibt der Continent vom enum List formatiert als String zurueck.
     * @Vorbedingung Continent vom enum List muss initialisiert sein.
     * @Nachbedingung Continent vom enum List wird formatiert als String zurueckgegeben.
     * @return Continent vom enum List formatiert als String
     */
    public String toString() {
        return name();
    }
}
