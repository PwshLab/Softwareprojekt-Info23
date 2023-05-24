package src.View.Screen;

import src.Model.Data.LinkedList.List;
import src.Model.Data.LinkedList.SortedList;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityOrder;

import javax.swing.*;
import java.awt.*;

public class ListView extends JPanel
{
    private static final String[] columnNames = {"Index", "Name", "Typ", "Beschreibung", "Position"};
    private JScrollPane scrollPane;
    private int currentOrder;
    private String currentSearch;
    private int currentSearchColumn;
    private List<Locality> unorderedData;
    private List<Locality> orderedData;
    private String[][] formattedData;
    private String[][] filteredData;

    public ListView()
    {
        this.scrollPane = null;
        this.currentOrder = 1;
        this.currentSearch = "";
        this.currentSearchColumn = 1;
        this.unorderedData = null;
        this.orderedData = null;
        this.formattedData = null;
        this.filteredData = null;

        initialize();
    }

    private void initialize()
    {
        setOpaque(true);
        setVisible(true);
        displayData();
    }

    public void setViewData(List<Locality> localities)
    {
        unorderedData = localities;
        orderData();
    }

    public void setCurrentOrder(int newOrderType)
    {
        if (Math.abs(currentOrder) == newOrderType)
        {
            currentOrder *= -1;
        }
        else
        {
            currentOrder = newOrderType;
        }
        orderData();
    }

    private void orderData()
    {
        // 1: Sortierung nach der Nummerierung
        // 2: Sortierung nach dem Namen
        // 3: Sortierung nach dem Typen

        if (unorderedData == null)
            return;

        int orderingType = Math.abs(currentOrder);
        List<Locality> sortedEntries = switch (orderingType)
        {
            case 2 -> new SortedList<>(unorderedData, LocalityOrder::ByName);
            case 3 -> new SortedList<>(unorderedData, LocalityOrder::ByType);
            default -> new List<>(unorderedData);
        };

        // Negativer Wert: Umgekehrte Sortierung
        if (currentOrder < 0)
            sortedEntries = sortedEntries.reversed();

        orderedData = sortedEntries;
        formatData();
    }

    private void formatData()
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
        filterData();
    }

    public void setCurrentSearch(String search)
    {
        currentSearch = search;
        filterData();
    }

    public void setCurrentSearchColumn(int column)
    {
        currentSearchColumn = column;
        filterData();
    }

    private void filterData()
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
                if (formattedData[i][currentSearchColumn].contains(currentSearch))
                    columnIndices.add(i);

            filteredData = new String[columnIndices.count()][columnNames.length];
            int index = 0;
            for (Integer i: columnIndices) {
                filteredData[index] = formattedData[i];
                index++;
            }
        }
        displayData();
    }

    //TODO : Implement searching and sorting by attributes
    //TODO : Add information block for selected entry
    public void displayData()
    {
        if (scrollPane != null)
            remove(scrollPane);

        JTable table;
        if (filteredData == null)
            table = new JTable(new String[0][0], columnNames);
        else
            table = new JTable(filteredData, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setCellSelectionEnabled(false);

        scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
