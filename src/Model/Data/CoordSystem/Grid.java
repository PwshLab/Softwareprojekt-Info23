package src.Model.Data.CoordSystem;

import src.Model.Data.LinkedList.List;

public class Grid
{
    private static Vector3 origin = Vector3.zero;

    public static double getPathLength(List<Vector2> path)
    {
        double length = 0;
        Vector2 prevPoint = null;
        for (Vector2 point: path)
        {
            if (prevPoint == null)
                prevPoint = point;
            length += prevPoint.distance(point);
            prevPoint = point;
        }
        return length;
    }

    public static int[] getNNearest(Vector2 startPoint, List<Vector2> otherPoints, int number)
    {
        if (number > otherPoints.count())
            throw new IllegalArgumentException();

        double[] distances = new double[otherPoints.count()];
        int index = 0;
        for (Vector2 point: otherPoints)
            distances[index] = startPoint.distance(point);

        int[] indices = new int[number];
        double minimum = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++)
            minimum = Math.min(minimum, distances[i]);


    }
}
