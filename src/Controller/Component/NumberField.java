package src.Controller.Component;

public class NumberField extends TextDataField<Double>
{
    public NumberField()
    {
        super();
    }

    @Override
    protected boolean checkError()
    {
        return false;
    }

    @Override
    protected Double parseData()
    {
        return null;
    }
}
