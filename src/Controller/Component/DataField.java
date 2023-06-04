package src.Controller.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Abstrakte Klasse für ein generelles Eingabefeld
 * @param <T> Beliebiger Datentyp des Eingabefelds
 */
public abstract class DataField<T> extends JPanel
{
    private final JPanel panel;

    // TODO : Fix JLabel and TextField misalignment (medium priority)
    // Possibly left align jLabel

    /**
     * Standardkonstruktor eines DataFields
     * @param fieldLabel Datenfeld beschriftung
     */
    public DataField(String fieldLabel)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(600, 19));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        JLabel label = new JLabel(fieldLabel);
        //label.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(label);
        add(panel, BorderLayout.WEST);
    }

    /**
     * Methode, um festzulegen, dass das Eingabefeld einen Fehler enthält
     */
    private void setError()
    {
        panel.setBackground(Color.RED);
    }

    /**
     * Methode, um den Fehlerstatus des Eingabefeldes zurückzusetzen
     */
    private void clearError()
    {
        panel.setBackground(new JPanel().getBackground());
    }

    /**
     * Methode zum Ausgeben, ob das Eingabefeld einen Fehler enthält
     * @return Boolean, ob das Eingabefeld einen Fehler enthält
     */
    public boolean hasError()
    {
        if (checkError())
        {
            setError();
            return true;
        }
        else
        {
            clearError();
            return false;
        }
    }

    /**
     * Methode zum Überprüfen, ob das Eingabefeld einen Fehler enthält
     * @return Boolean, ob das Eingabefeld einen Fehler enthält
     */
    protected abstract boolean checkError();

    /**
     * Methode zum Zurückgeben der Daten im Eingabefeld
     * @return Daten des Eingabefeldes
     */
    protected abstract T parseData();

    /**
     * Methode zum Ausgeben der Daten im Eingabefeld
     * @return Daten des Eingabefeldes
     */
    public T readData()
    {
        if (checkError())
            return null;
        else
            return parseData();
    }

    /**
     * Methode zum Setzen der Daten im Eingabefeld
     * @param newData Daten mit dem Datentyp des Eingabefeldes
     */
    public abstract void writeData(T newData);

    /**
     * Methode zum Zurücksetzen der Daten des Eingabefeldes
     */
    public abstract void resetData();

    /**
     * Methode, um dem Eingabefeld mitzuteilen, dass
     * außerhalb ein fehler mit den zurückgegebenen
     * Daten festgestellt wurde
     */
    public void notifyError()
    {
        setError();
    }
}
