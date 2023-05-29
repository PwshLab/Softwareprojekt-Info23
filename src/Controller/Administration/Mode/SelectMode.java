package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;

public class SelectMode extends PanelMode
{
    public SelectMode(EditingPanel editingPanel)
    {
        super(editingPanel);
        associatedMode = EditingMode.SELECT;
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
