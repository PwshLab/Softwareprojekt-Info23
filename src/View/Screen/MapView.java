package src.View.Screen;

import src.Model.Data.CoordSystem.Vector2;
import src.Model.Data.LinkedList.List;
import src.Model.Data.Locality.Locality;
import src.Model.Data.Value.Pair;
import src.Model.Model;
import src.Model.Observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Panel für die Kartenansicht
 */
public class MapView extends JPanel implements Observer
{
    private final Model model;
    private List<Locality> localities;
    private List<Pair<Integer, Integer>> edges;
    private Integer[] lastPath;
    private static final double circleSize = 5;

    /**
     * Standardkonstruktor der MepView
     * @param model Referenz zum Model
     */
    public MapView(Model model)
    {
        this.model = model;
        this.localities = new List<>();
        this.edges = new List<>();
        this.lastPath = new Integer[0];

        model.addObserver(this);
        initialize();
    }

    /**
     * Methode zum Initialisieren der Kartenansicht
     */
    private void initialize()
    {
        setOpaque(true);
        setVisible(true);
        setPreferredSize(new Dimension(model.getWorldBound() * 2 + 10, model.getWorldBound() * 2 + 10));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    /**
     * Überschriebene Methode aus der JPanel Klasse,
     * um eigene 2D Darstellungen zu zeichnen
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Berechnung der Koordinatenskalierung
        double averageSize = (double) (getBounds().width + getBounds().height) / 2;
        double displayFactor = averageSize / (model.getWorldBound() * 2) * 0.875;

        // Übertragen der Weltkoordinaten auf die Zeichenebene
        Vector2 center = new Vector2((double) getBounds().width / 2, (double) getBounds().height / 2);
        Point2D.Double[] points = new Point2D.Double[localities.count()];
        int index = 0;
        for (Locality l: localities)
        {
            Vector2 pos = l.getPosition().multiply(displayFactor).add(center);
            points[index] = new Point2D.Double(pos.getX(1), pos.getX(2));
            index++;
        }

        // Einzeichnen der Kanten im Graphen
        g2.setColor(Color.BLACK);
        for (Pair<Integer, Integer> edge: edges)
        {
            Line2D.Double edgeLine = new Line2D.Double(
                    points[edge.getValue1()],
                    points[edge.getValue2()]
            );
            g2.draw(edgeLine);
        }

        // Einzeichnen des kürzesten Weges (falls vorhanden)
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));
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

        // Einzeichnen der gefilterten Distanzsuche
        if (model.isFilterByDistance())
        {
            Vector2 filterPos = model.getFilterPosition().multiply(displayFactor).add(center);
            double filterDist = model.getFilterDistance() * displayFactor;
            Ellipse2D.Double filterCircle = new Ellipse2D.Double(
                    filterPos.getX(1) - filterDist,
                    filterPos.getX(2) - filterDist,
                    filterDist * 2,
                    filterDist * 2
            );
            g2.setColor(Color.CYAN);
            g2.draw(filterCircle);
            Color transparentCyan = new Color(Color.CYAN.getRed(), Color.CYAN.getGreen(), Color.CYAN.getBlue(), 25);
            g2.setColor(transparentCyan);
            g2.fill(filterCircle);
        }

        // Einzeichnen der Lokalitäten mit Index
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
            g2.drawString(String.valueOf(i), (float)(points[i].getX() + circleSize), (float)(points[i].getY() + circleSize));
        }
    }

    /**
     * Methode zum Aktualisieren der Kartenansicht
     */
    @Override
    public void update()
    {
        localities = model.getElements();
        edges = model.getEdges();
        lastPath = model.getLastPath().toArray(Integer.class);
        repaint();
    }
}
