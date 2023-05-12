package src.Model.Data.LinkedList;

import java.util.Comparator;

public class SortedList<T> extends List<T>
{
    private final Comparator<T> comparator;

    public SortedList(Comparator<T> comparator)
    {
        super();
        this.comparator = comparator;
    }

    public SortedList(List<T> list, Comparator<T> comparator)
    {
        super();
        this.comparator = comparator;

        for (T object: list)
        {
            add(object);
        }
    }

    public void add(T object)
    {
        first = first.addObjectSorted(object, comparator);
    }
}
