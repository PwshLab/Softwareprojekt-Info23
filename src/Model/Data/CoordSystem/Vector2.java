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
     * Methode zum Addieren zweier Vektoren
     * @param other Anderer Vektor
     * @return Resultierender Vektor
     */
    public Vector2 add(Vector2 other)
    {
        return new Vector2(this.x1 + other.x1, this.x2 + other.x2);
    }

    /**
     * Methode für den Gegenvektor eines Vektors
     * @return Gegenvektor des Vektors
     */
    public Vector2 neg()
    {
        return new Vector2(-this.x1, -this.x2);
    }

    /**
     * Methode zum Subtrahieren zweier Vektoren
     * @param other Anderer Vektor
     * @return Resultierender Vektor
     */
    public Vector2 sub(Vector2 other)
    {
        return this.add(other.neg());
    }

    /**
     * Methode zum Skalieren eines Vektors
     * @param n Skalarfaktor
     * @return Resultierender Vektor
     */
    public Vector2 multiply(double n)
    {
        return new Vector2(this.x1 * n, this.x2 * n);
    }

    /**
     * Methode zum Berechnen des Normalvektors eines Vektors
     * @return Normalvektor des Vektors
     */
    public Vector2 normalized()
    {
        return this.multiply(1 / this.magnitude());
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
