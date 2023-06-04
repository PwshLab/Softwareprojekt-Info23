package src.Model.Data.CoordSystem;

import src.Model.Data.LinkedList.List;

public final class Grid
{

    private Grid()
    {
    }

    /**
     * Methode zum Berechnen der N naechsten Punkte zu einem Ausgangspunkt
     * @param startPoint Position des Ausgangspunktes
     * @param otherPoints Liste der anderen Punkte
     * @param number Die Zahl N
     * @return Indices der N naechsten Punkte
     */
    public static int[] getNNearest(Vector2 startPoint, List<Vector2> otherPoints, int number)
    {
        if (number > otherPoints.count())
            throw new IllegalArgumentException();

        if (number == 0 || otherPoints.count() == 0)
            return new int[0];

        double[] distances = new double[otherPoints.count()];
        int index = 0;
        for (Vector2 point: otherPoints)
        {
            distances[index] = startPoint.distance(point);
            index++;
        }

        int[] indices = new int[number];
        double minimum = Double.MAX_VALUE;
        for (double distance : distances)
            minimum = Math.min(minimum, distance);

        /*
         * Wenn man von 5 gesuchten Elementen ausgeht, dann
         * ist dieses Vorgehen ab ca. 150 Eingabeelementen
         * schneller als das vorherige Sortieren der Elemente
         * in O(n * log(n)) Zeit
         */
        index = 0;
        double newMinimum = Double.MAX_VALUE;
        while (index < indices.length)
        {
            for (int j = 0; j < distances.length; j++)
            {
                if (minimum == distances[j]) // Speichern des Index des kleinsten Abstandes
                {
                    indices[index] = j;
                    index++;
                }
                else if (minimum < distances[j]) // Auswaehlen des naechst groeßeren Abstandes
                {
                    newMinimum = Math.min(newMinimum, distances[j]);
                }
            }
            minimum = newMinimum;
        }
        return indices;
    }
}
