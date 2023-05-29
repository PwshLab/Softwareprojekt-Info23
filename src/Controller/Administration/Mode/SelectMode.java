package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;
import src.Controller.Component.ModeField;
import src.Controller.Component.SelectDataField;

import javax.swing.*;
import java.awt.*;

public class SelectMode extends PanelMode
{
    private ModeField modeSelectField;

    public SelectMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Weiter");
        associatedMode = EditingMode.SELECT;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {
        formPanel.setLayout(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        modeSelectField = new ModeField("Bearbeitungsmodus:");
    }

    @Override
    protected void handleSubmit()
    {
        editingPanel.setEditingMode(modeSelectField.readData());
    }
}
