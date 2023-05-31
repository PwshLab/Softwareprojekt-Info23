package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class SelectDataField<T, U> extends DataField<T>
{
    protected JComboBox<U> comboBox;

    public SelectDataField(String fieldLabel)
    {
        super(fieldLabel);

        comboBox = new JComboBox<>();
        comboBox.setEditable(false);
        add(comboBox, BorderLayout.CENTER);
    }

    @Override
    public void resetData()
    {
    }
}
