package src.Model.Data.Graph;

import src.Model.Data.LinkedList.List;

/**
 * Dijkstra Pfadsuche Algorithmus
 * @param <T> Datentyp T des Graphen
 */
public class Dijkstra<T>
{
    private final Graph<T> graph;
    private int startNode;
    private int count;
    private double[][] weights;
    private double[] distances;
    private int[] previous;
    private List<Integer> remaining;

    /**
     * Standartkonstruktor der Klasse
     * @param graph Graph in welchem ein Pfad gesucht wird
     */
    public Dijkstra(Graph<T> graph)
    {
        this.graph = graph;
        this.startNode = -1;
    }

    /**
     * Methode zum Initialisieren des Algorithmus
     * @param startNode Index des Anfangsknotens
     */
    private void initialize(int startNode)
    {
        this.startNode = startNode;
        this.count = graph.getElements().count();
        this.weights = graph.getWeights();
        this.distances = new double[count];
        this.previous = new int[count];
        this.remaining = new List<>();

        for (int i = 0; i < count; i++)
        {
            distances[i] = Double.MAX_VALUE;
            previous[i] = -1;
            remaining.add(i);
        }
        distances[startNode] = 0;
    }

    /**
     * Methode zum Ausgeben des Knotens mit der geringsten
     * Distanz zum Anfangsknoten
     * @return Knoten mit der geringsten Distanz
     */
    private int getMinRemaining()
    {
        double value = Double.MAX_VALUE;
        int minimum = -1;
        for (int node: remaining)
        {
            if (distances[node] < value)
            {
                minimum = node;
                value = distances[node];
            }
        }
        return minimum;
    }

    /**
     * Methode zum Aktualisieren der Entfernung eines Knotens
     * @param node Knoten zu dem die Entfernung aktualisiert werden soll
     * @param prevNode Vorgängerknoten
     */
    private void updateDistance(int node, int prevNode)
    {
        double alternate = distances[prevNode] + weights[prevNode][node];
        if (alternate < distances[node])
        {
            distances[node] = alternate;
            previous[node] = prevNode;
        }
    }

    /**
     * Methode zum Suchen der kürzesten Pfade im Graphen
     * @param startNode Anfangsknoten
     */
    public void findShortestPaths(int startNode)
    {
        initialize(startNode);
        while (remaining.count() > 0)
        {
            int nearestNode = getMinRemaining();
            remaining.remove(nearestNode, Integer::equals);
            for (int neighbourNode = 0; neighbourNode < count; neighbourNode++)
            {
                if (weights[nearestNode][neighbourNode] < Double.MAX_VALUE)
                {
                    if (remaining.contains(neighbourNode, Integer::equals))
                    {
                        updateDistance(neighbourNode, nearestNode);
                    }
                }
            }
        }
    }

    /**
     * Methode zum Ausgeben des kürzesten Pfades im Graphen
     * @param node Zielknoten des Pfades
     * @return Besuchte Knoten des Pfades
     */
    public List<Integer> getShortestPath(int node)
    {
        int currentNode = node;
        List<Integer> path = new List<>();
        path.add(currentNode);
        while (previous[currentNode] >= 0)
        {
            currentNode = previous[currentNode];
            path.insert(0, currentNode);
        }
        return path;
    }

    /**
     * Methode zum Ausgeben der Länge des kürzesten Pfades im Graphem
     * @param node Zielknoten des Pfades
     * @return Länge des Pfades
     */
    public double getPathLength(int node)
    {
        return distances[node];
    }

    /**
     * Methode zum Ausgeben des Anfangsknotens
     * @return Index des Anfangsknotens
     */
    public int getStartNode()
    {
        return startNode;
    }
}
