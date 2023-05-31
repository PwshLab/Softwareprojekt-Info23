package src.Controller;

import src.Controller.Navigation.SearchFilter;
import src.Controller.Navigation.SearchPath;
import src.Model.Model;
import src.View.View;

import javax.swing.*;
import java.awt.*;

public class Controller
{
    private final Model model;
    private final View view;

    private JFrame mainFrame;
    private JPanel navigationWindow;
    private JPanel administrationWindow;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;

        initialize();
    }

    // TODO: Add database connection for data persistence
    // TODO: Add ability to generate example data
    // TODO: Make Data handling class


    private void initializeMainWindow()
    {
        mainFrame = new JFrame("Search a Bar");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void initializeNavigationWindow()
    {
        navigationWindow = new JPanel();
        navigationWindow.setPreferredSize(new Dimension(1200, 750));
        navigationWindow.setLayout(new BoxLayout(navigationWindow, BoxLayout.Y_AXIS));
        navigationWindow.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        navigationWindow.add(view.getNavigationView());
        JPanel bottomUI = new JPanel();
        bottomUI.setLayout(new GridLayout());
        bottomUI.add(new SearchFilter(model));
        bottomUI.add(new SearchPath(model));
        bottomUI.setPreferredSize(new Dimension(1200, 75));
        navigationWindow.add(bottomUI);
    }

    private void setWindowNavigation()
    {
        mainFrame.setContentPane(navigationWindow);
        mainFrame.pack();
    }

    private void initializeAdministrationWindow()
    {
        administrationWindow = new JPanel();
        administrationWindow.setPreferredSize(new Dimension(1200, 650));
        administrationWindow.setLayout(new BoxLayout(administrationWindow, BoxLayout.Y_AXIS));
        administrationWindow.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        administrationWindow.add(view.getAdministrationView());
    }

    private void setAdministrationWindow()
    {
        mainFrame.setContentPane(administrationWindow);
        mainFrame.pack();
    }

    private void initialize()
    {
        initializeMainWindow();
        initializeNavigationWindow();
        initializeAdministrationWindow();
        setWindowNavigation();
        //setAdministrationWindow();
    }
}
