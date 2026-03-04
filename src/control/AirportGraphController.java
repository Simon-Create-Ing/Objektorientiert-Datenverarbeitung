package control;

import model.Airport;
import resources.Literal;

import java.util.*;


public class AirportGraphController {

    /**
     * Diese Methode enthaelt alle die Aufrufe auf die notwendige Methode,
     * um einen Graphen zu erstellen und einen Pfad zwischen zwei gegebene Knoten zu finden
     * @param airportListe Liste aller eingelesene Flughaefen
     */
    public static void graphInDeutschland(ArrayList<Airport> airportListe){

        ArrayList<Airport> flughaefenInDeutschland = new ArrayList<>(Suche.filterGermanAirports(airportListe));
        // Print the graph
        AirportGraph graph = (AirportGraph.erstelleGraph(flughaefenInDeutschland));
        graph.printGraph();

        // Use the graph to find the path from Hamburg to Munich
        Airport hamburg = Suche.findAirportById(flughaefenInDeutschland, Literal.HAMBURG_AIRPORT_ID);
        Airport munich = Suche.findAirportById(flughaefenInDeutschland, Literal.MUENCHEN_AIRPORT_ID);

        if(AirportGraph.ueberpruefeObPfadInGraphExistiert(hamburg, munich,graph)) {
            List<Airport> list = AirportGraph.findPath(hamburg, munich);
        }
    }
}
