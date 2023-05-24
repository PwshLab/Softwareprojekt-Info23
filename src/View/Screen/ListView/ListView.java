package src.View.Screen.ListView;

import src.Model.Model;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ListView extends JPanel
{
    private JTable table;
    private TableRowSorter<ListTableModel> rowSorter;

    public ListView(Model model)
    {
        initialize();
        initializeSorter(model);
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

    private void initializeSorter(Model model)
    {
        ListTableModel tableModel = new ListTableModel(model);
        rowSorter = new TableRowSorter<>();
        rowSorter.setModel(tableModel);
        table.setModel(tableModel);
        table.setRowSorter(rowSorter);
    }

    public void setSearchString(String searchString)
    {
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchString));
    }
    //TODO : Add information block for selected entry
}
