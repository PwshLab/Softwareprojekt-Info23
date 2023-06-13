package src;

import src.Controller.Controller;
import src.Model.Model;
import src.View.View;

/**
 * Klasse für den Einstiegspunkt des Programms
 */
public class Main
{
    /**
     * Methode zum Programmstart
     * @param args Kommandozeilen Parameter
     */
    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}