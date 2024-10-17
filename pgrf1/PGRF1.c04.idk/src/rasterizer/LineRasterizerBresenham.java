package rasterizer;

import java.awt.*;

public class LineRasterizerBresenham extends LineRasterizer {

    public LineRasterizerBresenham(Raster raster) {
        super(raster);
    }

    // Implementoval jsem Bresenhamův algoritmus kvůli jeho efektivitě a rozšířenosti.
    // Velká výhoda bresenhamova algoritmu je, že nevyžaduje provádění žádných floating point operací.
    // Aby se vyhnul floating point operacím, v algoritmu se využívá rozhodovacího parametru p, který
    // je v každém kroku inkrementální vypočten a podle něj se rozhoduje který pixel bude vykreslen
    @Override
    protected void drawLine(int x1, int y1, int x2, int y2) {
        // Kontroluje se jestli čára vede horizontálně nebo vertikálně.
        if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
            drawLineH(x1, y1, x2, y2);
        } else {
            drawLineV(x1, y1, x2, y2);
        }
    }

    // Implementace bresenhamova algoritmu pro vykreslování horizontálních čar
    private void drawLineH(int x1, int y1, int x2, int y2) {
        var img = ((RasterBufferedImage) raster).getImage();

        // Bresenhamův algoritmus ze základu funguje pouze v prvním oktantu, takže
        // pokud vede čára ve 2. nebo 3. kvadrantu, prohodí hodnoty pro správné vykreslení
        if (x1 > x2) {
            var temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }

        int dx = x2 - x1;
        int dy = y2 - y1;

        // Rozhoduje směr kterým se bude čára vykreslovat. v Případě že by čára
        // vedla ve 3. nebo 4. kvadrantu chceme obrátit hodnoty x a y.
        int dir;
        if (dy > 0) {
            dir = 1;
        } else {
            dir = -1;
        }

        dy *= dir;

        if (dx != 0) {
            var y = y1;
            // Vytvoření rozhodovacího parametru v prvním kroce.
            var p = 2*dy-dx;

            for (var i = x1; i <= x2; i++) {
                img.setRGB(i, y, super.color.getRGB());
                // pokud je p > 0, tak je potřeba v dalším kroce skočit.
                if (p >= 0) {
                    y += dir;
                    p = p - 2*dx;
                }
                p = p + 2*dy;
            }
        }
    }

    // Implementace Bresenhamova algoritmu s prohozenými x a y hodnotami, pro vykreslování vertikálních čar
    private void drawLineV(int x1, int y1, int x2, int y2) {
        var img = ((RasterBufferedImage) raster).getImage();

        if (y1 > y2) {
            var temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }

        int dx = x2 - x1;
        int dy = y2 - y1;

        int dir;
        if (dx > 0) {
            dir = 1;
        } else {
            dir = -1;
        }

        dx *= dir;

        if (dy != 0) {
            var x = x1;
            var p = 2*dx-dy;

            for (var i = y1; i <= y2; i++) {
                img.setRGB(x, i, super.color.getRGB());
                if (p >= 0) {
                    x += dir;
                    p = p - 2*dy;
                }
                p = p + 2*dx;
            }
        }
    }
}
