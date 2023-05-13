package src.Model.Data;

import src.Model.Data.CoordSystem.Vector2;

public class Lokalität
{
    private String name;
    private LokalitätArt art;
    private String beschreibung;
    private Vector2 position;

    public Lokalität(String name, LokalitätArt art, String beschreibung, Vector2 position)
    {
        this.name = name;
        this.art = art;
        this.beschreibung = beschreibung;
        this.position = position;
    }

    public Lokalität(String name, LokalitätArt art, Vector2 position)
    {
        this.name = name;
        this.art = art;
        this.beschreibung = "";
        this.position = position;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LokalitätArt getArt()
    {
        return art;
    }

    public void setArt(LokalitätArt art)
    {
        this.art = art;
    }

    public String getBeschreibung()
    {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung)
    {
        this.beschreibung = beschreibung;
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public void setPosition(Vector2 position)
    {
        this.position = position;
    }

}
