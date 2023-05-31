package src.Controller.WindowSwitch;

import src.Controller.Component.TextField;
import src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class LoginPrompt implements ActionListener
{
    private final Controller controller;
    private final JPanel loginPanel;
    private JButton loginButton;
    private TextField loginField;

    private static final String loginPassword = "Passwort1234";

    public LoginPrompt(Controller controller)
    {
        this.controller = controller;

        JFrame loginFrame = new JFrame("Anmeldung");
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
        loginPanel = new JPanel();
        loginFrame.setContentPane(loginPanel);

        // TODO: Add custom window listener that only closes login window
        //loginFrame.addWindowListener();

        initialize();

        loginFrame.pack();
    }

    private void initialize()
    {
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setPreferredSize(new Dimension(200, 150));
        loginField = new TextField("Passwort", true);
        loginPanel.add(loginField, BorderLayout.CENTER);
        JButton button = new JButton("Anmelden");
        button.addActionListener(this);
        loginPanel.add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (loginField.readData().equals(loginPassword))
            controller.setAdministrationWindow();
        else
            loginField.notifyError();
    }
}
