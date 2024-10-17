package rasterizer;

import model.Line;
import model.Polygon;

public class PolygonRasterizer {
    private LineRasterizer lineRasterizer;

    public PolygonRasterizer(LineRasterizer lineRasterizer) {
        this.lineRasterizer = lineRasterizer;
    }

    public void rasterize(Polygon polygon) {

        if (polygon.getSize() == 2) {
            var a = polygon.getPoint(0);
            var b = polygon.getPoint(1);
            lineRasterizer.rasterize(new Line(a, b));
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

            lineRasterizer.rasterize(new Line(a, b));
        }

    }
}
