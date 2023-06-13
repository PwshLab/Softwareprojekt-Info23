package src.Controller.Component;

import src.Model.Data.CoordSystem.Vector2;

import java.awt.*;

/**
 * Datenfeld für einen Vektor2
 */
public class PointField extends DataField<Vector2>
{
    private final NumberField field1, field2;

    /**
     * Standardkonstruktor des PointFields
     * @param fieldLabel Beschriftung des Datenfeldes
     */
    public PointField(String fieldLabel)
    {
        super(fieldLabel);

        setLayout(new GridLayout());
        field1 = new NumberField("X");
        add(field1);
        field2 = new NumberField("Y");
        add(field2);
    }

    @Override
    protected boolean checkError()
    {
        return field1.checkError() || field2.checkError();
    }

    @Override
    protected Vector2 parseData()
    {
        return new Vector2(field1.parseData(), field2.parseData());
    }

    @Override
    public void writeData(Vector2 newData)
    {
        field1.writeData(newData.getX(1));
        field2.writeData(newData.getX(2));
    }

    @Override
    public void resetData()
    {
        field1.resetData();
        field2.resetData();
    }
}
