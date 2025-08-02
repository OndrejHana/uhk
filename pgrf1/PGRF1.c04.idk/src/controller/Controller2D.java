package controller;

import model.Point;
import model.Polygon;
import rasterizer.*;
import view.Panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller2D {
    private final Panel panel;
    public LineRasterizer lineRasterizer;

    private Polygon polygon;
    private PolygonRasterizer polygonRasterizer;

    public Controller2D(Panel panel, Raster raster) {
        this.panel = panel;
        lineRasterizer = new LineRasterizerBresenham(raster);
        lineRasterizer.setColor(Color.RED);

        polygon = new Polygon();
        polygonRasterizer = new PolygonRasterizer(lineRasterizer);
    }

    public void drawPolygon() {
        lineRasterizer.setColor(Color.RED.getRGB());
        polygonRasterizer.rasterize(polygon);
    }

    public void initListeners(Panel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                panel.clear(Color.BLACK.getRGB());

                polygon.addPoint(new Point(e.getX(), e.getY()));
                drawPolygon();

                panel.repaint();
            }
        });
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public Polygon getPolygon() {
        return polygon;
    }
}
