package src;

import src.Controller.Controller;
import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.LinkedList.List;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityType;
import src.Model.Model;
import src.View.View;

public class Main {

    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

        addData(model);
    }

    private static void addData(Model model)
    {
        Locality locality = new Locality("Test", LocalityType.BAR, new Vector2(0, 0));
        model.addElement(locality, new List<>());
    }
}