package Controller;

import Model.Mode;
import Model.Point;
import Model.Polygon;
import View.Panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PolygonController {
    private final Controller2D controller;

    public PolygonController(Controller2D controller) {
        this.controller = controller;
    }

    public void initListeners(Panel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                var c = controller.getController();

                if (c.getMode() != Mode.Polygon) {
                    return;
                }

                var p = c.getPolygon();

                if (p == null) {
                    c.setPolygon(new Polygon());
                    p = c.getPolygon();
                }

                var point = c.getHoveredPoint();
                if (point == null) {
                    point = new Point(e.getX(), e.getY());
                }
                p.addPoint(point);
                controller.clear();
                controller.draw();
            }
        });
    }
}
