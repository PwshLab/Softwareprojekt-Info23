package src.View.Window;

import javax.swing.*;
import java.awt.*;

public class Navigation extends JFrame
{
    private JFrame frame;

    public Navigation()
    {
        createNavigationGUI();
    }

    public void createNavigationGUI()
    {
        frame = new JFrame("Navigation");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
