package src.View;

import src.Model.Model;
import src.View.Window.Administration;
import src.View.Window.Navigation;

/**
 * Hautpklasse der View.
 * Zustaendig fuer die Grafische darstellung der Daten
 */
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

    /**
     * Methode zum Ausgeben der Navigationsansicht
     * @return Objekt der Navigationsansicht
     */
    public Navigation getNavigationView()
    {
        return navigation;
    }

    /**
     * Methode zum Ausgeben der Administrationsansicht
     * @return Objekt der Administrationsansicht
     */
    public Administration getAdministrationView()
    {
        return administration;
    }
}
