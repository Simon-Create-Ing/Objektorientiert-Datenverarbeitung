package model;

import resources.Konstanten;

/**
 *  Diese Klasse enthielt die Attribute (latitude, longitude und elevation) und Methoden einer Koordinate.
 */
public class Koordinaten {

    private Double latitude;
    private Double longitude;
    private Double elevation;

    /**
     * Konstruktor, um eine Koordinate zu erstellen.
     * @Vorbedingung Keine
     * @Nachbedingung Eine Koordinate wird aus latitude, longitude und elevation erstellt.
     * @param latitude Breitengrad des Flughafens
     * @param longitude Laengengrad des Flughafens
     * @param elevation Hoehe des Flughafens ueber dem Meeresspiegel
     */
    public Koordinaten(Double latitude, Double longitude, Double elevation) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    /**
     * Gibt die Koordinaten formatiert als String zurueck.
     * @Vorbedingung Koordinaten muss initialisiert sein.
     * @Nachbedingung Koordinaten wird formatiert als String zurueckgegeben.
     * @return Koordinates formatiert mit allen Attributen als String
     */
    public String toString() {
        String longD = (longitude!=null)?longitude.toString():Konstanten.UNKNOWN;
        String latD = (latitude!=null)?latitude.toString():Konstanten.UNKNOWN;
        String eleV = (elevation!=null)?elevation.toString():Konstanten.UNKNOWN;
        return latD+Konstanten.KOMMA+longD+Konstanten.KOMMA+eleV;
    }

    //Getters und Setters
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public Double getElevation() {
        return elevation;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }
}

