package src.Model.Data.LinkedList;

public abstract class Node<T>
{
    public abstract Node addObject(T object);
    public abstract Node removeObject(T object);
    public abstract Node getNext();
    public abstract T getData();
    public abstract int getCount();
    public abstract T getIndex(int index);
    public abstract boolean isLast();
    public abstract void setObject(int index, T object);

}
