package src.Model.Sample;

import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityType;
import src.Model.Model;

import java.util.Iterator;

/**
 * Klasse zum Bereitstellen von Beispieldaten
 */
public class DataProvider implements Iterable<Locality>
{
    // TODO: Enter example data
    private static final String[] names = {};
    private static final LocalityType[] types = {};
    private static final String[] descriptions = {};
    private static final int maxData = Math.min(names.length, Math.min(types.length, descriptions.length));
    private final Model model;

    public DataProvider(Model model)
    {
        this.model = model;
    }

    /**
     * Methode zum Ausgeben der maximalen Daten Anzahl
     * @return Zahlenwert des Typs Integer
     */
    public int getMaxData()
    {
        return maxData;
    }

    /**
     * Methode zum Ausgeben einer beispiel Lokalität
     * @param n Index der Lokalität
     * @return Eine Lokalität
     */
    public Locality getLocality(int n)
    {
        return new Locality(
                names[n],
                types[n],
                descriptions[n],
                model.generatePosition()
        );
    }

    /**
     * Methode zum Ausgeben eines Iterators für die Beispieldaten
     * @return Iterator für dieses Objekt
     */
    @Override
    public Iterator<Locality> iterator()
    {
        return new ProviderIterator(this);
    }
}
