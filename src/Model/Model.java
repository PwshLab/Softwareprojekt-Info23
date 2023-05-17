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

    public Model()
    {
        rnd = new Random();
        graph = new Graph<>();
        dijkstra = new Dijkstra<>(graph);
    }

    public List<Locality> getElements()
    {
        return graph.getElements();
    }

    public List<Locality> getElements(int order)
    {
        List<Locality> elements = getElements();

        return switch (order)
        {
            case 1 -> new SortedList<>(elements, LocalityOrder::ByName);
            case 2 -> new SortedList<>(elements, LocalityOrder::ByType);
            default -> elements;
        };
    }

    public void addElement(Locality locality, List<Pair<Locality, Double>> edges)
    {
        graph.add(locality);

        for (Pair<Locality, Double> edge: edges)
            graph.setEdge(locality, edge.getValue1(), edge.getValue2(), Object::equals);
    }

    public void removeElement(Locality locality)
    {
        graph.remove(locality, Object::equals);
    }

    public List<Pair<Locality, Double>> generateEdges(Locality locality, int n, double variance)
    {
        Locality[] localities = graph.getElements().toArray();
        List<Vector2> points = new List<>();

        for (Locality l: localities)
            points.add(l.getPosition());

        int[] nearest = Grid.getNNearest(locality.getPosition(), points, n);
        double distance;
        List<Pair<Locality, Double>> edges = new List<>();

        for (int i : nearest)
        {
            distance = locality.getPosition().distance(localities[i].getPosition());
            distance += distance * variance * rnd.nextGaussian();
            edges.add(new Pair<>(localities[i], distance));
        }

        return edges;
    }

    private List<Integer> getPath(Locality start, Locality end)
    {
        int index = graph.indexOf(start, Object::equals);
        if (dijkstra.getStartNode() != index || dijkstra.getPathLength(index) > 0)
            dijkstra.findShortestPaths(index);
        return dijkstra.getShortestPath(graph.indexOf(end, Object::equals));
    }
}
