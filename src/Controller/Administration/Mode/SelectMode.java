package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;
import src.Controller.Component.ModeField;

import javax.swing.*;
import java.awt.*;

public class SelectMode extends PanelMode
{
    private ModeField modeSelectField;

    public SelectMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Weiter", false);
        associatedMode = EditingMode.SELECT;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {
        formPanel.setLayout(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        modeSelectField = new ModeField("Bearbeitungsmodus:");
        formPanel.add(modeSelectField);
    }

    @Override
    protected void handleSubmit()
    {
        editingPanel.setEditingMode(modeSelectField.readData());
        System.out.println("Set editing mode to: " + modeSelectField.readData());
    }

    @Override
    public void resetPanel()
    {
        modeSelectField.resetData();
    }
}
