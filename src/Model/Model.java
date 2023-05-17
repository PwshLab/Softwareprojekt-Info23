package src.Model;

import src.Model.Data.Graph.Graph;
import src.Model.Data.LinkedList.List;
import src.Model.Data.LinkedList.SortedList;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityOrder;
import src.Model.Data.Value.Pair;
import src.Model.Observer.Observable;

public class Model extends Observable
{
    private final Graph<Locality> graph;

    public Model()
    {
        graph = new Graph<>();
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
}
