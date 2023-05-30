package src.Controller.Administration;

import src.Controller.Component.PointField;
import src.Controller.Component.TextField;
import src.Controller.Component.TypeField;
import src.Model.Data.Locality.Locality;

import javax.swing.*;

public class LocalityForm extends JPanel
{
    private TextField nameField;
    private TypeField typeField;
    private TextField descriptionField;
    private PointField positionField;

    public LocalityForm()
    {

    }

    public boolean hasError()
    {
        return nameField.hasError() || typeField.hasError() || descriptionField.hasError() || positionField.hasError();
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

    }
}
