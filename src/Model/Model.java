package src.Model;

import src.Model.Data.CoordSystem.Grid;
import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.Graph.Dijkstra;
import src.Model.Data.Graph.Graph;
import src.Model.Data.LinkedList.List;
import src.Model.Data.LinkedList.SortedList;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityOrder;
import src.Model.Data.Value.Pair;
import src.Model.Observer.Observable;
import src.Model.Sample.DataProvider;

import java.util.Random;

/**
 * Hauptklasse des Models.
 * Zuständig für die Verwaltung der Daten
 */
public class Model extends Observable
{
    private static final int interconnectedness = 3;
    private static final double distanceVariance = 0.25;
    private static final int worldBound = 200; // Wird in jede richtung vom Ursprung gezählt
    private static final double minGenDistance = 20;

    private final Random rnd;
    private final Graph<Locality> graph;
    private final Dijkstra<Locality> dijkstra;
    private List<Integer> lastPath;
    private boolean filterByDistance;
    private Vector2 filterPosition;
    private double filterDistance;

    /**
     * Standardkonstruktor des Models
     */
    public Model()
    {
        rnd = new Random();
        graph = new Graph<>();
        dijkstra = new Dijkstra<>(graph);
        lastPath = new List<>();
        filterByDistance = false;
        filterPosition = Vector2.zero;
        filterDistance = 0;

        initializeData();
    }

    /**
     * Methode zum Ausgeben der gespeicherten Elemente
     * @return Liste an Lokalitäten
     */
    public List<Locality> getElements()
    {
        return graph.getElements();
    }

    /**
     * Methode zum Ausgeben der Elemente, möglicherweise
     * eingeschränkt durch die Suchbegrenzung über die Entfernung
     * @return Liste an Lokalitäten
     */
    public List<Locality> getElementsFiltered()
    {
        if (!filterByDistance)
            return graph.getElements();
        else
            return getElementsByDistance(filterPosition, filterDistance);
    }

    /**
     * Methode zum Ausgeben der Anzahl an Elementen
     * @return Anzahl der Elemente
     */
    public int getElementCount()
    {
        return graph.getElements().count();
    }

    /**
     * Methode zum Ausgeben, ob die Elemente durch Entfernung gefiltert werden
     * @return Boolean Wert, ob die Elemente gefiltert werden
     */
    public boolean isFilterByDistance()
    {
        return filterByDistance;
    }

    /**
     * Methode zum Ausgeben der Position, von welcher der
     * Entfernungsfilter Ausgeht
     * @return Position als Vektor2
     */
    public Vector2 getFilterPosition()
    {
        return filterPosition;
    }

    /**
     * Methode zum Ausgeben der Filterentfernung
     * @return Entfernung als Double
     */
    public double getFilterDistance()
    {
        return filterDistance;
    }

    /**
     * Methode zum Ausgeben der Elemente mit einer bestimmten sortierung
     * @param order Integer Wert, welcher die Sortierung festlegt
     * @return Liste an Lokalitäten
     */
    public List<Locality> getElements(int order)
    {
        // 1: Sortierung nach der Nummerierung
        // 2: Sortierung nach dem Namen
        // 3: Sortierung nach dem Typen
        List<Locality> elements = switch (Math.abs(order))
        {
            case 2 -> new SortedList<>(getElements(), LocalityOrder::ByName);
            case 3 -> new SortedList<>(getElements(), LocalityOrder::ByType);
            default -> getElements();
        };

        // Negativer Wert: Umgekehrte Sortierung
        if (order < 0)
            return elements.reversed();
        else
            return elements;
    }

    /**
     * Methode zum Ausgeben der Elemente, gefiltert nach der Entfernung
     * @param position Position, von der die Entfernung Ausgeht
     * @param distance Maximale Distanz zu der festgelegten Position
     * @return Liste an Lokalitäten
     */
    public List<Locality> getElementsByDistance(Vector2 position, double distance)
    {
        List<Locality> elements = getElements();
        return elements.filter((Locality l) -> l.getPosition().distance(position) <= distance);
    }

    /**
     * Methode zum Hinzufügen eines Elementes
     * @param locality Hinzuzufügende Lokalität
     */
    public void addElement(Locality locality)
    {
        graph.add(locality);
        recalculateEdges(locality);
        notifyObservers();
    }

    /**
     * Methode zum Entfernen einer Lokalität
     * @param locality Zu entfernende Lokalität
     */
    public void removeElement(Locality locality)
    {
        graph.remove(locality, Object::equals);
        notifyObservers();
    }

    /**
     * Methode zum Überschreiben einer Lokalität
     * @param index Index einer Lokalität
     * @param locality Neue Lokalität
     */
    public void setElement(int index, Locality locality)
    {
        graph.set(index, locality);
        notifyObservers();
    }

