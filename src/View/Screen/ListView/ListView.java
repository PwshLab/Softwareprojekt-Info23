package src.View.Screen.ListView;

import src.Model.Data.LinkedList.List;
import src.Model.Data.LinkedList.SortedList;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityOrder;
import src.Model.Model;
import src.Model.Observer.Observer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ListView extends JPanel
{
    private JTable table;
    private RowSorter<ListTableModel> rowSorter;
    private int currentOrder;
    private String currentSearch;

    public ListView(Model model)
    {
        this.currentOrder = 1;
        this.currentSearch = "";

        initialize();
        table.setModel(new ListTableModel(model));
    }

    private void initialize()
    {
        setOpaque(true);
        setVisible(true);

        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDragEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private void initializeSorter()
    {
        rowSorter = new TableRowSorter<>();
        table.setRowSorter(rowSorter);
    }

    //TODO : Implement searching and sorting by attributes
    //TODO : Add information block for selected entry
    public void displayData()
    {

    }
}
