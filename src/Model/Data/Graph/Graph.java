package src.Model.Data.Graph;

import src.Model.Data.LinkedList.List;

/**
 * Generischer Graph
 * @param <T> Beliebiger Datentyp T
 */
public class Graph<T>
{
    private final List<Node<T>> nodes;
    private final List<List<Double>> matrix;

    /**
     * Standartkonstruktor des Graphen
     */
    public Graph()
    {
        /*
         * Implementierung von Knotenliste und Adjazenzmatrix
         * mit Listen
         */

        nodes = new List<>();
        matrix = new List<>();
    }

    /**
     * Methode zum Einfügen eines Objektes in den Graphen
     * @param object Objekt des Typen T
     */
    public void add(T object)
    {
        /*
         * Noch nicht beschriebene Kanten werden mit dem
         * Wert 0 Initialisiert
         */

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

    /**
     * Methode zum Entfernen eines Objektes aus dem Graphen
     * @param object Objekt des Typen T
     */
    public void remove(T object)
    {
        /*
         * Die Abschnitte der Adjazenzmatrix zu dem jeweiligen
         * Objekt werden ebenfalls mit entfernt
         */

        int index = nodes.indexOf(new Node<>(object), (Node<T>a, Node<T>b) -> a.getData().equals(b.getData()));
        nodes.pop(index);

        for (List<Double> list: matrix)
        {
            list.pop(index);
        }
        matrix.pop(index);
    }

    /**
     * Methode zum Hinzufügen eines Kantenwertes im Graphen
     * @param i1 Index des ersten Objektes
     * @param i2 Index des zweiten Objektes
     * @param weight Wert der Kante als Double
     */
    public void setEdge(int i1, int i2, double weight)
    {
        matrix.get(i1).set(i2, weight);
        matrix.get(i2).set(i1, weight);
    }

    /**
     * Methode zum Ausgeben eines Kantenwertes im Graphen
     * @param i1 Index des ersten Objektes
     * @param i2 Index des zweiten Objektes
     * @return Wert der Kante als Double
     */
    public double getEdge(int i1, int i2)
    {
        return matrix.get(i1).get(i2);
    }
}
