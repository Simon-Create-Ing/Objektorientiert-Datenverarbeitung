package view;

import model.Airport;
import resources.AirportAttributen;
import resources.Konstanten;
import resources.Literal;

import java.util.ArrayList;

/**
 * Enthaelt alle Methoden um etwas auszudrücken
 */
public class Ausgeben {

     /**
      * Methode fuer die "standard" Ausgabe.
      * @Vorbedingung String nuss schon gegeben werden
      * @Nachbedingung uebergebener String wird ausgegeben
      * @param ausgabe von beliebiger type welcher ausgegeben werden soll.
      */
    public static <E> void ausgeben(E ausgabe) {
        System.out.println(ausgabe);
    }

    /**
     * Gibt die sortierten Flughafendaten aus.
     * @param liste Sortierte Liste von Flughaefen.
     * @Vorbedingung Die Liste ist nicht null und enthaelt Flughafendaten.
     * @Nachbedingung Gibt die ersten 25 Flughaefen in formatiertem Text aus.
     */
    public static void printSortierungErgebnisse(ArrayList<Airport> liste) {
        Ausgeben.ausgeben(Konstanten.ERSTE_10_FLUGHaeFEN_NACH_SORTIERUNG);
        System.out.printf(Konstanten.AUFTEILUNG_TITEL,
                AirportAttributen.AIRPORT_ID,
                AirportAttributen.AIRPORT_NAME,
                AirportAttributen.AIRPORT_TYPE,
                AirportAttributen.CONTINENT,
                AirportAttributen.ISO_COUNTRY,
                AirportAttributen.ISO_REGION,
                AirportAttributen.MUNICIPALITY,
                AirportAttributen.RUNWAY_LENGHT,
                AirportAttributen.RUNWAY_WIDTH,
                AirportAttributen.BELEUCHTUNG
        );
        System.out.println(Konstanten.LINE);

        for (int i = Literal.NULL; i < Math.min(liste.size(), Literal.ZEHN); i++) {
            Airport airport = liste.get(i);
            System.out.printf(Konstanten.AUFTEILUNG,
                    airport.getIdentity().getId(),
                    airport.getIdentity().getName(),
                    airport.getIdentity().getAirportType(),
                    airport.getGeoLocation().getContinent(),
                    airport.getGeoLocation().getIsoCountry(),
                    airport.getGeoLocation().getIsoRegion(),
                    airport.getGeoLocation().getGemeinde(),
                    airport.getRunway().getRunwayDimension().getRunwayLength(),
                    airport.getRunway().getRunwayDimension().getRunwayWidth(),
                    airport.getRunway().getBeleuchtung()

            );
        }
    }
}
