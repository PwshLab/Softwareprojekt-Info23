package src.View.Window;

import src.Model.Data.Locality.Locality;
import src.Model.Data.Value.Pair;
import src.Model.Model;
import src.Model.Observer.Observer;
import src.View.Screen.ListView;
import src.View.Screen.MapView;

import javax.swing.*;
import java.awt.*;


public class Navigation extends JFrame implements Observer
{
    private final Model model;
    private JFrame frame;
    private ListView listView;
    private MapView mapView;

    public Navigation(Model model)
    {
        this.model = model;
        createNavigationGUI();
        update();
    }

    public void createNavigationGUI()
    {
        frame = new JFrame("Navigation");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        frame.setContentPane(mainPanel);

        mainPanel.setPreferredSize(new Dimension(1200, 600));
        mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new GridLayout());

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.GREEN);
        mainPanel.add(panelLeft);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBackground(Color.CYAN);
        mainPanel.add(panelRight);

        JLabel emptyLabel = new JLabel("Lorem Ipsum Dolor Sit Amet");
        //emptyLabel.setPreferredSize(new Dimension(1200, 600));
        //panelRight.add(emptyLabel, BorderLayout.CENTER);

        listView = new ListView();
        panelLeft.add(listView);
        //frame.getContentPane().add(listView, BorderLayout.WEST);
        //emptyLabel.add(listView, BorderLayout.WEST);
        //frame.setContentPane(listView);

        mapView = new MapView(400, 400);
        //mapView.setBackground(Color.BLUE);
        panelRight.add(mapView);

        frame.pack();
        frame.setVisible(true);
    }

    public void update()
    {
        Locality[] localities = model.getElements().toArray(Locality.class);
        listView.displayData(localities);

        @SuppressWarnings("unchecked") Class<Pair<Integer, Integer>> pairClass = (Class<Pair<Integer, Integer>>)(Class<?>)Pair.class;
        Pair<Integer, Integer>[] edges = model.getEdges().toArray(pairClass);
        Integer[] lastPath = model.getLastPath().toArray(Integer.class);
        mapView.displayData(localities, edges, lastPath);
    }
}
