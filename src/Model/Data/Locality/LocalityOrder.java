package src.Model.Data.Locality;

public final class LocalityOrder
{
    private LocalityOrder()
    {
    }

    public static int ByName(Locality a, Locality b)
    {
        return a.getName().compareTo(b.getName());
    }

    public static int ByType(Locality a, Locality b)
    {
        return a.getType().compareTo(b.getType());
    }
}
