package Model;

public class Line {
    private final int x1, y1, x2, y2;
    private int thickness;

    public Line(int x1, int y1, int x2, int y2, int thickness) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.thickness = thickness;
    }

    public Line(Point p1, Point p2, int thickness) {
        this.x1 = p1.getX();
        this.y1 = p1.getY();
        this.x2 = p2.getX();
        this.y2 = p2.getY();
        this.thickness = thickness;
    }

    public Point getPoint1() {
        return new Point(x1, y1);
    }

    public Point getPoint2() {
        return new Point(x2, y2);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getThickness() {
        return thickness;
    }
}
