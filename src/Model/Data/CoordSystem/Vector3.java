package src.Model.Data.CoordSystem;

/**
 * Vektor im 3-Dimensionalen Raum
 */
public class Vector3
{
    protected final double x1, x2, x3;

    /**
     * Standard Nullvektor
     */
    public static Vector3 zero = new Vector3(0, 0, 0);

    /**
     * Standartkonstruktor des Vektors
     * @param x1 X1 Koordinate
     * @param x2 X2 Koordinate
     * @param x3 X3 Koordinate
     */
    public Vector3(double x1, double x2, double x3)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    /**
     * Methode zum Addieren zweier Vektoren
     * @param other Anderer Vektor
     * @return Resultierender Vektor
     */
    public Vector3 add(Vector3 other)
    {
        return new Vector3(this.x1 + other.x1, this.x2 + other.x2, this.x3 + other.x3);
    }

    /**
     * Methode für den Gegenvektor eines Vektors
     * @return Gegenvektor des Vektors
     */
    public Vector3 neg()
    {
        return new Vector3(-this.x1, -this.x2, -this.x3);
    }

    /**
     * Methode zum Subtrahieren zweier Vektoren
     * @param other Anderer Vektor
     * @return Resultierender Vektor
     */
    public Vector3 sub(Vector3 other)
    {
        return this.add(other.neg());
    }

    /**
     * Methode zum Skalieren eines Vektors
     * @param n Skalar faktor
     * @return Resultierender Vektor
     */
    public Vector3 multiply(double n)
    {
        return new Vector3(this.x1 * n, this.x2 * n, this.x3 * n);
    }

    /**
     * Methode zum Berechnen des Punktprodukts zweier Vektoren
     * @param other Anderer Vektor
     * @return Ergebnis des Punktprodukts
     */
    public double dotProduct(Vector3 other)
    {
        return this.x1 * other.x1 + this.x2 * other.x2 + this.x3 * other.x3;
    }

    /**
     * Methode zum Berechnen der Länge eines Vektors
     * @return Länge des Vektors
     */
    public double magnitude()
    {
        return Math.sqrt(this.dotProduct(this));
    }

    /**
     * Methode zum Berechnen der Entfernung zwischen zwei Punkten
     * @param other Anderer Vektor
     * @return Entfernung zwischen den Punkten
     */
    public double distance(Vector3 other)
    {
        return this.sub(other).magnitude();
    }

    /**
     * Methode zum Berechnen des Normalvektors eines Vektors
     * @return Normalvektor des Vektors
     */
    public Vector3 normalized()
    {
        return this.multiply(1 / this.magnitude());
    }

    /**
     * Methode zum Ausgeben eines Vektors als String
     * @return Vektor als String
     */
    public String toString()
    {
        return "(" + x1 + "/" + x2 + "/" + x3 + ")";
    }

    /**
     * Methode zum Ausgeben der N-Ten Koordinate
     * @param n Der Wert N
     * @return Wert der zugehörigen Koordinate
     */
    public double getX(int n)
    {
        return switch (n) {
            case 1 -> x1;
            case 2 -> x2;
            case 3 -> x3;
            default -> 0;
        };
    }
}
