package src.Controller.Navigation;

import javax.swing.*;
import java.awt.*;

public class SearchFilter extends JPanel
{
    public SearchFilter()
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel label = new JLabel("Suche Begrenzen");
        add(label, BorderLayout.NORTH);
    }
}
