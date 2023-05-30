package src.Controller.Component;

import javax.swing.*;

public class TextAreaField extends TextAreaDataField<String>
{
    public TextAreaField(String fieldLabel)
    {
        super(fieldLabel);
        textArea.setBorder(BorderFactory.createBevelBorder(1));
    }

    @Override
    protected boolean checkError()
    {
        return false;
    }

    @Override
    protected String parseData()
    {
        return textArea.getText();
    }

    @Override
    public void writeData(String newData)
    {
        textArea.setText(newData);
    }
}
