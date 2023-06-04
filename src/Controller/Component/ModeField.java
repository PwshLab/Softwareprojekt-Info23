package src.Controller.Component;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

/**
 * Auswahldatenfeld fuer Bearbeitungsmodi
 */
public class ModeField extends SelectDataField<EditingMode, String>
{
    private static final String[] modeLabels = {"", "Hinzufuegen", "Bearbeiten", "Entfernen", ""};

    /**
     * Standardkonstruktor des ModeFields
     * @param fieldLabel Beschriftung des Datenfeldes
     */
    public ModeField(String fieldLabel)
    {
        super(fieldLabel);

        EditingMode[] editingModes = EditingMode.values();
        for (int i = 1; i < editingModes.length - 1; i++)
            comboBox.addItem(modeLabels[i]);
        comboBox.setSelectedIndex(0);
    }

    @Override
    protected boolean checkError()
    {
        return false;
    }

    @Override
    protected EditingMode parseData()
    {
        return EditingMode.values()[comboBox.getSelectedIndex() + 1];
    }

    @Override
    public void writeData(EditingMode newData)
    {
        int newIndex = EditingPanel.editingModeToPanelIndex(newData);
        newIndex = Math.min(newIndex, EditingMode.values().length);
        newIndex = Math.max(newIndex, 0);
        comboBox.setSelectedIndex(newIndex);
    }

}
