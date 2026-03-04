package model;

import resources.Konstanten;

/**
 * Diese Klasse ist eine enum Klasse enthielt alle enum Objekte und Methoden eines AirportTypes.
 */
public enum AirportType {
    SMALL_AIRPORT,
    SEAPLANE_BASE,
    CLOSED,
    LARGE_AIRPORT,
    MEDIUM_AIRPORT,
    HELIPORT,
    BALLOONPORT;


    /**
     * Findet die entsprechende AirportType vom enum List fuer die vorgegebene String
     * @Vorbedingung ein String muss schon gegeben werden
     * @Nachbedingung AirportType vom enum List wird zurueckgegeben
     * @param value String vom gelesene Daten
     * @return AirportType vom enum List
     */
    public static AirportType AirportTypeFromString(String value) {
        for (AirportType airportType : AirportType.values()) {
            if (airportType.toString().equalsIgnoreCase(value)) {
                return airportType;
            }
        }
        //falls String mit keinem Objekt vom enum List passt
        throw new IllegalArgumentException(Konstanten.INVALID_AIRPORT_TYPE + value);
    }

    /**
     * Gibt der AirportType vom enum List formatiert als String zurueck.
     * @Vorbedingung AirportType vom enum List muss initialisiert sein.
     * @Nachbedingung AirportType vom enum List wird formatiert als String zurueckgegeben.
     * @return AirportType vom enum List formatiert als String
     */
    public String toString() {
        return name();
    }
}
