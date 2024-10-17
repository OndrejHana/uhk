package Model;

import java.util.ArrayList;

public class LineModel {
    private ArrayList<Line> lines;

    public LineModel() {
        lines = new ArrayList<>();
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public int getSize() {
        return lines.size();
    }

    public void addLine(Line line) {
        System.out.println("thickness" + line.getThickness());
        lines.add(line);
    }

    public Line getLastLine() {
        return lines.get(lines.size() - 1);
    }

    public Line getFirstLine() {
        return lines.get(0);
    }

    public ArrayList<Point> getAsPoints() {
        var points = new ArrayList<Point>();
        for (Line line : lines) {
            points.add(line.getPoint1());
            points.add(line.getPoint2());
        }
        return points;
    }

    public Point getLastPoint() {
        return lines.get(lines.size() - 1).getPoint2();
    }

    public Point getFirstPoint() {
        return lines.get(0).getPoint2();
    }

    public void clear() {
        lines.clear();
    }
}
