package src.Controller.Component;

/**
 * Datenfeld fuer den Datentyp Double
 */
public class NumberField extends TextDataField<Double>
{
    public NumberField(String fieldLabel)
    {
        super(fieldLabel, false);
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

    @Override
    public void writeData(Double newData)
    {
        textField.setText(newData.toString());
    }
}
