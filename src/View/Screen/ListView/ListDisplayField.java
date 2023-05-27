package src.View.Screen.ListView;

import javax.swing.*;

public class ListDisplayField extends JPanel
{
    private final JLabel contentField;

    public ListDisplayField(String fieldLabel)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel labelField = new JLabel();
        labelField.setText(fieldLabel);
        add(labelField);

        contentField = new JLabel();
        contentField.setText(" ");
        add(contentField);
    }

    public void setContent(String content)
    {
        contentField.setText(content);
    }
}
