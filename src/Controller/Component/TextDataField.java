package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class TextDataField<T> extends DataField<T>
{
    protected JTextField textField;

    public TextDataField()
    {
        super();

        textField = new JTextField();
        add(textField, BorderLayout.CENTER);
    }
}
