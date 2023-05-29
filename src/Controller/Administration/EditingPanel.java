package src.Controller.Administration;

import src.Controller.Administration.Mode.*;
import src.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class EditingPanel extends JPanel
{
    private final Model model;
    private EditingMode currentEditingMode;
    private String confirmMessage;
    private Runnable confirmAction;
    private JPanel[] editorPanels;

    public EditingPanel(Model model)
    {
        this.model = model;

        initialize();
    }

    private void initialize()
    {
        editorPanels = new JPanel[EditingMode.values().length];
        initializeModeSelect();
        initializeAdd();
        initializeModify();
        initializeDelete();
        initializeConfirm();
        setEditingMode(EditingMode.SELECT);
    }

    private void initializeModeSelect()
    {
        editorPanels[0] = new JPanel();
        //editorPanels[0].setMaximumSize(new Dimension(300, 300));
        //editorPanels[0].setLayout(new GridLayout());
        editorPanels[0].add(new SelectMode(this));
    }

    private void initializeAdd()
    {
        editorPanels[1] = new JPanel();
        editorPanels[1].add(new AddMode(this));
    }

    private void initializeModify()
    {
        editorPanels[2] = new JPanel();
        editorPanels[2].add(new ModifyMode(this));
    }

    private void initializeDelete()
    {
        editorPanels[3] = new JPanel();
        editorPanels[3].add(new DeleteMode(this));
    }

    private void initializeConfirm()
    {
        editorPanels[4] = new JPanel();
        editorPanels[4].add(new ConfirmMode(this));
    }

    public void setEditingMode(EditingMode newEditingMode)
    {
        remove(editorPanels[editingModeToPanelIndex(currentEditingMode)]);
        currentEditingMode = newEditingMode;
        add(editorPanels[editingModeToPanelIndex(currentEditingMode)]);
        repaint();
    }

    private static int editingModeToPanelIndex(EditingMode editingMode)
    {
        int index = 0;
        for (EditingMode mode: EditingMode.values())
            if (mode.equals(editingMode))
                return index;
            else
                index++;
        return 0;
    }
}
