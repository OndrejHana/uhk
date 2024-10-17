package Controller;

import Model.Model;
import Model.Polygon;
import Model.Mode;
import Model.LineModel;
import Model.Point;

import java.util.ArrayList;

public class Controller {
    private Model model;
    private ArrayList<Observer<Polygon>> polygonObservers;
    private ArrayList<Observer<Mode>> modeObservers;
    private ArrayList<Observer<LineModel>> lineModelObservers;
    private ArrayList<Observer<Point>> LastPointObservers;
    private ArrayList<Observer<Point>> hoveredPointObservers;

    public Controller(Model model) {
        this.model = model;
        this.polygonObservers = new ArrayList<>();
        this.modeObservers = new ArrayList<>();
        this.lineModelObservers = new ArrayList<>();
        this.LastPointObservers = new ArrayList<>();
        this.hoveredPointObservers = new ArrayList<>();
    }

    public Polygon getPolygon() {
        return model.getPolygon();
    }

    public void setPolygon(Polygon polygon) {
        model.setPolygon(polygon);
        polygonObservers.forEach((observer) -> observer.update(polygon));
    }

    public void onPolygonUpdate(Observer observer) {
        polygonObservers.add(observer);
    }

    public Mode getMode() {
        return this.model.getMode();
    }

    public void setMode(Mode mode) {
        this.model.setMode(mode);
        modeObservers.forEach((observer) -> observer.update(mode));
    }
    public void onModeUpdate(Observer observer) {
        modeObservers.add(observer);
    }

    public LineModel getLineModel() {
        return this.model.getLineModel();
    }

    public void setLineModel(LineModel lineModel) {
        model.setLineModel(lineModel);
        lineModelObservers.forEach((observer) -> observer.update(lineModel));
    }

    public void onLineUpdate(Observer observer) {
        lineModelObservers.add(observer);
    }

    public Point getLastPoint() {
        return this.model.getLastPoint();
    }

    public void setLastPoint(Point lastPoint) {
        model.setLastPoint(lastPoint);
        LastPointObservers.forEach((observer) -> observer.update(lastPoint));
    }

    public void onLastPointUpdate(Observer observer) {
        LastPointObservers.add(observer);
    }

    public Point getHoveredPoint() {
        return this.model.getHoveredPoint();
    }

    public void setHoveredPoint(Point hoveredPoint) {
        model.setHoveredPoint(hoveredPoint);
        hoveredPointObservers.forEach((observer) -> observer.update(hoveredPoint));
    }

    public void onHoveredPointUpdate(Observer observer) {
        hoveredPointObservers.add(observer);
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
