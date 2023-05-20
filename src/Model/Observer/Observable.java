package src.Model.Observer;

import src.Model.Data.LinkedList.List;

public class Observable
{
    private List<Observer> observers;

    public Observable()
    {
        observers = new List<>();
    }

    protected void notifyObservers()
    {
        for (Observer observer: observers)
        {
            observer.update();
        }
    }

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer, Object::equals);
    }
}
