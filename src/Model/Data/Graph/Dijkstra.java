package src.Model.Data.Graph;

import src.Model.Data.LinkedList.List;

/**
 * Dijkstra Pfadsuche Algorithmus
 * @param <T> Datentyp T des Graphen
 */
public class Dijkstra<T>
{
    private final Graph<T> graph;
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
            path.insert(0, currentNode);
        }
        return path;
    }

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
                        updateDistance(nearestNode, neighbourNode);
                    }
                }
            }
        }
    }

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
}
