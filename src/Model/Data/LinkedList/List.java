package src.Model.Data.LinkedList;

import java.util.Iterator;

public class List<T> implements Iterable<T>
{
    private Node<T> first;
    private int count;
    private boolean changed;

    public List()
    {
        first = new Leaf();
        count = 0;
        changed = false;
    }

    public void add(T object)
    {
        first = first.addObject(object);
        count++;
    }

    public void remove(T object)
    {
        first = first.removeObject(object);
        changed = true;
    }

    public int count()
    {
        if (changed)
        {
            count = first.getCount();
            changed = false;
        }
        return count;
    }

    public T get(int index)
    {
        if (index < this.count())
        {
            return first.getIndex(index);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public T pop(int index)
    {
        if (index < this.count())
        {
            T object = first.getIndex(index);
            this.remove(object);
            return object;
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public void set(int index, T object)
    {
        if (index < this.count())
        {
            first.setObject(index, object);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public Node<T> getFirst()
    {
        return first;
    }

    public Iterator<T> iterator()
    {
        return new ListIterator<T>(this);
    }
}
