package control;

import model.Airport;
import resources.AirportAttributen;
import resources.Graph;
import resources.Konstanten;
import resources.Literal;
import utilities.Haversine;
import utilities.ZeitMessung;
import view.Ausgeben;

import java.util.*;

/**
 * Diese Klasse enthaelt Methoden zur Erstellung eines Graphen von Flughaefen und zur Bestimmung von Pfaden zwischen ihnen.
 * Sie unterstuetzt die Verwaltung eines ungerichteten Graphen und bietet Funktionalitaeten wie das Hinzufuegen von Knoten,
 * das Verbinden von Knoten und das ueberpruefen von Pfaden.
 */
public class AirportGraph implements Graph<Airport> {

    // Adjazenzliste, die den ungerichteten Graphen repraesentiert
    private final static Map<Airport, ArrayList<Airport>> adjazenzListe = new HashMap<>();

    /**
     * Erstellt einen Graphen aus einer Liste von Flughaefen.
     *
     * @Vorbedingung Die Liste der Flughaefen darf nicht null sein.
     * @Nachbedingung Ein Graph mit den Flughaefen und ihren Verbindungen wird erstellt.
     * @param myAirports Liste der Flughaefen zur Erstellung des Graphen.
     * @return Der erstellte Graph.
     */
    public static AirportGraph erstelleGraph(ArrayList<Airport> myAirports) {
        ZeitMessung stoppUhr = new ZeitMessung();
        stoppUhr.start();

        AirportGraph airportGraph = new AirportGraph();

        // Knoten hinzufuegen
        for (Airport airport : myAirports) {
            airportGraph.addVertex(airport);
        }

        // Kanten hinzufuegen
        for (Airport airport1 : myAirports) {
            if (airport1 != null) {
                for (Airport airport2 : myAirports) {
                    if (airport2 != null && airport1 != airport2) {
                        double distance = Haversine.calculateDistance(
                                airport1.getKoordinates().getLatitude(), airport1.getKoordinates().getLongitude(),
                                airport2.getKoordinates().getLatitude(), airport2.getKoordinates().getLongitude());

                        if (distance <= Literal.MAX_DISTANCE_KM) {
                            airportGraph.addEdge(airport1, airport2);
                        }
                    }
                }
            }
        }

        Ausgeben.ausgeben(Konstanten.GRAPH_WIRD_KONSTRUIERT + Konstanten.BEARBEITUNGSDAUER_DER_GRAPH_ERSTELLUNG
                + stoppUhr.berechneVergangeneZeitInMillisekunden() + Konstanten.MILLISEKUNDEN);

        return airportGraph;
    }

    /**
     * Fuegt einen neuen Knoten (Flughafen) zum Graphen hinzu.
     *
     * @Vorbedingung Der Flughafen darf nicht null sein.
     * @Nachbedingung Der Flughafen wird dem Graphen hinzugefuegt.
     * @param vertex Der hinzuzufuegende Flughafen.
     */
    public void addVertex(Airport vertex) {
        adjazenzListe.put(vertex, new ArrayList<>());
    }

    /**
     * Fuegt eine ungerichtete Kante zwischen zwei Knoten (Flughaefen) hinzu.
     *
     * @Vorbedingung Beide Flughaefen duerfen nicht null sein.
     * @Nachbedingung Eine Kante zwischen den beiden Flughaefen wird hinzugefuegt.
     * @param vertex1 Erster Flughafen.
     * @param vertex2 Zweiter Flughafen.
     */
    public void addEdge(Airport vertex1, Airport vertex2) {
        if (!adjazenzListe.containsKey(vertex1)) {
            addVertex(vertex1);
        }
        if (!adjazenzListe.containsKey(vertex2)) {
            addVertex(vertex2);
        }

        adjazenzListe.get(vertex1).add(vertex2);
        adjazenzListe.get(vertex2).add(vertex1);
    }

    /**
     * Gibt die Menge aller Knoten im Graphen zurueck.
     *
     * @Vorbedingung Der Graph muss initialisiert sein.
     * @Nachbedingung Eine Menge aller Knoten wird zurueckgegeben.
     * @return Menge aller Knoten.
     */
    public Set<Airport> getVertices() {
        return adjazenzListe.keySet();
    }

    /**
     * Gibt eine Menge aller Kanten im Graphen zurueck.
     *
     * @Vorbedingung Der Graph muss initialisiert sein.
     * @Nachbedingung Eine Menge aller Kanten wird zurueckgegeben.
     * @return Menge aller Kanten.
     */
    public Set<Airport> getEdges() {
        Set<Airport> edges = new HashSet<>();
        for (Airport vertex : adjazenzListe.keySet()) {
            edges.addAll(adjazenzListe.get(vertex));
        }
        return edges;
    }

    /**
     * Gibt eine Liste aller Nachbarn eines Knotens zurueck.
     *
     * @Vorbedingung Der Knoten muss Teil des Graphen sein.
     * @Nachbedingung Eine Liste aller Nachbarn wird zurueckgegeben.
     * @param vertex Der Knoten, dessen Nachbarn ermittelt werden sollen.
     * @return Liste der Nachbarn.
     */
    public HashSet<Airport> getNeighbors(Airport vertex) {
        return new HashSet<>(adjazenzListe.get(vertex));
    }

