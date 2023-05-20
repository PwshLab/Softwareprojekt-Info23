package src.View;

import src.Model.Model;
import src.View.Window.Navigation;

public class View
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

}
