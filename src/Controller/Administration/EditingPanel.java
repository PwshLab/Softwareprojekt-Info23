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
        editorPanels[0] = new SelectMode(this);
        editorPanels[1] = new AddMode(this);
        editorPanels[2] = new ModifyMode(this);
        editorPanels[3] = new DeleteMode(this);
        editorPanels[4] = new ConfirmMode(this);
        setEditingMode(EditingMode.SELECT);
    }

    public void setEditingMode(EditingMode newEditingMode)
    {
        remove(editorPanels[editingModeToPanelIndex(currentEditingMode)]);
        currentEditingMode = newEditingMode;
        add(editorPanels[editingModeToPanelIndex(currentEditingMode)]);
        repaint();
    }

    public static int editingModeToPanelIndex(EditingMode editingMode)
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
