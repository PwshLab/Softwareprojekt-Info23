package src.View.Screen;

import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Value.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MapView extends JPanel
{
    private final int width, height;

    private Locality[] localities;
    private Pair<Integer, Integer>[] edges;
    private Integer[] lastPath;
    private static final double circleSize = 5;

    public MapView(int width, int height)
    {
        this.width = width;
        this.height = height;
        localities = new Locality[0];
        edges = new Pair[0];
        lastPath = new Integer[0];

        initialize();
    }

    private void initialize()
    {
        setOpaque(true);
        setVisible(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
    }

    public void displayData(Locality[] localities, Pair<Integer, Integer>[] edges, Integer[] lastPath)
    {
        this.localities = localities;
        this.edges = edges;
        this.lastPath = lastPath;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Vector2 center = new Vector2((double) width / 2, (double) height / 2);
        Point2D.Double[] points = new Point2D.Double[localities.length];
        g2.setColor(Color.RED);
        for (int i = 0; i < localities.length; i++)
        {
            Vector2 pos = (Vector2) localities[i].getPosition().add(center);
            points[i] = new Point2D.Double(pos.getX(1), pos.getX(2));

            Ellipse2D.Double locCircle = new Ellipse2D.Double(
                    pos.getX(1) + circleSize / 2,
                    pos.getX(2) + circleSize / 2,
                    circleSize,
                    circleSize
            );
            g2.draw(locCircle);
        }

        g2.setColor(Color.BLACK);
        for (Pair<Integer, Integer> edge: edges)
        {
            Line2D.Double edgeLine = new Line2D.Double(
                    points[edge.getValue1()],
                    points[edge.getValue2()]
            );
            g2.draw(edgeLine);
        }

        g2.setColor(Color.BLUE);
        if (lastPath.length >= 2)
        {
            Point2D.Double lastPoint = points[lastPath[0]];
            for (int i = 1; i < lastPath.length; i++)
            {
                Line2D.Double edgeLine = new Line2D.Double(
                        lastPoint,
                        points[lastPath[i]]
                );
                g2.draw(edgeLine);
                lastPoint = points[lastPath[i]];
            }
        }
    }
}
