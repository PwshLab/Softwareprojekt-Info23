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
            "Gaststätte Quetschn",
            "Gaststätte Gravenreuther",
            "Restaurant COMING HOME",
            "Restaurant Orphée",
            "Pizza & Pasta Restaurant",
            "Restaurant Krauterer am Dom",
            "Restaurant Mesopotamia",
            "Restaurant Rosarium",
            "Dicker Mann",
            "Restaurant Gänsbauer",
            "Wirtshaus „Zum Sorgenfrei“",
            "Storstad Restaurant",
            "Piratenhöhle",
            "Heimat Regensburg",
            "Musikbar SAX",
            "Banane",
            "Hinterhaus",
            "Mono Bar",
            "Bar 13",
            "BÜRO",
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
            "Rustikale deutsche Gerichte wie Schnitzel in einem gemütlichen, traditionellen Lokal mit Holzbalken und Bier. Speisen vor Ort. Essen zum Mitnehmen.",
            "Traditionelle bayerische Gerichte in einem urigen Wirtshaus mit nostalgischer Einrichtung und Tischen am Gehweg. Sitzplätze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Gutbürgerliche Küche in einem gemütlichen Restaurant mit einer Bar und einer Gartenterrasse. Sitzplätze im Freien. Abholung vor dem Laden. Essen zum Mitnehmen. Speisen vor Ort.",
            "Mediterrane Gerichte und Wein in einem beliebten, traditionellen Bistro mit Bar und Terrasse. Sitzplätze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "In der offenen Küche des Restaurants mit Heiligenbildern und Terrasse werden italienische Gerichte zubereitet. Sitzplätze im Freien. Lieferdienst. Essen zum Mitnehmen. Speisen vor Ort.",
            "Bayerisches Restaurant. Sitzplätze im Freien. Speisen vor Ort.",
            "Unprätentiöses Restaurant mit kurdischen und vegetarischen Gerichten wie Kebabs, Falafel und Salaten. Sitzplätze im Freien. Kontaktlose Lieferung. Lieferdienst. Essen zum Mitnehmen. Speisen vor Ort.",
            "Bistro mit mediterraner Küche und großer Außenterrasse in einem Park. Sitzplätze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Deftige österreichische Hauptspeisen und Desserts in einem Gebäude aus dem 14. Jahrhundert. Sitzplätze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Restaurant für Bayerische Tapas. Essen zum Mitnehmen. Speisen vor Ort.",
            "Traditionelles Bayerisches Restaurant mit Biergarten. Sitzplätze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Edles, minimalistisches Restaurant mit Degustationsmenüs origineller europäisch-asiatischer Fusionsgerichte. Sitzplätze im Freien. Speisen vor Ort.",
            "Flippige Kellerkneipe mit Piratenmotiven sowie Rock- und Heavy-Metal-Musik in einem mittelalterlichen Gebäude. Sitzplätze im Freien. Speisen vor Ort.",
            "Craft-Bier und Cocktails in einer kleinen Bar mit lockerem Flair und Livemusik von regionalen Bands und Künstlern. Sitzplätze im Freien. Abholung vor dem Laden. Drive-in. Essen zum Mitnehmen. Speisen vor Ort. Live-Veranstaltungen. LGBTQ+-freundlich. Kartenzahlung möglich.",
            "Speisen vor Ort.",
            "Speisen vor Ort.",
            "Speisen vor Ort. Kartenzahlung möglich.",
            "Gemütliches Ambiente.",
            "Im Lokal mit Natursteinwänden lässt sich bei Drinks und Pizza kickern, Dart spielen und Karaoke singen. Essen zum Mitnehmen. Speisen vor Ort. LGBTQ+-freundlich",
            "Speisen vor Ort.",
            "Sitzplätze im Freien. Abholung vor dem Laden. Essen zum Mitnehmen. Speisen vor Ort.",
            "Mottopartys mit verschiedenen DJs und Cocktailspecials in der Bar mit bunten Wänden und Neonröhren. Abholung vor dem Laden. Speisen vor Ort. Rollstuhlgerechter Eingang.",
            "Stilvolle Cocktailbar in historischem Gewölbe und modernem Ambiente mit Kursen und Verkostungen. Speisen vor Ort. Gehobenes Ambiente.",
            "Speisen vor Ort. LGBTQ+-freundlich. Hunde erlaubt.",
            "Nacht- und Tanzclub mit Studentenpartys, DJs, Spezialveranstaltungen und Live-Auftritten. Speisen vor Ort. Gemütliches Ambiente.",
            "Speisen vor Ort. Live-Veranstaltungen.",
            "Kleiner, pulsierender Nachtclub mit Cocktails und Bier sowie Tanzfläche und Partymusik vergangener Jahrzehnte. Speisen vor Ort.",
            "Speisen vor Ort.",
            "Studentenpartys und Tanz zur Musik der letzten 4 Jahrzehnte im heimeligen Kellergewölbe mit Backsteinmauern. Speisen vor Ort.",
            "In der etablierten Discothek tanzt man in lockerer Atmosphäre zu Electro, Techno, Indie und den 80er-Charts. Speisen vor Ort.",
            "Speisen vor Ort.",
            "Speisen vor Ort. Live-Veranstaltungen.",
            "Dieses schicke Hotel mit Originalkunstwerken ist 16 Gehminuten vom Hauptbahnhof Regensburg sowie jeweils 2 km von der Steinernen Brücke aus dem 12. Jahrhundert und vom Regensburger Dom entfernt.\n" +
                    "Die modernen Zimmer mit Wandmalereien zum Thema Architektur bieten WLAN und einen Flachbildfernseher. In Zimmern mit gehobener Ausstattung gibt es ein ausziehbares Sofa.\n" +
                    "Es gibt eine Bar und Frühstück wird angeboten.\n",
            "Dieses schlichte und preisgünstige Hotel im Stadtzentrum liegt 3 Gehminuten vom Bahnhof Regensburg und 1,1 km vom Regensburger Dom entfernt.\n" +
                    "Die modernen Zimmer sind mit kostenlosem WLAN, einem Flachbildfernseher, einem Schreibtisch und Holzböden ausgestattet. Haustiere sind gegen Gebühr willkommen.\n" +
                    "Das Hotel bietet ein kostenloses Frühstücksbuffet, eine durchgehend geöffnete gemütliche Bar, in der Snacks serviert werden, und einen Innenspielplatz. Ferner stehen ein Business Center und Tagungsräume zur Verfügung.",
            "Dieses stilvolle Hotel in einer ehemaligen Manufaktur für Kunsthandwerk liegt direkt an der Donau. Es ist 10 Gehminuten vom Regensburger Dom und 14 Gehminuten vom Historischen Museum Regensburg entfernt.\n" +
                    "Die modernen Zimmer bieten ein Marmorbad mit Granitboden, einen Flachbildfernseher, WLAN, einen Schreibtisch und eine Minibar sowie teilweise Flussblick. In den Zimmern mit gehobener Ausstattung gibt es Möglichkeiten zur Kaffee- und Teezubereitung. Die Suiten haben außerdem ein Wohnzimmer. Eine Klimaanlage ist nicht vorhanden.\n" +
                    "Das Hotel bietet ein nobles Restaurant mit Terrasse und Flussblick sowie gelegentlichen Dinnershows. Eine helle Lobbybar, Massageanwendungen und eine Sauna sind ebenfalls verfügbar.",
            "Dieses zwanglose Hotel in einem Gewerbegebiet ist jeweils 11 Gehminuten vom Hauptbahnhof Regensburg und vom Einkaufszentrum Regensburg Arcaden entfernt. Zur Alten Steinbrücke aus dem 12. Jahrhundert über die Donau sind es 3 km.\n" +
                    "Die freundlich eingerichteten, gemütlichen Zimmer bieten kostenloses WLAN, einen Flachbildfernseher, einen Minikühlschrank und eine Sitzecke. Zimmer mit gehobener Ausstattung haben zusätzlich eine Pantryküche.\n" +
                    "Zum kostenlosen Angebot gehören das Frühstück und Zugang zu einem nahe gelegenen Fitnesscenter mit Sport- und Wellnessangeboten. Es gibt auch ein elegantes Fischrestaurant, eine stilvolle Bar und eine Lounge mit Kamin. Parkplätze sind verfügbar.",
            "Dieses gemütliche Budgethotel liegt 10 Gehminuten von den Restaurants im Stadtzentrum, 12 Gehminuten vom Hauptbahnhof Regensburg und 14 Gehminuten vom Haidplatz entfernt.\n" +
                    "Die einfachen Zimmer bieten kostenloses WLAN und Flachbildfernseher sowie einen Tee- und Kaffeekocher. Kinder bis einschließlich 16 Jahre übernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Ein kontinentales Frühstücksbuffet wird kostenlos angeboten. Außerdem gibt es eine rund um die Uhr geöffnete Bar. Parkplätze stehen gegen Gebühr zur Verfügung.",
            "Dieses elegante Hotel liegt im Stadtzentrum gegenüber dem Regensburger Dom aus dem 13. Jahrhundert. Es ist 10 Gehminuten vom Hauptbahnhof Regensburg und 11 Gehminuten von Schloss St. Emmeram entfernt.\n" +
                    "Die gemütlich-modernen Zimmer sind mit WLAN, Flachbildfernseher, Nespressomaschine, Minibar und Marmorbad ausgestattet. Suiten bieten zusätzlich eine Sitzecke, manche auch Ausblick auf den Dom. Zimmerservice ist verfügbar und Kinder bis einschließlich 12 Jahre übernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Zur Ausstattung gehören ein nobles Restaurant mit bayerischer Küche und Frühstücksbuffet (gegen Aufpreis), eine Cocktailbar und ein Biergarten. Es gibt auch ein Business Center.",
            "Dieses elegante Hotel liegt im Stadtzentrum gegenüber dem Regensburger Dom aus dem 13. Jahrhundert. Es ist 10 Gehminuten vom Hauptbahnhof Regensburg und 11 Gehminuten von Schloss St. Emmeram entfernt.\n" +
                    "Die gemütlich-modernen Zimmer sind mit WLAN, Flachbildfernseher, Nespressomaschine, Minibar und Marmorbad ausgestattet. Suiten bieten zusätzlich eine Sitzecke, manche auch Ausblick auf den Dom. Zimmerservice ist verfügbar und Kinder bis einschließlich 12 Jahre übernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Zur Ausstattung gehören ein nobles Restaurant mit bayerischer Küche und Frühstücksbuffet (gegen Aufpreis), eine Cocktailbar und ein Biergarten. Es gibt auch ein Business Center.",
            "Dieses gemütliche Altstadthotel befindet sich in einem Patrizierhaus aus dem 12. Jahrhundert und ist 6 Gehminuten vom gotischen Regensburger Dom sowie 10 Gehminuten vom Historischen Museum Regensburg entfernt.\n" +
                    "Die gemütlichen Zimmer sind mit einem Schreibtisch ausgestattet und verfügen über einen Flachbildfernseher mit Premium-Kabelkanälen und kostenloses WLAN. Die Suiten bieten zusätzlich eine separate Sitzecke mit Sofa oder Sessel und haben teilweise schräge Holzbalkendecken.\n" +
                    "Das Frühstück ist im Preis inbegriffen. Es gibt ein farbenfrohes, modernes Café mit Bar-Lounge sowie ein Business Center und Konferenzräume. Haustiere sind gegen Aufpreis erlaubt.\n",
            "Dieses gemütliche Hotel mit traditionellem Charme liegt inmitten von Bars und Geschäften an einer kopfsteingepflasterten Straße. Es ist 7 Gehminuten vom gotischen Regensburger Dom aus dem 13. Jahrhundert und 14 Gehminuten vom Bahnhof Regensburg entfernt.\n" +
                    "Die hellen Zimmer mit Möbeln im historischen Stil bieten einen Flachbildfernseher und teilweise eine Sitzecke. Es gibt 2 elegante Suiten mit Wohnbereich und Holzbalkendecke. Kinder übernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Es gibt eine gemütliche, freundlich eingerichtete Bar. Das Frühstücksbuffet wird gegen Aufpreis angeboten.",
            "Dieses bodenständige Budgethotel an einer von Bäumen gesäumten Straße ist 1 km vom Regensburger Dom und 2 km von der Steinernen Brücke entfernt. Zum Hauptbahnhof Regensburg sind es 12 Gehminuten.\n" +
                    "Die zweckmäßig eingerichteten Zimmer mit farbenfrohen Akzenten haben WLAN und einen Flachbildfernseher. Zimmer mit gehobener Ausstattung bieten außerdem Stadtblick. In den Familienzimmern gibt es ein Schlafsofa.\n" +
                    "Es gibt eine zwanglose Lobbybar. Parkplätze sind vorhanden und ein Frühstücksbuffet wird angeboten.\n"
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
