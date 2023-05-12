package src.Model.Data.LinkedList;

import java.util.Iterator;

// Source: https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
public class ListIterator<T> implements Iterator<T>
{
    Node<T> current;

    public ListIterator(List<T> list)
    {
        current = list.getFirst();
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
