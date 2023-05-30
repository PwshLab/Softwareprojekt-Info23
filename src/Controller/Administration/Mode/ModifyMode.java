package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;

public class ModifyMode extends PanelMode
{
    public ModifyMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Bearbeiten");
        associatedMode = EditingMode.MODIFY;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {

    }

    // TODO: Add confirmation panel integration
    @Override
    protected void handleSubmit()
    {

    }


}
