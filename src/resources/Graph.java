package resources;

import java.time.Clock;
import java.util.HashSet;
import java.util.Set;

 /**
 * Dieses Interface enthaelt die wichtigsten Methoden fuer die Implementierung eines Graphen.
 * @param <E> Datentyp der Knoten des Graphen
 */
public interface Graph<E> {
    void addVertex(E vertex);
    void addEdge(E vertex1, E vertex2);
    Set<E> getVertices ();
    Set<E> getEdges ();
    HashSet<E> getNeighbors(E vertex1);

}

