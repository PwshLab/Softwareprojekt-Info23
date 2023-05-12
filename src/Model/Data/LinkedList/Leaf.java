package src.Model.Data.LinkedList;

public class Leaf<T> extends Node<T>
{
    public Node addObject(T object)
    {
        return new Branch(this, object);
    }

    public Node removeObject(T object)
    {
        return this;
    }

    public Node getNext()
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
}
