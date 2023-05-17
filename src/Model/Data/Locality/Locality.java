package src.Model.Data.Locality;

import src.Model.Data.CoordSystem.Vector2;

public class Locality
{
    private String name;
    private LocalityType type;
    private String description;
    private Vector2 position;

    public Locality(String name, LocalityType type, String description, Vector2 position)
    {
        this.name = name;
        this.type = type;
        this.description = description;
        this.position = position;
    }

    public Locality(String name, LocalityType type, Vector2 position)
    {
        this.name = name;
        this.type = type;
        this.description = "";
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

    public LocalityType getType()
    {
        return type;
    }

    public void setType(LocalityType type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
