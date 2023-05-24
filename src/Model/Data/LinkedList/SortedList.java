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
     * Standartkonstruktor der sortierten Liste
     * @param comparator Benutzer spezifizierte Funktion zum Überprüfen
     *                   der Sortierreihenfolge zweier Objekte
     */
    public SortedList(Comparator<T> comparator)
    {
        super();
        this.comparator = comparator;
    }

    /**
     * Konstruktor zum Erstellen einer sortierten Liste mit den Elementen
     * aus einer schon vorhandenen Liste
     * @param list Eine andere Liste eines gleichen Typen
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
     * Konstruktor zum Erstellen einer sortierten Liste mit den Elementen
     * aus einer schon vorhandenen Liste
     * @param array Ein Array eines gleichen Typen
     * @param comparator Benutzer spezifizierte Funktion zum Überprüfen
     *                   der Sortierreihenfolge zweier Objekte
     */
    public SortedList(T[] array, Comparator<T> comparator)
    {
        super();
        this.comparator = comparator;

        for (T object: array)
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
        first = first.addObjectSorted(object, comparator);
    }
}
