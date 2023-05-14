package src.Model.Data.LinkedList;

import java.util.Comparator;
import java.util.function.BiPredicate;

public class Leaf<T> extends Node<T>
{
    public Node<T> addObject(T object)
    {
        return new Branch<>(this, object);
    }

    public Node<T> addObjectSorted(T object, Comparator<T> comparator)
    {
        return new Branch<>(this, object);
    }

    public Node<T> removeObject(T object, BiPredicate<T, T> equality)
    {
        return this;
    }

    public Node<T> getNext()
    {
        return this;
    }

    public T getData()
    {
        return null;
    }

    public int getCount()
    {
        return 0;
    }

    public T getIndex(int index)
    {
        return null;
    }

    public boolean isLast()
    {
        return true;
    }

    public void setObject(int index, T object)
    {
    }

    public int getIndexOf(T object, BiPredicate<T, T> equality, int index)
    {
        return -1;
    }
}
