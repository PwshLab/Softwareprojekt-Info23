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

    public void add(T object)
    {
        nodes.add(new Node<>(object));

        for (List<Double> list: matrix)
        {
            list.add(0.0);
        }

        List<Double> list = new List<>();
        for (int i = 0; i < nodes.count(); i++)
        {
            list.add(0.0);
        }
        matrix.add(list);
    }

    public void remove(T object)
    {
        int index = nodes.indexOf(new Node(object), (Node<T>a, Node<T>b) -> a.getData().equals(b.getData()));
        nodes.pop(index);

        for (List<Double> list: matrix)
        {
            list.pop(index);
        }
        matrix.pop(index);
    }

    public void setEdge(int i1, int i2, double weight)
    {
        matrix.get(i1).set(i2, weight);
        matrix.get(i2).set(i1, weight);
    }

    public double getEdge(int i1, int i2)
    {
        return matrix.get(i1).get(i2);
    }
}
