package src.Controller.Component;

import src.Model.Data.CoordSystem.Vector2;

public class PointField extends DataField<Vector2>
{
    public PointField()
    {
        super();
    }

    @Override
    protected boolean checkError()
    {
        return false;
    }

    @Override
    protected Vector2 parseData()
    {
        return null;
    }
}
