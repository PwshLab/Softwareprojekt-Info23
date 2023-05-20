package src.Model.Data.LinkedList;

import java.util.function.BiPredicate;
import java.util.Iterator;
import java.util.function.Predicate;

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
     * Methode zum Hinzufügen eines Objektes in die Liste
     * @param object Objekt des Typen T
     */
    public void add(T object)
    {
        first = first.addObject(object);
        count++;
    }

    /**
     * Methode zum Einfügen eines Objektes an einer Position in der Liste
     * @param index Position des Objektes
     * @param object Objekt des Typen T
     */
    public void insert(int index, T object)
    {
        first = first.addObjectAt(index, object);
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
     * Methode zum Überprüfen, ob die Liste ein Objekt enthält
     * @param object Objekt des Typen T
     * @param equality Benutzer spezifizierte Funktion zum Überprüfen
     *                 der Gleichheit zweier Objekte
     * @return Wahrheitswert, ob sich das Objekt in der Liste befindet
     */
    public boolean contains(T object, BiPredicate<T, T> equality)
    {
        return this.indexOf(object, equality) >= 0;
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
     * Methode zum Ausgeben der Objekte in der Liste in einem Array
     * @return Array mit den Objekten der Liste
     */
    public T[] toArray()
    {
        @SuppressWarnings("unchecked") T[] arr = (T[])new Object[count()];
        int index = 0;
        for (T object: this)
        {
            arr[index] = object;
            index++;
        }
        return arr;
    }

    /**
     * Methode zum Ausgeben der Objekte in der Liste, gemäß danach,
     * ob sie ein gegebenes Kriterium erfüllen
     * @param predicate Funktion zum Überprüfen des Kriteriums
     * @return Liste mit den Objekten, welche das Kriterium erfüllen
     */
    public List<T> filter(Predicate<T> predicate)
    {
        List<T> filtered = new List<>();
        for (T object: this)
            if (predicate.test(object))
                filtered.add(object);
        return filtered;
    }
}
