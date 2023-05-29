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

    public PanelMode(EditingPanel editingPanel, String buttonLabel)
    {
        this.editingPanel = editingPanel;

        setOpaque(true);
        setVisible(true);

        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(550, 550));
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        JButton submitButton = new JButton(buttonLabel);
        submitButton.addActionListener(this);
        submitButton.setMaximumSize(new Dimension(100, 50));
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

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
