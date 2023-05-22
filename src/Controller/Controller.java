package src.Controller;

import src.Model.Model;
import src.View.View;

import javax.swing.*;

public class Controller
{
    private final Model model;
    private final View view;

    private JFrame mainWindow;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    private void initializeMainWindow()
    {
        mainWindow = new JFrame("Search a Bar");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
