package controller;

import rasterizer.Raster;
import view.Panel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController {
    private Panel panel;
    private Raster raster;
    private Controller2D controller2D;

    public KeyboardController(Panel panel) {
        this.panel = panel;
        this.raster = panel.getRasterBufferedImage();
    }

    public void initListeners() {
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 67) {
                    controller2D.setPolygon(null);
                    raster.clear();
                }
            }
        });
    }
}
