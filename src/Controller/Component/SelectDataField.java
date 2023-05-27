package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class SelectDataField<T> extends DataField<T>
{
    protected JComboBox<T> comboBox;

    public SelectDataField()
    {
        super();

        comboBox = new JComboBox<>();
        add(comboBox, BorderLayout.CENTER);
    }
}
