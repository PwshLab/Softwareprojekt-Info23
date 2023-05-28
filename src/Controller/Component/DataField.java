package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class DataField<T> extends JPanel
{
    private final JPanel panel;

    // TODO : Fix JLabel and TextField misalignment
    public DataField(String fieldLabel)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(600, 19));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        JLabel label = new JLabel(fieldLabel);
        panel.add(label);
        add(panel, BorderLayout.WEST);
    }

    private void setError()
    {
        panel.setBackground(Color.RED);
    }

    private void clearError()
    {
        panel.setBackground(new JPanel().getBackground());
    }

    public boolean hasError()
    {
        if (checkError())
        {
            setError();
            return true;
        }
        else
        {
            clearError();
            return false;
        }
    }

    protected abstract boolean checkError();
    protected abstract T parseData();

    public T readData()
    {
        if (checkError())
            return null;
        else
            return parseData();
    }
}
