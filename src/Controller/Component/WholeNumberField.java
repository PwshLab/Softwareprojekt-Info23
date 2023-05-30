package src.Controller.Component;

public class WholeNumberField extends TextDataField<Integer>
{
    public WholeNumberField(String fieldLabel)
    {
        super(fieldLabel);
    }

    @Override
    protected boolean checkError()
    {
        try
        {
            Integer.parseInt(textField.getText());
            return false;
        } catch (NumberFormatException e)
        {
            return true;
        }
    }

    @Override
    protected Integer parseData()
    {
        return Integer.parseInt(textField.getText());
    }

    @Override
    public void writeData(Integer newData)
    {
        textField.setText(newData.toString());
    }
}
