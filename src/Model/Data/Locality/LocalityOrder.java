package src.Model.Data.Locality;

/**
 * Klasse zum Verwalten der Methoden zum Sortieren der Lokalit�ten
 */
public final class LocalityOrder
{
    private LocalityOrder()
    {
    }

    /**
     * Methode zum Sortieren der Lokalit�ten nach dem Namen
     * @param a Erste Lokalit�t
     * @param b Zweite Lokalit�t
     * @return Integer Zahlenwert des Vergleiches
     */
    public static int ByName(Locality a, Locality b)
    {
        return a.getName().compareTo(b.getName());
    }

    /**
     * Methode zum Sortieren der Lokalit�ten nach dem Typen
     * @param a Erste Lokalit�t
     * @param b Zweite Lokalit�t
     * @return Integer Zahlenwert des Vergleiches
     */
    public static int ByType(Locality a, Locality b)
    {
        return a.getType().compareTo(b.getType());
    }
}
