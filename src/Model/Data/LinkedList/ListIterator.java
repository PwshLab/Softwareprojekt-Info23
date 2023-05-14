package src.Model.Data.LinkedList;

import java.util.Iterator;

// Source: https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
public class ListIterator<T> implements Iterator<T>
{
    Node<T> first, current;

    public ListIterator(List<T> list)
    {
        first = list.first();
        current = list.first();
    }

    public boolean hasNext()
    {
        return !current.isLast();
    }

    public boolean hasPrevious()
    {
        return current.equals(first);
    }

    public T next()
    {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    public T previous()
    {
        T data = current.getData();
        current = current.getPrevious();
        return data;
    }
}
