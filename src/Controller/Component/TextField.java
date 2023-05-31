package src.Controller.Component;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextField extends TextDataField<String>
{
    private Pattern validationPattern;
    private boolean checkPattern;

    public TextField(String fieldLabel, boolean isPasswordField)
    {
        super(fieldLabel, isPasswordField);
        checkPattern = false;
    }

    @Override
    protected boolean checkError()
    {
        if (!checkPattern)
            return false;
        else
        {
            Matcher matcher = validationPattern.matcher(textField.getText());
            return !matcher.matches();
        }
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

    public void setValidationPattern(Pattern newPattern)
    {
        validationPattern = newPattern;
        checkPattern = true;
    }

    public static Pattern getTextOnlyPattern()
    {
        return Pattern.compile("^[a-zA-Z ]*$");
    }
}
