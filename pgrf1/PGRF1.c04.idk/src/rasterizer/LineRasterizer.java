package rasterizer;

import jdk.jshell.spi.ExecutionControl;
import model.Line;

import java.awt.*;

public abstract class LineRasterizer {
    Color color;
    Raster raster;

    public LineRasterizer(Raster raster) {
        this.raster = raster;
    }

    public void setColor(int color) {
        this.color = new Color(color);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void rasterize(Line line) {
        drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    protected void drawLine(int x1, int y1, int x2, int y2) {
    }

}
