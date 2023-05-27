package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class TextDataField<T> extends DataField<T>
{
    protected JTextField textField;

    public TextDataField(String fieldLabel)
    {
        super(fieldLabel);

        textField = new JTextField();
        JPanel panel = new JPanel();
        panel.add(textField, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel.setLayout(new GridLayout());
        add(panel);
    }
}
