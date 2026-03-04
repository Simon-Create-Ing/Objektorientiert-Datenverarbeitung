package model;

import resources.Konstanten;

/**
 * Diese Klasse enthielt die Attribute (identification, location, koordinaten und runway) und Methoden eines Airports.
 */
public class Airport {
    private Identity identification ;
    private GeoLocation location;
    private Koordinaten koordinaten;
    private Runway runway;

    /**
     * Konstruktor, um einen Airport zu erstellen.
     * @Vorbedingung Keine
     * @Nachbedingung Ein Airport wird aus identification, location, koordinaten und runway erstellt.
     * @param identification Enthaelt die Attribute von einem Flughafen, die identifiziert
     * @param location Objekt repraesentiert die grafische Lage der flughafen
     * @param koordinaten Objekt beschreibt die Laengen- und Breitengrade eines Flughafens sowie die Flughoehe
     * @param runway Objekt beschreibt die Attribute der Landebahn eines Flughafens
     */
    public Airport(Identity identification, Koordinaten koordinaten, GeoLocation location, Runway runway) {
        this.identification= identification;
        this.location = location;
        this.koordinaten = koordinaten;
        this.runway = runway;
    }

    /**
     * Gibt der Airport formatiert als String zurueck.
     * @Vorbedingung Airport muss initialisiert sein.
     * @Nachbedingung Airport wird formatiert als String zurueckgegeben.
     * @return Airport formatiert mit allen Attributen als String
     */
    public String toString() {
        return  identification + Konstanten.KOMMA +location+ Konstanten.KOMMA + koordinaten + Konstanten.KOMMA + runway ;
    }

    public Identity getIdentity() {
        return identification;
    }

    public GeoLocation getGeoLocation() {
        return location;
    }

    public Koordinaten getKoordinates() {
        return koordinaten;
    }

    public Runway getRunway() {
        return runway;
    }
}
