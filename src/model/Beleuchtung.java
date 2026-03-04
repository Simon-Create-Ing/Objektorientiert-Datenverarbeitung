package model;


import resources.Konstanten;

/**
 * Diese Klasse enthielt die Attribute (beleuchtet) und Methoden einer Beleuchtung.
 */

public class Beleuchtung {
    private Boolean beleuchtet;
    /**
     * Konstruktor, um eine Beleuchtung Objekt zu erstellen.
     * @Vorbedingung Keine
     * @Nachbedingung Eine Beleuchtung wird aus beleuchtet erstellt.
     * @param beleuchtet
     */
    public Beleuchtung(Boolean beleuchtet) {
        this.beleuchtet = beleuchtet;
    }
    /**
     * Gibt "ist beleuchtet" zurueck, wenn true, "ist nicht beleuchtet" wenn false und "unknown" wenn null.
     * @Vorbedingung Keine
     * @Nachbedingung Keine
     * @return String Darstellung des Beleuchtungsstatus
     */
    public String toString() {
        if (beleuchtet == null) {
            return Konstanten.UNKNOWN;
        } else if (!beleuchtet) {
            return Konstanten.IST_NICHT_BELEUCHTET;
        }else{
            return Konstanten.IST_BELEUCHTET;
        }
    }

    //Getter
    public Boolean istBeleuchtet() {
        return beleuchtet;
    }
}
