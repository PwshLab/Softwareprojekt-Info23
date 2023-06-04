package src.Controller.Component;

import src.Model.Data.Locality.LocalityType;

/**
 * Datenfeld fuer die Arten von Lokalitaeten
 */
public class TypeField extends SelectDataField<LocalityType, LocalityType>
{
    /**
     * Standardkonstruktor des TypeFields
     * @param fieldLabel Beschriftung des Datenfeldes
     */
    public TypeField(String fieldLabel)
    {
        super(fieldLabel);

        for (LocalityType type: LocalityType.values())
            comboBox.addItem(type);
        comboBox.setSelectedIndex(0);
    }

    @Override
    protected boolean checkError()
    {
        return false;
    }

    @Override
    protected LocalityType parseData()
    {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }

    @Override
    public void writeData(LocalityType newData)
    {
        comboBox.setSelectedItem(newData);
    }

}
