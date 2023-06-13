package src.Model.Sample;

import src.Model.Data.Locality.Locality;

import java.util.Iterator;

/**
 * Iterator für ein Objekt des Typs DataProvider
 */
public class ProviderIterator implements Iterator<Locality>
{
    private final DataProvider provider;
    private int currentGenerated;

    /**
     * Standardkonstruktor des ProviderIterators
     * @param provider Referenz zum jeweiligen DataProvider
     */
    public ProviderIterator(DataProvider provider)
    {
        this.provider = provider;
        this.currentGenerated = 0;
    }

    @Override
    public boolean hasNext()
    {
        return currentGenerated < provider.getMaxData();
    }

    @Override
    public Locality next()
    {
        Locality locality = provider.getLocality(currentGenerated);
        currentGenerated++;
        return locality;
    }
}
