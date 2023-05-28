package src.Model.Data.Graph;

import src.Model.Data.LinkedList.List;
import src.Model.Data.Value.Pair;

import java.util.function.BiPredicate;

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
         * Wert von Double.MAX_VALUE Initialisiert
         */

        nodes.add(new Node<>(object));

        for (List<Double> list: matrix)
            list.add(Double.MAX_VALUE);

        List<Double> list = new List<>();
        for (int i = 0; i < nodes.count(); i++)
            list.add(Double.MAX_VALUE);

        matrix.add(list);
    }

    /**
     * Methode zum Entfernen eines Objektes aus dem Graphen
     * @param object Objekt des Typen T
     */
    public void remove(T object, BiPredicate<T, T> equality)
    {
        /*
         * Die Abschnitte der Adjazenzmatrix zu dem jeweiligen
         * Objekt werden ebenfalls mit entfernt
         */

        int index = indexOf(object, equality);
        nodes.pop(index);

        for (List<Double> list: matrix)
            list.pop(index);

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

    /**
     * Methode zum Ausgeben der Objekte im Graphen
     * @return Liste mit den Objekten im Graphen
     */
    public List<T> getElements()
    {
        List<T> elements = new List<>();
        for (Node<T> node: nodes)
            elements.add(node.getData());
        return elements;
    }

    /**
     * Methode zum Ausgeben der Kantenwerte im Graphen
     * @return 2-Dimensionales Array der Kantenwerte
     */
    public double[][] getWeights()
    {
        double[][] weights = new double[nodes.count()][nodes.count()];
        int index1 = 0, index2 = 0;
        for (List<Double> row: matrix)
        {
            for (double value: row)
            {
                weights[index1][index2] = value;
                index2++;
            }
            index1++;
            index2 = 0;
        }
        return weights;
    }

    /**
     * Methode zum Ausgeben des Index eines Objektes
     * @param object Objekt des Typen T
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                 der Gleichheit zweier Objekte
     * @return Index des Objektes
     */
    public int indexOf(T object, BiPredicate<T, T> equality)
    {
        return nodes.indexOf(new Node<>(object), (Node<T> a, Node<T> b) -> equality.test(a.getData(), b.getData()));
    }

    /**
     * Methode zum Hinzufügen eines Kantenwertes im Graphen
     * @param obj1 Objekt des Typen T
     * @param obj2 Objekt des Typen T
     * @param weight Wert der Kante als Double
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                 der Gleichheit zweier Objekte
     */
    public void setEdge(T obj1, T obj2, double weight, BiPredicate<T, T> equality)
    {
        int i1 = indexOf(obj1, equality), i2 = indexOf(obj2, equality);
        setEdge(i1, i2, weight);
    }

    /**
     * Methode zum Ausgeben eines Kantenwertes im Graphen
     * @param obj1 Objekt des Typen T
     * @param obj2 Objekt des Typen T
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                 der Gleichheit zweier Objekte
     * @return Wert der Kante als Double
     */
    public double getEdge(T obj1, T obj2, BiPredicate<T, T> equality)
    {
        int i1 = indexOf(obj1, equality), i2 = indexOf(obj2, equality);
        return getEdge(i1, i2);
    }

    /**
     * Methode zum Entfernen aller Kannten eins bestimmten Knotens
     * @param object Objekt des Typen T
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                 der Gleichheit zweier Objekte
     */
    public void clearEdges(T object, BiPredicate<T, T> equality)
    {
        int index = indexOf(object, equality);
        List<Double> defaultValues = new List<>();
        for (int i = 0; i < nodes.count(); i++)
            defaultValues.add(Double.MAX_VALUE);

        matrix.set(index, defaultValues);
        for (List<Double> row: matrix)
            row.set(index, Double.MAX_VALUE);
    }

    /**
     * Methode zum Setzen der Kanten eines Knotens
     * @param object Objekt des Typen T
     * @param edges Liste von Knoten
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                 der Gleichheit zweier Objekte
     */
    public void setEdges(T object, List<Pair<T, Double>> edges, BiPredicate<T, T> equality)
    {
        for (Pair<T, Double> edge: edges)
            setEdge(object, edge.getValue1(), edge.getValue2(), equality);
    }
}
