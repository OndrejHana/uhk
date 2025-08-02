package view;

import rasterizer.RasterBufferedImage;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private RasterBufferedImage rasterBufferedImage;

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        rasterBufferedImage = new RasterBufferedImage(WIDTH, HEIGHT);
        rasterBufferedImage.setClearColor(Color.BLACK.getRGB());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        rasterBufferedImage.repaint(g);
    }

    public void clear(int color) {
        rasterBufferedImage.setClearColor(color);
        rasterBufferedImage.clear();
    }

    public RasterBufferedImage getRasterBufferedImage() {
        return rasterBufferedImage;
    }

    public RasterBufferedImage getRaster() {
        return rasterBufferedImage;
    }
}
