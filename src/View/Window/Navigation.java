package src.View.Window;

import src.Model.Model;
import src.View.Screen.ListView.ListView;
import src.View.Screen.MapView;
import src.View.Screen.PanelTitle;

import javax.swing.*;
import java.awt.*;

/**
 * Panel fuer die Navigationsansicht
 */
public class Navigation extends JPanel
{
    private final Model model;
    private ListView listView;
    private MapView mapView;

    /**
     * Standardkonstruktor der Navigation
     * @param model Referenz zum Model
     */
    public Navigation(Model model)
    {
        this.model = model;

        initializeNavigationGUI();
    }

    /**
     * Methode zur Initialisierung der Navigationsansicht
     */
    public void initializeNavigationGUI()
    {
        JPanel mainPanel = new JPanel();
        add(mainPanel);

        mainPanel.setPreferredSize(new Dimension(1200, 600));
        mainPanel.setLayout(new GridLayout());

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelLeft.setPreferredSize(new Dimension(600, 600));
        mainPanel.add(panelLeft);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBorder(BorderFactory.createEmptyBorder(5, 25, 45, 25));
        panelRight.setPreferredSize(new Dimension(600, 600));
        mainPanel.add(panelRight);

        panelLeft.add(new PanelTitle("Lokalitaeten"));
        listView = new ListView(model);
        panelLeft.add(listView);

        panelRight.add(new PanelTitle("Stadtkarte"));
        mapView = new MapView(model);
        panelRight.add(mapView);

        setVisible(true);
    }

    /**
     * Methode zum Ausgeben der Listenansicht
     * @return Objekt der Listenansicht
     */
    public ListView getListView()
    {
        return listView;
    }

    /**
     * Methode zum Ausgeben der Kartenansicht
     * @return Objekt der Kartenansicht
     */
    public MapView getMapView()
    {
        return mapView;
    }
}
