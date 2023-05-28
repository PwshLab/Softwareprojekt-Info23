package src.View.Window;

import src.Model.Model;
import src.View.Screen.ListView.ListView;
import src.View.Screen.MapView;
import src.View.Screen.PanelTitle;

import javax.swing.*;
import java.awt.*;

public class Administration extends JPanel
{
    private final Model model;
    private ListView listView;

    public Administration(Model model)
    {
        this.model = model;

        initializeAdministrationGUI();
    }

    // TODO: Finish implementing admin panel
    // TODO: Add login prompt to admin panel
    // TODO: Add ability to switch between panels
    public void initializeAdministrationGUI()
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

        panelLeft.add(new PanelTitle("Lokalitäten"));
        listView = new ListView(model);
        panelLeft.add(listView);

        panelRight.add(new PanelTitle("Bearbeitung"));
        //mapView = new MapView(model);
        //panelRight.add(mapView);

        setVisible(true);
    }

    public ListView getListView()
    {
        return listView;
    }
}
