package viewmodel;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Figure;
import model.Rectangle;

public class IOFigureViewModel extends ViewModel {
    private Figure defaultFigure;
    private Figure figure;
    private int idFigure;
    private MainViewModel parent;
    private Stage stage;

    public IOFigureViewModel(Figure figure, ViewModel parent) {
        this.defaultFigure = new Rectangle(10.0, 20.0, 100.0, 100.0, Color.BLACK, Color.WHITE);
        this.figure = null;
        this.idFigure = 1;
        if (figure == null) {
            this.figure = this.defaultFigure;
        } else {
            this.figure = figure;
        }

        this.parent = (MainViewModel)parent;
        this.idFigure = this.idFigure++;
    }

    public Figure getFigure() {
        return this.figure;
    }

    public int getFigureID() {
        return this.idFigure;
    }

    public Figure getSetting() {
        return null;
    }

    public void setFigure(Figure f) {
        this.figure = f;
    }

    public void setFigure(Figure f, int id) {
    }

    public void setFigureID(int id) {
        this.idFigure = id;
    }
}
