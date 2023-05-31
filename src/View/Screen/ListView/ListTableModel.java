package src.View.Screen.ListView;

import src.Model.Data.LinkedList.List;
import src.Model.Data.Locality.Locality;
import src.Model.Model;
import src.Model.Observer.Observer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ListTableModel extends AbstractTableModel implements Observer
{
    private final Model model;
    private static final String[] columnNames = {"Index", "Name", "Beschreibung", "Typ", "Position"};
    private Object[][] data;

    public ListTableModel(Model model)
    {
        this.model = model;
        model.addObserver(this);
        updateData();
    }

    @Override
    public int getRowCount()
    {
        return data.length;
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void update()
    {
        updateData();

        // TODO: Fix Threading error when update is called (low priority)
        // Ohne warten gibt es beim Darstellen der Tabelle
        // ab und an ArrayIndex Fehler

        /*
        try {
            SwingUtilities.invokeAndWait(() -> {fireTableStructureChanged();});
        } catch (InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
         */
        SwingUtilities.invokeLater(this::fireTableStructureChanged);
        //fireTableStructureChanged();
    }

    private void updateData()
    {
        List<Locality> localities = model.getElements();
        List<Locality> localitiesFiltered = model.getElementsFiltered();
        data = new Object[localitiesFiltered.count()][columnNames.length];
        int index = 0;
        for (Locality l: localitiesFiltered)
        {
            data[index][0] = localities.indexOf(l, Object::equals);
            data[index][1] = l.getName();
            data[index][2] = l.getDescription();
            data[index][3] = l.getType().toString();
            data[index][4] = l.getPosition().toString();
            index++;
        }
    }

    @Override
    public Class<?> getColumnClass(int column)
    {
        return column == 0 ? Integer.class : String.class;
    }
}
