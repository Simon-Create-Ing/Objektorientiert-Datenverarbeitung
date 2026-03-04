package model;

import resources.Konstanten;

/**
 *  Diese Klasse enthaelt die Attribute (continent, isoCountry, isoRegion und municipality) und Methoden einer GeoLocation.
 */

public class GeoLocation {
    private Continent continent;
    private IsoCountry isoCountry;
    private IsoRegion isoRegion;
    private Gemeinde municipality;

    /**
     * Konstruktor, um eine GeoLocation Objekt zu erstellen.
     * @Vorbedingung Keine
     * @Nachbedingung Eine GeoLocation wird aus continent, isoCountry, isoRegion und municipality erstellt.
     * @param continent Kontinent, auf dem sich der Flughafen befindet (NA fuer Nordamerika) nach ICAO-Standards
     * @param isoCountry ISO-Laendercode nach ISO 3166-1 Standard (zweistellige Laenderabkuerzung)
     * @param isoRegion ISO-Regioncode nach ISO 3166-2 Standard (regionale Kennzeichnung innerhalb des Landes)
     * @param municipality Gemeinde, in der sich der Flughafen befindet
     */
    public GeoLocation(Continent continent, IsoCountry isoCountry, IsoRegion isoRegion, Gemeinde municipality) {
        this.continent = continent;
        this.isoCountry = isoCountry;
        this.isoRegion = isoRegion;
        this.municipality = municipality;
    }

     /**
      * Gibt die GeoLocation formatiert als String zurueck.
      * @Vorbedingung GeoLocation muss initialisiert sein.
      * @Nachbedingung GeoLocation wird formatiert als String zurueckgegeben.
      * @return GeoLocation formatiert mit allen Attributen als String

      */
    public String toString() {
        return continent+Konstanten.KOMMA+isoCountry+Konstanten.KOMMA+isoRegion+ Konstanten.KOMMA +municipality;
    }

    public Continent getContinent() {
        return continent;
    }

    public IsoCountry getIsoCountry() {
        return isoCountry;
    }

    public IsoRegion getIsoRegion() {
        return isoRegion;
    }

    public Gemeinde getGemeinde() {
        return municipality;
    }
}
