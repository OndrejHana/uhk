package controller;

import model.Line;
import model.Point;
import model.Polygon;
import view.Panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverController {
    private boolean draw;
    private Point lastPoint;
    private Point hoveredPoint;
    private Controller2D controller;
    private Polygon polygon;


    public HoverController(Controller2D controller) {
        this.controller = controller;
        this.polygon = controller.getPolygon();

        if (this.polygon != null && polygon.getSize() > 0) {
            this.lastPoint = polygon.getPoint(polygon.getSize() - 1);
            this.draw = true;
        } else {
            this.draw = false;
        }
    }

    public void initListeners(Panel panel) {
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!draw || lastPoint == null) {
                    return;
                }
                var temp = new Point(e.getX(), e.getY());
                if (temp.equals(hoveredPoint)) {
                    return;
                }

                hoveredPoint = temp;
                panel.clear(Color.BLACK.getRGB());
                controller.lineRasterizer.setColor(Color.GRAY.getRGB());
                controller.lineRasterizer.rasterize(new Line(lastPoint, hoveredPoint));
                controller.drawPolygon();
                panel.repaint();
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastPoint = new Point(e.getX(), e.getY());

                if (polygon != null && polygon.getSize() > 0) {
                    lastPoint = polygon.getPoint(polygon.getSize() - 1);
                    draw = true;
                }
            }
        });
    }
}
