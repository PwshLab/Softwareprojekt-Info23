package src.Controller.Administration;

import src.Controller.Administration.Mode.*;
import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.Locality.Locality;
import src.Model.Model;

import javax.swing.*;

/**
 * Hauptklasse der Administrations-Bearbeitung
 */
public class EditingPanel extends JPanel
{
    private final Model model;
    private EditingMode currentEditingMode;
    private PanelMode[] editorPanels;

    public EditingPanel(Model model)
    {
        this.model = model;

        initialize();
    }

    /**
     * Methode zum Initialisieren der Bearbeitungsmodi
     */
    private void initialize()
    {
        editorPanels = new PanelMode[EditingMode.values().length];
        editorPanels[0] = new SelectMode(this);
        editorPanels[1] = new AddMode(this);
        editorPanels[2] = new ModifyMode(this);
        editorPanels[3] = new DeleteMode(this);
        editorPanels[4] = new ConfirmMode(this);
        setEditingMode(EditingMode.SELECT);
    }

    /**
     * Methode zum Setzen des momentanen Bearbeitungsmodus
     * @param newEditingMode Der neue Bearbeitungsmodus
     */
    public void setEditingMode(EditingMode newEditingMode)
    {
        remove(editorPanels[editingModeToPanelIndex(currentEditingMode)]);
        currentEditingMode = newEditingMode;
        add(editorPanels[editingModeToPanelIndex(currentEditingMode)]);
        editorPanels[editingModeToPanelIndex(currentEditingMode)].resetPanel();
        revalidate();
        repaint();
    }

    /**
     * Statische Methode zum Konvertieren eines Wertes des EditingMode Enums
     * zu dem jeweiligen index des Panels
     * @param editingMode Ein Wert des EditingMode Enums
     * @return Index des zugehoerigen Panels
     */
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

    /**
     * Methode um den Index einer Lokalitaet auf validitaet zu Ueberpruefen
     * @param index Gegebener Index einer Lokalitaet
     * @return Boolean Wert, ob dieser existiert
     */
    public boolean checkIndexBounds(int index)
    {
        return model.checkIndexBounds(index);
    }

    /**
     * Methode, um zu ueberpruefen, ob eine gegebene Position innerhalb
     * der im Model definierten Weltbegrenzung liegt
     * @param position Gegebene Position als Vektor2
     * @return Boolean, ob sich diese innerhalb der Welt befindet
     */
    public boolean checkPositionBounds(Vector2 position)
    {
        double x1 = Math.abs(position.getX(1));
        double x2 = Math.abs(position.getX(2));
        return x1 <= model.getWorldBound() && x2 <= model.getWorldBound();
    }

    /**
     * Methode zum Hinzufuegen einer Lokalitaet
     * @param locality Eine Lokalitaet
     */
    public void addLocality(Locality locality)
    {
        model.addElement(locality);
    }

    /**
     * Methode zum Entfernen einer Lokalitaet
     * @param localityIndex Index einer Lokalitaet
     */
    public void removeLocality(int localityIndex)
    {
        model.removeElement(model.getElements().get(localityIndex));
    }

    /**
     * Methode zum Ueberschreiben einer Lokalitaet
     * @param localityIndex Index einer Lokalitaet
     * @param newLocality Eine neue Lokalitaet
     */
    public void modifyLocality(int localityIndex, Locality newLocality)
    {
        model.setElement(localityIndex, newLocality);
    }

    /**
     * Methode zum Ausgeben einer Lokalitaet
     * @param localityIndex Index einer Lokalitaet
     * @return Die Lokalitaet mit dem gegebenen Index
     */
    public Locality getLocality(int localityIndex)
    {
        return model.getElements().get(localityIndex);
    }

    /**
     * Methode zum Setzen der zu bestaetigenden Aktion
     * @param confirmAction Eine Aktion
     */
    public void setConfirmAction(ConfirmAction confirmAction)
    {
        ((ConfirmMode) editorPanels[4]).setConfirmAction(confirmAction);
        setEditingMode(EditingMode.CONFIRM);
    }
}
