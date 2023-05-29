package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class PanelMode extends JPanel implements ActionListener
{
    protected final EditingPanel editingPanel;
    protected EditingMode associatedMode;

    public PanelMode(EditingPanel editingPanel)
    {
        this.editingPanel = editingPanel;

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension());
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        add(formPanel);
        JButton submitButton = new JButton();
        submitButton.addActionListener(this);
        add(submitButton);

        initializeForm(formPanel);
    }

    public EditingMode getAssociatedMode()
    {
        return associatedMode;
    }

    protected abstract void initializeForm(JPanel formPanel);
    protected abstract void handleSubmit();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        handleSubmit();
    }
}
