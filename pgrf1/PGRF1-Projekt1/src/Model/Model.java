package Model;

public class Model {
    private Polygon polygon;
    private LineModel lineModel;
    private Mode mode;
    private Point lastPoint;
    private Point hoveredPoint;

    public Model(Polygon polygon, LineModel lineModel, Mode mode) {
        this.polygon = polygon;
        this.lineModel = lineModel;
        this.mode = mode;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public LineModel getLineModel() {
        return lineModel;
    }

    public Mode getMode() {
        return mode;
    }

    public Point getLastPoint() {
        return lastPoint;
    }

    public Point getHoveredPoint() {
        return hoveredPoint;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public void setLineModel(LineModel lineModel) {
        this.lineModel = lineModel;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint;
    }

    public void setHoveredPoint(Point hoveredPoint) {
        this.hoveredPoint = hoveredPoint;
    }
}
