package src.Controller.Component;

import java.util.regex.Pattern;

public class TextField extends TextDataField<String>
{
    private Pattern validationPattern;
    private boolean checkPattern;

    // TODO: Add ability to check for errors via regex filter
    public TextField(String fieldLabel)
    {
        super(fieldLabel);
        checkPattern = false;
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
