package Controller;

import Model.Line;
import Model.Mode;
import Model.Point;
import View.Panel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineController {
    private final Controller2D controller;
    private int thickness = 1;

    public LineController(Controller2D controller) {
        this.controller = controller;
    }

    public void initListeners(Panel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                var c = controller.getController();
                if (c.getMode() != Mode.Line) {
                    return;
                }

                var current = new Point(e.getX(), e.getY());
                if (c.getLastPoint() == null) {
                    c.setLastPoint(current);
                } else {
                    c.getLineModel().addLine(new Line(c.getLastPoint(), c.getHoveredPoint(), thickness));
                    c.setLastPoint(null);
                    controller.clear();
                    controller.draw();
                }
            }
        });

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                // shift key
                if (e.getKeyCode() == 32) {
                    thickness = 5;
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    thickness = 1;
                }
            }
        });
    }

}
