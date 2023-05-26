package src.View.Screen.ListView;

import src.Model.Model;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import java.awt.*;

public class ListView extends JPanel implements DocumentListener
{
    private JTable table;
    private TableRowSorter<ListTableModel> rowSorter;
    private JTextField textField;

    public ListView(Model model)
    {
        initialize(model);
    }

    private void initialize(Model model)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        initializeTable();
        initializeSorter(model);
        initializeTextField();
        initializeDetailDisplay();
    }

    private void initializeTable()
    {
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

    private void initializeTextField()
    {
        textField = new JTextField();
        textField.getDocument().addDocumentListener(this);
        textField.setMaximumSize(new Dimension(600, 5));
        add(textField);
    }

    private void initializeDetailDisplay()
    {
        ListDetailDisplay display = new ListDetailDisplay(table);
        add(display);
    }

    private void setSearchString(String searchString)
    {
        int[] searchIndices = {0, 1, 2, 3};
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchString, searchIndices));
    }

    private void handleDocumentEvent(DocumentEvent e)
    {
        String searchText = textField.getText();
        if (searchText.length() > 0)
            setSearchString(searchText);
        else
            setSearchString("");
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        handleDocumentEvent(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        handleDocumentEvent(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        handleDocumentEvent(e);
    }
}
