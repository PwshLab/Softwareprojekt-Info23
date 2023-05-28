package src.View.Screen.ListView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;

public class ListDetailDisplay extends JPanel implements ListSelectionListener
{
    private final JTable table;
    private final TableModel tableModel;
    private final ListDisplayField[] displayFields;
    private Class<?>[] columnClasses;

    public ListDetailDisplay(JTable table)
    {
        this.table = table;
        this.tableModel = table.getModel();
        this.displayFields = new ListDisplayField[tableModel.getColumnCount()];
        this.columnClasses = null;

        table.getSelectionModel().addListSelectionListener(this);

        initialize();
    }

    private void initialize()
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new GridLayout());
        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //setLayout(new FlowLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        initializeDisplayFields();
    }

    private void initializeDisplayFields()
    {
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.Y_AXIS));
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new GridLayout());

        for (int i = 0; i < displayFields.length; i++)
        {
            displayFields[i] = new ListDisplayField(tableModel.getColumnName(i));
            if (i != 2)
                valuePanel.add(displayFields[i]);
            else
                descriptionPanel.add(displayFields[i]);
        }
        add(valuePanel);
        add(descriptionPanel);
    }

    private void getColumnClasses()
    {
        if (columnClasses != null)
            return;

        columnClasses = new Class<?>[tableModel.getColumnCount()];
        for (int i = 0; i < columnClasses.length; i++)
            columnClasses[i] = tableModel.getColumnClass(i);
    }

    private void displayData(int index)
    {
        getColumnClasses();
        String columnContent;
        for (int i = 0; i < displayFields.length; i++)
        {
            if (index >= 0 && index < table.getRowCount())
            {
                columnContent = columnClasses[i].cast(table.getValueAt(index, i)).toString();
                displayFields[i].setContent(columnContent);
            }
            else
                displayFields[i].setContent("");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        int selectedIndex = lsm.getLeadSelectionIndex();
        displayData(selectedIndex);
    }
}
