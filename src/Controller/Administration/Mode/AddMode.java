package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;

public class AddMode extends PanelMode
{
    public AddMode(EditingPanel editingPanel)
    {
        super(editingPanel);
        associatedMode = EditingMode.ADD;
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
