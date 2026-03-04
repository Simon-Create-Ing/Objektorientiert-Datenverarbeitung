package model;

/**
 * Die Klasse enthaelt alle methoden und Attributen (municipality) um eine Gemeinde Objekt zu erzeugen
 */
public class Gemeinde {
    private String municipality;

    /**
     * Konstruktor um Gemeinde Objekt zu erstellen
     * @Vorbedingung keine
     * @Nachbedingung Gemeinde Objekt wird erstellt
     * @param municipality Gemeinde, in der sich der Flughafen befindet
     */
    public Gemeinde(String municipality){
        this.municipality = municipality;
    }
    @Override
    public String toString() {
        return municipality;
    }
    public String getMunicipality() {
        return municipality;
    }
}

