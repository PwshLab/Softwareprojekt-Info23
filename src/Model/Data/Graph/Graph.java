package src.Model.Data.Graph;

import src.Model.Data.LinkedList.List;

public class Graph<T>
{
    private List<Node<T>> nodes;
    private List<List<Double>> matrix;

    public Graph()
    {
        nodes = new List<>();
        matrix = new List<>();
    }
}
