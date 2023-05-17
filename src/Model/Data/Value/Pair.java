package src.Model.Data.Value;

public class Pair<T, U>
{
    private final T value1;
    private final U value2;

    public Pair(T value1, U value2)
    {
        this.value1 = value1;
        this.value2 = value2;
    }


    public T getValue1()
    {
        return value1;
    }

    public U getValue2()
    {
        return value2;
    }
}
