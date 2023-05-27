package src.Controller.Navigation;

import src.Controller.Component.NumberField;
import src.Controller.Component.PointField;
import src.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchFilter extends JPanel implements ActionListener
{
    private final Model model;
    private final PointField pointField;
    private final NumberField numberField;

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
        pointField = new PointField("Position");
        upperCenter.add(pointField);
        numberField = new NumberField("Entfernung");
        upperCenter.add(numberField);
        add(centerPanel, BorderLayout.CENTER);

        JButton button = new JButton("Anwenden");
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.addActionListener(this);
        centerPanel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (pointField.hasError() || numberField.hasError())
        {
            model.resetFilterByDistance();
        }
    }
}
