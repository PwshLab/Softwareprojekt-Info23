package src.View.Window;

import src.Model.Model;
import src.Model.Observer.Observer;

import javax.swing.*;
import java.awt.*;


public class Navigation extends JFrame implements Observer
{
    private Model model;
    private JFrame frame;

    public Navigation(Model model)
    {
        this.model = model;
        createNavigationGUI();
    }

    public void createNavigationGUI()
    {
        frame = new JFrame("Navigation");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(1200, 600));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public void update()
    {
    }
}
