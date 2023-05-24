package src.View.Screen.ListView;

import src.Model.Data.LinkedList.List;
import src.Model.Data.LinkedList.SortedList;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityOrder;
import src.Model.Model;
import src.Model.Observer.Observer;

import javax.swing.table.AbstractTableModel;

public class ListTableModel extends AbstractTableModel implements Observer
{
    private Model model;
    private static final String[] columnNames = {"Index", "Name", "Beschreibung", "Typ", "Position"};
    private List<Locality> orderedData;
    private String[][] formattedData;
    private String[][] filteredData;
    private int currentOrder;
    private String currentSearch;

    public ListTableModel(Model model)
    {
        this.model = model;
        this.currentOrder = 1;
        this.currentSearch = "";
        model.addObserver(this);
        updateOrderedData();
    }

    @Override
    public int getRowCount()
    {
        return filteredData.length;
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
        return filteredData[rowIndex][columnIndex];
    }

    @Override
    public void update()
    {
        updateOrderedData();
        fireTableStructureChanged();
    }

    private void updateOrderedData()
    {
        // 1: Sortierung nach der Nummerierung
        // 2: Sortierung nach dem Namen
        // 3: Sortierung nach dem Typen

        int orderingType = Math.abs(currentOrder);
        List<Locality> sortedEntries = switch (orderingType)
        {
            case 2 -> new SortedList<>(model.getElements(), LocalityOrder::ByName);
            case 3 -> new SortedList<>(model.getElements(), LocalityOrder::ByType);
            default -> model.getElements();
        };

        // Negativer Wert: Umgekehrte Sortierung
        if (currentOrder < 0)
            sortedEntries = sortedEntries.reversed();

        orderedData = sortedEntries;
        updateFormattedData();
    }

    private void updateFormattedData()
    {
        if (orderedData == null)
            return;

        formattedData = new String[orderedData.count()][columnNames.length];
        int index = 0;
        for (Locality l: orderedData)
        {
            formattedData[index][0] = Integer.toString(index);
            formattedData[index][1] = l.getName();
            formattedData[index][2] = l.getDescription();
            formattedData[index][3] = l.getType().toString();
            formattedData[index][4] = l.getPosition().toString();
            index++;
        }
        updateFilteredData();
    }

    private void updateFilteredData()
    {
        if (formattedData == null)
            return;

        if (currentSearch.length() < 1)
        {
            filteredData = formattedData;
        }
        else
        {
            List<Integer> columnIndices = new List<>();
            for (int i = 0; i < formattedData.length; i++)
            {
                boolean contains = false;
                for (String column: formattedData[i])
                    contains = contains || column.contains(currentSearch);
                if (contains)
                    columnIndices.add(i);
            }

            filteredData = new String[columnIndices.count()][columnNames.length];
            int index = 0;
            for (Integer i: columnIndices) {
                filteredData[index] = formattedData[i];
                index++;
            }
        }
    }

    public void setCurrentOrder(int newOrder)
    {
        if (Math.abs(currentOrder) == newOrder)
        {
            currentOrder *= -1;
        }
        else
        {
            currentOrder = newOrder;
        }
        updateOrderedData();
        fireTableDataChanged();
    }

    public void setCurrentSearch(String newSearch)
    {
        currentSearch = newSearch;
        updateFilteredData();
        fireTableDataChanged();
    }
}
