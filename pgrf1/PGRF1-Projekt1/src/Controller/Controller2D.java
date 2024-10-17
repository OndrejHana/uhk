package Controller;

import View.Panel;
import View.rasterizer.LineRasterizer;
import View.rasterizer.PolygonRasterizer;
import Model.Line;

import java.awt.*;

public class Controller2D {
    private final Controller controller;
    private final LineRasterizer lineRasterizer;
    private final Panel panel;
    private final PolygonRasterizer polygonRasterizer;

    public Controller2D(Controller controller, LineRasterizer lineRasterizer, PolygonRasterizer polygonRasterizer, Panel panel) {
        this.controller = controller;
        this.lineRasterizer = lineRasterizer;
        this.polygonRasterizer = polygonRasterizer;
        this.panel = panel;
    }

    public void draw() {
        switch (controller.getMode()) {
            case Line:
                lineRasterizer.setColor(Color.GREEN);
                controller
                        .getLineModel()
                        .getLines()
                        .forEach(line -> lineRasterizer.rasterize(line));
                break;
            case Polygon:
                polygonRasterizer.setColor(Color.RED);
                polygonRasterizer.rasterize(controller.getPolygon());
                break;
        };
        panel.repaint();
    }

    public void drawTempLine(Line line) {
        lineRasterizer.setColor(Color.GRAY);
        lineRasterizer.rasterize(line);
        panel.repaint();
    }

    public void clear() {
        panel.getRaster().clear();
        panel.repaint();
    }

    public Controller getController() {
        return controller;
    }

    public void clearModel() {
        var c = this.getController();
        switch (c.getMode()) {
            case Polygon:
                c.setPolygon(null);
                break;
            case Line:
                c.getLineModel().clear();
                break;
        }
        c.setLastPoint(null);
        this.clear();
    }
}
