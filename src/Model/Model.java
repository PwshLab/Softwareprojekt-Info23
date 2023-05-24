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
    private final Random rnd;
    private final Graph<Locality> graph;
    private final Dijkstra<Locality> dijkstra;

    private List<Integer> lastPath;

    public Model()
    {
        rnd = new Random();
        graph = new Graph<>();
        dijkstra = new Dijkstra<>(graph);
        lastPath = new List<>();
    }

    public List<Locality> getElements()
    {
        return graph.getElements();
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

    public void addElement(Locality locality, List<Pair<Locality, Double>> edges)
    {
        graph.add(locality);

        for (Pair<Locality, Double> edge: edges)
            graph.setEdge(locality, edge.getValue1(), edge.getValue2(), Object::equals);

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
            for (int j = 0; j < matrix.length - i; j++)
                if (matrix[i][j] < Double.MAX_VALUE)
                    edges.add(new Pair<>(i, j));

        return edges;
    }

    public List<Pair<Locality, Double>> generateEdges(Locality locality, int n, double variance)
    {
        Locality[] localities = graph.getElements().toArray(Locality.class);
        List<Vector2> points = new List<>();

        n = Math.min(n, localities.length);

        for (Locality l: localities)
            points.add(l.getPosition());

        int[] nearest = Grid.getNNearest(locality.getPosition(), points, n);
        double distance;
        List<Pair<Locality, Double>> edges = new List<>();

        for (int i: nearest)
        {
            distance = locality.getPosition().distance(localities[i].getPosition());
            distance += distance * variance * Math.abs(rnd.nextGaussian());
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
}
