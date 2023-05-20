package src.Model.Data.CoordSystem;

/**
 * Vektor in der 2-Dimensionalen Ebene
 */
public class Vector2 extends Vector3
{
    public static Vector2 zero = new Vector2(0, 0);

    /**
     * Standartkonstruktor des Vektors
     * @param x1 X1 Koordinate
     * @param x2 X2 Koordinate
     */
    public Vector2(double x1, double x2)
    {
        super(x1, x2, 0);
    }

    /**
     * Methode zum Ausgeben eines Vektors als String
     * @return Vektor als String
     */
    public String toString()
    {
        return "(" + x1 + "/" + x2 + ")";
    }
}
