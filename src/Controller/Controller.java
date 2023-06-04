package src.Controller;

import src.Controller.Navigation.SearchFilter;
import src.Controller.Navigation.SearchPath;
import src.Controller.WindowSwitch.TopBar;
import src.Model.Model;
import src.View.View;

import javax.swing.*;
import java.awt.*;

/**
 * Hauptklasse des Controllers.
 * Zustaendig fuer die Benutzereingaben des Programms
 */
public class Controller
{
    private final Model model;
    private final View view;

    private JFrame mainFrame;
    private JPanel navigationWindow;
    private JPanel administrationWindow;

    /**
     * Standardkonstruktor des Controllers
     * @param model Referenz zum Model
     * @param view Referenz zur View
     */
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;

        initialize();
    }

    /**
     * Methode zum Initialisieren des Programmfensters
     */
    private void initializeMainWindow()
    {
        mainFrame = new JFrame("Search a Bar");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.pack();
    }

    /**
     * Methode zum Initialisieren des Navigationsfensters
     */
    private void initializeNavigationWindow()
    {
        navigationWindow = new JPanel();
        navigationWindow.add(new TopBar(this, true));
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

    /**
     * Methode zum Setzen des Programmfensters auf die Navigation
     */
    public void setWindowNavigation()
    {
        model.resetFilterByDistance();
        mainFrame.setContentPane(navigationWindow);
        mainFrame.pack();
    }

    /**
     * Methode zum Initialisieren des Administrationsfensters
     */
    private void initializeAdministrationWindow()
    {
        administrationWindow = new JPanel();
        administrationWindow.add(new TopBar(this, false));
        administrationWindow.setPreferredSize(new Dimension(1200, 650));
        administrationWindow.setLayout(new BoxLayout(administrationWindow, BoxLayout.Y_AXIS));
        administrationWindow.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        administrationWindow.add(view.getAdministrationView());
    }

    /**
     * Methode zum Setzen des Programmfensters auf die Administration
     */
    public void setAdministrationWindow()
    {
        model.resetFilterByDistance();
        mainFrame.setContentPane(administrationWindow);
        mainFrame.pack();
    }

    /**
     * Methode zum allgemeinen Initialisieren des Programmfensters
     */
    private void initialize()
    {
        initializeMainWindow();
        initializeNavigationWindow();
        initializeAdministrationWindow();
        setWindowNavigation();
    }
}
