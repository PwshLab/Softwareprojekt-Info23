package src.Model.Data.LinkedList;

import java.util.function.BiPredicate;
import java.util.Iterator;

public class List<T> implements Iterable<T>
{
    protected Node<T> first;
    protected int count;
    private boolean changed;

    public List()
    {
        first = new Leaf<>();
        count = 0;
        changed = false;
    }

    public void add(T object)
    {
        first = first.addObject(object);
        count++;
    }

    public void remove(T object, BiPredicate<T, T> comparator)
    {
        first = first.removeObject(object, comparator);
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
            this.remove(object, Object::equals);
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

    public int indexOf(T object, BiPredicate<T, T> comparator)
    {
        return first.getIndexOf(object, comparator, 0);
    }

    public Node<T> first()
    {
        return first;
    }

    public Iterator<T> iterator()
    {
        return new ListIterator<>(this);
    }
}
