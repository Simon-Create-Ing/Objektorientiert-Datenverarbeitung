package control;

import resources.Konstanten;

/**
 * Diese Klasse enthaelt die Main-Methode, welche alle Methodenaufrufe enthaelt, um das Programm zu starten.
 */
public class Main
{
    /**
     * Die Main-Methode enthaelt alle Methodenaufrufe, um das Programm zu starten.
     * @vorbedingung filePath mus eingegeben werden
     * @nachbedingung keine
     * @param args Argumente fuer die Befehlszeilen
     */

    public static void main(String[] args)
    {
        AirportGraphController.graphInDeutschland(Suche.allesSuchen(
                ArrayListSortieren.sortiereNachKombiniertenKriterien(DateiLeser.leseDaten(Konstanten.FILE_PATH))));
    }
}








































