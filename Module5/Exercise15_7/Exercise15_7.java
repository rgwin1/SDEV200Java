import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

public class Exercise15_7 extends Application {
    @Override 
    public void start(Stage primaryStage) {
        //create pane
        Pane pane = new Pane();

        //create and set Circle object
        Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(100.0f);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        //add circle to pane
        pane.getChildren().add(circle);

        //mouse press sets color to black
        circle.setOnMousePressed((MouseEvent e) -> {
            circle.setFill(Color.BLACK);
        });

        //mouse release sets color to white
        circle.setOnMouseReleased((MouseEvent e) -> {
            circle.setFill(Color.WHITE);
        });

        //create scene and show stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise15_7");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}