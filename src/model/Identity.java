package model;

import resources.Konstanten;

/**
 *  Diese Klasse enthaelt die Attribute (id, airportIdent, airportType und name) und Methoden der Identity einer FLughafen.
 */
public class Identity {
    private int id;
    private String airportIdent;
    private AirportType airportType;
    private String name;

    /**
     * Konstruktor, um eine Identity zu erstellen.
     * @Vorbedingung Keine
     * @Nachbedingung Ein Identity wird aus id, airportIdent, airportType und name erstellt.
     * @param id Eindeutige ID des Flughafens
     * @param airportIdent Eindeutiger Identifikationscode des Flughafens nach ICAO-Standards
     * @param airportType Typ des Flughafens FAA-Standards
     * @param name Name des Flughafens
     */
    public Identity(int id, String airportIdent, AirportType airportType, String name) {
        this.id = id;
        this.airportIdent = airportIdent;
        this.airportType = airportType;
        this.name = name;
    }

    /**
     * Gibt die Identity formatiert als String zurueck.
     * @Vorbedingung Identity muss initialisiert sein.
     * @Nachbedingung Identity wird formatiert als String zurueckgegeben.
     * @return Identity formatiert mit allen Attributen als String
     */
    public String toString() {
    return id + Konstanten.KOMMA + airportIdent + Konstanten.KOMMA +airportType+Konstanten.KOMMA+ name;
    }

    /**
     * Getters
     * @return required Attribute zurueckgeben
     */
    public int getId() {
        return id;
    }
    public String getAirportIdent() {
        return airportIdent;
    }
    public AirportType getAirportType() {
        return airportType;
    }
    public String getName() {
        return name;
    }


}
