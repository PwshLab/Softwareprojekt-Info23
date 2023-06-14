package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;
import src.Controller.Administration.LocalityForm;
import src.Controller.Component.WholeNumberField;
import src.Model.Data.Locality.Locality;

import javax.swing.*;
import java.awt.*;

/**
 * Bearbeitungsmodus des Administrations-Panels,
 * um Lokalitäten zu bearbeiten
 */
public class ModifyMode extends PanelMode
{
    private JPanel contentPanel;
    private WholeNumberField numberField;
    private LocalityForm localityForm;
    private boolean panelStatusEditing;

    /**
     * Standardkonstruktor des ModifyModes
     * @param editingPanel Referenz zum EditingPanel
     */
    public ModifyMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Weiter", true);
        associatedMode = EditingMode.MODIFY;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {
        formPanel.setLayout(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        contentPanel = new JPanel();
        formPanel.add(contentPanel);
        numberField = new WholeNumberField("Index der Lokalität");
        numberField.setPreferredSize(new Dimension(150, 25));
        contentPanel.add(numberField);
        panelStatusEditing = false;
        localityForm = new LocalityForm(editingPanel);
    }

    /**
     * Methode, um zwischen dem status für die Auswahl einer Lokalität
     * und dem eigentlichen bearbeiten zu wechseln
     */
    private void switchPanelStatus()
    {
        panelStatusEditing = true;
        contentPanel.remove(numberField);
        localityForm.setData(editingPanel.getLocality(numberField.readData()));
        contentPanel.add(localityForm, BorderLayout.CENTER);
        setButtonLabel("Absenden");
        revalidate();
        repaint();
    }

    @Override
    protected void handleSubmit()
    {
        if (!panelStatusEditing)
        {
            if (!numberField.hasError())
                if (editingPanel.checkIndexBounds(numberField.readData()))
                    switchPanelStatus();
                else
                    numberField.notifyError();
        }
        else
        {
            if (!localityForm.hasError())
            {
                int localityIndex = numberField.readData();
                Locality locality = localityForm.getData();
                editingPanel.setConfirmAction(
                        new ConfirmAction(
                                "Lokalität " + localityIndex + " überschreiben",
                                () -> editingPanel.modifyLocality(localityIndex, locality)
                        )
                );
            }
        }
    }

    @Override
    public void resetPanel()
    {
        panelStatusEditing = false;
        contentPanel.remove(localityForm);
        contentPanel.add(numberField);
        numberField.resetData();
        localityForm.resetData();
        setButtonLabel("Weiter");
    }
}
