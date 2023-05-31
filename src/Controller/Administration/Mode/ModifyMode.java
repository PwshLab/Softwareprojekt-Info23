package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;
import src.Controller.Administration.LocalityForm;
import src.Controller.Component.WholeNumberField;

import javax.swing.*;
import java.awt.*;

public class ModifyMode extends PanelMode
{
    private JPanel contentPanel;
    private WholeNumberField numberField;
    private LocalityForm localityForm;
    private boolean panelStatusEditing;

    public ModifyMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Absenden");
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
    }

    private void switchPanelStatus()
    {
        panelStatusEditing = true;
        contentPanel.remove(numberField);
        localityForm = new LocalityForm();
        localityForm.setData(editingPanel.getLocality(numberField.readData()));
        contentPanel.add(localityForm, BorderLayout.CENTER);
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
                editingPanel.setConfirmAction(
                        new ConfirmAction(
                                "Lokalität " + numberField.readData() + " überschreiben",
                                () -> editingPanel.modifyLocality(numberField.readData(), localityForm.getData())
                        )
                );
            }
        }
    }
}
