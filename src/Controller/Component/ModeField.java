package src.Controller.Component;

import src.Controller.Administration.EditingMode;

public class ModeField extends SelectDataField<EditingMode, String>
{
    String[] modeLabels = {"", "Hinzufügen", "Bearbeiten", "Entfernen", ""};

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
        return EditingMode.values()[comboBox.getSelectedIndex()];
    }

}
