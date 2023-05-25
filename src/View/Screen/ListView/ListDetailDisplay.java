package src.View.Screen.ListView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;

public class ListDetailDisplay extends JPanel implements ListSelectionListener
{
    private final TableModel tableModel;
    private final ListDisplayField[] displayFields;
    private Class<?>[] columnClasses;

    public ListDetailDisplay(JTable table)
    {
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

        initializeDisplayFields();
    }

    private void initializeDisplayFields()
    {
        for (int i = 0; i < displayFields.length; i++)
        {
            displayFields[i] = new ListDisplayField(tableModel.getColumnName(i));
            add(displayFields[i]);
        }
    }

    private void getColumnClasses()
    {
        if (columnClasses != null)
            return;

        columnClasses = new Class<?>[tableModel.getColumnCount()];
        for (int i = 0; i < columnClasses.length; i++)
            columnClasses[i] = tableModel.getColumnClass(i);
    }

    //TODO : Fix mismatch between search and selection indices
    private void displayData(int index)
    {
        getColumnClasses();
        String columnContent;
        for (int i = 0; i < displayFields.length; i++)
        {
            if (index > 0)
            {
                columnContent = columnClasses[i].cast(tableModel.getValueAt(index, i)).toString();
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
        int firstIndex = e.getFirstIndex();
        displayData(firstIndex);

        System.out.println("First Index: " + firstIndex + " LSM Index: " + lsm.getLeadSelectionIndex());
    }
}
