package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;
import src.Controller.Administration.LocalityForm;
import src.Model.Data.Locality.Locality;

import javax.swing.*;
import java.awt.*;

/**
 * Bearbeitungsmodus des Administrations-Panels,
 * um Lokalitäten hinzuzufügen
 */
public class AddMode extends PanelMode
{
    private LocalityForm localityForm;

    public AddMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Absenden", true);
        associatedMode = EditingMode.ADD;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {
        formPanel.setLayout(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        localityForm = new LocalityForm(editingPanel);
        formPanel.add(localityForm, BorderLayout.CENTER);
    }

    @Override
    protected void handleSubmit()
    {
        if (!localityForm.hasError())
        {
            Locality locality = localityForm.getData();
            editingPanel.setConfirmAction(
                    new ConfirmAction(
                            "diese Lokalität hinzufügen",
                            () -> editingPanel.addLocality(locality)
                    )
            );
        }
    }

    @Override
    public void resetPanel()
    {
        localityForm.resetData();
    }
}
