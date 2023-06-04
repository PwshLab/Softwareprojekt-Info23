package src.Controller.Administration;

import src.Controller.Component.PointField;
import src.Controller.Component.TextAreaField;
import src.Controller.Component.TextField;
import src.Controller.Component.TypeField;
import src.Model.Data.Locality.Locality;

import javax.swing.*;
import java.awt.*;

/**
 * Formular fuer eine Lokalitaet
 */
public class LocalityForm extends JPanel
{
    private final EditingPanel editingPanel;
    private final TextField nameField;
    private final TypeField typeField;
    private final TextAreaField descriptionField;
    private final PointField positionField;

    /**
     * Standardkonstruktor des LocalityForm
     * @param editingPanel Referenz zum EditingPanel
     */
    public LocalityForm(EditingPanel editingPanel)
    {
        this.editingPanel = editingPanel;

        setPreferredSize(new Dimension(400, 350));
        setOpaque(true);
        setVisible(true);
        setLayout(new GridLayout(4, 1));

        nameField = new TextField("Name", false);
        nameField.setValidationPattern(TextField.getTextOnlyPattern());
        typeField = new TypeField("Art der Lokalitaet");
        descriptionField = new TextAreaField("Beschreibung");
        positionField = new PointField("Position");
        for (JPanel panel: new JPanel[]{nameField, typeField, descriptionField, positionField})
        {
            panel.setMaximumSize(new Dimension(400 ,5));
            JPanel parentPanel = new JPanel();
            parentPanel.setLayout(new BorderLayout());
            parentPanel.add(panel, BorderLayout.CENTER);
            if (panel.getClass() != TextAreaField.class)
                parentPanel.setBorder(BorderFactory.createEmptyBorder(32, 0, 32, 2));
            else
                parentPanel.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 2));
            add(parentPanel);
        }
    }

    /**
     * Methode zum Ausgeben, ob das Formular fehler enthaelt
     * @return Boolean, ob das Formular fehler enthaelt
     */
    public boolean hasError()
    {
        boolean invalidInput = nameField.hasError() || typeField.hasError() || descriptionField.hasError() || positionField.hasError();
        boolean positionOutOfBounds = false;
        if (!invalidInput)
            positionOutOfBounds = !editingPanel.checkPositionBounds(positionField.readData());
        if (positionOutOfBounds)
            positionField.notifyError();

        return invalidInput || positionOutOfBounds;
    }

    /**
     * Methode zum Ausgeben des Inhalts des Formulars
     * @return Eine Lokalitaet nach dem Inhalt des Formulars
     */
    public Locality getData()
    {
        if (hasError())
            return null;
        else
            return new Locality(
                    nameField.readData(),
                    typeField.readData(),
                    descriptionField.readData(),
                    positionField.readData()
            );
    }

    /**
     * Methode zum Setzen der Daten im Formular
     * @param locality Eine Lokalitaet
     */
    public void setData(Locality locality)
    {
        nameField.writeData(locality.getName());
        typeField.writeData(locality.getType());
        descriptionField.writeData(locality.getDescription());
        positionField.writeData(locality.getPosition());
    }

    /**
     * Methode zum Zuruecksetzen des Formulars
     */
    public void resetData()
    {
        nameField.resetData();
        typeField.resetData();
        descriptionField.resetData();
        positionField.resetData();
    }
}
