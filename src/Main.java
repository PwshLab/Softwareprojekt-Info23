package src;

import src.Controller.Controller;
import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.LinkedList.List;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityType;
import src.Model.Data.Value.Pair;
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

        model.getPath(model.getElements().get(2), model.getElements().get(7));
        System.out.println("Last Path Length: " + model.getLastPath().count());
    }

    private static void generateData(Model model, int ammount)
    {
        Random rnd = new Random();
        for (int i = 0; i < ammount; i++)
        {
            Locality l = new Locality(
                    "Test" + i,
                    LocalityType.values()[rnd.nextInt(LocalityType.values().length)],
                    model.generatePosition()
                    );
            //List<Pair<Locality, Double>> edges = model.generateEdges(l, 1, 0.25);
            model.addElement(l);
            /*
            if (edges.count() > 0)
            {
                int j = model.getElements().indexOf(edges.get(0).getValue1(), Object::equals);
                System.out.println("#" + i + " Edges: " + edges.count() + " First Edge: " + j + " Edge Distance: " + model.getEdge(edges.get(0).getValue1(), l));
            }
             */
        }
    }
}