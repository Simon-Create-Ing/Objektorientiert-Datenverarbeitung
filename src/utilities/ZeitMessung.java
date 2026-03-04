package utilities;

import resources.Literal;

/**
 * Diese Klasse enthaelt alle Methoden zur Messung der Bearbeitungszeit von Code
 */
public class ZeitMessung {
        private long startZeit = System.nanoTime();

    /**
     * Diese Methode setz die StartZeit fuer die Berechnungsdauer
     * @Vorbedingung Keine
     * @Nachbedingung StartZeit wird gesetz.
     */
    public void start ()
    {
        this.startZeit = System.nanoTime();
    }

    /**
     * Diese Methode gibt die vergangene Zeit seitdem die Start-Methode aufgerufen wurde
     * (in Millisekunden) zurück.
     * @Vorbedingung Die Start-Methode der Instanz wurde bereits aufgerufen.
     * @Nachbedingung Die vergangene Zeit seitdem das letzte Mal die Start-Methode aufgerufen wurde,
     * wird in Millisekunden zurückgegeben.
     * @return Vergangene Zeit seitdem das letzte Mal die Start-Methode aufgerufen wurde (in Millisekunden)
     */
    public long berechneVergangeneZeitInMillisekunden ()
    {
        return (System.nanoTime() - this.startZeit) / Literal.NANO_TO_MILLI;
    }

}
