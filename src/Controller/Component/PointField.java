package src.Controller.Component;

import src.Model.Data.CoordSystem.Vector2;

import java.awt.*;

public class PointField extends DataField<Vector2>
{
    private NumberField field1, field2;

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
}
