package src.View.Screen;

import src.Model.Data.Locality.Locality;

import javax.swing.*;
import java.awt.*;

public class ListView extends JPanel
{
    String[] columnNames = {"Name", "Typ", "Beschreibung", "Position"};
    JScrollPane scrollPane;

    public ListView()
    {
        setOpaque(true);
        setVisible(true);
        displayData(new Locality[0]);
    }

    public void displayData(Locality[] localities)
    {
        if (scrollPane != null)
            remove(scrollPane);

        String[][] columnData = new String[localities.length][columnNames.length];
        for (int i = 0; i < localities.length; i++)
        {
            columnData[i][0] = localities[i].getName();
            columnData[i][1] = localities[i].getDescription();
            columnData[i][2] = localities[i].getType().toString();
            columnData[i][3] = localities[i].getPosition().toString();
        }

        JTable table = new JTable(columnData, columnNames);
        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
