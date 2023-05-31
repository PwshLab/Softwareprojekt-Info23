package src.Controller.Administration;

import src.Controller.Component.PointField;
import src.Controller.Component.TextAreaField;
import src.Controller.Component.TextField;
import src.Controller.Component.TypeField;
import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.Locality.Locality;

import javax.swing.*;
import java.awt.*;

public class LocalityForm extends JPanel
{
    private final EditingPanel editingPanel;
    private TextField nameField;
    private TypeField typeField;
    private TextAreaField descriptionField;
    private PointField positionField;

    public LocalityForm(EditingPanel editingPanel)
    {
        this.editingPanel = editingPanel;

        setPreferredSize(new Dimension(400, 350));
        setOpaque(true);
        setVisible(true);
        setLayout(new GridLayout(4, 1));

        nameField = new TextField("Name");
        nameField.setValidationPattern(TextField.getTextOnlyPattern());
        typeField = new TypeField("Art der Lokalität");
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

    public boolean hasError()
    {
        boolean isValidInput = nameField.hasError() || typeField.hasError() || descriptionField.hasError() || positionField.hasError();
        boolean positionOutOfBounds = false;
        if (isValidInput)
            positionOutOfBounds =

        return isValidInput || positionOutOfBounds;
    }

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

    public void setData(Locality locality)
    {
        nameField.writeData(locality.getName());
        typeField.writeData(locality.getType());
        descriptionField.writeData(locality.getDescription());
        positionField.writeData(locality.getPosition());
    }
}
