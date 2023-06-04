package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Abstrakte Klasse fuer einen Bearbeitungsmodus
 * des Administrations-Panels
 */
public abstract class PanelMode extends JPanel implements ActionListener
{
    protected final EditingPanel editingPanel;
    protected EditingMode associatedMode;
    private final JButton submitButton;

    /**
     * Standardkonstruktor eines PanelModes
     * @param editingPanel Referenz zum EditingPanel
     * @param buttonLabel Beschriftung des Absenden JButtons
     * @param canAbort Boolean, ob der Mode abgebrochen werden kann
     */
    public PanelMode(EditingPanel editingPanel, String buttonLabel, boolean canAbort)
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
        submitButton = new JButton(buttonLabel);
        submitButton.addActionListener(this);
        submitButton.setMaximumSize(new Dimension(100, 50));
        buttonPanel.add(submitButton);
        if (canAbort)
        {
            JButton abortButton = new JButton("Abbrechen");
            abortButton.addActionListener(new AbortHandler(editingPanel));
            abortButton.setMaximumSize(new Dimension(100, 50));
            buttonPanel.add(abortButton);
        }
        add(buttonPanel, BorderLayout.SOUTH);

        initializeForm(formPanel);
    }

    /**
     * Methode zum Ausgeben des zugehoerigen Enum Wertes aus EditingMode,
     * der dieses Panel beschreibt
     * @return Wert des EditingMode Enum
     */
    public EditingMode getAssociatedMode()
    {
        return associatedMode;
    }

    /**
     * Methode zum Initialisieren des Grafisch variierenden Teiles
     * eines Panels
     * @param formPanel JPanel, auf welchem das UI aufgebaut wird
     */
    protected abstract void initializeForm(JPanel formPanel);

    /**
     * Methode, die beim Betaetigen des Panels ausgefuehrt wird.
     * Die eingegebenen Daten sollen hier an das Bestaetigungspanel
     * weitergegeben werden
     */
    protected abstract void handleSubmit();

    /**
     * Methode, um die Beschriftung des Absenden JButtons aendert
     * @param newLabel Neue Beschriftung des Buttons
     */
    protected void setButtonLabel(String newLabel)
    {
        submitButton.setText(newLabel);
    }

    /**
     * Methode, um das Panel auf seinen Ursprungszustand zurueckzusetzen
     */
    public abstract void resetPanel();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        handleSubmit();
    }

    /**
     * Hilfsklasse, um das Abbrechen der Bearbeitung durchzufuehren
     */
    private static class AbortHandler implements ActionListener
    {
        private final EditingPanel editingPanel;

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
