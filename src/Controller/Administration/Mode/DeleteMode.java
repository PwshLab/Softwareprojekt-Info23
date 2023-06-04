package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;
import src.Controller.Component.WholeNumberField;

import javax.swing.*;
import java.awt.*;


/**
 * Bearbeitungsmodus des Administrations-Panels,
 * um Lokalitaeten zu entfernen
 */
public class DeleteMode extends PanelMode
{
    private WholeNumberField numberField;

    /**
     * Standardkonstruktor des DeleteModes
     * @param editingPanel Referenz zum EditingPanel
     */
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
        numberField = new WholeNumberField("Index der Lokalitaet");
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
                                "Lokalitaet " + numberField.readData() + " entfernen",
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
