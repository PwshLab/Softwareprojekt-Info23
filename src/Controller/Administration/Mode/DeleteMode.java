package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;

public class DeleteMode extends PanelMode
{
    public DeleteMode(EditingPanel editingPanel)
    {
        super(editingPanel);
        associatedMode = EditingMode.DELETE;
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
