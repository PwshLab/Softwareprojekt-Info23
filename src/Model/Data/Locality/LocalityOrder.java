package src.Model.Data.Locality;

/**
 * Klasse zum Verwalten der Methoden zum Sortieren der Lokalitaeten
 */
public final class LocalityOrder
{
    private LocalityOrder()
    {
    }

    /**
     * Methode zum Sortieren der Lokalitaeten nach dem Namen
     * @param a Erste Lokalitaet
     * @param b Zweite Lokalitaet
     * @return Integer Zahlenwert des Vergleiches
     */
    public static int ByName(Locality a, Locality b)
    {
        return a.getName().compareTo(b.getName());
    }

    /**
     * Methode zum Sortieren der Lokalitaeten nach dem Typen
     * @param a Erste Lokalitaet
     * @param b Zweite Lokalitaet
     * @return Integer Zahlenwert des Vergleiches
     */
    public static int ByType(Locality a, Locality b)
    {
        return a.getType().compareTo(b.getType());
    }
}
