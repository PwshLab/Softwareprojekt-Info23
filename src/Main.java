package src;

import src.Controller.Controller;
import src.Model.Model;
import src.View.View;

public class Main
{

    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}