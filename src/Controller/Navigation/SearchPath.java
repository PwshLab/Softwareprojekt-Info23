package src.Controller.Navigation;

import src.Controller.Component.WholeNumberField;
import src.Model.Data.LinkedList.List;
import src.Model.Data.Locality.Locality;
import src.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPath extends JPanel implements ActionListener
{
    private final Model model;
    private final WholeNumberField field1, field2;
    private final TextArea textArea;

    public SearchPath(Model model)
    {
        this.model = model;

        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel label = new JLabel("Kürzesten Weg Suchen");
        add(label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        JPanel upperCenter = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));
        centerPanel.add(upperCenter);
        upperCenter.setLayout(new BoxLayout(upperCenter, BoxLayout.X_AXIS));
        field1 = new WholeNumberField("Start Index");
        upperCenter.add(field1);
        field2 = new WholeNumberField("End Index");
        upperCenter.add(field2);
        add(centerPanel, BorderLayout.CENTER);

        textArea = new TextArea();
        textArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(textArea, BorderLayout.CENTER);

        JButton button = new JButton("Suchen");
        buttonPanel.add(button, BorderLayout.EAST);
        button.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        button.setMaximumSize(new Dimension(50, 30));
        button.addActionListener(this);
        centerPanel.add(buttonPanel);

        displayPath(new List<>());
    }

    private void displayPath(List<Integer> path)
    {
        StringBuilder pathString = new StringBuilder("Kürzester Weg: ");
        for (Integer i: path)
            pathString.append(i).append(", ");
        if (pathString.lastIndexOf(",") >= 0)
            pathString.deleteCharAt(pathString.lastIndexOf(","));
        textArea.setText(pathString.toString());
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (!(field1.hasError() || field2.hasError()))
        {
            int startIndex = field1.readData();
            int endIndex = field2.readData();
            Locality l1, l2;
            try
            {
                l1 = model.getElements().get(startIndex);
                l2 = model.getElements().get(endIndex);
            } catch (IndexOutOfBoundsException exception)
            {
                displayPath(new List<>());
                return;
            }
            List<Integer> path =  model.getPath(l1, l2);
            displayPath(path);
        }
        else
            displayPath(new List<>());
    }
}
