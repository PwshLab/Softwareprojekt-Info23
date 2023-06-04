package src.Controller.Administration.Mode;

import src.Controller.Administration.EditingMode;
import src.Controller.Administration.EditingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Collections;

/**
 * Bearbeitungsmodus des Administrations-Panels,
 * um die vorhergegangene Bearbeitung zu bestaetigen
 */
public class ConfirmMode extends PanelMode
{
    private JTextPane confirmDisplay;
    private ConfirmAction confirmAction;

    /**
     * Standardkonstruktor des ConfirmModes
     * @param editingPanel Referenz zum EditingPanel
     */
    public ConfirmMode(EditingPanel editingPanel)
    {
        super(editingPanel, "Bestaetigen", true);
        associatedMode = EditingMode.CONFIRM;
    }

    @Override
    protected void initializeForm(JPanel formPanel)
    {
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        JPanel confirmPanel = new JPanel();
        confirmPanel.setBorder(BorderFactory.createBevelBorder(0));
        confirmPanel.setBackground(Color.WHITE);
        confirmDisplay = new JTextPane();
        confirmDisplay.setEditable(false);
        confirmDisplay.setPreferredSize(new Dimension(250, 75));
        Font displayFont = confirmDisplay.getFont();
        displayFont = displayFont.deriveFont(Collections.singletonMap(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD));
        displayFont = displayFont.deriveFont(16f);
        confirmDisplay.setFont(displayFont);
        confirmPanel.add(confirmDisplay);
        formPanel.add(confirmPanel);
    }

    @Override
    protected void handleSubmit()
    {
        confirmAction.run();
        editingPanel.setEditingMode(EditingMode.SELECT);
    }

    @Override
    public void resetPanel()
    {
    }

    /**
     * Methode, um die Anzuzeigende Bestaetigungsnachricht zu formatieren
     * @param confirmAction Eine zu bestaetigende Aktion
     * @return Zugehoerige Nachricht als String
     */
    private String formatConfirmMessage(ConfirmAction confirmAction)
    {
        return "Sind sie sicher, dass sie " + confirmAction.getMessage() + " wollen?";
    }

    /**
     * Methode, um die Aktion zu setzen, welche nach der Bestaetigung ausgefuehrt wird
     * @param confirmAction Eine zu bestaetigende Aktion
     */
    public void setConfirmAction(ConfirmAction confirmAction)
    {
        this.confirmAction = confirmAction;
        confirmDisplay.setText(formatConfirmMessage(confirmAction));
        revalidate();
        repaint();
    }
}
