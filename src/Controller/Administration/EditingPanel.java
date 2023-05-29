package src.Controller.Administration;

import src.Model.Model;

import javax.swing.*;
import java.awt.*;

public class EditingPanel extends JPanel
{
    private final Model model;
    private EditingMode currentEditingMode;
    private String confirmMessage;
    private Runnable confirmAction;
    private JPanel[] editorPanels;

    private EditingPanel(Model model)
    {
        this.model = model;

        initialize();
    }

    private void initialize()
    {
        editorPanels = new JPanel[EditingMode.values().length];
    }

    private void initializeModeSelect()
    {
        editorPanels[0] = new JPanel();
        editorPanels[0].setMaximumSize(new Dimension(300, 300));
        editorPanels[0].setLayout(new GridLayout());
    }

    private void initializeAdd()
    {

    }

    private void initializeModify()
    {

    }

    private void initializeDelete()
    {

    }

    private void initializeConfirm()
    {

    }
}
