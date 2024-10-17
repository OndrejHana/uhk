package Controller;

import Model.Line;
import Model.Mode;
import View.Panel;
import Model.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverController {
    private final Controller2D controller;
    private boolean draw;
    private boolean snap;

    public HoverController(Controller2D controller) {
        this.controller = controller;
        this.snap = false;
    }

    public void setInitialDraw() {
        var c = controller.getController();
        switch (c.getMode()) {
            case Polygon:
                var polygon = c.getPolygon();
                if (polygon != null && polygon.getSize() > 0) {
                    this.draw = true;
                } else {
                    this.draw = false;
                }
                break;
            case Line:
                 if (c.getLastPoint() == null) {
                     this.draw = false;
                 } else {
                     this.draw = true;
                 }
                break;
        }
    }

    public void initListeners(Panel panel) {
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                var c = controller.getController();

                if (!draw) {
                    return;
                }

                if (c.getLastPoint() == null) {
                    return;
                }
                var temp = new Point(e.getX(), e.getY());
                var l = c.getLastPoint();

                if (snap) {
                    var dx = Math.abs(l.getX() - temp.getX());
                    var dy = Math.abs(l.getY() - temp.getY());

                    if (dx < dy) {
                        temp.setX(l.getX());
                    }
                    else {
                        temp.setY(l.getY());
                    }
                }

                if (temp.equals(c.getHoveredPoint())) {
                    return;
                }

                c.setHoveredPoint(temp);
                controller.clear();
                controller.draw();
                controller.drawTempLine(new Line(c.getLastPoint(), c.getHoveredPoint(), 1));
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                var c = controller.getController();

                switch (c.getMode()) {
                    case Mode.Polygon:
                        c.setLastPoint(new Point(e.getX(), e.getY()));
                    var polygon = c.getPolygon();
                    if (polygon != null && polygon.getSize() > 0) {
                        c.setLastPoint(polygon.getPoint(polygon.getSize() - 1));
                        draw = true;
                    }
                    break;
                    case Mode.Line:
                        if (c.getLastPoint() != null) {
                            draw = true;
                        } else {
                            draw = false;
                        }
                        break;
                }

            }
        });

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    snap = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                    snap = false;
                }
            }
        });
    }
}
