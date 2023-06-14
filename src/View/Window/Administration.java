package src.View.Window;

import src.Controller.Administration.EditingPanel;
import src.Model.Model;
import src.View.Screen.ListView.ListView;
import src.View.Screen.PanelTitle;

import javax.swing.*;
import java.awt.*;

/**
 * Panel der Administrationsansicht
 */
public class Administration extends JPanel
{
    private final Model model;
    private ListView listView;

    /**
     * Standardkonstruktor der Administration
     * @param model Referenz zum Model
     */
    public Administration(Model model)
    {
        this.model = model;

        initializeAdministrationGUI();
    }

    /**
     * Methode zum Initialisieren der Administrationsansicht
     */
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
        EditingPanel editingPanel = new EditingPanel(model);
        panelRight.add(editingPanel);

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
}
