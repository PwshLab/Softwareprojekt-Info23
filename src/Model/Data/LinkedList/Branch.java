package src.Model.Data.LinkedList;

import java.util.Comparator;
import java.util.function.BiPredicate;

public class Branch<T> extends Node<T>
{
    private Node<T> next, previous;
    private T data;

    public Branch(Node<T> previous, Node<T> next, T data)
    {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public Node<T> addObject(Node<T> parent, T object)
    {
        next = next.addObject(this, object);
        return this;
    }

    public Node<T> addObjectSorted(Node<T> parent, T object, Comparator<T> comparator)
    {
        if (comparator.compare(data, object) < 0)
        {
            next = next.addObject(this, object);
        }
        else
        {
            next = new Branch<>(this, next, object);
        }
        return this;
    }

    public Node<T> removeObject(T object, BiPredicate<T, T> equality)
    {
        if (equality.test(data, object))
        {
            return next;
        }
        else
        {
            return this;
        }
    }

    public Node<T> getNext()
    {
        return next;
    }

    public Node<T> getPrevious()
    {
        return previous;
    }

    public T getData()
    {
        return  data;
    }

    public int getCount()
    {
        return next.getCount() + 1;
    }

    public T getIndex(int index)
    {
        if (index <= 0)
        {
            return data;
        }
        else
        {
            return next.getIndex(index - 1);
        }
    }

    public boolean isLast()
    {
        return false;
    }

    public void setObject(int index, T object)
    {
        if (index <= 0)
        {
            data = object;
        }
        else
        {
            next.setObject(index - 1, object);
        }
    }

    public int getIndexOf(T object, BiPredicate<T, T> equality, int index)
    {
        if (equality.test(data, object))
        {
            return index;
        }
        else
        {
            return next.getIndexOf(object, equality,  index + 1);
        }
    }
}
