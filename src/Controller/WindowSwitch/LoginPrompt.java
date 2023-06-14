package src.Controller.WindowSwitch;

import src.Controller.Component.TextField;
import src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Eingabe-Panel für den Administrator Zugang
 */
public class LoginPrompt implements ActionListener
{
    private final Controller controller;
    private final JFrame loginFrame;
    private final JPanel loginPanel;
    private TextField loginField;

    private static final String loginPassword = "Passwort1234";

    /**
     * Standardkonstruktor des LoginPrompt
     * @param controller Referenz zum Controller
     */
    public LoginPrompt(Controller controller)
    {
        this.controller = controller;

        loginFrame = new JFrame("Anmeldung");
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
        loginPanel = new JPanel();
        loginFrame.setContentPane(loginPanel);

        initialize();

        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }

    /**
     * Methode zum Initialisieren des Login-Panels
     */
    private void initialize()
    {
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        loginField = new TextField("Passwort", true);
        loginField.addActionListener(this);
        loginPanel.add(loginField, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("Anmelden");
        buttonPanel.add(button);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        button.addActionListener(this);
        loginPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (loginField.readData().equals(loginPassword))
        {
            controller.setAdministrationWindow();
            loginFrame.dispose();
        }
        else
            loginField.notifyError();
    }
}
