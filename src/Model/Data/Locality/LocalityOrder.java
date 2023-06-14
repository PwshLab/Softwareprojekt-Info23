package src.Model.Data.Locality;

/**
 * Klasse zum Verwalten der Methoden zum Sortieren der Lokalitšten
 */
public final class LocalityOrder
{
    private LocalityOrder()
    {
    }

    /**
     * Methode zum Sortieren der Lokalitšten nach dem Namen
     * @param a Erste Lokalitšt
     * @param b Zweite Lokalitšt
     * @return Integer Zahlenwert des Vergleiches
     */
    public static int ByName(Locality a, Locality b)
    {
        return a.getName().compareTo(b.getName());
    }

    /**
     * Methode zum Sortieren der Lokalitšten nach dem Typen
     * @param a Erste Lokalitšt
     * @param b Zweite Lokalitšt
     * @return Integer Zahlenwert des Vergleiches
     */
    public static int ByType(Locality a, Locality b)
    {
        return a.getType().compareTo(b.getType());
    }
}
