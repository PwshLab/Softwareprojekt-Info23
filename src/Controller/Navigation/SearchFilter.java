package src.Controller.Navigation;

import src.Controller.Component.NumberField;
import src.Controller.Component.WholeNumberField;
import src.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Eingabe-Panel um die Suche nach Lokalitäten auf einen bestimmten Radius
 * um eine andere Lokalität zu begrenzen
 */
public class SearchFilter extends JPanel implements ActionListener
{
    private final Model model;
    private final WholeNumberField indexField;
    private final NumberField distanceField;

    public SearchFilter(Model model)
    {
        this.model = model;

        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel label = new JLabel("Suche Begrenzen");
        add(label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        JPanel upperCenter = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));
        centerPanel.add(upperCenter);
        upperCenter.setLayout(new BoxLayout(upperCenter, BoxLayout.X_AXIS));
        indexField = new WholeNumberField("Lokalität");
        upperCenter.add(indexField);
        distanceField = new NumberField("Entfernung");
        upperCenter.add(distanceField);
        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Anwenden");
        buttonPanel.add(button);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setMaximumSize(new Dimension(50, 30));
        button.addActionListener(this);
        centerPanel.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (indexField.hasError() || distanceField.hasError())
        {
            model.resetFilterByDistance();
        }
        else
        {
            int index = indexField.readData();
            if (model.checkIndexBounds(index))
                model.setFilterByDistance(model.getElements().get(index).getPosition(), distanceField.readData());
            else
                indexField.notifyError();
        }
    }
}
