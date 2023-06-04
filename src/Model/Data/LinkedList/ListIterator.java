package src.Model.Data.LinkedList;

import java.util.Iterator;

/**
 * Iterator der verknuepften Liste.
 * Diese Klasse wurde aus einer bestehenden Implementierung eines
 * solchen Iterators abgewandelt.
 * Original Quellcode: <a href="https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/">Java | Implementing Iterator and Iterable Interface</a>
 * @param <T> Beliebiger Datentyp T
 */
public class ListIterator<T> implements Iterator<T>
{
    private Node<T> current;

    /**
     * Standardkonstruktor des ListIterators
     * @param list Referenz zur jeweiligen Liste
     */
    public ListIterator(List<T> list)
    {
        current = list.first();
    }

    public boolean hasNext()
    {
        return !current.isLast();
    }

    public T next()
    {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}
