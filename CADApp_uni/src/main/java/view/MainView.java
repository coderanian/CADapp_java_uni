package view;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import viewmodel.MainViewModel;

public class MainView extends BorderPane implements IView {
    private Application parent = null;
    private Stage stage = null;
    private IOFigureView viewIOFigure = null;
    private MainViewModel vm = null;

    public MainView(MainViewModel vm, Application parent, Stage stage) {
        try {
            this.parent = parent;
            this.stage = stage;
            this.vm = vm;
            this.viewIOFigure = new IOFigureView(this.vm, this, stage);
            vm.registerView(this);
            this.setPrefSize(1400.0, 700.0);
            this.setRight(this.viewIOFigure.funktionsleiste);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public void update() {
    }
}

