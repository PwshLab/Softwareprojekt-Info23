package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class SelectDataField<T> extends DataField<T>
{
    protected JComboBox<T> comboBox;

    public SelectDataField(String fieldLabel)
    {
        super(fieldLabel);

        comboBox = new JComboBox<>();
        comboBox.setEditable(false);
        add(comboBox, BorderLayout.CENTER);
    }
}
