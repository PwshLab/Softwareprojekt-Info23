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

        generateData(model, 25);
    }

    private static void generateData(Model model, int ammount)
    {
        Random rnd = new Random();
        for (int i = 0; i < ammount; i++)
        {
            Locality l = new Locality(
                    "Test" + i,
                    LocalityType.values()[rnd.nextInt(LocalityType.values().length)],
                    "Lorem Ipsum Dolor Sit Amtet, Consetetur Sadipiscing Elitir, Nonumy",
                    model.generatePosition()
                    );
            model.addElement(l);
        }
    }
}