package src.Model.Data.LinkedList;

import java.util.Comparator;
import java.util.function.BiPredicate;

public abstract class Node<T>
{
    public abstract Node<T> addObject(T object);
    public abstract Node<T> addObjectAt(int index, T object);
    public abstract Node<T> addObjectSorted(T object, Comparator<T> comparator);
    public abstract Node<T> removeObject(T object, BiPredicate<T, T> equality);
    public abstract Node<T> getNext();
    public abstract T getData();
    public abstract int getCount();
    public abstract T getIndex(int index);
    public abstract boolean isLast();
    public abstract void setObject(int index, T object);
    public abstract int getIndexOf(T object, BiPredicate<T, T> equality, int index);

}
