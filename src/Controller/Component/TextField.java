package src.Controller.Component;

public class TextField extends TextDataField<String>
{
    // TODO: Add ability to check for errors via regex filter
    public TextField(String fieldLabel)
    {
        super(fieldLabel);
    }

    @Override
    protected boolean checkError()
    {
        return false;
    }

    @Override
    protected String parseData()
    {
        return textField.getText();
    }

    @Override
    public void writeData(String newData)
    {
        textField.setText(newData);
    }
}
