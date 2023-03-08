package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MainView;
import viewmodel.MainViewModel;

public class CADApp extends Application {
    private MainView viewMain = null;
    private MainViewModel vmMain = null;

    public CADApp() {
    }

    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 1400.0, 800.0);
            scene.getStylesheets().add("/CAD.css");
            this.vmMain = new MainViewModel();
            this.viewMain = new MainView(this.vmMain, this, primaryStage);
            root.setLeft(this.viewMain);
            primaryStage.setScene(scene);
            primaryStage.setTitle("CADApp - P II");
            primaryStage.show();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
