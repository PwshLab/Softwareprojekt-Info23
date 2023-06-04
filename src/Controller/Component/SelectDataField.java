package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Abstrakte Klasse für ein Auswahldatenfeld
 * @param <T> Grundlegender Datentyp des Datenfeldes
 * @param <U> Anzuzeigender Datentyp bei der Auswahl
 */
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
        comboBox.setSelectedIndex(0);
    }
}
