package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

public abstract class TextDataField<T> extends DataField<T>
{
    protected JTextField textField;

    public TextDataField(String fieldLabel, boolean isPasswordField)
    {
        super(fieldLabel);

        if (isPasswordField)
            textField = new JPasswordField();
        else
            textField = new JTextField();
        JPanel panel = new JPanel();
        panel.add(textField, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel.setLayout(new GridLayout());
        add(panel);
    }
}
