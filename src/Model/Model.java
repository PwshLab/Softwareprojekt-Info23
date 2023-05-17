package src.Model;

import src.Model.Data.Graph.Graph;
import src.Model.Data.LinkedList.List;
import src.Model.Data.LinkedList.SortedList;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityOrder;
import src.Model.Observer.Observable;

public class Model extends Observable
{
    private Graph<Locality> graph;

    public List<Locality> getElements()
    {
        return graph.getElements();
    }

    public List<Locality> getElements(int order)
    {
        List<Locality> elements = getElements();

        switch (order)
        {
            case 1:
                return new SortedList<>(elements, LocalityOrder::ByName);
            case 2:
                return new SortedList<>(elements, LocalityOrder::ByType);
            default:
                return elements;
        }
    }
}
