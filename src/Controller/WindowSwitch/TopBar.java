package src.Controller.WindowSwitch;

import src.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel fuer die Ueberschrift des Fensters.
 * Enthaelt zusaetzlich den Anmeldebutton fuer die Administration
 */
public class TopBar extends JPanel implements ActionListener
{
    private final Controller controller;
    private final boolean isNavigation;
    private LoginPrompt loginPrompt;

    /**
     * Standardkonstruktor der TopBar
     * @param controller Referenz zum Controller
     * @param isNavigation Boolean, ob es im Navigation hinzugefuegt wird
     */
    public TopBar(Controller controller, boolean isNavigation)
    {
        this.controller = controller;
        this.isNavigation = isNavigation;

        initialize();
    }

    /**
     * Methode zum Initialisieren der Ueberschrift.
     * Der enthaltene Text ist abhaengig von der Anmeldung
     * des Administrators
     */
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
        button.addActionListener(this);
        add(button, BorderLayout.EAST);
        JLabel title;
        if (isNavigation)
            title = new JLabel("Search a Bar : Suche");
        else
            title = new JLabel("Search a Bar : Administration");
        title.setFont(title.getFont().deriveFont(18f));
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
