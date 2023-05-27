package src.Controller.Component;

public class NumberField extends TextDataField<Double>
{
    public NumberField(String fieldLabel)
    {
        super(fieldLabel);
    }

    @Override
    protected boolean checkError()
    {
        try
        {
            Double.parseDouble(textField.getText());
            return false;
        } catch (NumberFormatException e)
        {
            return true;
        }
    }

    @Override
    protected Double parseData()
    {
        return Double.parseDouble(textField.getText());
    }
}