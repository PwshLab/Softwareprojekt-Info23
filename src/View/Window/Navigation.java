package src.View.Window;

import src.Model.Model;
import src.View.Screen.ListView.ListView;
import src.View.Screen.MapView;

import javax.swing.*;
import java.awt.*;


public class Navigation extends JPanel
{
    private final Model model;
    private ListView listView;
    private MapView mapView;

    public Navigation(Model model)
    {
        this.model = model;

        initializeNavigationGUI();
    }

    public void initializeNavigationGUI()
    {
        JPanel mainPanel = new JPanel();
        add(mainPanel);

        mainPanel.setPreferredSize(new Dimension(1200, 600));
        mainPanel.setLayout(new GridLayout());

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainPanel.add(panelLeft);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBorder(BorderFactory.createEmptyBorder(25, 25, 50, 25));
        mainPanel.add(panelRight);

        listView = new ListView(model);
        panelLeft.add(listView);

        mapView = new MapView(model, 400, 400);
        panelRight.add(mapView);

        setVisible(true);
    }

    public ListView getListView()
    {
        return listView;
    }

    public MapView getMapView()
    {
        return mapView;
    }
}
