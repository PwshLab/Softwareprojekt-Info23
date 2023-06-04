package src.View.Screen.ListView;

import src.Model.Model;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Panel der Lokalitaeten-Liste / Tabellenansicht
 */
public class ListView extends JPanel implements DocumentListener
{
    private JTable table;
    private TableRowSorter<ListTableModel> rowSorter;
    private JTextField textField;

    public ListView(Model model)
    {
        initialize(model);
    }

    /**
     * Methode zum Initialisieren der Listenansicht mit dem gegebenen Model
     * @param model Objekt des Typs Model
     */
    private void initialize(Model model)
    {
        setOpaque(true);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        initializeTable();
        initializeSorter(model);
        initializeTextField();
        initializeDetailDisplay();
    }

    /**
     * Methode zum Initialisieren der Tabelle
     */
    private void initializeTable()
    {
        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDragEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    /**
     * Methode zum Initialisieren der Tabellensortierung
     * @param model Objekt des Typs Model
     */
    private void initializeSorter(Model model)
    {
        ListTableModel tableModel = new ListTableModel(model);
        rowSorter = new TableRowSorter<>();
        rowSorter.setModel(tableModel);
        table.setModel(tableModel);
        table.setRowSorter(rowSorter);
    }

    /**
     * Methode zum Initialisieren des Suchfeldes
     */
    private void initializeTextField()
    {
        JPanel textPanel = new JPanel();
        textPanel.add(new JLabel("Suche: "));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        textField = new JTextField();
        textField.getDocument().addDocumentListener(this);
        textField.setMaximumSize(new Dimension(600, 19));
        textPanel.add(textField);
        add(textPanel);
    }

    /**
     * Methode zum Initialisieren der Detailansicht
     */
    private void initializeDetailDisplay()
    {
        ListDetailDisplay display = new ListDetailDisplay(table);
        add(display);
    }

    /**
     * Methode zum Festlegen der Sucheingabe
     * @param searchString Neue Sucheingage als String
     */
    private void setSearchString(String searchString)
    {
        int[] searchIndices = {0, 1, 2, 3};
        StringBuilder regexString = new StringBuilder("(?i)");
        for (String word: searchString.split(" "))
            regexString.append("(?=.*").append(word).append(")");
        rowSorter.setRowFilter(new RegexMultiRowFilter<>(regexString.toString(), searchIndices));
    }

    /**
     * Methode zum Aktualisieren der Suche bei Eingabe
     * @param e DocumentEvent
     */
    private void handleDocumentEvent(DocumentEvent e)
    {
        String searchText = textField.getText();
        if (searchText.length() > 0)
            setSearchString(searchText);
        else
            setSearchString("");
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        handleDocumentEvent(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        handleDocumentEvent(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        handleDocumentEvent(e);
    }
}
