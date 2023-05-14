package src.Model.Data.Graph;

import src.Model.Data.LinkedList.List;

public class Dijkstra<T>
{
    private Graph<T> graph;
    private int startNode;
    private int count;
    private double[][] weights;
    private double[] distances;
    private int[] previous;
    private List<Integer> remaining;

    public Dijkstra(Graph<T> graph)
    {
        this.graph = graph;
    }

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
            if (i != startNode)
                remaining.add(i);
        }
        distances[startNode] = 0;
    }

    private void updateDistance(int node, int prevNode)
    {
        double alternate = distances[prevNode] + weights[prevNode][node];
        if (alternate < distances[node])
        {
            distances[node] = alternate;
            previous[node] = prevNode;
        }
    }

    public List<Integer> getShortestPath(int node)
    {
        int currentNode = node;
        List<Integer> path = new List<>();
        path.add(currentNode);
        while (previous[currentNode] >= 0)
        {
            currentNode = previous[currentNode];
            path.add(currentNode);
        }
    }
}
