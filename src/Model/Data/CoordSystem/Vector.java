package src.Model.Data.CoordSystem;

public class Vector
{
    private double x1;
    private double x2;

    public static Vector zero = new Vector(0, 0);
    public static Vector up = new Vector(0, 1);
    public static Vector forward = new Vector(1, 0);

    public Vector(double x1, double x2)
    {
        this.x1 = x1;
        this.x2 = x2;
    }

    private Vector add(Vector other)
    {
        return new Vector(this.x1 + other.x1, this.x2 + other.x2);
    }

    private Vector neg()
    {
        return new Vector(-this.x1, -this.x2);
    }

    private Vector sub(Vector other)
    {
        return this.add(other.neg());
    }

    public Vector multiply(double n)
    {
        return new Vector(this.x1 * n, this.x2 * n);
    }

    public double dotProduct(Vector other)
    {
        return this.x1 * other.x1 + this.x2 * other.x2;
    }

    public double magnitude()
    {
        return Math.sqrt(this.dotProduct(this));
    }

    public double distance(Vector other)
    {
        return this.sub(other).magnitude();
    }

    public Vector normalized()
    {
        return this.multiply(1 / this.magnitude());
    }
}
