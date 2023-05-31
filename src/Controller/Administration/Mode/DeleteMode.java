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
        super(editingPanel, "Entfernen", true);
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

    @Override
    protected void handleSubmit()
    {
        if (!numberField.hasError())
            if (editingPanel.checkIndexBounds(numberField.readData()))
            {
                int localityIndex = numberField.readData();
                editingPanel.setConfirmAction(
                        new ConfirmAction(
                                "Lokalität " + numberField.readData() + " entfernen",
                                () -> editingPanel.removeLocality(localityIndex)
                        )
                );
            }
            else
                numberField.notifyError();
    }

    @Override
    public void resetPanel()
    {
        numberField.resetData();
    }
}
