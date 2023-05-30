package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmMode extends PanelMode
{
    private Runnable confirmAction;

    public ConfirmMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Bestätigen");
        associatedMode = EditingMode.CONFIRM;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        JButton submitButton = new JButton("Abbrechen");
        submitButton.addActionListener(new AbortHandler(editingPanel));
        submitButton.setMaximumSize(new Dimension(100, 50));
        buttonPanel.add(submitButton);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void handleSubmit()
    {

    }

    public void setConfirmAction(Runnable confirmAction)
    {
        this.confirmAction = confirmAction;
    }

    private class AbortHandler implements ActionListener
    {
        private EditingPanel editingPanel;

        public AbortHandler(EditingPanel editingPanel)
        {
            this.editingPanel = editingPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            editingPanel.setEditingMode(EditingMode.SELECT);
        }
    }
}
