package src.View.Screen.ListView;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

/**
 * Panel für ein Anzeigefeld der Detailansicht
 */
public class ListDisplayField extends JPanel
{
    private final JTextPane contentField;
    private final JScrollPane scrollPane;

    /**
     * Standardkonstruktor des ListDisplayFields
     * @param fieldLabel Beschreitung des Anzeigefeldes
     */
    public ListDisplayField(String fieldLabel)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BorderLayout());

        JLabel labelField = new JLabel();
        labelField.setText(fieldLabel);
        labelField.setBackground(Color.LIGHT_GRAY);
        labelField.setOpaque(true);
        labelField.setBorder(BorderFactory.createBevelBorder(0));
        add(labelField, BorderLayout.NORTH);

        contentField = new JTextPane();
        contentField.setText(" ");
        contentField.setEditable(false);
        contentField.setBorder(BorderFactory.createBevelBorder(0));
        DefaultCaret caret = new DefaultCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        contentField.setCaret(caret);
        scrollPane = new JScrollPane(contentField);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Methode zum Festlegen des Wertes des Anzeigefeldes
     * @param content Neuer Wert des Anzeigefeldes
     */
    public void setContent(String content)
    {
        SwingUtilities.invokeLater(() -> {
            contentField.setText(content);
            scrollPane.getVerticalScrollBar().setValue(0);
        });
    }
}
