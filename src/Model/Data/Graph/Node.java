package src.Model.Data.Graph;

public class Node<T>
{
    private T data;

    public Node(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
