package Model;

import java.util.ArrayList;

public class Polygon {
    public final ArrayList<Point> points;

    public Polygon() {
        this.points = new ArrayList<>();
    }

    public Point getPoint(int i) {
        return points.get(i);
    }

    public int getSize() {
        return points.size();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public Point getLastPoint() {
        return points.getLast();
    }
}
