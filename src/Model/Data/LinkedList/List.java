package src.Model.Data.LinkedList;

import java.lang.reflect.Array;
import java.util.function.BiPredicate;
import java.util.Iterator;

/**
 * Generische einfach verknüpfte Liste
 * @param <T> Beliebiger Datentyp T
 */
public class List<T> implements Iterable<T>
{
    protected Node<T> first;
    protected int count;
    private boolean changed;

    /**
     * Standartkonstruktor der Liste
     */
    public List()
    {
        first = new Leaf<>();
        count = 0;
        changed = false;
    }

    /**
     * Methode zum Hinzufügen eines Objektes Liste
     * @param object Objekt des Typen T
     */
    public void add(T object)
    {
        first = first.addObject(object);
        count++;
    }

    /**
     * Methode zum Entfernen eines Objektes aus der Liste
     * @param object Objekt des Typen T
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                   der Gleichheit zweier Objekte
     */
    public void remove(T object, BiPredicate<T, T> equality)
    {
        first = first.removeObject(object, equality);
        changed = true;
    }

    /**
     * Methode zum Zugreifen auf die Länge der Liste
     * @return Anzahl der Elemente in der Liste
     */
    public int count()
    {
        /*
         * Bei der Remove Methode ist nicht sicher, ob
         * ein Objekt entfernt wurde, oder nicht. Deshalb werden
         * die Objekte beim nächsten Aufruf erneut gezählt.
         */

        if (changed)
        {
            count = first.getCount();
            changed = false;
        }
        return count;
    }

    /**
     * Methode zum Ausgeben des Objektes an der übergebenen Stelle
     * @param index Index des Objektes
     * @return Objekt des Typen T
     */
    public T get(int index)
    {
        if (index < this.count())
        {
            return first.getIndex(index);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Methode zum Entfernen und Ausgeben des Objektes an
     * der übergebenen Stelle
     * @param index Index des Objektes
     * @return Objekt des Typen T
     */
    public T pop(int index)
    {
        if (index < this.count())
        {
            T object = first.getIndex(index);
            this.remove(object, Object::equals);
            return object;
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Methode zum Setzen des Objektes an der übergebenen Stelle
     * @param index Index des eingesetzten Objektes
     * @param object Objekt des Typen T
     */
    public void set(int index, T object)
    {
        if (index < this.count())
        {
            first.setObject(index, object);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Methode zum Ausgeben des Index eines bekannten Objektes
     * @param object Objekt des Typen T
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                   der Gleichheit zweier Objekte
     * @return Index des Objektes
     */
    public int indexOf(T object, BiPredicate<T, T> equality)
    {
        return first.getIndexOf(object, equality, 0);
    }

    /**
     * Methode zum Ausgeben des ersten Knotens der Liste
     * @return Knoten mit Objekt des Typen T
     */
    public Node<T> first()
    {
        return first;
    }

    /**
     * Methode zum Ausgeben eines Iterators über der Liste
     * @return Iterator der Liste
     */
    public Iterator<T> iterator()
    {
        /*
         * Der Iterator ist hier ein effizienterer Weg die Objekte in der
         * Liste mit einer foreach Schleife zu referenzieren als dies
         * Anderweitig möglich wäre
         */

        return new ListIterator<>(this);
    }

    /**
     * Methode zum Ausgeben eines Arrays mit den Objekten in der Liste
     * @param type Typ des Ausgabe Arrays
     * @return Array mit den Objekten in der Liste
     */
    public T[] toArray(Class<T> type)
    {
        T[] arr = (T[]) Array.newInstance(type, this.count());
        int index = 0;
        for (T object: this)
        {
            arr[index] = object;
            index++;
        }
        return arr;
    }
}
