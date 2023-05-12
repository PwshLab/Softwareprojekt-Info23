package src.Model.Data.Graph;

public class Node<T>
{
    private final T data;

    public Node(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

}
