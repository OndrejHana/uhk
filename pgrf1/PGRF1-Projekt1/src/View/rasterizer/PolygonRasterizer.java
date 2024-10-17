package View.rasterizer;


import Model.Line;
import Model.Polygon;
import View.Panel;

import java.awt.*;

public class PolygonRasterizer {
    private LineRasterizer lineRasterizer;
    private Color color;
    private int thickness = 1;

    public PolygonRasterizer(LineRasterizer lineRasterizer) {
        this.lineRasterizer = lineRasterizer;
    }

    public void setColor(int color) {
        this.color = new Color(color);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void rasterize(Polygon polygon) {
        if (polygon == null) {
            return;
        }

        lineRasterizer.setColor(color);
        if (polygon.getSize() == 2) {
            var a = polygon.getPoint(0);
            var b = polygon.getPoint(1);
            lineRasterizer.rasterize(new Line(a, b, thickness));
            return;
        }
        if (polygon.getSize() < 3) {
            return;
        }

        for (int i = 0; i < polygon.getSize(); i++) {
            int indexA = i;
            int indexB = i + 1;

            if (indexA == polygon.getSize()-1) {
                indexB = 0;
            }

            var a = polygon.getPoint(indexA);
            var b = polygon.getPoint(indexB);

            lineRasterizer.rasterize(new Line(a, b, thickness));
        }

    }
}
