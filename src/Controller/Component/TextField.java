package src.Controller.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ein Textdatenfeld mit einer Zeile
 */
public class TextField extends TextDataField<String>
{
    private Pattern validationPattern;
    private boolean checkPattern;

    /**
     * Standardkonstruktor des TextFields
     * @param fieldLabel Beschriftung des Datenfeldes
     * @param isPasswordField Boolean, ob es sich um ein Passwortfeld handelt
     */
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

    /**
     * Methode zum Festlegen eines Regex Ausdrucks zur fehlerüberprüfung
     * @param newPattern Neuer Regelausdruck
     */
    public void setValidationPattern(Pattern newPattern)
    {
        validationPattern = newPattern;
        checkPattern = true;
    }

    /**
     * Methode zum Erstellen eines Regex für nur Textauswahl
     * @return Neuer Regex
     */
    public static Pattern getTextOnlyPattern()
    {
        return Pattern.compile("^[a-zA-ZäöüÄÖÜ '" + '"' + "]*$");
    }
}
