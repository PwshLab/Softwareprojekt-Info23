package src.Model.Observer;

import src.Model.Data.LinkedList.List;

/**
 * Überklasse für ein Beobachtbares Objekt
 */
public class Observable
{
    private final List<Observer> observers;

    /**
     * Standardkonstruktor eines Observable Objektes
     */
    public Observable()
    {
        observers = new List<>();
    }

    /**
     * Methode zum Benachrichtigen der Beobachter
     */
    protected void notifyObservers()
    {
        for (Observer observer: observers)
        {
            observer.update();
        }
    }

    /**
     * Methode zum Hinzufügen eines Beobachters
     * @param observer Ein Objekt, welches das Observer Interface implementiert
     */
    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    /**
     * Methode zum Entfernen eines Beobachters
     * @param observer Ein Objekt, welches das Observer Interface implementiert
     */
    public void removeObserver(Observer observer)
    {
        observers.remove(observer, Object::equals);
    }
}
