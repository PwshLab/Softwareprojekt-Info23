package src.Controller.WindowSwitch;

import src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopBar extends JPanel implements ActionListener
{
    private final Controller controller;
    private final boolean isNavigation;
    private LoginPrompt loginPrompt;

    public TopBar(Controller controller, boolean isNavigation)
    {
        this.controller = controller;
        this.isNavigation = isNavigation;

        initialize();
    }

    private void initialize()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 25));
        setMaximumSize(new Dimension(1200, 25));
        JButton button;
        if (isNavigation)
            button = new JButton("Anmelden");
        else
            button = new JButton("Abmelden");
        add(button, BorderLayout.EAST);
        JLabel title = new JLabel("Search a Bar Software");
        title.setFont(title.getFont().deriveFont(16f));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (!isNavigation)
            controller.setWindowNavigation();
        else
            loginPrompt = new LoginPrompt(controller);
    }
}
