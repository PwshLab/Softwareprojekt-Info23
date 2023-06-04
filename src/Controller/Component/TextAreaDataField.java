package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Abstrakte Klasse fuer ein Datenfeld mit mehreren Zeilen
 * @param <T> Datentyp des Datenfeldes
 */
public abstract class TextAreaDataField<T> extends DataField<T>
{
    protected JTextArea textArea;

    public TextAreaDataField(String fieldLabel)
    {
        super(fieldLabel);

        textArea = new JTextArea();
        JPanel panel = new JPanel();
        panel.add(textArea, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel.setLayout(new GridLayout());
        add(panel);
    }

    @Override
    public void resetData()
    {
        textArea.setText("");
    }
}
