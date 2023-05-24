package src.View.Screen;

import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Value.Pair;
import src.Model.Model;
import src.Model.Observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MapView extends JPanel implements Observer
{
    private Model model;
    private final int width, height;

    private Locality[] localities;
    private Pair<Integer, Integer>[] edges;
    private Integer[] lastPath;
    private static final double circleSize = 5;

    public MapView(Model model, int width, int height)
    {
        this.model = model;
        this.width = width;
        this.height = height;
        localities = new Locality[0];
        edges = new Pair[0];
        lastPath = new Integer[0];

        model.addObserver(this);

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

    //TODO : Add labels to every point on the map
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Vector2 center = new Vector2((double) width / 2, (double) height / 2);
        Point2D.Double[] points = new Point2D.Double[localities.length];
        for (int i = 0; i < localities.length; i++)
        {
            Vector2 pos = localities[i].getPosition().add(center);
            points[i] = new Point2D.Double(pos.getX(1), pos.getX(2));
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

        Font font = g2.getFont();
        g2.setFont(new Font(font.getName(), font.getStyle(), 18));
        for (int i = 0; i < points.length; i++)
        {
            Ellipse2D.Double locCircle = new Ellipse2D.Double(
                    points[i].getX() - circleSize / 2,
                    points[i].getY() - circleSize / 2,
                    circleSize,
                    circleSize
            );
            g2.setColor(Color.RED);
            g2.fill(locCircle);
            g2.setColor(Color.MAGENTA);
            g2.drawString("" + i, (float)(points[i].getX() + circleSize), (float)(points[i].getY() + circleSize));
        }
    }

    @Override
    public void update()
    {

    }
}
