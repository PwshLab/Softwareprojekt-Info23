package src;

import src.Controller.Controller;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityType;
import src.Model.Model;
import src.View.View;

import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}