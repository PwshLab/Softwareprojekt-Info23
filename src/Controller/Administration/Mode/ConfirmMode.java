package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;

public class ConfirmMode extends PanelMode
{
    public ConfirmMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Bestätigen");
        associatedMode = EditingMode.CONFIRM;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {

    }

    @Override
    protected void handleSubmit()
    {

    }


}
