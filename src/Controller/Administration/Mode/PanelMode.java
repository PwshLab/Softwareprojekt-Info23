package src.Controller.Administration.Mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class PanelMode extends JPanel implements ActionListener
{

    public PanelMode()
    {
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

    protected abstract void initializeForm(JPanel formPanel);
    protected abstract void handleSubmit();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        handleSubmit();
    }
}
