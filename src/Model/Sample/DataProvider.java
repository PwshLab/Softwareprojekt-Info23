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
            "Gastst�tte Quetschn",
            "Gastst�tte Gravenreuther",
            "Restaurant COMING HOME",
            "Restaurant Orph�e",
            "Pizza & Pasta Restaurant",
            "Restaurant Krauterer am Dom",
            "Restaurant Mesopotamia",
            "Restaurant Rosarium",
            "Dicker Mann",
            "Restaurant G�nsbauer",
            "Wirtshaus 'Zum Sorgenfrei'",
            "Storstad Restaurant",
            "Piratenh�hle",
            "Heimat Regensburg",
            "Musikbar SAX",
            "Banane",
            "Hinterhaus",
            "Mono Bar",
            "Bar 13",
            "B�RO",
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
            "Rustikale deutsche Gerichte wie Schnitzel in einem gem�tlichen, traditionellen Lokal mit Holzbalken und Bier. Speisen vor Ort. Essen zum Mitnehmen.",
            "Traditionelle bayerische Gerichte in einem urigen Wirtshaus mit nostalgischer Einrichtung und Tischen am Gehweg. Sitzpl�tze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Gutb�rgerliche K�che in einem gem�tlichen Restaurant mit einer Bar und einer Gartenterrasse. Sitzpl�tze im Freien. Abholung vor dem Laden. Essen zum Mitnehmen. Speisen vor Ort.",
            "Mediterrane Gerichte und Wein in einem beliebten, traditionellen Bistro mit Bar und Terrasse. Sitzpl�tze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "In der offenen K�che des Restaurants mit Heiligenbildern und Terrasse werden italienische Gerichte zubereitet. Sitzpl�tze im Freien. Lieferdienst. Essen zum Mitnehmen. Speisen vor Ort.",
            "Bayerisches Restaurant. Sitzpl�tze im Freien. Speisen vor Ort.",
            "Unpr�tenti�ses Restaurant mit kurdischen und vegetarischen Gerichten wie Kebabs, Falafel und Salaten. Sitzpl�tze im Freien. Kontaktlose Lieferung. Lieferdienst. Essen zum Mitnehmen. Speisen vor Ort.",
            "Bistro mit mediterraner K�che und gro�er Au�enterrasse in einem Park. Sitzpl�tze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Deftige �sterreichische Hauptspeisen und Desserts in einem Geb�ude aus dem 14. Jahrhundert. Sitzpl�tze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Restaurant f�r Bayerische Tapas. Essen zum Mitnehmen. Speisen vor Ort.",
            "Traditionelles Bayerisches Restaurant mit Biergarten. Sitzpl�tze im Freien. Essen zum Mitnehmen. Speisen vor Ort.",
            "Edles, minimalistisches Restaurant mit Degustationsmen�s origineller europ�isch-asiatischer Fusionsgerichte. Sitzpl�tze im Freien. Speisen vor Ort.",
            "Flippige Kellerkneipe mit Piratenmotiven sowie Rock- und Heavy-Metal-Musik in einem mittelalterlichen Geb�ude. Sitzpl�tze im Freien. Speisen vor Ort.",
            "Craft-Bier und Cocktails in einer kleinen Bar mit lockerem Flair und Livemusik von regionalen Bands und K�nstlern. Sitzpl�tze im Freien. Abholung vor dem Laden. Drive-in. Essen zum Mitnehmen. Speisen vor Ort. Live-Veranstaltungen. LGBTQ+-freundlich. Kartenzahlung m�glich.",
            "Speisen vor Ort.",
            "Speisen vor Ort.",
            "Speisen vor Ort. Kartenzahlung m�glich.",
            "Gem�tliches Ambiente.",
            "Im Lokal mit Natursteinw�nden l�sst sich bei Drinks und Pizza kickern, Dart spielen und Karaoke singen. Essen zum Mitnehmen. Speisen vor Ort. LGBTQ+-freundlich",
            "Speisen vor Ort.",
            "Sitzpl�tze im Freien. Abholung vor dem Laden. Essen zum Mitnehmen. Speisen vor Ort.",
            "Mottopartys mit verschiedenen DJs und Cocktailspecials in der Bar mit bunten W�nden und Neonr�hren. Abholung vor dem Laden. Speisen vor Ort. Rollstuhlgerechter Eingang.",
            "Stilvolle Cocktailbar in historischem Gew�lbe und modernem Ambiente mit Kursen und Verkostungen. Speisen vor Ort. Gehobenes Ambiente.",
            "Speisen vor Ort. LGBTQ+-freundlich. Hunde erlaubt.",
            "Nacht- und Tanzclub mit Studentenpartys, DJs, Spezialveranstaltungen und Live-Auftritten. Speisen vor Ort. Gem�tliches Ambiente.",
            "Speisen vor Ort. Live-Veranstaltungen.",
            "Kleiner, pulsierender Nachtclub mit Cocktails und Bier sowie Tanzfl�che und Partymusik vergangener Jahrzehnte. Speisen vor Ort.",
            "Speisen vor Ort.",
            "Studentenpartys und Tanz zur Musik der letzten 4 Jahrzehnte im heimeligen Kellergew�lbe mit Backsteinmauern. Speisen vor Ort.",
            "In der etablierten Discothek tanzt man in lockerer Atmosph�re zu Electro, Techno, Indie und den 80er-Charts. Speisen vor Ort.",
            "Speisen vor Ort.",
            "Speisen vor Ort. Live-Veranstaltungen.",
            "Dieses schicke Hotel mit Originalkunstwerken ist 16 Gehminuten vom Hauptbahnhof Regensburg sowie jeweils 2 km von der Steinernen Br�cke aus dem 12. Jahrhundert und vom Regensburger Dom entfernt.\n" +
                    "Die modernen Zimmer mit Wandmalereien zum Thema Architektur bieten WLAN und einen Flachbildfernseher. In Zimmern mit gehobener Ausstattung gibt es ein ausziehbares Sofa.\n" +
                    "Es gibt eine Bar und Fr�hst�ck wird angeboten.\n",
            "Dieses schlichte und preisg�nstige Hotel im Stadtzentrum liegt 3 Gehminuten vom Bahnhof Regensburg und 1,1 km vom Regensburger Dom entfernt.\n" +
                    "Die modernen Zimmer sind mit kostenlosem WLAN, einem Flachbildfernseher, einem Schreibtisch und Holzb�den ausgestattet. Haustiere sind gegen Geb�hr willkommen.\n" +
                    "Das Hotel bietet ein kostenloses Fr�hst�cksbuffet, eine durchgehend ge�ffnete gem�tliche Bar, in der Snacks serviert werden, und einen Innenspielplatz. Ferner stehen ein Business Center und Tagungsr�ume zur Verf�gung.",
            "Dieses stilvolle Hotel in einer ehemaligen Manufaktur f�r Kunsthandwerk liegt direkt an der Donau. Es ist 10 Gehminuten vom Regensburger Dom und 14 Gehminuten vom Historischen Museum Regensburg entfernt.\n" +
                    "Die modernen Zimmer bieten ein Marmorbad mit Granitboden, einen Flachbildfernseher, WLAN, einen Schreibtisch und eine Minibar sowie teilweise Flussblick. In den Zimmern mit gehobener Ausstattung gibt es M�glichkeiten zur Kaffee- und Teezubereitung. Die Suiten haben au�erdem ein Wohnzimmer. Eine Klimaanlage ist nicht vorhanden.\n" +
                    "Das Hotel bietet ein nobles Restaurant mit Terrasse und Flussblick sowie gelegentlichen Dinnershows. Eine helle Lobbybar, Massageanwendungen und eine Sauna sind ebenfalls verf�gbar.",
            "Dieses zwanglose Hotel in einem Gewerbegebiet ist jeweils 11 Gehminuten vom Hauptbahnhof Regensburg und vom Einkaufszentrum Regensburg Arcaden entfernt. Zur Alten Steinbr�cke aus dem 12. Jahrhundert �ber die Donau sind es 3 km.\n" +
                    "Die freundlich eingerichteten, gem�tlichen Zimmer bieten kostenloses WLAN, einen Flachbildfernseher, einen Minik�hlschrank und eine Sitzecke. Zimmer mit gehobener Ausstattung haben zus�tzlich eine Pantryk�che.\n" +
                    "Zum kostenlosen Angebot geh�ren das Fr�hst�ck und Zugang zu einem nahe gelegenen Fitnesscenter mit Sport- und Wellnessangeboten. Es gibt auch ein elegantes Fischrestaurant, eine stilvolle Bar und eine Lounge mit Kamin. Parkpl�tze sind verf�gbar.",
            "Dieses gem�tliche Budgethotel liegt 10 Gehminuten von den Restaurants im Stadtzentrum, 12 Gehminuten vom Hauptbahnhof Regensburg und 14 Gehminuten vom Haidplatz entfernt.\n" +
                    "Die einfachen Zimmer bieten kostenloses WLAN und Flachbildfernseher sowie einen Tee- und Kaffeekocher. Kinder bis einschlie�lich 16 Jahre �bernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Ein kontinentales Fr�hst�cksbuffet wird kostenlos angeboten. Au�erdem gibt es eine rund um die Uhr ge�ffnete Bar. Parkpl�tze stehen gegen Geb�hr zur Verf�gung.",
            "Dieses elegante Hotel liegt im Stadtzentrum gegen�ber dem Regensburger Dom aus dem 13. Jahrhundert. Es ist 10 Gehminuten vom Hauptbahnhof Regensburg und 11 Gehminuten von Schloss St. Emmeram entfernt.\n" +
                    "Die gem�tlich-modernen Zimmer sind mit WLAN, Flachbildfernseher, Nespressomaschine, Minibar und Marmorbad ausgestattet. Suiten bieten zus�tzlich eine Sitzecke, manche auch Ausblick auf den Dom. Zimmerservice ist verf�gbar und Kinder bis einschlie�lich 12 Jahre �bernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Zur Ausstattung geh�ren ein nobles Restaurant mit bayerischer K�che und Fr�hst�cksbuffet (gegen Aufpreis), eine Cocktailbar und ein Biergarten. Es gibt auch ein Business Center.",
            "Dieses elegante Hotel liegt im Stadtzentrum gegen�ber dem Regensburger Dom aus dem 13. Jahrhundert. Es ist 10 Gehminuten vom Hauptbahnhof Regensburg und 11 Gehminuten von Schloss St. Emmeram entfernt.\n" +
                    "Die gem�tlich-modernen Zimmer sind mit WLAN, Flachbildfernseher, Nespressomaschine, Minibar und Marmorbad ausgestattet. Suiten bieten zus�tzlich eine Sitzecke, manche auch Ausblick auf den Dom. Zimmerservice ist verf�gbar und Kinder bis einschlie�lich 12 Jahre �bernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Zur Ausstattung geh�ren ein nobles Restaurant mit bayerischer K�che und Fr�hst�cksbuffet (gegen Aufpreis), eine Cocktailbar und ein Biergarten. Es gibt auch ein Business Center.",
            "Dieses gem�tliche Altstadthotel befindet sich in einem Patrizierhaus aus dem 12. Jahrhundert und ist 6 Gehminuten vom gotischen Regensburger Dom sowie 10 Gehminuten vom Historischen Museum Regensburg entfernt.\n" +
                    "Die gem�tlichen Zimmer sind mit einem Schreibtisch ausgestattet und verf�gen �ber einen Flachbildfernseher mit Premium-Kabelkan�len und kostenloses WLAN. Die Suiten bieten zus�tzlich eine separate Sitzecke mit Sofa oder Sessel und haben teilweise schr�ge Holzbalkendecken.\n" +
                    "Das Fr�hst�ck ist im Preis inbegriffen. Es gibt ein farbenfrohes, modernes Caf� mit Bar-Lounge sowie ein Business Center und Konferenzr�ume. Haustiere sind gegen Aufpreis erlaubt.\n",
            "Dieses gem�tliche Hotel mit traditionellem Charme liegt inmitten von Bars und Gesch�ften an einer kopfsteingepflasterten Stra�e. Es ist 7 Gehminuten vom gotischen Regensburger Dom aus dem 13. Jahrhundert und 14 Gehminuten vom Bahnhof Regensburg entfernt.\n" +
                    "Die hellen Zimmer mit M�beln im historischen Stil bieten einen Flachbildfernseher und teilweise eine Sitzecke. Es gibt 2 elegante Suiten mit Wohnbereich und Holzbalkendecke. Kinder �bernachten kostenlos im Zimmer eines Erwachsenen.\n" +
                    "Es gibt eine gem�tliche, freundlich eingerichtete Bar. Das Fr�hst�cksbuffet wird gegen Aufpreis angeboten.",
            "Dieses bodenst�ndige Budgethotel an einer von B�umen ges�umten Stra�e ist 1 km vom Regensburger Dom und 2 km von der Steinernen Br�cke entfernt. Zum Hauptbahnhof Regensburg sind es 12 Gehminuten.\n" +
                    "Die zweckm��ig eingerichteten Zimmer mit farbenfrohen Akzenten haben WLAN und einen Flachbildfernseher. Zimmer mit gehobener Ausstattung bieten au�erdem Stadtblick. In den Familienzimmern gibt es ein Schlafsofa.\n" +
                    "Es gibt eine zwanglose Lobbybar. Parkpl�tze sind vorhanden und ein Fr�hst�cksbuffet wird angeboten.\n"
        };
    private final Model model;

    /**
     * Standardkonstruktor des DataProviders
     * @param model Referenz zum Model
     */
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
        return names.length;
    }

    /**
     * Methode zum Ausgeben einer beispiel Lokalit�t
     * @param n Index der Lokalit�t
     * @return Eine Lokalit�t
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
     * Methode zum Ausgeben eines Iterators f�r die Beispieldaten
     * @return Iterator f�r dieses Objekt
     */
    @Override
    public Iterator<Locality> iterator()
    {
        return new ProviderIterator(this);
    }
}
