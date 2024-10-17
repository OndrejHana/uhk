package Controller;

import Model.Model;
import Model.Polygon;
import Model.Mode;
import Model.LineModel;
import Model.Point;

public class Controller {
    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public Polygon getPolygon() {
        return model.getPolygon();
    }

    public void setPolygon(Polygon polygon) {
        model.setPolygon(polygon);
    }

    public Mode getMode() {
        return this.model.getMode();
    }

    public void setMode(Mode mode) {
        this.model.setMode(mode);
    }

    public LineModel getLineModel() {
        return this.model.getLineModel();
    }

    public void setLineModel(LineModel lineModel) {
        model.setLineModel(lineModel);
    }

    public Point getLastPoint() {
        return this.model.getLastPoint();
    }

    public void setLastPoint(Point lastPoint) {
        model.setLastPoint(lastPoint);
    }

    public Point getHoveredPoint() {
        return this.model.getHoveredPoint();
    }

    public void setHoveredPoint(Point hoveredPoint) {
        model.setHoveredPoint(hoveredPoint);
    }

    public void switchMode() {
        this.setLastPoint(null);
        this.setHoveredPoint(null);
        switch (this.model.getMode()) {
            case Polygon:
                this.setMode(Mode.Line);
                break;
            case Line:
                this.setMode(Mode.Polygon);
                if (this.getPolygon() != null) {
                    this.setLastPoint(this.getPolygon().getLastPoint());
                }
                break;
        }
    }
}
