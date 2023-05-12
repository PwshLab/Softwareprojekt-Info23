package src.Model.Data.CoordSystem;

/**
 * Vektor in der 2-Dimensionalen Ebene
 */
public class Vector2 extends Vector3
{
    /**
     * Standartkonstruktor des Vektors
     * @param x1 X1 Koordinate
     * @param x2 X2 Koordinate
     */
    public Vector2(double x1, double x2)
    {
        super(x1, x2, 0);
    }
}
