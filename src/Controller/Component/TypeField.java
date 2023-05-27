package src.Controller.Component;

import src.Model.Data.Locality.LocalityType;

public class TypeField extends SelectDataField<LocalityType>
{
    public TypeField()
    {
        super();
    }

    @Override
    protected boolean checkError()
    {
        return false;
    }

    @Override
    protected LocalityType parseData()
    {
        return null;
    }

}
