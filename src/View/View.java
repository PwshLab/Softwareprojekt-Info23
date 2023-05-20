package src.View;

import src.Model.Model;
import src.View.Screen.ListView.ListView;
import src.View.Window.Navigation;

public class View
{
    private Model model;

    private Navigation navigation;

    public View(Model model)
    {
        this.model = model;
        navigation = new Navigation();
    }

    private void registerViews()
    {
        model.addObserver(navigation);
    }

}
