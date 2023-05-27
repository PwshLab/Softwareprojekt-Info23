package src.Controller.Component;

public class TextField extends TextDataField<String>
{
    public TextField()
    {
        super();
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
}
