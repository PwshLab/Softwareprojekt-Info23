package src;

import src.Controller.Controller;
import src.Model.Model;
import src.View.View;

public class Main {

    private Model model;
    private View view;
    private Controller controller;

    public void main(String[] args)
    {
        model = new Model();
        view = new View();
        controller = new Controller();
    }
}