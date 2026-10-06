import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class Play extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid,350,300);
        String cssPath = getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        primaryStage.setTitle("RPG Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
