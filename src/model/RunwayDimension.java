package model;

import resources.Konstanten;

/**
 * Diese Klasse repraesentiert die Dimensionen einer Landebahn (Runway).
 * Sie enthaelt die Laenge und Breite der Landebahn sowie Methoden zum Abrufen und Bearbeiten dieser Werte.
 */
public class RunwayDimension {
    private Double runwayLength;
    private Double runwayWidth;

    /**
     * Konstruktor zur Initialisierung der Dimensionen einer Landebahn.
     *
     * @param runwayLength Laenge der Landebahn in Metern.
     * @param runwayWidth Breite der Landebahn in Metern.
     *
     * @Vorbedingung runwayLength und runwayWidth sind nicht null.
     * @Nachbedingung Ein RunwayDimension-Objekt wird mit den angegebenen Werten initialisiert.
     */
    public RunwayDimension(Double runwayLength, Double runwayWidth) {
        this.runwayLength = runwayLength;
        this.runwayWidth = runwayWidth;
    }

    /**
     * Gibt die Laenge der Landebahn zurueck.
     *
     * @return Laenge der Landebahn in Metern.
     *
     * @Vorbedingung Keine.
     * @Nachbedingung Gibt den Wert von "runwayLength" zurueck.
     */
    public Double getRunwayLength() {
        return runwayLength;
    }

    /**
     * Gibt die Breite der Landebahn zurueck.
     *
     * @return Breite der Landebahn in Metern.
     *
     * @Vorbedingung Keine.
     * @Nachbedingung Gibt den Wert von "runwayWidth" zurueck.
     */
    public Double getRunwayWidth() {
        return runwayWidth;
    }

    /**
     * Setzt die Laenge der Landebahn.
     *
     * @param runwayLength Neue Laenge der Landebahn in Metern.
     *
     * @Vorbedingung runwayLength ist nicht null.
     * @Nachbedingung Der Wert von "runwayLength" wird auf den angegebenen Wert aktualisiert.
     */
    public void setRunwayLength(Double runwayLength) {
        this.runwayLength = runwayLength;
    }

    /**
     * Setzt die Breite der Landebahn.
     *
     * @param runwayWidth Neue Breite der Landebahn in Metern.
     *
     * @Vorbedingung runwayWidth ist nicht null.
     * @Nachbedingung Der Wert von "runwayWidth" wird auf den angegebenen Wert aktualisiert.
     */
    public void setRunwayWidth(Double runwayWidth) {
        this.runwayWidth = runwayWidth;
    }

    /**
     * Gibt die Dimensionen der Landebahn als String zurueck.
     * @return String-Repraesentation der Landebahndimensionen im Format "Laenge, Breite".
     * @Vorbedingung Keine.
     * @Nachbedingung Gibt einen String zurueck, der die Laenge und Breite der Landebahn enthaelt.
     */
    @Override
    public String toString() {
        String length = (runwayLength != null) ? runwayLength.toString() : Konstanten.UNKNOWN;
        String width = (runwayWidth != null) ? runwayWidth.toString() : Konstanten.UNKNOWN;
        return (length+Konstanten.KOMMA+width);
    }


}