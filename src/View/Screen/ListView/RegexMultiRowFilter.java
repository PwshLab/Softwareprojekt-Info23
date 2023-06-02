package src.View.Screen.ListView;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex-Tabellenfilter für mehrere Spalten gleichzeitig
 * @param <M> Beliebiger Datentyp M
 * @param <I> Beliebiger Datentyp I
 */
public class RegexMultiRowFilter<M, I> extends RowFilter<M, I>
{
    private final Matcher matcher;
    private final int[] columns;

    public RegexMultiRowFilter(String regexString, int[] columns)
    {
        this.matcher = Pattern.compile(regexString).matcher("");
        this.columns = columns;
    }

    @Override
    public boolean include(Entry<? extends M, ? extends I> entry)
    {
        StringBuilder rowRepresentation = new StringBuilder();
        for (int index: columns)
            rowRepresentation.append(" ").append(entry.getStringValue(index));
        matcher.reset(rowRepresentation.toString());
        return matcher.find();
    }
}
