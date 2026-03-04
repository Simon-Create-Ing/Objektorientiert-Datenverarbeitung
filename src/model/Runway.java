package model;

import resources.Konstanten;

/**
 *  Diese Klasse enthielt die Attribute (runwayDimension, runwaySurface und Beleuchtung) und Methoden eines Runways.
 */
public class Runway {
    private RunwayDimension runwayDimension;
    private RunwaySurface runwaySurface;
    private Beleuchtung beleuchtung = null;

    /**
     * Konstruktor, um ein Runway zu erstellen.
     * @vorbedingung keine
     * @Nachbedingung Ein Runway wird aus runwayDimension, -Surface und Beleuchtung erstellt.
     * @param runwayDimension Objekt enthaelt die Dimension einer Landebahn (Laenge und Breite der Start- und Landebahn)
     * @param runwaySurface Oberflaeche der Start- und Landebahn nach ICAO-Standards
     * @param beleuchtung Ob die Start- und Landebahn beleuchtet ist
     */
    public Runway(RunwayDimension runwayDimension, RunwaySurface runwaySurface, Beleuchtung beleuchtung) {
        this.runwayDimension = runwayDimension;
        this.runwaySurface = runwaySurface;
        this.beleuchtung = beleuchtung;
    }

    /**
     * Gibt die Runway formatiert als String zurueck.
     * @Vorbedingung Runway muss initialisiert sein.
     * @Nachbedingung Runway wird formatiert als String zurueckgegeben.
     * @return Runway formatiert mit allen Attributen als String
     */
    public String toString() {
        return (runwayDimension +Konstanten.KOMMA+ runwaySurface + Konstanten.KOMMA+ beleuchtung);
    }

    public RunwayDimension getRunwayDimension() {
        return runwayDimension;
    }
    public RunwaySurface getRunwaySurface() {
        return runwaySurface;
    }
    public Beleuchtung getBeleuchtung() {
        return beleuchtung;
    }

    public void setRunwayDimension(RunwayDimension runwayDimension) {
        this.runwayDimension = runwayDimension;
    }

    public void setRunwaySurface(RunwaySurface runwaySurface) {
        this.runwaySurface = runwaySurface;
    }

    public void setBeleuchtung(Beleuchtung beleuchtung) {
        this.beleuchtung = beleuchtung;
    }
}
