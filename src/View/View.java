package src.View;

import src.Model.Model;
import src.View.Window.Administration;
import src.View.Window.Navigation;

public class View
{
    private final Model model;
    private final Navigation navigation;
    private final Administration administration;

    public View(Model model)
    {
        this.model = model;
        navigation = new Navigation(model);
        administration = new Administration(model);
    }

    public Navigation getNavigationView()
    {
        return navigation;
    }

    public Administration getAdministrationView()
    {
        return administration;
    }
}