    /**
     * Methode zum Ausgeben der Kanten im Graphen
     * @return Kanten im Graphen in einer Liste
     */
    public List<Pair<Integer, Integer>> getEdges()
    {
        double[][] matrix = graph.getWeights();
        List<Pair<Integer, Integer>> edges = new List<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = i; j < matrix.length; j++)
                if (matrix[i][j] < Double.MAX_VALUE)
                    edges.add(new Pair<>(i, j));

        return edges;
    }

    /**
     * Methode zum Ausgeben eines Kantenwertes im Graphen
     * @param l1 Erste Lokalität
     * @param l2 Zweite Lokalität
     * @return Kantenwert als Double
     */
    public double getEdge(Locality l1, Locality l2)
    {
        return graph.getEdge(l1, l2, Object::equals);
    }

    /**
     * Methode zum Generieren der Kanten einer Lokalität
     * @param locality Eine gegebene Lokalität
     * @return Liste an Kanten
     */
    private List<Pair<Locality, Double>> generateEdges(Locality locality)
    {
        Locality[] localities = graph.getElements().toArray(Locality.class);
        List<Vector2> points = new List<>();

        int nextNodeCount = Math.min(interconnectedness, localities.length);

        for (Locality l: localities)
            points.add(l.getPosition());

        int[] nearest = Grid.getNNearest(locality.getPosition(), points, nextNodeCount);
        double distance;
        List<Pair<Locality, Double>> edges = new List<>();

        for (int i: nearest)
        {
            distance = locality.getPosition().distance(localities[i].getPosition());
            distance += distance * distanceVariance * Math.abs(rnd.nextGaussian());
            edges.add(new Pair<>(localities[i], distance));
        }

        return edges;
    }

    /**
     * Methode zum Bestimmen des kürzesten Weges zwischen zwei Lokalitäten
     * @param loc1 Erste Lokalität
     * @param loc2 Zweite Lokalität
     * @return Weg zwischen den Lokalitäten als Liste von Indices
     */
    public List<Integer> getPath(Locality loc1, Locality loc2)
    {
        int index = graph.indexOf(loc1, Object::equals);
        if (dijkstra.getStartNode() != index || dijkstra.getPathLength(index) > 0)
            dijkstra.findShortestPaths(index);
        lastPath = dijkstra.getShortestPath(graph.indexOf(loc2, Object::equals));
        notifyObservers();
        return lastPath;
    }

    /**
     * Methode zum Ausgeben des zuletzt bestimmten kürzesten Weges
     * @return Weg zwischen den Lokalitäten als Liste von Indices
     */
    public List<Integer> getLastPath()
    {
        return lastPath;
    }

    /**
     * Methode zum Zurücksetzen des zuletzt bestimmten kürzesten Weges
     */
    public void clearLastPath()
    {
        lastPath = new List<>();
        notifyObservers();
    }

    /**
     * Methode zum neuberechnen der Kanten einer Lokalität im Graph
     * @param locality Eine gegebene Lokalität
     */
    private void recalculateEdges(Locality locality)
    {
        List<Pair<Locality, Double>> edges = generateEdges(locality);
        graph.clearEdges(locality, Object::equals);
        graph.setEdges(locality, edges, Object::equals);
    }

    /**
     * Methode zum Generieren einer neuen Postion einer Lokalität,
     * unter berücksichtigung des Mindestabstandes und der Weltgröße
     * @return Mögliche Position der Lokalität als Vektor2
     */
    public Vector2 generatePosition()
    {
        Vector2 position = null;
        while (position == null || getElementsByDistance(position, minGenDistance).count() > 0)
            position = new Vector2(
                    rnd.nextInt(-worldBound, worldBound),
                    rnd.nextInt(-worldBound, worldBound)
            );
        return position;
    }

    /**
     * Methode zum Ausgeben der festgelegten Weltgröße
     * @return Weltgröße als Integer Wert
     */
    public int getWorldBound()
    {
        return worldBound;
    }

    /**
     * Methode zum Festlegen des Distanzfilters für die beschränkte Ausgabe
     * @param newFilterPosition Neue Filterposition
     * @param newFilterDistance Neue Filterdistanz
     */
    public void setFilterByDistance(Vector2 newFilterPosition, double newFilterDistance)
    {
        filterByDistance = true;
        filterPosition = newFilterPosition;
        filterDistance = newFilterDistance;
        notifyObservers();
    }

    /**
     * Methode zum Zurücksetzen des Distanzfilters
     */
    public void resetFilterByDistance()
    {
        filterByDistance = false;
        notifyObservers();
    }

    /**
     * Methoden zum Überprüfen, ob einem Index eine Lokalität zugeordnet ist
     * @param index Ein gegebener Index
     * @return Boolean Wert, ob der Index gültig ist
     */
    public boolean checkIndexBounds(int index)
    {
        return index >= 0 && index < getElementCount();
    }

    /**
     * Methode zum Eingeben von Beispieldaten in den Graphen
     */
    private void initializeData()
    {
        for (Locality l: new DataProvider(this))
            addElement(l);
    }
}
