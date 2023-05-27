package src.Controller.Component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class DataField<T> extends JPanel
{
    private boolean isError;

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

        isError = false;
    }

    private void setError()
    {
        isError = true;
        setBackground(Color.RED);
    }

    private void clearError()
    {
        isError = false;
        setBackground(Color.WHITE);
    }

    public boolean hasError()
    {
        checkError();
        return isError;
    }

    protected abstract boolean checkError();
    protected abstract T parseData();

    public T readData()
    {
        if (checkError())
        {
            setError();
            return null;
        }
        else
        {
            clearError();
            return parseData();
        }
    }
}
