package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;
import src.Controller.Component.WholeNumberField;

import javax.swing.*;
import java.awt.*;

public class DeleteMode extends PanelMode
{
    private WholeNumberField numberField;

    public DeleteMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Entfernen");
        associatedMode = EditingMode.DELETE;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {
        formPanel.setLayout(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        numberField = new WholeNumberField("Index der Lokalität");
        numberField.setPreferredSize(new Dimension(150, 25));
        formPanel.add(numberField);
    }

    // TODO: Add confirmation panel integration
    @Override
    protected void handleSubmit()
    {
        if (!numberField.hasError())
            if (editingPanel.checkIndexBounds(numberField.readData()))
            {
                editingPanel.setConfirmAction(
                        new ConfirmAction(
                                "Lokalität " + numberField.readData() + " entfernen",
                                () -> editingPanel.removeLocality(numberField.readData())
                        )
                );
            }
            else
                numberField.notifyError();
    }
}
