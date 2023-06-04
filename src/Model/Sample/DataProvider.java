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
    private static final String[] names = {
            "Gaststaette Quetschn",
            "Gaststaette Gravenreuther",
            "Restaurant COMING HOME",
            "Restaurant Orphée",
            "Pizza & Pasta Restaurant",
            "Restaurant Krauterer am Dom",
            "Restaurant Mesopotamia",
            "Restaurant Rosarium",
            "Dicker Mann",
            "Restaurant Gaensbauer",
            "Wirtshaus „Zum Sorgenfrei“",
            "Storstad Restaurant",
            "Piratenhoehle",
            "Heimat Regensburg",
            "Musikbar SAX",
            "Banane",
            "Hinterhaus",
            "Mono Bar",
            "Bar 13",
            "BUeRO",
            "Mood",
            "da Silva - Bar & Lounge",
            "Barock Bar",
            "Olle Gaffel",
            "Beats-Club",
            "Club Schimmerlos",
            "Rauschgold",
            "Velvet room",
            "Zarap Zap Zap",
            "Scala",
            "Peter Und Paul WaschBar",
            "Tiki Beat Bar & Club",
            "the niu Sparrow",
            "ibis Hotel Regensburg City",
            "SORAT Insel-Hotel Regensburg",
            "Hansa Apart-Hotel Regensburg",
            "Holiday Inn Express Regensburg, an IHG Hotel",
            "ACHAT Hotel Regensburg Herzog Am Dom",
            "ACHAT Hotel Regensburg Herzog Am Dom",
            "Altstadthotel Arch",
            "Bohemian Hotel",
            "ibis Regensburg Zentrum"
        };
    private static final LocalityType[] types = {
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.RESTAURANT,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.BAR,
            LocalityType.CLUB,
            LocalityType.CLUB,
            LocalityType.CLUB,
            LocalityType.CLUB,
            LocalityType.CLUB,
            LocalityType.CLUB,
            LocalityType.CLUB,
            LocalityType.CLUB,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL,
            LocalityType.HOTEL
    };
    private static final String[] descriptions = {
            "Rustikale deutsche Gerichte wie Schnitzel in einem gemuetlichen, traditionellen Lokal mit Holzbalken und Bier. Speisen vor Ort. Essen zum Mitnehmen.",
            "Traditionelle bayerische Gerichte in einem urigen Wirtshaus mit nostalgischer Einrichtung und Tischen am Gehweg. Sitzplaetze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Gutbuergerliche Kueche in einem gemuetlichen Restaurant mit einer Bar und einer Gartenterrasse. Sitzplaetze im Freien. Abholung vor dem Laden. Essen zum Mitnehmen. Speisen vor Ort.",
            "Mediterrane Gerichte und Wein in einem beliebten, traditionellen Bistro mit Bar und Terrasse. Sitzplaetze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "In der offenen Kueche des Restaurants mit Heiligenbildern und Terrasse werden italienische Gerichte zubereitet. Sitzplaetze im Freien. Lieferdienst. Essen zum Mitnehmen. Speisen vor Ort.",
            "Bayerisches Restaurant. Sitzplaetze im Freien. Speisen vor Ort.",
            "Unpraetentioeses Restaurant mit kurdischen und vegetarischen Gerichten wie Kebabs, Falafel und Salaten. Sitzplaetze im Freien. Kontaktlose Lieferung. Lieferdienst. Essen zum Mitnehmen. Speisen vor Ort.",
            "Bistro mit mediterraner Kueche und großer Außenterrasse in einem Park. Sitzplaetze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Deftige oesterreichische Hauptspeisen und Desserts in einem Gebaeude aus dem 14. Jahrhundert. Sitzplaetze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Restaurant fuer Bayerische Tapas. Essen zum Mitnehmen. Speisen vor Ort.",
            "Traditionelles Bayerisches Restaurant mit Biergarten. Sitzplaetze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Edles, minimalistisches Restaurant mit Degustationsmenues origineller europaeisch-asiatischer Fusionsgerichte. Sitzplaetze im Freien. Speisen vor Ort.",
            "Flippige Kellerkneipe mit Piratenmotiven sowie Rock- und Heavy-Metal-Musik in einem mittelalterlichen Gebaeude. Sitzplaetze im Freien. Speisen vor Ort.",
            "Craft-Bier und Cocktails in einer kleinen Bar mit lockerem Flair und Livemusik von regionalen Bands und Kuenstlern. Sitzplaetze im Freien. Abholung vor dem Laden. Drive-in. Essen zum Mitnehmen. Speisen vor Ort. Live-Veranstaltungen. LGBTQ+-freundlich. Kartenzahlung moeglich.",
            "Speisen vor Ort.",
            "Speisen vor Ort.",
            "Speisen vor Ort. Kartenzahlung moeglich.",
            "Gemuetliches Ambiente.",
            "Im Lokal mit Natursteinwaenden laesst sich bei Drinks und Pizza kickern, Dart spielen und Karaoke singen. Essen zum Mitnehmen. Speisen vor Ort. LGBTQ+-freundlich",
            "Speisen vor Ort.",
            "Sitzplaetze im Freien. Abholung vor dem Laden. Essen zum Mitnehmen. Speisen vor Ort.",
            "Mottopartys mit verschiedenen DJs und Cocktailspecials in der Bar mit bunten Waenden und Neonroehren. Abholung vor dem Laden. Speisen vor Ort. Rollstuhlgerechter Eingang.",
            "Stilvolle Cocktailbar in historischem Gewoelbe und modernem Ambiente mit Kursen und Verkostungen. Speisen vor Ort. Gehobenes Ambiente.",
            "Speisen vor Ort. LGBTQ+-freundlich. Hunde erlaubt.",
            "Nacht- und Tanzclub mit Studentenpartys, DJs, Spezialveranstaltungen und Live-Auftritten. Speisen vor Ort. Gemuetliches Ambiente.",
            "Speisen vor Ort. Live-Veranstaltungen.",
            "Kleiner, pulsierender Nachtclub mit Cocktails und Bier sowie Tanzflaeche und Partymusik vergangener Jahrzehnte. Speisen vor Ort.",
            "Speisen vor Ort.",
            "Studentenpartys und Tanz zur Musik der letzten 4 Jahrzehnte im heimeligen Kellergewoelbe mit Backsteinmauern. Speisen vor Ort.",
            "In der etablierten Discothek tanzt man in lockerer Atmosphaere zu Electro, Techno, Indie und den 80er-Charts. Speisen vor Ort.",
            "Speisen vor Ort.",
            "Speisen vor Ort. Live-Veranstaltungen.",
            "Dieses schicke Hotel mit Originalkunstwerken ist 16 Gehminuten vom Hauptbahnhof Regensburg sowie jeweils 2 km von der Steinernen Bruecke aus dem 12. Jahrhundert und vom Regensburger Dom entfernt.\n" +
                    "Die modernen Zimmer mit Wandmalereien zum Thema Architektur bieten WLAN und einen Flachbildfernseher. In Zimmern mit gehobener Ausstattung gibt es ein ausziehbares Sofa.\n" +
                    "Es gibt eine Bar und Fruehstueck wird angeboten.\n",
            "Dieses schlichte und preisguenstige Hotel im Stadtzentrum liegt 3 Gehminuten vom Bahnhof Regensburg und 1,1 km vom Regensburger Dom entfernt.\n" +
                    "Die modernen Zimmer sind mit kostenlosem WLAN, einem Flachbildfernseher, einem Schreibtisch und Holzboeden ausgestattet. Haustiere sind gegen Gebuehr willkommen.\n" +
                    "Das Hotel bietet ein kostenloses Fruehstuecksbuffet, eine durchgehend geoeffnete gemuetliche Bar, in der Snacks serviert werden, und einen Innenspielplatz. Ferner stehen ein Business Center und Tagungsraeume zur Verfuegung.",
            "Dieses stilvolle Hotel in einer ehemaligen Manufaktur fuer Kunsthandwerk liegt direkt an der Donau. Es ist 10 Gehminuten vom Regensburger Dom und 14 Gehminuten vom Historischen Museum Regensburg entfernt.\n" +
                    "Die modernen Zimmer bieten ein Marmorbad mit Granitboden, einen Flachbildfernseher, WLAN, einen Schreibtisch und eine Minibar sowie teilweise Flussblick. In den Zimmern mit gehobener Ausstattung gibt es Moeglichkeiten zur Kaffee- und Teezubereitung. Die Suiten haben außerdem ein Wohnzimmer. Eine Klimaanlage ist nicht vorhanden.\n" +
                    "Das Hotel bietet ein nobles Restaurant mit Terrasse und Flussblick sowie gelegentlichen Dinnershows. Eine helle Lobbybar, Massageanwendungen und eine Sauna sind ebenfalls verfuegbar.",
            "Dieses zwanglose Hotel in einem Gewerbegebiet ist jeweils 11 Gehminuten vom Hauptbahnhof Regensburg und vom Einkaufszentrum Regensburg Arcaden entfernt. Zur Alten Steinbruecke aus dem 12. Jahrhundert ueber die Donau sind es 3 km.\n" +
                    "Die freundlich eingerichteten, gemuetlichen Zimmer bieten kostenloses WLAN, einen Flachbildfernseher, einen Minikuehlschrank und eine Sitzecke. Zimmer mit gehobener Ausstattung haben zusaetzlich eine Pantrykueche.\n" +
                    "Zum kostenlosen Angebot gehoeren das Fruehstueck und Zugang zu einem nahe gelegenen Fitnesscenter mit Sport- und Wellnessangeboten. Es gibt auch ein elegantes Fischrestaurant, eine stilvolle Bar und eine Lounge mit Kamin. Parkplaetze sind verfuegbar.",
            "Dieses gemuetliche Budgethotel liegt 10 Gehminuten von den Restaurants im Stadtzentrum, 12 Gehminuten vom Hauptbahnhof Regensburg und 14 Gehminuten vom Haidplatz entfernt.\n" +
                    "Die einfachen Zimmer bieten kostenloses WLAN und Flachbildfernseher sowie einen Tee- und Kaffeekocher. Kinder bis einschließlich 16 Jahre uebernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Ein kontinentales Fruehstuecksbuffet wird kostenlos angeboten. Außerdem gibt es eine rund um die Uhr geoeffnete Bar. Parkplaetze stehen gegen Gebuehr zur Verfuegung.",
            "Dieses elegante Hotel liegt im Stadtzentrum gegenueber dem Regensburger Dom aus dem 13. Jahrhundert. Es ist 10 Gehminuten vom Hauptbahnhof Regensburg und 11 Gehminuten von Schloss St. Emmeram entfernt.\n" +
                    "Die gemuetlich-modernen Zimmer sind mit WLAN, Flachbildfernseher, Nespressomaschine, Minibar und Marmorbad ausgestattet. Suiten bieten zusaetzlich eine Sitzecke, manche auch Ausblick auf den Dom. Zimmerservice ist verfuegbar und Kinder bis einschließlich 12 Jahre uebernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Zur Ausstattung gehoeren ein nobles Restaurant mit bayerischer Kueche und Fruehstuecksbuffet (gegen Aufpreis), eine Cocktailbar und ein Biergarten. Es gibt auch ein Business Center.",
            "Dieses elegante Hotel liegt im Stadtzentrum gegenueber dem Regensburger Dom aus dem 13. Jahrhundert. Es ist 10 Gehminuten vom Hauptbahnhof Regensburg und 11 Gehminuten von Schloss St. Emmeram entfernt.\n" +
                    "Die gemuetlich-modernen Zimmer sind mit WLAN, Flachbildfernseher, Nespressomaschine, Minibar und Marmorbad ausgestattet. Suiten bieten zusaetzlich eine Sitzecke, manche auch Ausblick auf den Dom. Zimmerservice ist verfuegbar und Kinder bis einschließlich 12 Jahre uebernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Zur Ausstattung gehoeren ein nobles Restaurant mit bayerischer Kueche und Fruehstuecksbuffet (gegen Aufpreis), eine Cocktailbar und ein Biergarten. Es gibt auch ein Business Center.",
            "Dieses gemuetliche Altstadthotel befindet sich in einem Patrizierhaus aus dem 12. Jahrhundert und ist 6 Gehminuten vom gotischen Regensburger Dom sowie 10 Gehminuten vom Historischen Museum Regensburg entfernt.\n" +
                    "Die gemuetlichen Zimmer sind mit einem Schreibtisch ausgestattet und verfuegen ueber einen Flachbildfernseher mit Premium-Kabelkanaelen und kostenloses WLAN. Die Suiten bieten zusaetzlich eine separate Sitzecke mit Sofa oder Sessel und haben teilweise schraege Holzbalkendecken.\n" +
                    "Das Fruehstueck ist im Preis inbegriffen. Es gibt ein farbenfrohes, modernes Café mit Bar-Lounge sowie ein Business Center und Konferenzraeume. Haustiere sind gegen Aufpreis erlaubt.\n",
            "Dieses gemuetliche Hotel mit traditionellem Charme liegt inmitten von Bars und Geschaeften an einer kopfsteingepflasterten Straße. Es ist 7 Gehminuten vom gotischen Regensburger Dom aus dem 13. Jahrhundert und 14 Gehminuten vom Bahnhof Regensburg entfernt.\n" +
                    "Die hellen Zimmer mit Moebeln im historischen Stil bieten einen Flachbildfernseher und teilweise eine Sitzecke. Es gibt 2 elegante Suiten mit Wohnbereich und Holzbalkendecke. Kinder uebernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Es gibt eine gemuetliche, freundlich eingerichtete Bar. Das Fruehstuecksbuffet wird gegen Aufpreis angeboten.",
            "Dieses bodenstaendige Budgethotel an einer von Baeumen gesaeumten Straße ist 1 km vom Regensburger Dom und 2 km von der Steinernen Bruecke entfernt. Zum Hauptbahnhof Regensburg sind es 12 Gehminuten.\n" +
                    "Die zweckmaeßig eingerichteten Zimmer mit farbenfrohen Akzenten haben WLAN und einen Flachbildfernseher. Zimmer mit gehobener Ausstattung bieten außerdem Stadtblick. In den Familienzimmern gibt es ein Schlafsofa.\n" +
                    "Es gibt eine zwanglose Lobbybar. Parkplaetze sind vorhanden und ein Fruehstuecksbuffet wird angeboten.\n"
        };
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
     * Methode zum Ausgeben einer beispiel Lokalitaet
     * @param n Index der Lokalitaet
     * @return Eine Lokalitaet
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
     * Methode zum Ausgeben eines Iterators fuer die Beispieldaten
     * @return Iterator fuer dieses Objekt
     */
    @Override
    public Iterator<Locality> iterator()
    {
        return new ProviderIterator(this);
    }
}
