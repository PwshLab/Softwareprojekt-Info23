package src.Model.Data.LinkedList;

public class Branch<T> extends Node<T>
{
    private Node<T> next;
    private T data;

    public Branch(Node<T> next, T data)
    {
        this.next = next;
        this.data = data;
    }

    public Node addObject(T object)
    {
        return next.addObject(object);
    }

    public Node removeObject(T object)
    {
        if (data.equals(object))
        {
            return next;
        }
        else
        {
            return this;
        }
    }

    public Node getNext()
    {
        return next;
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
}