    /**
     * Gibt eine Textdarstellung des Graphen aus.
     *
     * @Vorbedingung Der Graph muss initialisiert sein.
     * @Nachbedingung Eine uebersicht des Graphen wird ausgegeben.
     */
    public void printGraph() {
        System.out.println(Konstanten.GRAPH_ZUSAMMENFASSUNG);
        System.out.println(Konstanten.ANZAHL_DER_AIRPORTS_IM_GRAPH + adjazenzListe.size());
        Ausgeben.ausgeben(Konstanten.ANFANG_GRAPH);

        List<Map.Entry<Airport, ArrayList<Airport>>> entries = new ArrayList<>(adjazenzListe.entrySet());
        for(int j=0; j<Math.min(adjazenzListe.size(), Literal.FUENF) ; j++){
            Map.Entry<Airport, ArrayList<Airport>> entry = entries.get(j);
            // Zugriff auf key (Airport) haben und value (ArrayList<Airport>)
            Airport airport = entry.getKey();
            ArrayList<Airport> connections = entry.getValue();

            // Print node and its connections
            Ausgeben.ausgeben(Konstanten.FLUGHAFEN + airport.getIdentity().getName() +Konstanten.PFEILE);
            if (!connections.isEmpty()) {
                for (int i=0; i< Math.min(connections.size(), Literal.ZEHN); i++) {
                    System.out.print(connections.get(i).getIdentity().getAirportIdent() + Konstanten.KOMMA);
                }
                Ausgeben.ausgeben(Konstanten.ANZAHL_DER_VERBINDUNGEN + connections.size());
            } else {
                Ausgeben.ausgeben(Konstanten.KEINE_VERBINDUNGEN);
            }
        }
    }

    /**
     * Findet den kuerzesten Pfad zwischen zwei Flughaefen im Graphen.
     *
     * @Vorbedingung Beide Flughaefen muessen Teil des Graphen sein.
     * @Nachbedingung Gibt die Liste der Flughaefen zurueck, die den kuerzesten Pfad bilden.
     * @param start Der Startflughafen.
     * @param destination Der Zielflughafen.
     * @return Liste der Flughaefen, die den Pfad bilden, oder {@code null}, wenn kein Pfad gefunden wurde.
     */
    public static List<Airport> findPath(Airport start, Airport destination) {
        ZeitMessung timer = new ZeitMessung();
        timer.start();

        Map<Airport, Airport> previous = new HashMap<>(); // Zur Rekonstruktion des Pfades
        Queue<Airport> queue = new LinkedList<>();
        Set<Airport> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Airport current = queue.poll();

            if (current.equals(destination)) {
                // Pfad gefunden, Rekonstruktion
                List<Airport> path = new ArrayList<>();
                for (Airport at = destination; at != null; at = previous.get(at)) {
                    path.add(at);
                }
                Collections.reverse(path);

                // Pfad ausgeben
                System.out.println(Konstanten.FOUND_PATH_FROM + start.getIdentity().getName() + Konstanten.TO + destination.getIdentity().getName() + ":");
                for (Airport airport : path) {
                    System.out.println(Konstanten.ARROW + airport.getIdentity().getName());
                }

                System.out.println(Konstanten.EXECUTION_TIME + timer.berechneVergangeneZeitInMillisekunden() + Konstanten.MILLISEKUNDEN);
                return path;
            }

            for (Airport neighbor : adjazenzListe.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }

        // Kein Pfad gefunden
        System.out.println(Konstanten.NO_PATH_FOUND_FROM + start.getIdentity().getName() + Konstanten.TO + destination.getIdentity().getName() + ".");
        System.out.println(Konstanten.EXECUTION_TIME + timer.berechneVergangeneZeitInMillisekunden() + Konstanten.MILLISEKUNDEN);
        return null;
    }

    /**
     * ueberprueft, ob ein Pfad zwischen der Start- und Ziel-Airport im gegebenen AirportGraph existiert.
     *
     * @Vorbedingung Beide Flughaefen muessen Teil des Graphen sein.
     * @Nachbedingung Gibt einen booleschen Wert zurueck, der angibt, ob ein Pfad existiert.
     * @param startAirport Der Startflughafen.
     * @param zielAirport Der Zielflughafen.
     * @param airportGraph Der Graph, in dem der Pfad ueberprueft werden soll.
     * @return {@code true}, wenn ein Pfad existiert; sonst {@code false}.
     */
    public static boolean ueberpruefeObPfadInGraphExistiert(Airport startAirport, Airport zielAirport, AirportGraph airportGraph) {

        if (airportGraph.getVertices().contains(startAirport) && airportGraph.getVertices().contains(zielAirport)) {
            // Ziel-Airport kann vom Start-Airport aus erreicht werden
            Ausgeben.ausgeben(Konstanten.NEXT_LINE +
                    AirportAttributen.MUNICIPALITY +
                    zielAirport.getGeoLocation().getGemeinde() +
                    Konstanten.IST_VON +
                    startAirport.getGeoLocation().getGemeinde() +
                    Konstanten.ERREICHBAR);
            return true;
        } else {
            // Ziel-Airport kann vom Start-Airport aus NICHT erreicht werden
            Ausgeben.ausgeben(Konstanten.NEXT_LINE +
                    AirportAttributen.MUNICIPALITY +
                    zielAirport.getGeoLocation().getGemeinde() +
                    Konstanten.IST_VON +
                    startAirport.getGeoLocation().getGemeinde() +
                    Konstanten.NICHT_ERREICHBAR);
            return false;
        }
    }
}

