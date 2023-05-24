package src.View.Window;

import src.Model.Data.LinkedList.List;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Value.Pair;
import src.Model.Model;
import src.Model.Observer.Observer;
import src.View.Screen.ListView.ListView;
import src.View.Screen.MapView;

import javax.swing.*;
import java.awt.*;


public class Navigation extends JPanel implements Observer
{
    private final Model model;
    private ListView listView;
    private MapView mapView;

    public Navigation(Model model)
    {
        this.model = model;

        initializeNavigationGUI();
        update();
    }

    public void initializeNavigationGUI()
    {
        JPanel mainPanel = new JPanel();
        add(mainPanel);

        mainPanel.setPreferredSize(new Dimension(1200, 600));
        //mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new GridLayout());

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        //panelLeft.setBackground(Color.GREEN);
        panelLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainPanel.add(panelLeft);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        //panelRight.setBackground(Color.CYAN);
        panelRight.setBorder(BorderFactory.createEmptyBorder(25, 25, 50, 25));
        mainPanel.add(panelRight);

        listView = new ListView(model);
        panelLeft.add(listView);

        mapView = new MapView(model, 400, 400);
        panelRight.add(mapView);

        setVisible(true);
    }

    public void update()
    {
        List<Locality> localities = model.getElements();
        @SuppressWarnings("unchecked") Class<Pair<Integer, Integer>> pairClass = (Class<Pair<Integer, Integer>>)(Class<?>)Pair.class;
        Pair<Integer, Integer>[] edges = model.getEdges().toArray(pairClass);
        Integer[] lastPath = model.getLastPath().toArray(Integer.class);
        mapView.displayData(localities.toArray(Locality.class), edges, lastPath);
    }
}
