package src.Model.Data.LinkedList;

import java.util.Comparator;

/**
 * Generische einfach verknüpfte sortierte Liste
 * @param <T> Beliebiger Datentyp T
 */
public class SortedList<T> extends List<T>
{
    private final Comparator<T> comparator;

    /**
     * Standartkonstruktor der Liste
     * @param comparator Benutzer spezifizierte Funktion zum Überprüfen
     *                   der Sortierreihenfolge zweier Objekte
     */
    public SortedList(Comparator<T> comparator)
    {
        super();
        this.comparator = comparator;
    }

    /**
     * Konstruktor zum Sortieren einer bereits vorhandenen Liste
     * @param list Andere Liste
     * @param comparator Benutzer spezifizierte Funktion zum Überprüfen
     *                   der Sortierreihenfolge zweier Objekte
     */
    public SortedList(List<T> list, Comparator<T> comparator)
    {
        super();
        this.comparator = comparator;

        for (T object: list)
        {
            add(object);
        }
    }

    /**
     * Methode zum sortierten Einfügen eines Objektes
     * @param object Objekt des Typen T
     */
    public void add(T object)
    {
        first = first.addObjectSorted(null, object, comparator);
    }
}
