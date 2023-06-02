package src.Model.Sample;

import src.Model.Data.Locality.Locality;
import src.Model.Data.Locality.LocalityType;
import src.Model.Model;

import java.util.Iterator;

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

    public int getMaxData()
    {
        return maxData;
    }

    public Locality getLocality(int n)
    {
        return new Locality(
                names[n],
                types[n],
                descriptions[n],
                model.generatePosition()
        );
    }

    @Override
    public Iterator<Locality> iterator()
    {
        return new ProviderIterator(this);
    }
}
