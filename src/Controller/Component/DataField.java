package src.Controller.Component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class DataField<T> extends JPanel
{
    // TODO : Fix JLabel and TextField misalignment
    public DataField(String fieldLabel)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(600, 19));

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        JLabel label = new JLabel(fieldLabel);
        panel.add(label);
        add(panel, BorderLayout.WEST);
    }

    private void setError()
    {
        setBackground(Color.RED);
    }

    private void clearError()
    {
        setBackground(Color.WHITE);
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
