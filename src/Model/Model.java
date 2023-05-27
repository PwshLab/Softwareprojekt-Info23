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

import java.util.Random;

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

    public Model()
    {
        rnd = new Random();
        graph = new Graph<>();
        dijkstra = new Dijkstra<>(graph);
        lastPath = new List<>();
        filterByDistance = false;
        filterPosition = Vector2.zero;
        filterDistance = 0;

    }

    public List<Locality> getElements()
    {
        if (!filterByDistance)
            return graph.getElements();
        else
            return graph.getElements().filter((Locality l) -> l.getPosition().distance(filterPosition) <= filterDistance);
    }

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

    public List<Locality> getElementsByDistance(Vector2 position, double distance)
    {
        List<Locality> elements = getElements();
        return elements.filter((Locality l) -> l.getPosition().distance(position) <= distance);
    }

    public void addElement(Locality locality)
    {
        graph.add(locality);
        recalculateEdges(locality);

        notifyObservers();
    }

    public void removeElement(Locality locality)
    {
        graph.remove(locality, Object::equals);
        notifyObservers();
    }

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

    public double getEdge(Locality l1, Locality l2)
    {
        return graph.getEdge(l1, l2, Object::equals);
    }

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

    public List<Integer> getPath(Locality loc1, Locality loc2)
    {
        int index = graph.indexOf(loc1, Object::equals);
        if (dijkstra.getStartNode() != index || dijkstra.getPathLength(index) > 0)
            dijkstra.findShortestPaths(index);
        lastPath = dijkstra.getShortestPath(graph.indexOf(loc2, Object::equals));
        notifyObservers();
        return lastPath;
    }

    public List<Integer> getLastPath()
    {
        return lastPath;
    }

    private void recalculateEdges(Locality locality)
    {
        List<Pair<Locality, Double>> edges = generateEdges(locality);
        graph.clearEdges(locality, Object::equals);
        graph.setEdges(locality, edges, Object::equals);
    }

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

    public int getWorldBound()
    {
        return worldBound;
    }

    public void setFilterByDistance(Vector2 newFilterPosition, double newFilterDistance)
    {
        filterByDistance = true;
        filterPosition = newFilterPosition;
        filterDistance = newFilterDistance;
    }

    public void resetFilterByDistance()
    {
        filterByDistance = false;
    }
}
