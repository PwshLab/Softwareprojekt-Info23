package src.View.Screen.ListView;

import src.Model.Model;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ListView extends JPanel
{
    private JTable table;

    public ListView(Model model)
    {
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
        RowSorter<ListTableModel> rowSorter = new TableRowSorter<>();
        table.setRowSorter(rowSorter);
    }

    //TODO : Implement searching and sorting by attributes
    //TODO : Add information block for selected entry
}
