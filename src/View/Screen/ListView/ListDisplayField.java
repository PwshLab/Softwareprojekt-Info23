package src.View.Screen.ListView;

import javax.swing.*;
import java.awt.*;

/**
 * Panel für ein Anzeigefeld der Detailansicht
 */
public class ListDisplayField extends JPanel
{
    private final JTextPane contentField;

    public ListDisplayField(String fieldLabel)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());

        JLabel labelField = new JLabel();
        labelField.setText(fieldLabel);
        labelField.setBackground(Color.LIGHT_GRAY);
        labelField.setOpaque(true);
        labelField.setBorder(BorderFactory.createBevelBorder(0));
        add(labelField, BorderLayout.NORTH);

        contentField = new JTextPane();
        contentField.setText(" ");
        contentField.setEditable(false);
        contentField.setBorder(BorderFactory.createBevelBorder(0));
        add(contentField, BorderLayout.CENTER);
    }

    /**
     * Methode zum Festlegen des Wertes des Anzeigefeldes
     * @param content
     */
    public void setContent(String content)
    {
        contentField.setText(content);
    }
}
