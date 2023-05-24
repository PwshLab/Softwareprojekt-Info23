package src.View;

import src.Controller.Controller;
import src.Model.Model;
import src.Model.Observer.Observer;
import src.View.Window.Navigation;

import javax.swing.*;

public class View implements Observer
{
    private final Model model;

    private final Navigation navigation;

    public View(Model model)
    {
        this.model = model;
        navigation = new Navigation(model);

        registerViews();
    }

    private void registerViews()
    {
        model.addObserver(navigation);
    }

    public Navigation getNavigationView()
    {
        return navigation;
    }

    public void update() {

    }
}
