package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class DataField<T> extends JPanel
{
    private boolean isError;

    public DataField()
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

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
