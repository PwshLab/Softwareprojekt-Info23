package src.Model.Data.Value;

/**
 * Generische Klasse fuer ein Wertepaar
 * @param <T> Datentyp des ersten Wertes
 * @param <U> Datentyp des zweiten Wertes
 */
public class Pair<T, U>
{
    private final T value1;
    private final U value2;

    /**
     * Standardkonstruktor des Pairs
     * @param value1 Erster Wert
     * @param value2 Zweiter Wert
     */
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
