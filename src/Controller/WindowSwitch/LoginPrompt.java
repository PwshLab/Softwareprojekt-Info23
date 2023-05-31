package src.Controller.WindowSwitch;

import src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPrompt implements ActionListener
{
    private final Controller controller;
    private final JPanel loginPanel;
    private JButton loginButton;

    public LoginPrompt(Controller controller)
    {
        this.controller = controller;

        JFrame loginFrame = new JFrame("Anmeldung");
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
        loginPanel = new JPanel();
        loginFrame.setContentPane(loginPanel);
        loginFrame.pack();

        initialize();
    }

    private void initialize()
    {
        loginPanel.setPreferredSize(new Dimension(200, 150));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
