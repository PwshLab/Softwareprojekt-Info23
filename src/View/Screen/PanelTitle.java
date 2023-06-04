package src.View.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * Panel für den Titel einer Ansicht
 */
public class PanelTitle extends JPanel
{
    public PanelTitle(String titleString)
    {
        setOpaque(true);
        setMaximumSize(new Dimension(1200, 5));
        setBorder(BorderFactory.createBevelBorder(1));

        JLabel label = new JLabel(titleString);
        Font labelFont = new Font(label.getFont().getName(), 0, 20);
        label.setFont(labelFont);
        add(label);
    }
}
